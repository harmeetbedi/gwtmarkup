// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.toolbar.SplitToolItem;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.util.GwtXMLHelper;


public  class SplitToolItemFactory extends TextToolItemFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "SplitToolItem";
    
    public SplitToolItemFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
    }

    @Override
    protected SplitToolItem newInstance(Element element) {
        return new SplitToolItem();
    }
    
    public SplitToolItem create(java.util.List<Object> ancestors,final Element element) {
        final SplitToolItem item = (SplitToolItem)createInstance(element);
        new WidgetDOMConverter<SplitToolItem>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
                String function = GwtXMLHelper.getAttribute(element,emforium.gwt.widget.MarkupConstants.CHILDTYPE_XML_ATTRIBUTE_NAME);
                String setFunc = "set"+function;
                String addFunc = "add"+function;
                if ( widget instanceof com.extjs.gxt.ui.client.widget.menu.Menu )
                    item.setMenu((com.extjs.gxt.ui.client.widget.menu.Menu)widget);
            }
        };
        return item;
    }
}
