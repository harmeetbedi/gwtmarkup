// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.WidgetFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  class LabelFactory extends WidgetFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "Label";
    
    public LabelFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("text", new StringAttributeSetter<Label>() {
            public void set(Label widget, Element element, String name, String value) {
                widget.setText(value);
            }
        });
        register("wordWrap", new BooleanAttributeSetter<Label>() {
            public void set(Label widget, Element element, String name, boolean value) {
                widget.setWordWrap(value);
            }
        });
    }

    @Override
    protected Label newInstance(Element element) {
        return new Label();
    }
    
    public Label create(java.util.List<Object> ancestors,final Element element) {
        final Label item = (Label)createInstance(element);
        new WidgetDOMConverter<Label>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
