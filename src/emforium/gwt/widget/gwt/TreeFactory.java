// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.WidgetFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  class TreeFactory extends WidgetFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "Tree";
    
    public TreeFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("accessKey", new CharacterAttributeSetter<Tree>() {
            public void set(Tree widget, Element element, String name, char value) {
                widget.setAccessKey(value);
            }
        });
        register("animationEnabled", new BooleanAttributeSetter<Tree>() {
            public void set(Tree widget, Element element, String name, boolean value) {
                widget.setAnimationEnabled(value);
            }
        });
        register("focus", new BooleanAttributeSetter<Tree>() {
            public void set(Tree widget, Element element, String name, boolean value) {
                widget.setFocus(value);
            }
        });
        register("imageBase", new StringAttributeSetter<Tree>() {
            public void set(Tree widget, Element element, String name, String value) {
                widget.setImageBase(value);
            }
        });
        register("tabIndex", new IntegerAttributeSetter<Tree>() {
            public void set(Tree widget, Element element, String name, int value) {
                widget.setTabIndex(value);
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
                if ( widget instanceof com.google.gwt.user.client.ui.TreeItem && "addItem".equalsIgnoreCase(addFunc) )
                    item.addItem((com.google.gwt.user.client.ui.TreeItem)widget);
                else 
                if ( widget instanceof com.google.gwt.user.client.ui.Widget && "addItem".equalsIgnoreCase(addFunc) )
                    item.addItem((com.google.gwt.user.client.ui.Widget)widget);
                else 
                if ( widget instanceof com.google.gwt.user.client.ui.TreeItem && "setSelectedItem".equalsIgnoreCase(setFunc) )
                    item.setSelectedItem((com.google.gwt.user.client.ui.TreeItem)widget);
                else 
                if ( widget instanceof com.google.gwt.user.client.ui.Widget )
                    item.add((com.google.gwt.user.client.ui.Widget)widget);
            }
        };
        return item;
    }
}
