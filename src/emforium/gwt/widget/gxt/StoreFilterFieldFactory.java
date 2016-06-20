// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.StoreFilterField;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  abstract  class StoreFilterFieldFactory extends TriggerFieldFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "StoreFilterField";
    
    public StoreFilterFieldFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("property", new StringAttributeSetter<StoreFilterField>() {
            public void set(StoreFilterField widget, Element element, String name, String value) {
                widget.setProperty(value);
            }
        });
    }

}
