// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.form.TwinTriggerField;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  class TwinTriggerFieldFactory extends TriggerFieldFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "TwinTriggerField";
    
    public TwinTriggerFieldFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("twinTriggerStyle", new StringAttributeSetter<TwinTriggerField>() {
            public void set(TwinTriggerField widget, Element element, String name, String value) {
                widget.setTwinTriggerStyle(value);
            }
        });
    }

    @Override
    protected TwinTriggerField newInstance(Element element) {
        return new TwinTriggerField();
    }
    
    public TwinTriggerField create(java.util.List<Object> ancestors,final Element element) {
        final TwinTriggerField item = (TwinTriggerField)createInstance(element);
        new WidgetDOMConverter<TwinTriggerField>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
