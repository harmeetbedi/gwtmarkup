// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.tips.Tip;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  class TipFactory extends ContentPanelFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "Tip";
    
    public TipFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("closable", new BooleanAttributeSetter<Tip>() {
            public void set(Tip widget, Element element, String name, boolean value) {
                widget.setClosable(value);
            }
        });
        register("maxWidth", new IntegerAttributeSetter<Tip>() {
            public void set(Tip widget, Element element, String name, int value) {
                widget.setMaxWidth(value);
            }
        });
        register("minWidth", new IntegerAttributeSetter<Tip>() {
            public void set(Tip widget, Element element, String name, int value) {
                widget.setMinWidth(value);
            }
        });
    }

    @Override
    protected Tip newInstance(Element element) {
        return new Tip();
    }
    
    public Tip create(java.util.List<Object> ancestors,final Element element) {
        final Tip item = (Tip)createInstance(element);
        new WidgetDOMConverter<Tip>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
                String function = GwtXMLHelper.getAttribute(element,emforium.gwt.widget.MarkupConstants.CHILDTYPE_XML_ATTRIBUTE_NAME);
                String setFunc = "set"+function;
                String addFunc = "add"+function;
                if ( widget instanceof com.extjs.gxt.ui.client.widget.Component && "setBottomComponent".equalsIgnoreCase(setFunc) )
                    item.setBottomComponent((com.extjs.gxt.ui.client.widget.Component)widget);
                else 
                if ( widget instanceof com.extjs.gxt.ui.client.widget.Component && "setTopComponent".equalsIgnoreCase(setFunc) )
                    item.setTopComponent((com.extjs.gxt.ui.client.widget.Component)widget);
                else 
                if ( widget instanceof com.extjs.gxt.ui.client.widget.button.Button )
                    item.addButton((com.extjs.gxt.ui.client.widget.button.Button)widget);
                else 
                if ( widget instanceof com.extjs.gxt.ui.client.widget.button.ButtonBar )
                    item.setButtonBar((com.extjs.gxt.ui.client.widget.button.ButtonBar)widget);
                else 
                if ( widget instanceof com.google.gwt.user.client.ui.Widget )
                    item.add((com.google.gwt.user.client.ui.Widget)widget);
            }
        };
        return item;
    }
}
