// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.UIObjectFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  class MenuItemFactory extends UIObjectFactory<MenuItem> {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "MenuItem";
    
    public MenuItemFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("hTML", new StringAttributeSetter<MenuItem>() {
            public void set(MenuItem widget, Element element, String name, String value) {
                widget.setHTML(value);
            }
        });
        register("text", new StringAttributeSetter<MenuItem>() {
            public void set(MenuItem widget, Element element, String name, String value) {
                widget.setText(value);
            }
        });
    }

    /** override to create instance with arguments */
    @Override
    protected MenuItem newInstance(Element element) {
        throw new RuntimeException("override to create instance with arguments");
    }
    
    public MenuItem create(java.util.List<Object> ancestors,final Element element) {
        final MenuItem item = (MenuItem)createInstance(element);
        new WidgetDOMConverter<MenuItem>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
                String function = GwtXMLHelper.getAttribute(element,emforium.gwt.widget.MarkupConstants.CHILDTYPE_XML_ATTRIBUTE_NAME);
                String setFunc = "set"+function;
                String addFunc = "add"+function;
                if ( widget instanceof com.google.gwt.user.client.ui.MenuBar && "setSubMenu".equalsIgnoreCase(setFunc) )
                    item.setSubMenu((com.google.gwt.user.client.ui.MenuBar)widget);
            }
        };
        return item;
    }
}
