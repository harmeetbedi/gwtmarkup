// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.layout.CardLayout;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  class CardLayoutFactory extends FitLayoutFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "CardLayout";
    
    public CardLayoutFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("deferredRender", new BooleanAttributeSetter<CardLayout>() {
            public void set(CardLayout widget, Element element, String name, boolean value) {
                widget.setDeferredRender(value);
            }
        });
    }

    @Override
    protected CardLayout newInstance(Element element) {
        return new CardLayout();
    }
    
    public CardLayout create(java.util.List<Object> ancestors,final Element element) {
        final CardLayout item = (CardLayout)createInstance(element);
        new WidgetDOMConverter<CardLayout>(ancestors,item,element) {
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
