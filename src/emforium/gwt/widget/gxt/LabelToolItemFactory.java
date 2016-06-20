// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  class LabelToolItemFactory extends ToolItemFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "LabelToolItem";
    
    public LabelToolItemFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("label", new StringAttributeSetter<LabelToolItem>() {
            public void set(LabelToolItem widget, Element element, String name, String value) {
                widget.setLabel(value);
            }
        });
    }

    @Override
    protected LabelToolItem newInstance(Element element) {
        return new LabelToolItem();
    }
    
    public LabelToolItem create(java.util.List<Object> ancestors,final Element element) {
        final LabelToolItem item = (LabelToolItem)createInstance(element);
        new WidgetDOMConverter<LabelToolItem>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
