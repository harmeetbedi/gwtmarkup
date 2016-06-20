// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.TextBoxBaseFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  class TextBoxFactory extends TextBoxBaseFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "TextBox";
    
    public TextBoxFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("maxLength", new IntegerAttributeSetter<TextBox>() {
            public void set(TextBox widget, Element element, String name, int value) {
                widget.setMaxLength(value);
            }
        });
        register("visibleLength", new IntegerAttributeSetter<TextBox>() {
            public void set(TextBox widget, Element element, String name, int value) {
                widget.setVisibleLength(value);
            }
        });
    }

    @Override
    protected TextBox newInstance(Element element) {
        return new TextBox();
    }
    
    public TextBox create(java.util.List<Object> ancestors,final Element element) {
        final TextBox item = (TextBox)createInstance(element);
        new WidgetDOMConverter<TextBox>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
