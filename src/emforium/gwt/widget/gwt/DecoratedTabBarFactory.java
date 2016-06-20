// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.DecoratedTabBar;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.TabBarFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.util.GwtXMLHelper;


public  class DecoratedTabBarFactory extends TabBarFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "DecoratedTabBar";
    
    public DecoratedTabBarFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
    }

    @Override
    protected DecoratedTabBar newInstance(Element element) {
        return new DecoratedTabBar();
    }
    
    public DecoratedTabBar create(java.util.List<Object> ancestors,final Element element) {
        final DecoratedTabBar item = (DecoratedTabBar)createInstance(element);
        new WidgetDOMConverter<DecoratedTabBar>(ancestors,item,element) {
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
