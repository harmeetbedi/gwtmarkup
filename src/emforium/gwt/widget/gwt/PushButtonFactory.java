// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.CustomButtonFactory;
import com.google.gwt.user.client.Element;


public  class PushButtonFactory extends CustomButtonFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "PushButton";
    
    public PushButtonFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
    }

    @Override
    protected PushButton newInstance(Element element) {
        return new PushButton();
    }
    
    public PushButton create(java.util.List<Object> ancestors,final Element element) {
        final PushButton item = (PushButton)createInstance(element);
        new WidgetDOMConverter<PushButton>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
