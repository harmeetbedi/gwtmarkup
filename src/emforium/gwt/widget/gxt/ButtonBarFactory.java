// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  class ButtonBarFactory extends ContainerFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "ButtonBar";
    
    public ButtonBarFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("buttonWidth", new IntegerAttributeSetter<ButtonBar>() {
            public void set(ButtonBar widget, Element element, String name, int value) {
                widget.setButtonWidth(value);
            }
        });
        register("cellSpacing", new IntegerAttributeSetter<ButtonBar>() {
            public void set(ButtonBar widget, Element element, String name, int value) {
                widget.setCellSpacing(value);
            }
        });
    }

    @Override
    protected ButtonBar newInstance(Element element) {
        return new ButtonBar();
    }
    
    public ButtonBar create(java.util.List<Object> ancestors,final Element element) {
        final ButtonBar item = (ButtonBar)createInstance(element);
        new WidgetDOMConverter<ButtonBar>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
                String function = GwtXMLHelper.getAttribute(element,emforium.gwt.widget.MarkupConstants.CHILDTYPE_XML_ATTRIBUTE_NAME);
                String setFunc = "set"+function;
                String addFunc = "add"+function;
                if ( widget instanceof com.extjs.gxt.ui.client.widget.button.Button )
                    item.add((com.extjs.gxt.ui.client.widget.button.Button)widget);
            }
        };
        return item;
    }
}
