// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.ProgressBar;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  class ProgressBarFactory extends BoxComponentFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "ProgressBar";
    
    public ProgressBarFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("increment", new IntegerAttributeSetter<ProgressBar>() {
            public void set(ProgressBar widget, Element element, String name, int value) {
                widget.setIncrement(value);
            }
        });
        register("interval", new IntegerAttributeSetter<ProgressBar>() {
            public void set(ProgressBar widget, Element element, String name, int value) {
                widget.setInterval(value);
            }
        });
        register("duration", new IntegerAttributeSetter<ProgressBar>() {
            public void set(ProgressBar widget, Element element, String name, int value) {
                widget.setDuration(value);
            }
        });
    }

    @Override
    protected ProgressBar newInstance(Element element) {
        return new ProgressBar();
    }
    
    public ProgressBar create(java.util.List<Object> ancestors,final Element element) {
        final ProgressBar item = (ProgressBar)createInstance(element);
        new WidgetDOMConverter<ProgressBar>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
