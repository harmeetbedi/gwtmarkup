// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  class MenuFactory extends ContainerFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "Menu";
    
    public MenuFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("constrainViewport", new BooleanAttributeSetter<Menu>() {
            public void set(Menu widget, Element element, String name, boolean value) {
                widget.setConstrainViewport(value);
            }
        });
        register("defaultAlign", new StringAttributeSetter<Menu>() {
            public void set(Menu widget, Element element, String name, String value) {
                widget.setDefaultAlign(value);
            }
        });
        register("minWidth", new IntegerAttributeSetter<Menu>() {
            public void set(Menu widget, Element element, String name, int value) {
                widget.setMinWidth(value);
            }
        });
        register("subMenuAlign", new StringAttributeSetter<Menu>() {
            public void set(Menu widget, Element element, String name, String value) {
                widget.setSubMenuAlign(value);
            }
        });
    }

    @Override
    protected Menu newInstance(Element element) {
        return new Menu();
    }
    
    public Menu create(java.util.List<Object> ancestors,final Element element) {
        final Menu item = (Menu)createInstance(element);
        new WidgetDOMConverter<Menu>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
                String function = GwtXMLHelper.getAttribute(element,emforium.gwt.widget.MarkupConstants.CHILDTYPE_XML_ATTRIBUTE_NAME);
                String setFunc = "set"+function;
                String addFunc = "add"+function;
                if ( widget instanceof com.extjs.gxt.ui.client.widget.menu.Item )
                    item.add((com.extjs.gxt.ui.client.widget.menu.Item)widget);
            }
        };
        return item;
    }
}
