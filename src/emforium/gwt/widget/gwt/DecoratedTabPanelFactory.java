// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.TabPanelFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.util.GwtXMLHelper;


public  class DecoratedTabPanelFactory extends TabPanelFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "DecoratedTabPanel";
    
    public DecoratedTabPanelFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
    }

    @Override
    protected DecoratedTabPanel newInstance(Element element) {
        return new DecoratedTabPanel();
    }
    
    public DecoratedTabPanel create(java.util.List<Object> ancestors,final Element element) {
        final DecoratedTabPanel item = (DecoratedTabPanel)createInstance(element);
        new WidgetDOMConverter<DecoratedTabPanel>(ancestors,item,element) {
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
