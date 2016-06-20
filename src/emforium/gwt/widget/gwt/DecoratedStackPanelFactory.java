// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.DecoratedStackPanel;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.StackPanelFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.util.GwtXMLHelper;


public  class DecoratedStackPanelFactory extends StackPanelFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "DecoratedStackPanel";
    
    public DecoratedStackPanelFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
    }

    @Override
    protected DecoratedStackPanel newInstance(Element element) {
        return new DecoratedStackPanel();
    }
    
    public DecoratedStackPanel create(java.util.List<Object> ancestors,final Element element) {
        final DecoratedStackPanel item = (DecoratedStackPanel)createInstance(element);
        new WidgetDOMConverter<DecoratedStackPanel>(ancestors,item,element) {
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
