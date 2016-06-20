// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.dnd.StatusProxy;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  class StatusProxyFactory extends BoxComponentFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "StatusProxy";
    
    public StatusProxyFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("status", new BooleanAttributeSetter<StatusProxy>() {
            public void set(StatusProxy widget, Element element, String name, boolean value) {
                widget.setStatus(value);
            }
        });
    }

    /** override to create instance with arguments */
    @Override
    protected StatusProxy newInstance(Element element) {
        throw new RuntimeException("override to create instance with arguments");
    }
    
    public StatusProxy create(java.util.List<Object> ancestors,final Element element) {
        final StatusProxy item = (StatusProxy)createInstance(element);
        new WidgetDOMConverter<StatusProxy>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
