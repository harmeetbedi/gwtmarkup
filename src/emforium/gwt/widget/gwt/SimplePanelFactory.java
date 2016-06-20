// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.PanelFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.util.GwtXMLHelper;


public  class SimplePanelFactory extends PanelFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "SimplePanel";
    
    public SimplePanelFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
    }

    @Override
    protected SimplePanel newInstance(Element element) {
        return new SimplePanel();
    }
    
    public SimplePanel create(java.util.List<Object> ancestors,final Element element) {
        final SimplePanel item = (SimplePanel)createInstance(element);
        new WidgetDOMConverter<SimplePanel>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
                String function = GwtXMLHelper.getAttribute(element,emforium.gwt.widget.MarkupConstants.CHILDTYPE_XML_ATTRIBUTE_NAME);
                String setFunc = "set"+function;
                String addFunc = "add"+function;
                if ( widget instanceof com.google.gwt.user.client.ui.Widget )
                    item.add((com.google.gwt.user.client.ui.Widget)widget);
                else 
                if ( widget instanceof com.google.gwt.user.client.ui.Widget )
                    item.setWidget((com.google.gwt.user.client.ui.Widget)widget);
            }
        };
        return item;
    }
}
