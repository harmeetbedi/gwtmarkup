// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.NamedFrame;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.FrameFactory;
import com.google.gwt.user.client.Element;


public  class NamedFrameFactory extends FrameFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "NamedFrame";
    
    public NamedFrameFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
    }

    /** override to create instance with arguments */
    @Override
    protected NamedFrame newInstance(Element element) {
        throw new RuntimeException("override to create instance with arguments");
    }
    
    public NamedFrame create(java.util.List<Object> ancestors,final Element element) {
        final NamedFrame item = (NamedFrame)createInstance(element);
        new WidgetDOMConverter<NamedFrame>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
