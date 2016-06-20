// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.toolbar.TextToolItem;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  class TextToolItemFactory extends ToolItemFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "TextToolItem";
    
    public TextToolItemFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("iconStyle", new StringAttributeSetter<TextToolItem>() {
            public void set(TextToolItem widget, Element element, String name, String value) {
                widget.setIconStyle(value);
            }
        });
        register("text", new StringAttributeSetter<TextToolItem>() {
            public void set(TextToolItem widget, Element element, String name, String value) {
                widget.setText(value);
            }
        });
        register("toolTip", new StringAttributeSetter<TextToolItem>() {
            public void set(TextToolItem widget, Element element, String name, String value) {
                widget.setToolTip(value);
            }
        });
    }

    @Override
    protected TextToolItem newInstance(Element element) {
        return new TextToolItem();
    }
    
    public TextToolItem create(java.util.List<Object> ancestors,final Element element) {
        final TextToolItem item = (TextToolItem)createInstance(element);
        new WidgetDOMConverter<TextToolItem>(ancestors,item,element) {
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
