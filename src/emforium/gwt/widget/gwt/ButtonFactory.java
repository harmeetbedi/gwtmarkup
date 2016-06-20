// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.ButtonBaseFactory;
import com.google.gwt.user.client.Element;


public  class ButtonFactory extends ButtonBaseFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "Button";
    
    public ButtonFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
    }

    @Override
    protected Button newInstance(Element element) {
        return new Button();
    }
    
    public Button create(java.util.List<Object> ancestors,final Element element) {
        final Button item = (Button)createInstance(element);
        new WidgetDOMConverter<Button>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
