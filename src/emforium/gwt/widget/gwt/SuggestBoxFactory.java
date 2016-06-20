// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.CompositeFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  class SuggestBoxFactory extends CompositeFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "SuggestBox";
    
    public SuggestBoxFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("accessKey", new CharacterAttributeSetter<SuggestBox>() {
            public void set(SuggestBox widget, Element element, String name, char value) {
                widget.setAccessKey(value);
            }
        });
        register("animationEnabled", new BooleanAttributeSetter<SuggestBox>() {
            public void set(SuggestBox widget, Element element, String name, boolean value) {
                widget.setAnimationEnabled(value);
            }
        });
        register("focus", new BooleanAttributeSetter<SuggestBox>() {
            public void set(SuggestBox widget, Element element, String name, boolean value) {
                widget.setFocus(value);
            }
        });
        register("limit", new IntegerAttributeSetter<SuggestBox>() {
            public void set(SuggestBox widget, Element element, String name, int value) {
                widget.setLimit(value);
            }
        });
        register("popupStyleName", new StringAttributeSetter<SuggestBox>() {
            public void set(SuggestBox widget, Element element, String name, String value) {
                widget.setPopupStyleName(value);
            }
        });
        register("tabIndex", new IntegerAttributeSetter<SuggestBox>() {
            public void set(SuggestBox widget, Element element, String name, int value) {
                widget.setTabIndex(value);
            }
        });
        register("text", new StringAttributeSetter<SuggestBox>() {
            public void set(SuggestBox widget, Element element, String name, String value) {
                widget.setText(value);
            }
        });
    }

    @Override
    protected SuggestBox newInstance(Element element) {
        return new SuggestBox();
    }
    
    public SuggestBox create(java.util.List<Object> ancestors,final Element element) {
        final SuggestBox item = (SuggestBox)createInstance(element);
        new WidgetDOMConverter<SuggestBox>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
