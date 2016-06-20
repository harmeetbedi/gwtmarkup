// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.LayoutFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  class FlowLayoutFactory extends LayoutFactory<FlowLayout> {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "FlowLayout";
    
    public FlowLayoutFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("margin", new IntegerAttributeSetter<FlowLayout>() {
            public void set(FlowLayout widget, Element element, String name, int value) {
                widget.setMargin(value);
            }
        });
        register("removePositioning", new BooleanAttributeSetter<FlowLayout>() {
            public void set(FlowLayout widget, Element element, String name, boolean value) {
                widget.setRemovePositioning(value);
            }
        });
    }

    @Override
    protected FlowLayout newInstance(Element element) {
        return new FlowLayout();
    }
    
    public FlowLayout create(java.util.List<Object> ancestors,final Element element) {
        final FlowLayout item = (FlowLayout)createInstance(element);
        new WidgetDOMConverter<FlowLayout>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
