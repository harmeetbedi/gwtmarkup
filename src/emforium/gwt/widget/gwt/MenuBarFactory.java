// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.WidgetFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  class MenuBarFactory extends WidgetFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "MenuBar";
    
    public MenuBarFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("animationEnabled", new BooleanAttributeSetter<MenuBar>() {
            public void set(MenuBar widget, Element element, String name, boolean value) {
                widget.setAnimationEnabled(value);
            }
        });
        register("autoOpen", new BooleanAttributeSetter<MenuBar>() {
            public void set(MenuBar widget, Element element, String name, boolean value) {
                widget.setAutoOpen(value);
            }
        });
    }

    @Override
    protected MenuBar newInstance(Element element) {
        return new MenuBar();
    }
    
    public MenuBar create(java.util.List<Object> ancestors,final Element element) {
        final MenuBar item = (MenuBar)createInstance(element);
        new WidgetDOMConverter<MenuBar>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
                String function = GwtXMLHelper.getAttribute(element,emforium.gwt.widget.MarkupConstants.CHILDTYPE_XML_ATTRIBUTE_NAME);
                String setFunc = "set"+function;
                String addFunc = "add"+function;
                if ( widget instanceof com.google.gwt.user.client.ui.MenuItem && "addItem".equalsIgnoreCase(addFunc) )
                    item.addItem((com.google.gwt.user.client.ui.MenuItem)widget);
                else 
                if ( widget instanceof com.google.gwt.user.client.ui.MenuItemSeparator && "addSeparator".equalsIgnoreCase(addFunc) )
                    item.addSeparator((com.google.gwt.user.client.ui.MenuItemSeparator)widget);
            }
        };
        return item;
    }
}
