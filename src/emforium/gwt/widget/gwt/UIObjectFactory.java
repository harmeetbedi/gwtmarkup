// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  abstract  class UIObjectFactory<W extends UIObject> extends emforium.gwt.widget.GwtObjectFactory<W> {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "UIObject";
    
    public UIObjectFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("height", new StringAttributeSetter<UIObject>() {
            public void set(UIObject widget, Element element, String name, String value) {
                widget.setHeight(value);
            }
        });
        register("styleName", new StringAttributeSetter<UIObject>() {
            public void set(UIObject widget, Element element, String name, String value) {
                widget.setStyleName(value);
            }
        });
        register("stylePrimaryName", new StringAttributeSetter<UIObject>() {
            public void set(UIObject widget, Element element, String name, String value) {
                widget.setStylePrimaryName(value);
            }
        });
        register("title", new StringAttributeSetter<UIObject>() {
            public void set(UIObject widget, Element element, String name, String value) {
                widget.setTitle(value);
            }
        });
        register("visible", new BooleanAttributeSetter<UIObject>() {
            public void set(UIObject widget, Element element, String name, boolean value) {
                widget.setVisible(value);
            }
        });
        register("width", new StringAttributeSetter<UIObject>() {
            public void set(UIObject widget, Element element, String name, String value) {
                widget.setWidth(value);
            }
        });
    }

}
