// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.Component;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.gwt.WidgetFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  abstract  class ComponentFactory extends WidgetFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "Component";
    
    public ComponentFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("borders", new BooleanAttributeSetter<Component>() {
            public void set(Component widget, Element element, String name, boolean value) {
                widget.setBorders(value);
            }
        });
        register("enabled", new BooleanAttributeSetter<Component>() {
            public void set(Component widget, Element element, String name, boolean value) {
                widget.setEnabled(value);
            }
        });
        register("enableState", new BooleanAttributeSetter<Component>() {
            public void set(Component widget, Element element, String name, boolean value) {
                widget.setEnableState(value);
            }
        });
        register("height", new StringAttributeSetter<Component>() {
            public void set(Component widget, Element element, String name, String value) {
                widget.setHeight(value);
            }
        });
        register("id", new StringAttributeSetter<Component>() {
            public void set(Component widget, Element element, String name, String value) {
                widget.setId(value);
            }
        });
        register("itemId", new StringAttributeSetter<Component>() {
            public void set(Component widget, Element element, String name, String value) {
                widget.setItemId(value);
            }
        });
        register("styleName", new StringAttributeSetter<Component>() {
            public void set(Component widget, Element element, String name, String value) {
                widget.setStyleName(value);
            }
        });
        register("title", new StringAttributeSetter<Component>() {
            public void set(Component widget, Element element, String name, String value) {
                widget.setTitle(value);
            }
        });
        register("toolTip", new StringAttributeSetter<Component>() {
            public void set(Component widget, Element element, String name, String value) {
                widget.setToolTip(value);
            }
        });
        register("visible", new BooleanAttributeSetter<Component>() {
            public void set(Component widget, Element element, String name, boolean value) {
                widget.setVisible(value);
            }
        });
        register("width", new StringAttributeSetter<Component>() {
            public void set(Component widget, Element element, String name, String value) {
                widget.setWidth(value);
            }
        });
    }

}
