// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.WidgetComponent;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;


public  class WidgetComponentFactory extends BoxComponentFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "WidgetComponent";
    
    public WidgetComponentFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
    }

    /** override to create instance with arguments */
    @Override
    protected WidgetComponent newInstance(Element element) {
        throw new RuntimeException("override to create instance with arguments");
    }
    
    public WidgetComponent create(java.util.List<Object> ancestors,final Element element) {
        final WidgetComponent item = (WidgetComponent)createInstance(element);
        new WidgetDOMConverter<WidgetComponent>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
