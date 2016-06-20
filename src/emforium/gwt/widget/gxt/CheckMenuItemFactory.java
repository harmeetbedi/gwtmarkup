// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.menu.CheckMenuItem;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  class CheckMenuItemFactory extends MenuItemFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "CheckMenuItem";
    
    public CheckMenuItemFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("checked", new BooleanAttributeSetter<CheckMenuItem>() {
            public void set(CheckMenuItem widget, Element element, String name, boolean value) {
                widget.setChecked(value);
            }
        });
        register("group", new StringAttributeSetter<CheckMenuItem>() {
            public void set(CheckMenuItem widget, Element element, String name, String value) {
                widget.setGroup(value);
            }
        });
        register("groupStyle", new StringAttributeSetter<CheckMenuItem>() {
            public void set(CheckMenuItem widget, Element element, String name, String value) {
                widget.setGroupStyle(value);
            }
        });
    }

    @Override
    protected CheckMenuItem newInstance(Element element) {
        return new CheckMenuItem();
    }
    
    public CheckMenuItem create(java.util.List<Object> ancestors,final Element element) {
        final CheckMenuItem item = (CheckMenuItem)createInstance(element);
        new WidgetDOMConverter<CheckMenuItem>(ancestors,item,element) {
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
