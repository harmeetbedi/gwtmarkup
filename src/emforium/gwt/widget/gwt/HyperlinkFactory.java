// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.WidgetFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  class HyperlinkFactory extends WidgetFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "Hyperlink";
    
    public HyperlinkFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("hTML", new StringAttributeSetter<Hyperlink>() {
            public void set(Hyperlink widget, Element element, String name, String value) {
                widget.setHTML(value);
            }
        });
        register("targetHistoryToken", new StringAttributeSetter<Hyperlink>() {
            public void set(Hyperlink widget, Element element, String name, String value) {
                widget.setTargetHistoryToken(value);
            }
        });
        register("text", new StringAttributeSetter<Hyperlink>() {
            public void set(Hyperlink widget, Element element, String name, String value) {
                widget.setText(value);
            }
        });
    }

    @Override
    protected Hyperlink newInstance(Element element) {
        return new Hyperlink();
    }
    
    public Hyperlink create(java.util.List<Object> ancestors,final Element element) {
        final Hyperlink item = (Hyperlink)createInstance(element);
        new WidgetDOMConverter<Hyperlink>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
