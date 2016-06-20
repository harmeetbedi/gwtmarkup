// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.SimplePanelFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  class FocusPanelFactory extends SimplePanelFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "FocusPanel";
    
    public FocusPanelFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("accessKey", new CharacterAttributeSetter<FocusPanel>() {
            public void set(FocusPanel widget, Element element, String name, char value) {
                widget.setAccessKey(value);
            }
        });
        register("focus", new BooleanAttributeSetter<FocusPanel>() {
            public void set(FocusPanel widget, Element element, String name, boolean value) {
                widget.setFocus(value);
            }
        });
        register("tabIndex", new IntegerAttributeSetter<FocusPanel>() {
            public void set(FocusPanel widget, Element element, String name, int value) {
                widget.setTabIndex(value);
            }
        });
    }

    @Override
    protected FocusPanel newInstance(Element element) {
        return new FocusPanel();
    }
    
    public FocusPanel create(java.util.List<Object> ancestors,final Element element) {
        final FocusPanel item = (FocusPanel)createInstance(element);
        new WidgetDOMConverter<FocusPanel>(ancestors,item,element) {
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
