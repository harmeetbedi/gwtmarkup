// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.menu.Item;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  abstract  class ItemFactory extends ComponentFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "Item";
    
    public ItemFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("activeStyle", new StringAttributeSetter<Item>() {
            public void set(Item widget, Element element, String name, String value) {
                widget.setActiveStyle(value);
            }
        });
        register("hideOnClick", new BooleanAttributeSetter<Item>() {
            public void set(Item widget, Element element, String name, boolean value) {
                widget.setHideOnClick(value);
            }
        });
    }

}
