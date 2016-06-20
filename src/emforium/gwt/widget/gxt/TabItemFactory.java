// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.TabItem;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  class TabItemFactory extends LayoutContainerFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "TabItem";
    
    public TabItemFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("closable", new BooleanAttributeSetter<TabItem>() {
            public void set(TabItem widget, Element element, String name, boolean value) {
                widget.setClosable(value);
            }
        });
        register("iconStyle", new StringAttributeSetter<TabItem>() {
            public void set(TabItem widget, Element element, String name, String value) {
                widget.setIconStyle(value);
            }
        });
        register("text", new StringAttributeSetter<TabItem>() {
            public void set(TabItem widget, Element element, String name, String value) {
                widget.setText(value);
            }
        });
        register("textStyle", new StringAttributeSetter<TabItem>() {
            public void set(TabItem widget, Element element, String name, String value) {
                widget.setTextStyle(value);
            }
        });
        register("url", new StringAttributeSetter<TabItem>() {
            public void set(TabItem widget, Element element, String name, String value) {
                widget.setUrl(value);
            }
        });
    }

    @Override
    protected TabItem newInstance(Element element) {
        return new TabItem();
    }
    
    public TabItem create(java.util.List<Object> ancestors,final Element element) {
        final TabItem item = (TabItem)createInstance(element);
        new WidgetDOMConverter<TabItem>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
                String function = GwtXMLHelper.getAttribute(element,emforium.gwt.widget.MarkupConstants.CHILDTYPE_XML_ATTRIBUTE_NAME);
                String setFunc = "set"+function;
                String addFunc = "add"+function;
                if ( widget instanceof com.google.gwt.user.client.ui.Widget )
                    item.add((com.google.gwt.user.client.ui.Widget)widget);
            }
        };
        return item;
    }
}
