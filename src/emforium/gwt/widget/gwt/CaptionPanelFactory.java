// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.CompositeFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  class CaptionPanelFactory extends CompositeFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "CaptionPanel";
    
    public CaptionPanelFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("captionHTML", new StringAttributeSetter<CaptionPanel>() {
            public void set(CaptionPanel widget, Element element, String name, String value) {
                widget.setCaptionHTML(value);
            }
        });
        register("captionText", new StringAttributeSetter<CaptionPanel>() {
            public void set(CaptionPanel widget, Element element, String name, String value) {
                widget.setCaptionText(value);
            }
        });
    }

    @Override
    protected CaptionPanel newInstance(Element element) {
        return new CaptionPanel();
    }
    
    public CaptionPanel create(java.util.List<Object> ancestors,final Element element) {
        final CaptionPanel item = (CaptionPanel)createInstance(element);
        new WidgetDOMConverter<CaptionPanel>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
                String function = GwtXMLHelper.getAttribute(element,emforium.gwt.widget.MarkupConstants.CHILDTYPE_XML_ATTRIBUTE_NAME);
                String setFunc = "set"+function;
                String addFunc = "add"+function;
                if ( widget instanceof com.google.gwt.user.client.ui.Widget && "setContentWidget".equalsIgnoreCase(setFunc) )
                    item.setContentWidget((com.google.gwt.user.client.ui.Widget)widget);
                else 
                if ( widget instanceof com.google.gwt.user.client.ui.Widget )
                    item.add((com.google.gwt.user.client.ui.Widget)widget);
            }
        };
        return item;
    }
}
