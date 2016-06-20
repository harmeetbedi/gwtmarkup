// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.InlineHTML;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.HTMLFactory;
import com.google.gwt.user.client.Element;


public  class InlineHTMLFactory extends HTMLFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "InlineHTML";
    
    public InlineHTMLFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
    }

    @Override
    protected InlineHTML newInstance(Element element) {
        return new InlineHTML();
    }
    
    public InlineHTML create(java.util.List<Object> ancestors,final Element element) {
        final InlineHTML item = (InlineHTML)createInstance(element);
        new WidgetDOMConverter<InlineHTML>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
