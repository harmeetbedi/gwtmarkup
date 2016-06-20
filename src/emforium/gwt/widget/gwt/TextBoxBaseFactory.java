// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.TextBoxBase;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.FocusWidgetFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  class TextBoxBaseFactory extends FocusWidgetFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "TextBoxBase";
    
    public TextBoxBaseFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("cursorPos", new IntegerAttributeSetter<TextBoxBase>() {
            public void set(TextBoxBase widget, Element element, String name, int value) {
                widget.setCursorPos(value);
            }
        });
        register("key", new CharacterAttributeSetter<TextBoxBase>() {
            public void set(TextBoxBase widget, Element element, String name, char value) {
                widget.setKey(value);
            }
        });
        register("name", new StringAttributeSetter<TextBoxBase>() {
            public void set(TextBoxBase widget, Element element, String name, String value) {
                widget.setName(value);
            }
        });
        register("readOnly", new BooleanAttributeSetter<TextBoxBase>() {
            public void set(TextBoxBase widget, Element element, String name, boolean value) {
                widget.setReadOnly(value);
            }
        });
        register("text", new StringAttributeSetter<TextBoxBase>() {
            public void set(TextBoxBase widget, Element element, String name, String value) {
                widget.setText(value);
            }
        });
    }

    /** override to create instance with arguments */
    @Override
    protected TextBoxBase newInstance(Element element) {
        throw new RuntimeException("override to create instance with arguments");
    }
    
    public TextBoxBase create(java.util.List<Object> ancestors,final Element element) {
        final TextBoxBase item = (TextBoxBase)createInstance(element);
        new WidgetDOMConverter<TextBoxBase>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
