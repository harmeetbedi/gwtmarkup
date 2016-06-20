// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.VerticalSplitPanel;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.SplitPanelFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  class VerticalSplitPanelFactory extends SplitPanelFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "VerticalSplitPanel";
    
    public VerticalSplitPanelFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("height", new StringAttributeSetter<VerticalSplitPanel>() {
            public void set(VerticalSplitPanel widget, Element element, String name, String value) {
                widget.setHeight(value);
            }
        });
        register("splitPosition", new StringAttributeSetter<VerticalSplitPanel>() {
            public void set(VerticalSplitPanel widget, Element element, String name, String value) {
                widget.setSplitPosition(value);
            }
        });
    }

    @Override
    protected VerticalSplitPanel newInstance(Element element) {
        return new VerticalSplitPanel();
    }
    
    public VerticalSplitPanel create(java.util.List<Object> ancestors,final Element element) {
        final VerticalSplitPanel item = (VerticalSplitPanel)createInstance(element);
        new WidgetDOMConverter<VerticalSplitPanel>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
                String function = GwtXMLHelper.getAttribute(element,emforium.gwt.widget.MarkupConstants.CHILDTYPE_XML_ATTRIBUTE_NAME);
                String setFunc = "set"+function;
                String addFunc = "add"+function;
                if ( widget instanceof com.google.gwt.user.client.ui.Widget && "setBottomWidget".equalsIgnoreCase(setFunc) )
                    item.setBottomWidget((com.google.gwt.user.client.ui.Widget)widget);
                else 
                if ( widget instanceof com.google.gwt.user.client.ui.Widget && "setTopWidget".equalsIgnoreCase(setFunc) )
                    item.setTopWidget((com.google.gwt.user.client.ui.Widget)widget);
            }
        };
        return item;
    }
}
