// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.tips.ToolTip;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  class ToolTipFactory extends TipFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "ToolTip";
    
    public ToolTipFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("autoHide", new BooleanAttributeSetter<ToolTip>() {
            public void set(ToolTip widget, Element element, String name, boolean value) {
                widget.setAutoHide(value);
            }
        });
        register("dismissDelay", new IntegerAttributeSetter<ToolTip>() {
            public void set(ToolTip widget, Element element, String name, int value) {
                widget.setDismissDelay(value);
            }
        });
        register("hideDelay", new IntegerAttributeSetter<ToolTip>() {
            public void set(ToolTip widget, Element element, String name, int value) {
                widget.setHideDelay(value);
            }
        });
        register("showDelay", new IntegerAttributeSetter<ToolTip>() {
            public void set(ToolTip widget, Element element, String name, int value) {
                widget.setShowDelay(value);
            }
        });
        register("trackMouse", new BooleanAttributeSetter<ToolTip>() {
            public void set(ToolTip widget, Element element, String name, boolean value) {
                widget.setTrackMouse(value);
            }
        });
    }

    @Override
    protected ToolTip newInstance(Element element) {
        return new ToolTip();
    }
    
    public ToolTip create(java.util.List<Object> ancestors,final Element element) {
        final ToolTip item = (ToolTip)createInstance(element);
        new WidgetDOMConverter<ToolTip>(ancestors,item,element) {
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
