// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.treetable.RootTreeTableItem;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.util.GwtXMLHelper;


public  class RootTreeTableItemFactory extends TreeTableItemFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "RootTreeTableItem";
    
    public RootTreeTableItemFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
    }

    /** override to create instance with arguments */
    @Override
    protected RootTreeTableItem newInstance(Element element) {
        throw new RuntimeException("override to create instance with arguments");
    }
    
    public RootTreeTableItem create(java.util.List<Object> ancestors,final Element element) {
        final RootTreeTableItem item = (RootTreeTableItem)createInstance(element);
        new WidgetDOMConverter<RootTreeTableItem>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
                String function = GwtXMLHelper.getAttribute(element,emforium.gwt.widget.MarkupConstants.CHILDTYPE_XML_ATTRIBUTE_NAME);
                String setFunc = "set"+function;
                String addFunc = "add"+function;
                if ( widget instanceof com.extjs.gxt.ui.client.widget.tree.TreeItem )
                    item.add((com.extjs.gxt.ui.client.widget.tree.TreeItem)widget);
            }
        };
        return item;
    }
}
