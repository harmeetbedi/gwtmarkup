// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.LayoutFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  class ColumnLayoutFactory extends LayoutFactory<ColumnLayout> {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "ColumnLayout";
    
    public ColumnLayoutFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("adjustForScroll", new BooleanAttributeSetter<ColumnLayout>() {
            public void set(ColumnLayout widget, Element element, String name, boolean value) {
                widget.setAdjustForScroll(value);
            }
        });
    }

    @Override
    protected ColumnLayout newInstance(Element element) {
        return new ColumnLayout();
    }
    
    public ColumnLayout create(java.util.List<Object> ancestors,final Element element) {
        final ColumnLayout item = (ColumnLayout)createInstance(element);
        new WidgetDOMConverter<ColumnLayout>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
