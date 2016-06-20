package emforium.gwt.widget;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.UIObject;

import emforium.gwt.util.GwtXMLHelper;
import emforium.gwt.widget.AttributeSetter.StringAttributeSetter;

/**
 * A WidgetFactory is responsible for converting a DOM element into a Widget. It
 * generally will create the appropriate Widget instance, and then scan all the
 * attributes on the DOM element for ones that will be mapped into setters for
 * the instance. This means that through the DOM, you can create a widget
 * instance and pass it parameters via the attributes. The following example
 * will set the width and height of the widget by invoking the
 * <code>setWidth("100px")</code> and <code>setHeight("200")</code>
 * 
 * <pre>
 * &lt;div gwt-type=&quot;label&quot; width=&quot;100px&quot; height=&quot;200&quot;/&gt;
 * </pre>
 * 
 * @param <W>
 */
public abstract class GwtObjectFactory<W extends Object> {

	// map of all the attribute names and their corresponding setters. Maintain order or registrations
	private Map<String, AttributeSetter<?>> setters;

	/**
	 * Register a setter with this factory. Once performed, any attribute that
	 * matches <code>name</code> in a case insensitive manner will invoke the
	 * setter.
	 * 
	 * @param <X>
	 * @param name
	 *            attribute that will cause it's value to be used as the value
	 *            for the setter
	 * @param setter
	 *            specific setter for this attribute's value
	 */
	public final <X extends Object> void register(String name, AttributeSetter<X> setter) {
		String key = name.toLowerCase();
		AttributeSetter<X> existing = (AttributeSetter<X>)setters.get(key);
		// only overwrite if the previous registered attribute is not a string
		if ( ( existing == null ) || ( setter instanceof AttributeSetter.StringAttributeSetter) ) {
			setters.put(key, setter);
		}
	}

	/**
	 * Create a new instance of the required widget component.
	 * 
	 * @param element
	 *            The element that is causing this widget to be created.
	 * @return
	 */
	protected abstract W newInstance(Element element);

	/**
	 * Primary entry point to navigate through a DOM object graph and convert it
	 * to a corresponding GXT graph.
	 * 
	 * @param element
	 * @return
	 */
	protected final W createInstance(Element element) {
		W widget = newInstance(element);
		registerAttributeIfNeeded();
		mapAttributes(element, widget);
		return widget;
	}
	
	/** lazily initialize attribute setters and cache them in factory instance */
	private void registerAttributeIfNeeded() {
		if ( setters == null ) {
			setters = new LinkedHashMap<String, AttributeSetter<?>>();
			registerAttributes();
			CustomAttributes.getInstance(this).registerAttributes();
		}
	}
	
	/** derived classes should override to register attribute setters */
	protected void registerAttributes() {
        register("widgetId", new StringAttributeSetter<W>() {
            public void set(W widget, Element element, String name, String value) {
            	if ( widget instanceof UIObject ) {
            		if ( value == null || value.length() == 0 )
            			return;
            		((UIObject) widget).getElement().setId(value);
            		PageDOMConverter.registerMarkupComponent(value, widget);
            	}
            }
        });
	}

	/**
	 * Primary entry point to navigate through a DOM object graph and convert it
	 * to a corresponding GXT graph.
	 * 
	 * @param element
	 * @return
	 */
	public abstract W create(List<Object> ancestors,Element element);

	/**
	 * Extract any attributes from the provided dom element. This is how
	 * arguments are passed to the widgets during creation. By convention, use
	 * the same name for the attribute on the element as the field in the class.
	 * 
	 * So, if the class as <code>myVariable</code> as a local attribute and the
	 * associated <code>getMyVariable()</code> getter and
	 * <code>setMyVariable()</code> setter, than the attribute should be
	 * <code>myVariable</code>. This convention should minimize the amount of
	 * documentation required.
	 * 
	 * @param element
	 * @param widget
	 */
	@SuppressWarnings("unchecked")
	private void mapAttributes(Element element, W widget) {
		// set attributes in same order as registrations
		for ( Map.Entry<String,AttributeSetter<?>> entry : setters.entrySet() ) {
			AttributeSetter<W> setter = (AttributeSetter<W>)entry.getValue();
			if ( setter == null )
				continue;
			String key = entry.getKey();
			String value = GwtXMLHelper.getAttribute(element, key);
			if ( value.equals("none") )
				setter.set(widget, element, key, "");
			else if ( value.length() > 0 )
				setter.set(widget, element, key, value);
		}
	}
}
