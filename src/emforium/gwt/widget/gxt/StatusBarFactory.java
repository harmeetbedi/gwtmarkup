// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.StatusBar;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  class StatusBarFactory extends ComponentFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "StatusBar";
    
    public StatusBarFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("message", new StringAttributeSetter<StatusBar>() {
            public void set(StatusBar widget, Element element, String name, String value) {
                widget.setMessage(value);
            }
        });
        register("iconStyle", new StringAttributeSetter<StatusBar>() {
            public void set(StatusBar widget, Element element, String name, String value) {
                widget.setIconStyle(value);
            }
        });
    }

    @Override
    protected StatusBar newInstance(Element element) {
        return new StatusBar();
    }
    
    public StatusBar create(java.util.List<Object> ancestors,final Element element) {
        final StatusBar item = (StatusBar)createInstance(element);
        new WidgetDOMConverter<StatusBar>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
