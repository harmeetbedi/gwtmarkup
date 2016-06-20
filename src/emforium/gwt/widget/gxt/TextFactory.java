// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.Text;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  class TextFactory extends BoxComponentFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "Text";
    
    public TextFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("tagName", new StringAttributeSetter<Text>() {
            public void set(Text widget, Element element, String name, String value) {
                widget.setTagName(value);
            }
        });
        register("text", new StringAttributeSetter<Text>() {
            public void set(Text widget, Element element, String name, String value) {
                widget.setText(value);
            }
        });
    }

    @Override
    protected Text newInstance(Element element) {
        return new Text();
    }
    
    public Text create(java.util.List<Object> ancestors,final Element element) {
        final Text item = (Text)createInstance(element);
        new WidgetDOMConverter<Text>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
