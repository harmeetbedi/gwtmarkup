// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.LabelFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  class HTMLFactory extends LabelFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "HTML";
    
    public HTMLFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("hTML", new StringAttributeSetter<HTML>() {
            public void set(HTML widget, Element element, String name, String value) {
                widget.setHTML(value);
            }
        });
    }

    @Override
    protected HTML newInstance(Element element) {
        return new HTML();
    }
    
    public HTML create(java.util.List<Object> ancestors,final Element element) {
        final HTML item = (HTML)createInstance(element);
        new WidgetDOMConverter<HTML>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
