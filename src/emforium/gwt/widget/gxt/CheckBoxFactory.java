// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  class CheckBoxFactory extends FieldFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "CheckBox";
    
    public CheckBoxFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("boxLabel", new StringAttributeSetter<CheckBox>() {
            public void set(CheckBox widget, Element element, String name, String value) {
                widget.setBoxLabel(value);
            }
        });
        register("rawValue", new StringAttributeSetter<CheckBox>() {
            public void set(CheckBox widget, Element element, String name, String value) {
                widget.setRawValue(value);
            }
        });
        register("valueAttribute", new StringAttributeSetter<CheckBox>() {
            public void set(CheckBox widget, Element element, String name, String value) {
                widget.setValueAttribute(value);
            }
        });
    }

    @Override
    protected CheckBox newInstance(Element element) {
        return new CheckBox();
    }
    
    public CheckBox create(java.util.List<Object> ancestors,final Element element) {
        final CheckBox item = (CheckBox)createInstance(element);
        new WidgetDOMConverter<CheckBox>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
