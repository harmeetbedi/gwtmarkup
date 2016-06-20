// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.layout.TableRowLayout;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;


public  class TableRowLayoutFactory extends TableLayoutFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "TableRowLayout";
    
    public TableRowLayoutFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
    }

    @Override
    protected TableRowLayout newInstance(Element element) {
        return new TableRowLayout();
    }
    
    public TableRowLayout create(java.util.List<Object> ancestors,final Element element) {
        final TableRowLayout item = (TableRowLayout)createInstance(element);
        new WidgetDOMConverter<TableRowLayout>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
