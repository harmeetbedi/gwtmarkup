// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  class TextFieldFactory extends FieldFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "TextField";
    
    public TextFieldFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("allowBlank", new BooleanAttributeSetter<TextField>() {
            public void set(TextField widget, Element element, String name, boolean value) {
                widget.setAllowBlank(value);
            }
        });
        register("cursorPos", new IntegerAttributeSetter<TextField>() {
            public void set(TextField widget, Element element, String name, int value) {
                widget.setCursorPos(value);
            }
        });
        register("emptyText", new StringAttributeSetter<TextField>() {
            public void set(TextField widget, Element element, String name, String value) {
                widget.setEmptyText(value);
            }
        });
        register("maxLength", new IntegerAttributeSetter<TextField>() {
            public void set(TextField widget, Element element, String name, int value) {
                widget.setMaxLength(value);
            }
        });
        register("minLength", new IntegerAttributeSetter<TextField>() {
            public void set(TextField widget, Element element, String name, int value) {
                widget.setMinLength(value);
            }
        });
        register("password", new BooleanAttributeSetter<TextField>() {
            public void set(TextField widget, Element element, String name, boolean value) {
                widget.setPassword(value);
            }
        });
        register("regex", new StringAttributeSetter<TextField>() {
            public void set(TextField widget, Element element, String name, String value) {
                widget.setRegex(value);
            }
        });
        register("selectOnFocus", new BooleanAttributeSetter<TextField>() {
            public void set(TextField widget, Element element, String name, boolean value) {
                widget.setSelectOnFocus(value);
            }
        });
    }

    @Override
    protected TextField newInstance(Element element) {
        return new TextField();
    }
    
    public TextField create(java.util.List<Object> ancestors,final Element element) {
        final TextField item = (TextField)createInstance(element);
        new WidgetDOMConverter<TextField>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
