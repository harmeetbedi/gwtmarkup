// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.DatePicker;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  class DatePickerFactory extends BoxComponentFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "DatePicker";
    
    public DatePickerFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("startDay", new IntegerAttributeSetter<DatePicker>() {
            public void set(DatePicker widget, Element element, String name, int value) {
                widget.setStartDay(value);
            }
        });
    }

    @Override
    protected DatePicker newInstance(Element element) {
        return new DatePicker();
    }
    
    public DatePicker create(java.util.List<Object> ancestors,final Element element) {
        final DatePicker item = (DatePicker)createInstance(element);
        new WidgetDOMConverter<DatePicker>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
