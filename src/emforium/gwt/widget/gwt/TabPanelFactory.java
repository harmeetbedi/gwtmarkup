// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.CompositeFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  class TabPanelFactory extends CompositeFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "TabPanel";
    
    public TabPanelFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("animationEnabled", new BooleanAttributeSetter<TabPanel>() {
            public void set(TabPanel widget, Element element, String name, boolean value) {
                widget.setAnimationEnabled(value);
            }
        });
    }

    @Override
    protected TabPanel newInstance(Element element) {
        return new TabPanel();
    }
    
    public TabPanel create(java.util.List<Object> ancestors,final Element element) {
        final TabPanel item = (TabPanel)createInstance(element);
        new WidgetDOMConverter<TabPanel>(ancestors,item,element) {
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
