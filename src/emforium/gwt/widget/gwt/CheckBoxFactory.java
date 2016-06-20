// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.ButtonBaseFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  class CheckBoxFactory extends ButtonBaseFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "CheckBox";
    
    public CheckBoxFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("accessKey", new CharacterAttributeSetter<CheckBox>() {
            public void set(CheckBox widget, Element element, String name, char value) {
                widget.setAccessKey(value);
            }
        });
        register("checked", new BooleanAttributeSetter<CheckBox>() {
            public void set(CheckBox widget, Element element, String name, boolean value) {
                widget.setChecked(value);
            }
        });
        register("enabled", new BooleanAttributeSetter<CheckBox>() {
            public void set(CheckBox widget, Element element, String name, boolean value) {
                widget.setEnabled(value);
            }
        });
        register("focus", new BooleanAttributeSetter<CheckBox>() {
            public void set(CheckBox widget, Element element, String name, boolean value) {
                widget.setFocus(value);
            }
        });
        register("hTML", new StringAttributeSetter<CheckBox>() {
            public void set(CheckBox widget, Element element, String name, String value) {
                widget.setHTML(value);
            }
        });
        register("name", new StringAttributeSetter<CheckBox>() {
            public void set(CheckBox widget, Element element, String name, String value) {
                widget.setName(value);
            }
        });
        register("tabIndex", new IntegerAttributeSetter<CheckBox>() {
            public void set(CheckBox widget, Element element, String name, int value) {
                widget.setTabIndex(value);
            }
        });
        register("text", new StringAttributeSetter<CheckBox>() {
            public void set(CheckBox widget, Element element, String name, String value) {
                widget.setText(value);
            }
        });
    }

    @Override
    protected CheckBox newInstance(Element element) {
        return new CheckBox();
    }
    
    public CheckBox create(java.util.List<Object> ancestors,final Element element) {
        final CheckBox item = (CheckBox)createInstance(element);
        new WidgetDOMConverter<CheckBox>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
