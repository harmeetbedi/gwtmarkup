// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.CompositeFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  class DisclosurePanelFactory extends CompositeFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "DisclosurePanel";
    
    public DisclosurePanelFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("animationEnabled", new BooleanAttributeSetter<DisclosurePanel>() {
            public void set(DisclosurePanel widget, Element element, String name, boolean value) {
                widget.setAnimationEnabled(value);
            }
        });
        register("open", new BooleanAttributeSetter<DisclosurePanel>() {
            public void set(DisclosurePanel widget, Element element, String name, boolean value) {
                widget.setOpen(value);
            }
        });
    }

    @Override
    protected DisclosurePanel newInstance(Element element) {
        return new DisclosurePanel();
    }
    
    public DisclosurePanel create(java.util.List<Object> ancestors,final Element element) {
        final DisclosurePanel item = (DisclosurePanel)createInstance(element);
        new WidgetDOMConverter<DisclosurePanel>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
                String function = GwtXMLHelper.getAttribute(element,emforium.gwt.widget.MarkupConstants.CHILDTYPE_XML_ATTRIBUTE_NAME);
                String setFunc = "set"+function;
                String addFunc = "add"+function;
                if ( widget instanceof com.google.gwt.user.client.ui.Widget && "setContent".equalsIgnoreCase(setFunc) )
                    item.setContent((com.google.gwt.user.client.ui.Widget)widget);
                else 
                if ( widget instanceof com.google.gwt.user.client.ui.Widget && "setHeader".equalsIgnoreCase(setFunc) )
                    item.setHeader((com.google.gwt.user.client.ui.Widget)widget);
                else 
                if ( widget instanceof com.google.gwt.user.client.ui.Widget )
                    item.add((com.google.gwt.user.client.ui.Widget)widget);
            }
        };
        return item;
    }
}
