// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.FocusWidgetFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  class RichTextAreaFactory extends FocusWidgetFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "RichTextArea";
    
    public RichTextAreaFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("focus", new BooleanAttributeSetter<RichTextArea>() {
            public void set(RichTextArea widget, Element element, String name, boolean value) {
                widget.setFocus(value);
            }
        });
        register("hTML", new StringAttributeSetter<RichTextArea>() {
            public void set(RichTextArea widget, Element element, String name, String value) {
                widget.setHTML(value);
            }
        });
        register("text", new StringAttributeSetter<RichTextArea>() {
            public void set(RichTextArea widget, Element element, String name, String value) {
                widget.setText(value);
            }
        });
    }

    @Override
    protected RichTextArea newInstance(Element element) {
        return new RichTextArea();
    }
    
    public RichTextArea create(java.util.List<Object> ancestors,final Element element) {
        final RichTextArea item = (RichTextArea)createInstance(element);
        new WidgetDOMConverter<RichTextArea>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
