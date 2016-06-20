// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.tree.Tree;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  class TreeFactory extends ContainerFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "Tree";
    
    public TreeFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("animate", new BooleanAttributeSetter<Tree>() {
            public void set(Tree widget, Element element, String name, boolean value) {
                widget.setAnimate(value);
            }
        });
        register("checkable", new BooleanAttributeSetter<Tree>() {
            public void set(Tree widget, Element element, String name, boolean value) {
                widget.setCheckable(value);
            }
        });
        register("indentWidth", new IntegerAttributeSetter<Tree>() {
            public void set(Tree widget, Element element, String name, int value) {
                widget.setIndentWidth(value);
            }
        });
        register("itemIconStyle", new StringAttributeSetter<Tree>() {
            public void set(Tree widget, Element element, String name, String value) {
                widget.setItemIconStyle(value);
            }
        });
        register("nodeIconStyle", new StringAttributeSetter<Tree>() {
            public void set(Tree widget, Element element, String name, String value) {
                widget.setNodeIconStyle(value);
            }
        });
        register("openNodeIconStyle", new StringAttributeSetter<Tree>() {
            public void set(Tree widget, Element element, String name, String value) {
                widget.setOpenNodeIconStyle(value);
            }
        });
    }

    @Override
    protected Tree newInstance(Element element) {
        return new Tree();
    }
    
    public Tree create(java.util.List<Object> ancestors,final Element element) {
        final Tree item = (Tree)createInstance(element);
        new WidgetDOMConverter<Tree>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
                String function = GwtXMLHelper.getAttribute(element,emforium.gwt.widget.MarkupConstants.CHILDTYPE_XML_ATTRIBUTE_NAME);
                String setFunc = "set"+function;
                String addFunc = "add"+function;
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
