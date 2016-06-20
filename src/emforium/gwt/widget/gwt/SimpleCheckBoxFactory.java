// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.SimpleCheckBox;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.FocusWidgetFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  class SimpleCheckBoxFactory extends FocusWidgetFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "SimpleCheckBox";
    
    public SimpleCheckBoxFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("checked", new BooleanAttributeSetter<SimpleCheckBox>() {
            public void set(SimpleCheckBox widget, Element element, String name, boolean value) {
                widget.setChecked(value);
            }
        });
        register("enabled", new BooleanAttributeSetter<SimpleCheckBox>() {
            public void set(SimpleCheckBox widget, Element element, String name, boolean value) {
                widget.setEnabled(value);
            }
        });
        register("name", new StringAttributeSetter<SimpleCheckBox>() {
            public void set(SimpleCheckBox widget, Element element, String name, String value) {
                widget.setName(value);
            }
        });
    }

    @Override
    protected SimpleCheckBox newInstance(Element element) {
        return new SimpleCheckBox();
    }
    
    public SimpleCheckBox create(java.util.List<Object> ancestors,final Element element) {
        final SimpleCheckBox item = (SimpleCheckBox)createInstance(element);
        new WidgetDOMConverter<SimpleCheckBox>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
