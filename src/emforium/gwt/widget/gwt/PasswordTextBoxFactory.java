// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.TextBoxFactory;
import com.google.gwt.user.client.Element;


public  class PasswordTextBoxFactory extends TextBoxFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "PasswordTextBox";
    
    public PasswordTextBoxFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
    }

    @Override
    protected PasswordTextBox newInstance(Element element) {
        return new PasswordTextBox();
    }
    
    public PasswordTextBox create(java.util.List<Object> ancestors,final Element element) {
        final PasswordTextBox item = (PasswordTextBox)createInstance(element);
        new WidgetDOMConverter<PasswordTextBox>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
