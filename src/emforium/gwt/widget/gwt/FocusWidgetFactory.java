// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.FocusWidget;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.gwt.WidgetFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  abstract  class FocusWidgetFactory extends WidgetFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "FocusWidget";
    
    public FocusWidgetFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("accessKey", new CharacterAttributeSetter<FocusWidget>() {
            public void set(FocusWidget widget, Element element, String name, char value) {
                widget.setAccessKey(value);
            }
        });
        register("enabled", new BooleanAttributeSetter<FocusWidget>() {
            public void set(FocusWidget widget, Element element, String name, boolean value) {
                widget.setEnabled(value);
            }
        });
        register("focus", new BooleanAttributeSetter<FocusWidget>() {
            public void set(FocusWidget widget, Element element, String name, boolean value) {
                widget.setFocus(value);
            }
        });
        register("tabIndex", new IntegerAttributeSetter<FocusWidget>() {
            public void set(FocusWidget widget, Element element, String name, int value) {
                widget.setTabIndex(value);
            }
        });
    }

}
