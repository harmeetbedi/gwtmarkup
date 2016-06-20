// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  class FormLayoutFactory extends AnchorLayoutFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "FormLayout";
    
    public FormLayoutFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("defaultWidth", new IntegerAttributeSetter<FormLayout>() {
            public void set(FormLayout widget, Element element, String name, int value) {
                widget.setDefaultWidth(value);
            }
        });
        register("hideLabels", new BooleanAttributeSetter<FormLayout>() {
            public void set(FormLayout widget, Element element, String name, boolean value) {
                widget.setHideLabels(value);
            }
        });
        register("labelPad", new IntegerAttributeSetter<FormLayout>() {
            public void set(FormLayout widget, Element element, String name, int value) {
                widget.setLabelPad(value);
            }
        });
        register("labelSeparator", new StringAttributeSetter<FormLayout>() {
            public void set(FormLayout widget, Element element, String name, String value) {
                widget.setLabelSeparator(value);
            }
        });
        register("labelWidth", new IntegerAttributeSetter<FormLayout>() {
            public void set(FormLayout widget, Element element, String name, int value) {
                widget.setLabelWidth(value);
            }
        });
        register("padding", new IntegerAttributeSetter<FormLayout>() {
            public void set(FormLayout widget, Element element, String name, int value) {
                widget.setPadding(value);
            }
        });
    }

    @Override
    protected FormLayout newInstance(Element element) {
        return new FormLayout();
    }
    
    public FormLayout create(java.util.List<Object> ancestors,final Element element) {
        final FormLayout item = (FormLayout)createInstance(element);
        new WidgetDOMConverter<FormLayout>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
                String function = GwtXMLHelper.getAttribute(element,emforium.gwt.widget.MarkupConstants.CHILDTYPE_XML_ATTRIBUTE_NAME);
                String setFunc = "set"+function;
                String addFunc = "add"+function;
                if ( widget instanceof com.extjs.gxt.ui.client.widget.Container )
                    item.setContainer((com.extjs.gxt.ui.client.widget.Container)widget);
            }
        };
        return item;
    }
}
