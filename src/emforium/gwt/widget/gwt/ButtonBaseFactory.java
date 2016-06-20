// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.ButtonBase;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.gwt.FocusWidgetFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  abstract  class ButtonBaseFactory extends FocusWidgetFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "ButtonBase";
    
    public ButtonBaseFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("hTML", new StringAttributeSetter<ButtonBase>() {
            public void set(ButtonBase widget, Element element, String name, String value) {
                widget.setHTML(value);
            }
        });
        register("text", new StringAttributeSetter<ButtonBase>() {
            public void set(ButtonBase widget, Element element, String name, String value) {
                widget.setText(value);
            }
        });
    }

}
