// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.Html;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  class HtmlFactory extends BoxComponentFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "Html";
    
    public HtmlFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("html", new StringAttributeSetter<Html>() {
            public void set(Html widget, Element element, String name, String value) {
                widget.setHtml(value);
            }
        });
        register("tagName", new StringAttributeSetter<Html>() {
            public void set(Html widget, Element element, String name, String value) {
                widget.setTagName(value);
            }
        });
    }

    @Override
    protected Html newInstance(Element element) {
        return new Html();
    }
    
    public Html create(java.util.List<Object> ancestors,final Element element) {
        final Html item = (Html)createInstance(element);
        new WidgetDOMConverter<Html>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
