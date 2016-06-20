// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.LayoutFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  class BorderLayoutFactory extends LayoutFactory<BorderLayout> {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "BorderLayout";
    
    public BorderLayoutFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("containerStyle", new StringAttributeSetter<BorderLayout>() {
            public void set(BorderLayout widget, Element element, String name, String value) {
                widget.setContainerStyle(value);
            }
        });
        register("enableState", new BooleanAttributeSetter<BorderLayout>() {
            public void set(BorderLayout widget, Element element, String name, boolean value) {
                widget.setEnableState(value);
            }
        });
    }

    @Override
    protected BorderLayout newInstance(Element element) {
        return new BorderLayout();
    }
    
    public BorderLayout create(java.util.List<Object> ancestors,final Element element) {
        final BorderLayout item = (BorderLayout)createInstance(element);
        new WidgetDOMConverter<BorderLayout>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
