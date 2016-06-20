// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.treetable.TreeTable;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  class TreeTableFactory extends TreeFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "TreeTable";
    
    public TreeTableFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("columnContextMenu", new BooleanAttributeSetter<TreeTable>() {
            public void set(TreeTable widget, Element element, String name, boolean value) {
                widget.setColumnContextMenu(value);
            }
        });
        register("horizontalScroll", new BooleanAttributeSetter<TreeTable>() {
            public void set(TreeTable widget, Element element, String name, boolean value) {
                widget.setHorizontalScroll(value);
            }
        });
    }

    @Override
    protected TreeTable newInstance(Element element) {
        return new TreeTable();
    }
    
    public TreeTable create(java.util.List<Object> ancestors,final Element element) {
        final TreeTable item = (TreeTable)createInstance(element);
        new WidgetDOMConverter<TreeTable>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
                String function = GwtXMLHelper.getAttribute(element,emforium.gwt.widget.MarkupConstants.CHILDTYPE_XML_ATTRIBUTE_NAME);
                String setFunc = "set"+function;
                String addFunc = "add"+function;
                if ( widget instanceof com.extjs.gxt.ui.client.widget.treetable.TreeTableHeader && "setTableHeader".equalsIgnoreCase(setFunc) )
                    item.setTableHeader((com.extjs.gxt.ui.client.widget.treetable.TreeTableHeader)widget);
                else 
                if ( widget instanceof com.extjs.gxt.ui.client.widget.menu.Menu && "setContextMenu".equalsIgnoreCase(setFunc) )
                    item.setContextMenu((com.extjs.gxt.ui.client.widget.menu.Menu)widget);
                else 
                if ( widget instanceof com.extjs.gxt.ui.client.widget.tree.TreeItem && "setSelectedItem".equalsIgnoreCase(setFunc) )
                    item.setSelectedItem((com.extjs.gxt.ui.client.widget.tree.TreeItem)widget);
            }
        };
        return item;
    }
}
