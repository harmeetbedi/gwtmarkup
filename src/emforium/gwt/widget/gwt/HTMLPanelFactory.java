// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.ComplexPanelFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.util.GwtXMLHelper;


public  class HTMLPanelFactory extends ComplexPanelFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "HTMLPanel";
    
    public HTMLPanelFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
    }

    /** override to create instance with arguments */
    @Override
    protected HTMLPanel newInstance(Element element) {
        throw new RuntimeException("override to create instance with arguments");
    }
    
    public HTMLPanel create(java.util.List<Object> ancestors,final Element element) {
        final HTMLPanel item = (HTMLPanel)createInstance(element);
        new WidgetDOMConverter<HTMLPanel>(ancestors,item,element) {
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
