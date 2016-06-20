// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.form.Radio;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;


public  class RadioFactory extends CheckBoxFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "Radio";
    
    public RadioFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
    }

    @Override
    protected Radio newInstance(Element element) {
        return new Radio();
    }
    
    public Radio create(java.util.List<Object> ancestors,final Element element) {
        final Radio item = (Radio)createInstance(element);
        new WidgetDOMConverter<Radio>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
