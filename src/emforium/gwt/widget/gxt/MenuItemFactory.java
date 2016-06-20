// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.menu.MenuItem;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  class MenuItemFactory extends ItemFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "MenuItem";
    
    public MenuItemFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("iconStyle", new StringAttributeSetter<MenuItem>() {
            public void set(MenuItem widget, Element element, String name, String value) {
                widget.setIconStyle(value);
            }
        });
        register("text", new StringAttributeSetter<MenuItem>() {
            public void set(MenuItem widget, Element element, String name, String value) {
                widget.setText(value);
            }
        });
    }

    @Override
    protected MenuItem newInstance(Element element) {
        return new MenuItem();
    }
    
    public MenuItem create(java.util.List<Object> ancestors,final Element element) {
        final MenuItem item = (MenuItem)createInstance(element);
        new WidgetDOMConverter<MenuItem>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
                String function = GwtXMLHelper.getAttribute(element,emforium.gwt.widget.MarkupConstants.CHILDTYPE_XML_ATTRIBUTE_NAME);
                String setFunc = "set"+function;
                String addFunc = "add"+function;
                if ( widget instanceof com.extjs.gxt.ui.client.widget.menu.Menu && "setSubMenu".equalsIgnoreCase(setFunc) )
                    item.setSubMenu((com.extjs.gxt.ui.client.widget.menu.Menu)widget);
            }
        };
        return item;
    }
}
