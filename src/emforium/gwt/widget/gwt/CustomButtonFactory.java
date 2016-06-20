// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.CustomButton;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.gwt.ButtonBaseFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  abstract  class CustomButtonFactory extends ButtonBaseFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "CustomButton";
    
    public CustomButtonFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("accessKey", new CharacterAttributeSetter<CustomButton>() {
            public void set(CustomButton widget, Element element, String name, char value) {
                widget.setAccessKey(value);
            }
        });
        register("enabled", new BooleanAttributeSetter<CustomButton>() {
            public void set(CustomButton widget, Element element, String name, boolean value) {
                widget.setEnabled(value);
            }
        });
        register("focus", new BooleanAttributeSetter<CustomButton>() {
            public void set(CustomButton widget, Element element, String name, boolean value) {
                widget.setFocus(value);
            }
        });
        register("hTML", new StringAttributeSetter<CustomButton>() {
            public void set(CustomButton widget, Element element, String name, String value) {
                widget.setHTML(value);
            }
        });
        register("tabIndex", new IntegerAttributeSetter<CustomButton>() {
            public void set(CustomButton widget, Element element, String name, int value) {
                widget.setTabIndex(value);
            }
        });
        register("text", new StringAttributeSetter<CustomButton>() {
            public void set(CustomButton widget, Element element, String name, String value) {
                widget.setText(value);
            }
        });
    }

}
