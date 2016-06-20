// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.SimpleRadioButton;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.SimpleCheckBoxFactory;
import com.google.gwt.user.client.Element;


public  class SimpleRadioButtonFactory extends SimpleCheckBoxFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "SimpleRadioButton";
    
    public SimpleRadioButtonFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
    }

    /** override to create instance with arguments */
    @Override
    protected SimpleRadioButton newInstance(Element element) {
        throw new RuntimeException("override to create instance with arguments");
    }
    
    public SimpleRadioButton create(java.util.List<Object> ancestors,final Element element) {
        final SimpleRadioButton item = (SimpleRadioButton)createInstance(element);
        new WidgetDOMConverter<SimpleRadioButton>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
