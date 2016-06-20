// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;


public  class SeparatorToolItemFactory extends ToolItemFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "SeparatorToolItem";
    
    public SeparatorToolItemFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
    }

    @Override
    protected SeparatorToolItem newInstance(Element element) {
        return new SeparatorToolItem();
    }
    
    public SeparatorToolItem create(java.util.List<Object> ancestors,final Element element) {
        final SeparatorToolItem item = (SeparatorToolItem)createInstance(element);
        new WidgetDOMConverter<SeparatorToolItem>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
