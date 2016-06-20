// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.LayoutFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  class RowLayoutFactory extends LayoutFactory<RowLayout> {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "RowLayout";
    
    public RowLayoutFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("adjustForScroll", new BooleanAttributeSetter<RowLayout>() {
            public void set(RowLayout widget, Element element, String name, boolean value) {
                widget.setAdjustForScroll(value);
            }
        });
    }

    @Override
    protected RowLayout newInstance(Element element) {
        return new RowLayout();
    }
    
    public RowLayout create(java.util.List<Object> ancestors,final Element element) {
        final RowLayout item = (RowLayout)createInstance(element);
        new WidgetDOMConverter<RowLayout>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
