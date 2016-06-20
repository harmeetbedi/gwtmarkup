// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  class BoxComponentFactory extends ComponentFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "BoxComponent";
    
    public BoxComponentFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("autoHeight", new BooleanAttributeSetter<BoxComponent>() {
            public void set(BoxComponent widget, Element element, String name, boolean value) {
                widget.setAutoHeight(value);
            }
        });
        register("autoWidth", new BooleanAttributeSetter<BoxComponent>() {
            public void set(BoxComponent widget, Element element, String name, boolean value) {
                widget.setAutoWidth(value);
            }
        });
        register("deferHeight", new BooleanAttributeSetter<BoxComponent>() {
            public void set(BoxComponent widget, Element element, String name, boolean value) {
                widget.setDeferHeight(value);
            }
        });
        register("height", new IntegerAttributeSetter<BoxComponent>() {
            public void set(BoxComponent widget, Element element, String name, int value) {
                widget.setHeight(value);
            }
        });
        register("shadow", new BooleanAttributeSetter<BoxComponent>() {
            public void set(BoxComponent widget, Element element, String name, boolean value) {
                widget.setShadow(value);
            }
        });
        register("shim", new BooleanAttributeSetter<BoxComponent>() {
            public void set(BoxComponent widget, Element element, String name, boolean value) {
                widget.setShim(value);
            }
        });
        register("width", new IntegerAttributeSetter<BoxComponent>() {
            public void set(BoxComponent widget, Element element, String name, int value) {
                widget.setWidth(value);
            }
        });
    }

    @Override
    protected BoxComponent newInstance(Element element) {
        return new BoxComponent();
    }
    
    public BoxComponent create(java.util.List<Object> ancestors,final Element element) {
        final BoxComponent item = (BoxComponent)createInstance(element);
        new WidgetDOMConverter<BoxComponent>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
