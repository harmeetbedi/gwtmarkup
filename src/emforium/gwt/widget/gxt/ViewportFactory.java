// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.Viewport;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  class ViewportFactory extends LayoutContainerFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "Viewport";
    
    public ViewportFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("delay", new IntegerAttributeSetter<Viewport>() {
            public void set(Viewport widget, Element element, String name, int value) {
                widget.setDelay(value);
            }
        });
        register("enableScroll", new BooleanAttributeSetter<Viewport>() {
            public void set(Viewport widget, Element element, String name, boolean value) {
                widget.setEnableScroll(value);
            }
        });
        register("loadingPanelId", new StringAttributeSetter<Viewport>() {
            public void set(Viewport widget, Element element, String name, String value) {
                widget.setLoadingPanelId(value);
            }
        });
    }

    @Override
    protected Viewport newInstance(Element element) {
        return new Viewport();
    }
    
    public Viewport create(java.util.List<Object> ancestors,final Element element) {
        final Viewport item = (Viewport)createInstance(element);
        new WidgetDOMConverter<Viewport>(ancestors,item,element) {
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
