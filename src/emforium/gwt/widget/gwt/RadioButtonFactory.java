// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.CheckBoxFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  class RadioButtonFactory extends CheckBoxFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "RadioButton";
    
    public RadioButtonFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("name", new StringAttributeSetter<RadioButton>() {
            public void set(RadioButton widget, Element element, String name, String value) {
                widget.setName(value);
            }
        });
    }

    /** override to create instance with arguments */
    @Override
    protected RadioButton newInstance(Element element) {
        throw new RuntimeException("override to create instance with arguments");
    }
    
    public RadioButton create(java.util.List<Object> ancestors,final Element element) {
        final RadioButton item = (RadioButton)createInstance(element);
        new WidgetDOMConverter<RadioButton>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
