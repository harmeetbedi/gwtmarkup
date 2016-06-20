package emforium.gwt.widget.custom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.extjs.gxt.ui.client.XDOM;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.Html;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;

import emforium.gwt.util.GwtXMLHelper;
import emforium.gwt.widget.ElementComponent;
import emforium.gwt.widget.GwtObjectFactory;
import emforium.gwt.widget.GwtObjectFactoryLookup;
import emforium.gwt.widget.MarkupConstants;
import emforium.gwt.widget.WidgetDOMConverter;

public class ListManager {
	private ListManager() { }
	private static ListManager instance;
	public static ListManager getInstance() {
		if ( instance == null )
			instance = new ListManager();
		return instance; 
	}
	
	private static Map<String,LayoutContainer> targetContainerMap = new HashMap<String,LayoutContainer>();
	private static Map<String,ListAddTemplateFactory.ListAddTemplate> itemTemplateMap = new HashMap<String,ListAddTemplateFactory.ListAddTemplate>();
	
	public static void registerTemplate(ListAddTemplateFactory.ListAddTemplate template) {
		itemTemplateMap.put(template.getTemplateId(), template);
	}
	public static ListAddTemplateFactory.ListAddTemplate getTemplate(String id) {
		return itemTemplateMap.get(id);
	}
	public static void registerListContainer(String id, LayoutContainer container) {
		targetContainerMap.put(id,container);
	}
	private static LayoutContainer getContainer(String containerId) {
		LayoutContainer container = targetContainerMap.get(containerId);
		if ( container == null ) {
			System.out.println("cannot add widget to container. no container found : "+containerId);
			return null;  
		} else {
			return container;
		}
	}
	public static void addToContainer(String containerId, UIObject widget) {
		//System.out.println("addToContainer : "+containerId);
		LayoutContainer container = getContainer(containerId);
		if ( container == null )
			return;  
		container.add((Widget)widget);
		container.layout();
	}

	public static void removeItem(String containerId, String listItemId) {
		LayoutContainer container = getContainer(containerId);
		if ( container == null )
			return;  
		for ( Component widget : container.getItems() ) {
			Element elem = widget.getElement();
			String id = GwtXMLHelper.getAttribute(elem, "id");
			if ( id.equals(listItemId) ) {
				boolean removed = container.remove(widget);
				//System.out.println("Remove from container : "+removed);
				container.layout();
				break;
			}
		}
	}
	
	public static void addItem(ListAddTemplateFactory.ListAddTemplate template) {
		System.out.println("addItem");
		String containerId = template.getListContainerId();
		String templateId = template.getTemplateId();
		//System.out.println("addItem: "+containerId+", "+templateId);
		LayoutContainer container = getContainer(containerId);
		if ( container == null )
			return;  

		// replace placeholder with new generated id
		String id = XDOM.getUniqueId();
		String html = template.getMarkupToAdd()
			.replace("placeholder_item_id", id)
			.replace("placeholder_container_id", containerId)
			.replace("placeholder_template_id", templateId)
			.trim();

		if ( html.contains(MarkupConstants.TYPE_XML_ATTRIBUTE_NAME) ) {
			Element newNode = XDOM.create(html);
			List<Object> ancestors = new ArrayList<Object>();
	
			//RootPanel panel = RootPanel.get(value);
			GwtObjectFactory<?> factory = GwtObjectFactoryLookup.getFactory(newNode);
			if ( factory != null  ) {
				Widget widget = (Widget)factory.create(ancestors, newNode);
				container.add(widget);
			} else {
				final ElementComponent elemComp = new ElementComponent(newNode);
	
				// now convert the children
				new WidgetDOMConverter<ElementComponent>(ancestors, elemComp, newNode) {
					protected void addUIObject(UIObject child) {
						elemComp.add(child);
					}
				};
				container.add(elemComp);
			}
		}
		else {
			Html htmlWidget = new Html(html);
			container.add(htmlWidget);
		}
		container.layout();
	}
}