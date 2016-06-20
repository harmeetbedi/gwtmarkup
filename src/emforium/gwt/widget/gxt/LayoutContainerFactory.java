// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;
import com.extjs.gxt.ui.client.widget.Layout;


public  class LayoutContainerFactory extends ScrollContainerFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "LayoutContainer";
    
    public LayoutContainerFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("layoutOnChange", new BooleanAttributeSetter<LayoutContainer>() {
            public void set(LayoutContainer widget, Element element, String name, boolean value) {
                widget.setLayoutOnChange(value);
            }
        });
        register("monitorWindowResize", new BooleanAttributeSetter<LayoutContainer>() {
            public void set(LayoutContainer widget, Element element, String name, boolean value) {
                widget.setMonitorWindowResize(value);
            }
        });
    }

    @Override
    protected LayoutContainer newInstance(Element element) {
        return new LayoutContainer();
    }
    
    public LayoutContainer create(java.util.List<Object> ancestors,final Element element) {
        final LayoutContainer item = (LayoutContainer)createInstance(element);
        new WidgetDOMConverter<LayoutContainer>(ancestors,item,element) {
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
