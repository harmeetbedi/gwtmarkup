// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.form.TriggerField;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  class TriggerFieldFactory extends TextFieldFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "TriggerField";
    
    public TriggerFieldFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("hideTrigger", new BooleanAttributeSetter<TriggerField>() {
            public void set(TriggerField widget, Element element, String name, boolean value) {
                widget.setHideTrigger(value);
            }
        });
        register("triggerStyle", new StringAttributeSetter<TriggerField>() {
            public void set(TriggerField widget, Element element, String name, String value) {
                widget.setTriggerStyle(value);
            }
        });
    }

    @Override
    protected TriggerField newInstance(Element element) {
        return new TriggerField();
    }
    
    public TriggerField create(java.util.List<Object> ancestors,final Element element) {
        final TriggerField item = (TriggerField)createInstance(element);
        new WidgetDOMConverter<TriggerField>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
