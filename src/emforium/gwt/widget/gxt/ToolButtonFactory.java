// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.button.ToolButton;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;


public  class ToolButtonFactory extends IconButtonFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "ToolButton";
    
    public ToolButtonFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
    }

    /** override to create instance with arguments */
    @Override
    protected ToolButton newInstance(Element element) {
        throw new RuntimeException("override to create instance with arguments");
    }
    
    public ToolButton create(java.util.List<Object> ancestors,final Element element) {
        final ToolButton item = (ToolButton)createInstance(element);
        new WidgetDOMConverter<ToolButton>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
