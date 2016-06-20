// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.HtmlContainer;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  class HtmlContainerFactory extends ContainerFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "HtmlContainer";
    
    public HtmlContainerFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("html", new StringAttributeSetter<HtmlContainer>() {
            public void set(HtmlContainer widget, Element element, String name, String value) {
                widget.setHtml(value);
            }
        });
        register("tagName", new StringAttributeSetter<HtmlContainer>() {
            public void set(HtmlContainer widget, Element element, String name, String value) {
                widget.setTagName(value);
            }
        });
        register("url", new StringAttributeSetter<HtmlContainer>() {
            public void set(HtmlContainer widget, Element element, String name, String value) {
                widget.setUrl(value);
            }
        });
    }

    @Override
    protected HtmlContainer newInstance(Element element) {
        return new HtmlContainer();
    }
    
    public HtmlContainer create(java.util.List<Object> ancestors,final Element element) {
        final HtmlContainer item = (HtmlContainer)createInstance(element);
        new WidgetDOMConverter<HtmlContainer>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
