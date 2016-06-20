// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.FramePanel;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  class FramePanelFactory extends ComponentFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "FramePanel";
    
    public FramePanelFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("zIndex", new IntegerAttributeSetter<FramePanel>() {
            public void set(FramePanel widget, Element element, String name, int value) {
                widget.setZIndex(value);
            }
        });
    }

    /** override to create instance with arguments */
    @Override
    protected FramePanel newInstance(Element element) {
        throw new RuntimeException("override to create instance with arguments");
    }
    
    public FramePanel create(java.util.List<Object> ancestors,final Element element) {
        final FramePanel item = (FramePanel)createInstance(element);
        new WidgetDOMConverter<FramePanel>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
