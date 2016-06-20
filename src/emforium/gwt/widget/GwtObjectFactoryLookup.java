package emforium.gwt.widget;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.google.gwt.user.client.Element;

/**
 * This the primary entry point for a GWT application. It will scan the DOM
 * looking for elements that have been marked with special attribute values.
 * These special markings will result in the creation of GWT and GXT widgets at
 * the specified locations.
 * 
 * This allows for simple applications to be created and wired up without
 * writing any javascript of gwt code.
 * 
 * 
 */
public class GwtObjectFactoryLookup {

	// map from EM_TYPE attribute value, to factory instance
	private Map<String, GwtObjectFactory<?>> types = new HashMap<String, GwtObjectFactory<?>>();
//		public GwtObjectFactory<?> put(String key, GwtObjectFactory<?> value) {
//			//key = key.toLowerCase();
//			//System.out.println("factoryMap: "+key);
//			return super.put(key, value);
//		}
//	};
	
	// singleton
	private static GwtObjectFactoryLookup instance ;
	
	private static final String CUSTOM_FACTORIES_PREFIX = "custom.";
	private static final String GXT_FACTORIES_PREFIX = "gxt.";
	private static final String GWT_FACTORIES_PREFIX = "gwt.";
	private static final String VISUALIZATION_FACTORIES_PREFIX = "chart.";
	//private static final String SMARTGWT_FACTORIES_PREFIX = "smartgwt.";
	private Map<String,GwtObjectFactoryRegistry> registryMap = new LinkedHashMap<String,GwtObjectFactoryRegistry>();
//		public GwtObjectFactoryRegistry put(String key, GwtObjectFactoryRegistry value) {
//			//System.out.println("registryMap: "+key);
//			return super.put(key,value);
//		}
//	};
	
	private GwtObjectFactoryLookup() {
		// prefered is on top
		registryMap.put(CUSTOM_FACTORIES_PREFIX,new emforium.gwt.widget.custom.GwtFactoryRegistryImpl());
		registryMap.put(GXT_FACTORIES_PREFIX,new emforium.gwt.widget.gxt.GwtFactoryRegistryImpl());
		registryMap.put(GWT_FACTORIES_PREFIX,new emforium.gwt.widget.gwt.GwtFactoryRegistryImpl());
		registryMap.put(VISUALIZATION_FACTORIES_PREFIX,new emforium.gwt.widget.visualization.GwtFactoryRegistryImpl());
		//registryMap.put(SMARTGWT_FACTORIES_PREFIX,new emforium.gwt.widget.smartgwt.GwtFactoryRegistryImpl());

		// pull factory lookup
		for ( Map.Entry<String,GwtObjectFactoryRegistry> entry : registryMap.entrySet() ) {
			entry.getValue().registerFactories(entry.getKey(),types);
		}
	}

	private GwtObjectFactory<?> lookup(String xmlTag) {
		GwtObjectFactory<?> factory = null;
		if ( xmlTag != null ) {
			//xmlTag = xmlTag.toLowerCase();
			// check if xml tag has the registry prefix and can be directly resolved
			// if not, add registy prefix to tag and then try to resolve
			factory = types.get(xmlTag);
			if ( factory == null ) {
				for ( String prefix : registryMap.keySet() ) {
					factory = types.get(prefix+xmlTag);
					if ( factory != null )
						break;
				}
			}
		}
//		if ( factory != null ) 
//			System.out.println(xmlTag+": "+factory.getClass().getName());
//		else
//			System.out.println(xmlTag+": not found");
		return factory;
	}

	private static GwtObjectFactoryLookup getInstance() {
		if ( instance == null ) {
			instance = new GwtObjectFactoryLookup();
		}
		return instance;
	}
	
	/**
	 * Return the appropriate factory for a specified DOM element. null will be
	 * returned if this element is not to be converted into a Widget.
	 * 
	 * @param <W>
	 * @param element
	 *            Element being examined
	 * @return Appropriate widget factory to use
	 */
	public static <W extends Object> GwtObjectFactory<W> getFactory(Element element) {
		String type = element.getAttribute(MarkupConstants.TYPE_XML_ATTRIBUTE_NAME);
		return getFactory(type);
	}

	@SuppressWarnings("unchecked")
	public static <W extends Object> GwtObjectFactory<W> getFactory(String factoryType) {
		GwtObjectFactory<W> factory = (GwtObjectFactory<W>) getInstance().lookup(factoryType);
		return factory;
	}

	/**
	 * Register a new WidgetFactory for the specified tag value.
	 * 
	 * @param tag
	 * @param factory
	 */
	protected <W extends Object> void register(String tag, GwtObjectFactory<W> factory) {
		types.put(tag.toLowerCase(), factory);
	}
}
