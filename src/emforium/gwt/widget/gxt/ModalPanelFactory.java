// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.ModalPanel;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  class ModalPanelFactory extends BoxComponentFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "ModalPanel";
    
    public ModalPanelFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("blink", new BooleanAttributeSetter<ModalPanel>() {
            public void set(ModalPanel widget, Element element, String name, boolean value) {
                widget.setBlink(value);
            }
        });
    }

    @Override
    protected ModalPanel newInstance(Element element) {
        return new ModalPanel();
    }
    
    public ModalPanel create(java.util.List<Object> ancestors,final Element element) {
        final ModalPanel item = (ModalPanel)createInstance(element);
        new WidgetDOMConverter<ModalPanel>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
