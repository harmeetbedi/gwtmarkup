// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.toolbar.AdapterToolItem;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;


public  class AdapterToolItemFactory extends ToolItemFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "AdapterToolItem";
    
    public AdapterToolItemFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
    }

    /** override to create instance with arguments */
    @Override
    protected AdapterToolItem newInstance(Element element) {
        throw new RuntimeException("override to create instance with arguments");
    }
    
    public AdapterToolItem create(java.util.List<Object> ancestors,final Element element) {
        final AdapterToolItem item = (AdapterToolItem)createInstance(element);
        new WidgetDOMConverter<AdapterToolItem>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
