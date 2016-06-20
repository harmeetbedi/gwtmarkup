// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.CollapsePanel;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  class CollapsePanelFactory extends ContentPanelFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "CollapsePanel";
    
    public CollapsePanelFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("expanded", new BooleanAttributeSetter<CollapsePanel>() {
            public void set(CollapsePanel widget, Element element, String name, boolean value) {
                widget.setExpanded(value);
            }
        });
    }

    /** override to create instance with arguments */
    @Override
    protected CollapsePanel newInstance(Element element) {
        throw new RuntimeException("override to create instance with arguments");
    }
    
    public CollapsePanel create(java.util.List<Object> ancestors,final Element element) {
        final CollapsePanel item = (CollapsePanel)createInstance(element);
        new WidgetDOMConverter<CollapsePanel>(ancestors,item,element) {
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
