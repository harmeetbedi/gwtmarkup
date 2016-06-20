// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.toolbar.FillToolItem;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;


public  class FillToolItemFactory extends ToolItemFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "FillToolItem";
    
    public FillToolItemFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
    }

    @Override
    protected FillToolItem newInstance(Element element) {
        return new FillToolItem();
    }
    
    public FillToolItem create(java.util.List<Object> ancestors,final Element element) {
        final FillToolItem item = (FillToolItem)createInstance(element);
        new WidgetDOMConverter<FillToolItem>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
