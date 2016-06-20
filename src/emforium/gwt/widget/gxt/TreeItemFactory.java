// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.tree.TreeItem;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  class TreeItemFactory extends ComponentFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "TreeItem";
    
    public TreeItemFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("checked", new BooleanAttributeSetter<TreeItem>() {
            public void set(TreeItem widget, Element element, String name, boolean value) {
                widget.setChecked(value);
            }
        });
        register("expanded", new BooleanAttributeSetter<TreeItem>() {
            public void set(TreeItem widget, Element element, String name, boolean value) {
                widget.setExpanded(value);
            }
        });
        register("iconStyle", new StringAttributeSetter<TreeItem>() {
            public void set(TreeItem widget, Element element, String name, String value) {
                widget.setIconStyle(value);
            }
        });
        register("itemStyleName", new StringAttributeSetter<TreeItem>() {
            public void set(TreeItem widget, Element element, String name, String value) {
                widget.setItemStyleName(value);
            }
        });
        register("leaf", new BooleanAttributeSetter<TreeItem>() {
            public void set(TreeItem widget, Element element, String name, boolean value) {
                widget.setLeaf(value);
            }
        });
        register("text", new StringAttributeSetter<TreeItem>() {
            public void set(TreeItem widget, Element element, String name, String value) {
                widget.setText(value);
            }
        });
        register("textStyle", new StringAttributeSetter<TreeItem>() {
            public void set(TreeItem widget, Element element, String name, String value) {
                widget.setTextStyle(value);
            }
        });
    }

    @Override
    protected TreeItem newInstance(Element element) {
        return new TreeItem();
    }
    
    public TreeItem create(java.util.List<Object> ancestors,final Element element) {
        final TreeItem item = (TreeItem)createInstance(element);
        new WidgetDOMConverter<TreeItem>(ancestors,item,element) {
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
