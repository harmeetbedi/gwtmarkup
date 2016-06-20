// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.Document;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;


public  class DocumentFactory extends ComponentFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "Document";
    
    public DocumentFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
    }

    /** override to create instance with arguments */
    @Override
    protected Document newInstance(Element element) {
        throw new RuntimeException("override to create instance with arguments");
    }
    
    public Document create(java.util.List<Object> ancestors,final Element element) {
        final Document item = (Document)createInstance(element);
        new WidgetDOMConverter<Document>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
