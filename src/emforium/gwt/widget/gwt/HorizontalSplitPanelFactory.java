// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.HorizontalSplitPanel;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.SplitPanelFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  class HorizontalSplitPanelFactory extends SplitPanelFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "HorizontalSplitPanel";
    
    public HorizontalSplitPanelFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("splitPosition", new StringAttributeSetter<HorizontalSplitPanel>() {
            public void set(HorizontalSplitPanel widget, Element element, String name, String value) {
                widget.setSplitPosition(value);
            }
        });
    }

    @Override
    protected HorizontalSplitPanel newInstance(Element element) {
        return new HorizontalSplitPanel();
    }
    
    public HorizontalSplitPanel create(java.util.List<Object> ancestors,final Element element) {
        final HorizontalSplitPanel item = (HorizontalSplitPanel)createInstance(element);
        new WidgetDOMConverter<HorizontalSplitPanel>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
                String function = GwtXMLHelper.getAttribute(element,emforium.gwt.widget.MarkupConstants.CHILDTYPE_XML_ATTRIBUTE_NAME);
                String setFunc = "set"+function;
                String addFunc = "add"+function;
                if ( widget instanceof com.google.gwt.user.client.ui.Widget && "setEndOfLineWidget".equalsIgnoreCase(setFunc) )
                    item.setEndOfLineWidget((com.google.gwt.user.client.ui.Widget)widget);
                else 
                if ( widget instanceof com.google.gwt.user.client.ui.Widget && "setLeftWidget".equalsIgnoreCase(setFunc) )
                    item.setLeftWidget((com.google.gwt.user.client.ui.Widget)widget);
                else 
                if ( widget instanceof com.google.gwt.user.client.ui.Widget && "setRightWidget".equalsIgnoreCase(setFunc) )
                    item.setRightWidget((com.google.gwt.user.client.ui.Widget)widget);
                else 
                if ( widget instanceof com.google.gwt.user.client.ui.Widget && "setStartOfLineWidget".equalsIgnoreCase(setFunc) )
                    item.setStartOfLineWidget((com.google.gwt.user.client.ui.Widget)widget);
                else 
                if ( widget instanceof com.google.gwt.user.client.ui.Widget )
                    item.add((com.google.gwt.user.client.ui.Widget)widget);
            }
        };
        return item;
    }
}
