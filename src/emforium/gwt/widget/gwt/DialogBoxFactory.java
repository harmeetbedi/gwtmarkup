// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.DecoratedPopupPanelFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  class DialogBoxFactory extends DecoratedPopupPanelFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "DialogBox";
    
    public DialogBoxFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("hTML", new StringAttributeSetter<DialogBox>() {
            public void set(DialogBox widget, Element element, String name, String value) {
                widget.setHTML(value);
            }
        });
        register("text", new StringAttributeSetter<DialogBox>() {
            public void set(DialogBox widget, Element element, String name, String value) {
                widget.setText(value);
            }
        });
    }

    @Override
    protected DialogBox newInstance(Element element) {
        return new DialogBox();
    }
    
    public DialogBox create(java.util.List<Object> ancestors,final Element element) {
        final DialogBox item = (DialogBox)createInstance(element);
        new WidgetDOMConverter<DialogBox>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
                String function = GwtXMLHelper.getAttribute(element,emforium.gwt.widget.MarkupConstants.CHILDTYPE_XML_ATTRIBUTE_NAME);
                String setFunc = "set"+function;
                String addFunc = "add"+function;
                if ( widget instanceof com.google.gwt.user.client.ui.Widget )
                    item.setWidget((com.google.gwt.user.client.ui.Widget)widget);
                else 
                if ( widget instanceof com.google.gwt.user.client.ui.Widget )
                    item.add((com.google.gwt.user.client.ui.Widget)widget);
            }
        };
        return item;
    }
}
