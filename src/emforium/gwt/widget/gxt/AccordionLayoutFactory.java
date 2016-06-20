// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.layout.AccordionLayout;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  class AccordionLayoutFactory extends FitLayoutFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "AccordionLayout";
    
    public AccordionLayoutFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("activeOnTop", new BooleanAttributeSetter<AccordionLayout>() {
            public void set(AccordionLayout widget, Element element, String name, boolean value) {
                widget.setActiveOnTop(value);
            }
        });
        register("autoWidth", new BooleanAttributeSetter<AccordionLayout>() {
            public void set(AccordionLayout widget, Element element, String name, boolean value) {
                widget.setAutoWidth(value);
            }
        });
        register("fill", new BooleanAttributeSetter<AccordionLayout>() {
            public void set(AccordionLayout widget, Element element, String name, boolean value) {
                widget.setFill(value);
            }
        });
        register("hideCollapseTool", new BooleanAttributeSetter<AccordionLayout>() {
            public void set(AccordionLayout widget, Element element, String name, boolean value) {
                widget.setHideCollapseTool(value);
            }
        });
        register("titleCollapse", new BooleanAttributeSetter<AccordionLayout>() {
            public void set(AccordionLayout widget, Element element, String name, boolean value) {
                widget.setTitleCollapse(value);
            }
        });
    }

    @Override
    protected AccordionLayout newInstance(Element element) {
        return new AccordionLayout();
    }
    
    public AccordionLayout create(java.util.List<Object> ancestors,final Element element) {
        final AccordionLayout item = (AccordionLayout)createInstance(element);
        new WidgetDOMConverter<AccordionLayout>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
                String function = GwtXMLHelper.getAttribute(element,emforium.gwt.widget.MarkupConstants.CHILDTYPE_XML_ATTRIBUTE_NAME);
                String setFunc = "set"+function;
                String addFunc = "add"+function;
                if ( widget instanceof com.extjs.gxt.ui.client.widget.Component && "setActiveItem".equalsIgnoreCase(setFunc) )
                    item.setActiveItem((com.extjs.gxt.ui.client.widget.Component)widget);
            }
        };
        return item;
    }
}
