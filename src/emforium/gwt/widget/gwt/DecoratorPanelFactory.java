// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.SimplePanelFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.util.GwtXMLHelper;


public  class DecoratorPanelFactory extends SimplePanelFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "DecoratorPanel";
    
    public DecoratorPanelFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
    }

    @Override
    protected DecoratorPanel newInstance(Element element) {
        return new DecoratorPanel();
    }
    
    public DecoratorPanel create(java.util.List<Object> ancestors,final Element element) {
        final DecoratorPanel item = (DecoratorPanel)createInstance(element);
        new WidgetDOMConverter<DecoratorPanel>(ancestors,item,element) {
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
