// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.MenuItemSeparator;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.UIObjectFactory;
import com.google.gwt.user.client.Element;


public  class MenuItemSeparatorFactory extends UIObjectFactory<MenuItemSeparator> {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "MenuItemSeparator";
    
    public MenuItemSeparatorFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
    }

    @Override
    protected MenuItemSeparator newInstance(Element element) {
        return new MenuItemSeparator();
    }
    
    public MenuItemSeparator create(java.util.List<Object> ancestors,final Element element) {
        final MenuItemSeparator item = (MenuItemSeparator)createInstance(element);
        new WidgetDOMConverter<MenuItemSeparator>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
