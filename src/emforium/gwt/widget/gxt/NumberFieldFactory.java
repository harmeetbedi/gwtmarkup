// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  class NumberFieldFactory extends TextFieldFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "NumberField";
    
    public NumberFieldFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("allowDecimals", new BooleanAttributeSetter<NumberField>() {
            public void set(NumberField widget, Element element, String name, boolean value) {
                widget.setAllowDecimals(value);
            }
        });
        register("allowNegative", new BooleanAttributeSetter<NumberField>() {
            public void set(NumberField widget, Element element, String name, boolean value) {
                widget.setAllowNegative(value);
            }
        });
        register("baseChars", new StringAttributeSetter<NumberField>() {
            public void set(NumberField widget, Element element, String name, String value) {
                widget.setBaseChars(value);
            }
        });
        register("decimalSeparator", new StringAttributeSetter<NumberField>() {
            public void set(NumberField widget, Element element, String name, String value) {
                widget.setDecimalSeparator(value);
            }
        });
    }

    @Override
    protected NumberField newInstance(Element element) {
        return new NumberField();
    }
    
    public NumberField create(java.util.List<Object> ancestors,final Element element) {
        final NumberField item = (NumberField)createInstance(element);
        new WidgetDOMConverter<NumberField>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
