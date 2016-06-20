// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.FocusWidgetFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  class AnchorFactory extends FocusWidgetFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "Anchor";
    
    public AnchorFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("accessKey", new CharacterAttributeSetter<Anchor>() {
            public void set(Anchor widget, Element element, String name, char value) {
                widget.setAccessKey(value);
            }
        });
        register("focus", new BooleanAttributeSetter<Anchor>() {
            public void set(Anchor widget, Element element, String name, boolean value) {
                widget.setFocus(value);
            }
        });
        register("href", new StringAttributeSetter<Anchor>() {
            public void set(Anchor widget, Element element, String name, String value) {
                widget.setHref(value);
            }
        });
        register("hTML", new StringAttributeSetter<Anchor>() {
            public void set(Anchor widget, Element element, String name, String value) {
                widget.setHTML(value);
            }
        });
        register("name", new StringAttributeSetter<Anchor>() {
            public void set(Anchor widget, Element element, String name, String value) {
                widget.setName(value);
            }
        });
        register("tabIndex", new IntegerAttributeSetter<Anchor>() {
            public void set(Anchor widget, Element element, String name, int value) {
                widget.setTabIndex(value);
            }
        });
        register("target", new StringAttributeSetter<Anchor>() {
            public void set(Anchor widget, Element element, String name, String value) {
                widget.setTarget(value);
            }
        });
        register("text", new StringAttributeSetter<Anchor>() {
            public void set(Anchor widget, Element element, String name, String value) {
                widget.setText(value);
            }
        });
        register("wordWrap", new BooleanAttributeSetter<Anchor>() {
            public void set(Anchor widget, Element element, String name, boolean value) {
                widget.setWordWrap(value);
            }
        });
    }

    @Override
    protected Anchor newInstance(Element element) {
        return new Anchor();
    }
    
    public Anchor create(java.util.List<Object> ancestors,final Element element) {
        final Anchor item = (Anchor)createInstance(element);
        new WidgetDOMConverter<Anchor>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
