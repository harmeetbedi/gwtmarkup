// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.treetable.TreeTableItem;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.util.GwtXMLHelper;


public  class TreeTableItemFactory extends TreeItemFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "TreeTableItem";
    
    public TreeTableItemFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
    }

    /** override to create instance with arguments */
    @Override
    protected TreeTableItem newInstance(Element element) {
        throw new RuntimeException("override to create instance with arguments");
    }
    
    public TreeTableItem create(java.util.List<Object> ancestors,final Element element) {
        final TreeTableItem item = (TreeTableItem)createInstance(element);
        new WidgetDOMConverter<TreeTableItem>(ancestors,item,element) {
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
