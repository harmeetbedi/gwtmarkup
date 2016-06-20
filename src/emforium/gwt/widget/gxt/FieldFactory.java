// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.form.Field;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  abstract  class FieldFactory extends BoxComponentFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "Field";
    
    public FieldFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("autoValidate", new BooleanAttributeSetter<Field>() {
            public void set(Field widget, Element element, String name, boolean value) {
                widget.setAutoValidate(value);
            }
        });
        register("emptyText", new StringAttributeSetter<Field>() {
            public void set(Field widget, Element element, String name, String value) {
                widget.setEmptyText(value);
            }
        });
        register("fieldLabel", new StringAttributeSetter<Field>() {
            public void set(Field widget, Element element, String name, String value) {
                widget.setFieldLabel(value);
            }
        });
        register("hideLabel", new BooleanAttributeSetter<Field>() {
            public void set(Field widget, Element element, String name, boolean value) {
                widget.setHideLabel(value);
            }
        });
        register("labelSeparator", new StringAttributeSetter<Field>() {
            public void set(Field widget, Element element, String name, String value) {
                widget.setLabelSeparator(value);
            }
        });
        register("labelStyle", new StringAttributeSetter<Field>() {
            public void set(Field widget, Element element, String name, String value) {
                widget.setLabelStyle(value);
            }
        });
        register("messageTarget", new StringAttributeSetter<Field>() {
            public void set(Field widget, Element element, String name, String value) {
                widget.setMessageTarget(value);
            }
        });
        register("name", new StringAttributeSetter<Field>() {
            public void set(Field widget, Element element, String name, String value) {
                widget.setName(value);
            }
        });
        register("rawValue", new StringAttributeSetter<Field>() {
            public void set(Field widget, Element element, String name, String value) {
                widget.setRawValue(value);
            }
        });
        register("readOnly", new BooleanAttributeSetter<Field>() {
            public void set(Field widget, Element element, String name, boolean value) {
                widget.setReadOnly(value);
            }
        });
        register("tabIndex", new IntegerAttributeSetter<Field>() {
            public void set(Field widget, Element element, String name, int value) {
                widget.setTabIndex(value);
            }
        });
        register("validateOnBlur", new BooleanAttributeSetter<Field>() {
            public void set(Field widget, Element element, String name, boolean value) {
                widget.setValidateOnBlur(value);
            }
        });
        register("validationDelay", new IntegerAttributeSetter<Field>() {
            public void set(Field widget, Element element, String name, int value) {
                widget.setValidationDelay(value);
            }
        });
    }

}
