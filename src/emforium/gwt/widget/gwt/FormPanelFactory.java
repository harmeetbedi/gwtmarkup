// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.SimplePanelFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  class FormPanelFactory extends SimplePanelFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "FormPanel";
    
    public FormPanelFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("action", new StringAttributeSetter<FormPanel>() {
            public void set(FormPanel widget, Element element, String name, String value) {
                widget.setAction(value);
            }
        });
        register("encoding", new StringAttributeSetter<FormPanel>() {
            public void set(FormPanel widget, Element element, String name, String value) {
                widget.setEncoding(value);
            }
        });
        register("method", new StringAttributeSetter<FormPanel>() {
            public void set(FormPanel widget, Element element, String name, String value) {
                widget.setMethod(value);
            }
        });
    }

    @Override
    protected FormPanel newInstance(Element element) {
        return new FormPanel();
    }
    
    public FormPanel create(java.util.List<Object> ancestors,final Element element) {
        final FormPanel item = (FormPanel)createInstance(element);
        new WidgetDOMConverter<FormPanel>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
                String function = GwtXMLHelper.getAttribute(element,emforium.gwt.widget.MarkupConstants.CHILDTYPE_XML_ATTRIBUTE_NAME);
                String setFunc = "set"+function;
                String addFunc = "add"+function;
                if ( widget instanceof com.google.gwt.user.client.ui.Widget )
                    item.add((com.google.gwt.user.client.ui.Widget)widget);
                else 
                if ( widget instanceof com.google.gwt.user.client.ui.Widget )
                    item.setWidget((com.google.gwt.user.client.ui.Widget)widget);
            }
        };
        return item;
    }
}
