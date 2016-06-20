// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.UIObjectFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  class TreeItemFactory extends UIObjectFactory<TreeItem> {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "TreeItem";
    
    public TreeItemFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("hTML", new StringAttributeSetter<TreeItem>() {
            public void set(TreeItem widget, Element element, String name, String value) {
                widget.setHTML(value);
            }
        });
        register("selected", new BooleanAttributeSetter<TreeItem>() {
            public void set(TreeItem widget, Element element, String name, boolean value) {
                widget.setSelected(value);
            }
        });
        register("state", new BooleanAttributeSetter<TreeItem>() {
            public void set(TreeItem widget, Element element, String name, boolean value) {
                widget.setState(value);
            }
        });
        register("text", new StringAttributeSetter<TreeItem>() {
            public void set(TreeItem widget, Element element, String name, String value) {
                widget.setText(value);
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
                if ( widget instanceof com.google.gwt.user.client.ui.TreeItem && "addItem".equalsIgnoreCase(addFunc) )
                    item.addItem((com.google.gwt.user.client.ui.TreeItem)widget);
                else 
                if ( widget instanceof com.google.gwt.user.client.ui.Widget && "addItem".equalsIgnoreCase(addFunc) )
                    item.addItem((com.google.gwt.user.client.ui.Widget)widget);
                else 
                if ( widget instanceof com.google.gwt.user.client.ui.Widget )
                    item.setWidget((com.google.gwt.user.client.ui.Widget)widget);
            }
        };
        return item;
    }
}
