// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.Editor;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  class EditorFactory extends BoxComponentFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "Editor";
    
    public EditorFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("alignment", new StringAttributeSetter<Editor>() {
            public void set(Editor widget, Element element, String name, String value) {
                widget.setAlignment(value);
            }
        });
        register("allowBlur", new BooleanAttributeSetter<Editor>() {
            public void set(Editor widget, Element element, String name, boolean value) {
                widget.setAllowBlur(value);
            }
        });
        register("cancelOnEsc", new BooleanAttributeSetter<Editor>() {
            public void set(Editor widget, Element element, String name, boolean value) {
                widget.setCancelOnEsc(value);
            }
        });
        register("completeOnEnter", new BooleanAttributeSetter<Editor>() {
            public void set(Editor widget, Element element, String name, boolean value) {
                widget.setCompleteOnEnter(value);
            }
        });
        register("constrain", new BooleanAttributeSetter<Editor>() {
            public void set(Editor widget, Element element, String name, boolean value) {
                widget.setConstrain(value);
            }
        });
        register("revertInvalid", new BooleanAttributeSetter<Editor>() {
            public void set(Editor widget, Element element, String name, boolean value) {
                widget.setRevertInvalid(value);
            }
        });
        register("swallowKeys", new BooleanAttributeSetter<Editor>() {
            public void set(Editor widget, Element element, String name, boolean value) {
                widget.setSwallowKeys(value);
            }
        });
        register("updateEl", new BooleanAttributeSetter<Editor>() {
            public void set(Editor widget, Element element, String name, boolean value) {
                widget.setUpdateEl(value);
            }
        });
    }

    /** override to create instance with arguments */
    @Override
    protected Editor newInstance(Element element) {
        throw new RuntimeException("override to create instance with arguments");
    }
    
    public Editor create(java.util.List<Object> ancestors,final Element element) {
        final Editor item = (Editor)createInstance(element);
        new WidgetDOMConverter<Editor>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
