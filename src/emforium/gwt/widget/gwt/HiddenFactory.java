// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.Hidden;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.WidgetFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  class HiddenFactory extends WidgetFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "Hidden";
    
    public HiddenFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("defaultValue", new StringAttributeSetter<Hidden>() {
            public void set(Hidden widget, Element element, String name, String value) {
                widget.setDefaultValue(value);
            }
        });
        register("iD", new StringAttributeSetter<Hidden>() {
            public void set(Hidden widget, Element element, String name, String value) {
                widget.setID(value);
            }
        });
        register("name", new StringAttributeSetter<Hidden>() {
            public void set(Hidden widget, Element element, String name, String value) {
                widget.setName(value);
            }
        });
        register("value", new StringAttributeSetter<Hidden>() {
            public void set(Hidden widget, Element element, String name, String value) {
                widget.setValue(value);
            }
        });
    }

    @Override
    protected Hidden newInstance(Element element) {
        return new Hidden();
    }
    
    public Hidden create(java.util.List<Object> ancestors,final Element element) {
        final Hidden item = (Hidden)createInstance(element);
        new WidgetDOMConverter<Hidden>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
