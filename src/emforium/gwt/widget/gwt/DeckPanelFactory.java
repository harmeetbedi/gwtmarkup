// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.DeckPanel;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.ComplexPanelFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  class DeckPanelFactory extends ComplexPanelFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "DeckPanel";
    
    public DeckPanelFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("animationEnabled", new BooleanAttributeSetter<DeckPanel>() {
            public void set(DeckPanel widget, Element element, String name, boolean value) {
                widget.setAnimationEnabled(value);
            }
        });
    }

    @Override
    protected DeckPanel newInstance(Element element) {
        return new DeckPanel();
    }
    
    public DeckPanel create(java.util.List<Object> ancestors,final Element element) {
        final DeckPanel item = (DeckPanel)createInstance(element);
        new WidgetDOMConverter<DeckPanel>(ancestors,item,element) {
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
