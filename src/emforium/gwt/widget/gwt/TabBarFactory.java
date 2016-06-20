// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.TabBar;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.CompositeFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.util.GwtXMLHelper;


public  class TabBarFactory extends CompositeFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "TabBar";
    
    public TabBarFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
    }

    @Override
    protected TabBar newInstance(Element element) {
        return new TabBar();
    }
    
    public TabBar create(java.util.List<Object> ancestors,final Element element) {
        final TabBar item = (TabBar)createInstance(element);
        new WidgetDOMConverter<TabBar>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
                String function = GwtXMLHelper.getAttribute(element,emforium.gwt.widget.MarkupConstants.CHILDTYPE_XML_ATTRIBUTE_NAME);
                String setFunc = "set"+function;
                String addFunc = "add"+function;
                if ( widget instanceof com.google.gwt.user.client.ui.Widget && "addTab".equalsIgnoreCase(addFunc) )
                    item.addTab((com.google.gwt.user.client.ui.Widget)widget);
            }
        };
        return item;
    }
}
