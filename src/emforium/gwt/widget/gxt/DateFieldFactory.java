// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.form.DateField;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  class DateFieldFactory extends TriggerFieldFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "DateField";
    
    public DateFieldFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("editable", new BooleanAttributeSetter<DateField>() {
            public void set(DateField widget, Element element, String name, boolean value) {
                widget.setEditable(value);
            }
        });
        register("formatValue", new BooleanAttributeSetter<DateField>() {
            public void set(DateField widget, Element element, String name, boolean value) {
                widget.setFormatValue(value);
            }
        });
        register("rawValue", new StringAttributeSetter<DateField>() {
            public void set(DateField widget, Element element, String name, String value) {
                widget.setRawValue(value);
            }
        });
    }

    @Override
    protected DateField newInstance(Element element) {
        return new DateField();
    }
    
    public DateField create(java.util.List<Object> ancestors,final Element element) {
        final DateField item = (DateField)createInstance(element);
        new WidgetDOMConverter<DateField>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
