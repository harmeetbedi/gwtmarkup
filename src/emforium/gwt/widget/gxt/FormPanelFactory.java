// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  class FormPanelFactory extends ContentPanelFactory {
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
        register("fieldWidth", new IntegerAttributeSetter<FormPanel>() {
            public void set(FormPanel widget, Element element, String name, int value) {
                widget.setFieldWidth(value);
            }
        });
        register("hideLabels", new BooleanAttributeSetter<FormPanel>() {
            public void set(FormPanel widget, Element element, String name, boolean value) {
                widget.setHideLabels(value);
            }
        });
        register("labelSeparator", new StringAttributeSetter<FormPanel>() {
            public void set(FormPanel widget, Element element, String name, String value) {
                widget.setLabelSeparator(value);
            }
        });
        register("labelWidth", new IntegerAttributeSetter<FormPanel>() {
            public void set(FormPanel widget, Element element, String name, int value) {
                widget.setLabelWidth(value);
            }
        });
        register("padding", new IntegerAttributeSetter<FormPanel>() {
            public void set(FormPanel widget, Element element, String name, int value) {
                widget.setPadding(value);
            }
        });
        register("readOnly", new BooleanAttributeSetter<FormPanel>() {
            public void set(FormPanel widget, Element element, String name, boolean value) {
                widget.setReadOnly(value);
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
