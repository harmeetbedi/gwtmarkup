// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.WidgetFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  class FrameFactory extends WidgetFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "Frame";
    
    public FrameFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("url", new StringAttributeSetter<Frame>() {
            public void set(Frame widget, Element element, String name, String value) {
                widget.setUrl(value);
            }
        });
    }

    @Override
    protected Frame newInstance(Element element) {
        return new Frame();
    }
    
    public Frame create(java.util.List<Object> ancestors,final Element element) {
        final Frame item = (Frame)createInstance(element);
        new WidgetDOMConverter<Frame>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
