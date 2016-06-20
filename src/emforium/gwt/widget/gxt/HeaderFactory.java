// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.Header;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  class HeaderFactory extends ComponentFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "Header";
    
    public HeaderFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("iconStyle", new StringAttributeSetter<Header>() {
            public void set(Header widget, Element element, String name, String value) {
                widget.setIconStyle(value);
            }
        });
        register("text", new StringAttributeSetter<Header>() {
            public void set(Header widget, Element element, String name, String value) {
                widget.setText(value);
            }
        });
        register("textStyle", new StringAttributeSetter<Header>() {
            public void set(Header widget, Element element, String name, String value) {
                widget.setTextStyle(value);
            }
        });
    }

    @Override
    protected Header newInstance(Element element) {
        return new Header();
    }
    
    public Header create(java.util.List<Object> ancestors,final Element element) {
        final Header item = (Header)createInstance(element);
        new WidgetDOMConverter<Header>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
                String function = GwtXMLHelper.getAttribute(element,emforium.gwt.widget.MarkupConstants.CHILDTYPE_XML_ATTRIBUTE_NAME);
                String setFunc = "set"+function;
                String addFunc = "add"+function;
                if ( widget instanceof com.extjs.gxt.ui.client.widget.Component && "addTool".equalsIgnoreCase(addFunc) )
                    item.addTool((com.extjs.gxt.ui.client.widget.Component)widget);
            }
        };
        return item;
    }
}
