// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.HorizontalPanel;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  class HorizontalPanelFactory extends LayoutContainerFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "HorizontalPanel";
    
    public HorizontalPanelFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("spacing", new IntegerAttributeSetter<HorizontalPanel>() {
            public void set(HorizontalPanel widget, Element element, String name, int value) {
                widget.setSpacing(value);
            }
        });
        register("tableHeight", new StringAttributeSetter<HorizontalPanel>() {
            public void set(HorizontalPanel widget, Element element, String name, String value) {
                widget.setTableHeight(value);
            }
        });
        register("tableWidth", new StringAttributeSetter<HorizontalPanel>() {
            public void set(HorizontalPanel widget, Element element, String name, String value) {
                widget.setTableWidth(value);
            }
        });
    }

    @Override
    protected HorizontalPanel newInstance(Element element) {
        return new HorizontalPanel();
    }
    
    public HorizontalPanel create(java.util.List<Object> ancestors,final Element element) {
        final HorizontalPanel item = (HorizontalPanel)createInstance(element);
        new WidgetDOMConverter<HorizontalPanel>(ancestors,item,element) {
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
