// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.TextBoxBaseFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  class TextAreaFactory extends TextBoxBaseFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "TextArea";
    
    public TextAreaFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("characterWidth", new IntegerAttributeSetter<TextArea>() {
            public void set(TextArea widget, Element element, String name, int value) {
                widget.setCharacterWidth(value);
            }
        });
        register("visibleLines", new IntegerAttributeSetter<TextArea>() {
            public void set(TextArea widget, Element element, String name, int value) {
                widget.setVisibleLines(value);
            }
        });
    }

    @Override
    protected TextArea newInstance(Element element) {
        return new TextArea();
    }
    
    public TextArea create(java.util.List<Object> ancestors,final Element element) {
        final TextArea item = (TextArea)createInstance(element);
        new WidgetDOMConverter<TextArea>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
