/**
 * 
 */
package emforium.gwt.widget.custom;

import com.extjs.gxt.ui.client.widget.custom.Portlet;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.UIObject;

import emforium.gwt.widget.WidgetDOMConverter;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.widget.gxt.ComponentFactory;

/**
 * Factory for the NumberField widget.
 *
 */
public class PortalFactory extends ComponentFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "Portal";

	public PortalFactory() {
	}
	
    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
		register("columnWidths", new StringAttributeSetter<PortalContainer>() {
			public void set(PortalContainer widget, Element element, String name, String value) {
				widget.setColumnWidths(value);
			}
		});
	}
	protected PortalContainer newInstance(Element element) {
		return new PortalContainer();
	}

    public PortalContainer create(java.util.List<Object> ancestors,final Element element) {
        final PortalContainer item = (PortalContainer)createInstance(element);
        new WidgetDOMConverter<PortalContainer>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            	if ( widget instanceof Portlet ) {
            		item.addPortlet((Portlet)widget);
            	}
            }
        };	
        return item;
    }
}