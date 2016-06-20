// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.table.TableColumnUI;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;


public  class TableColumnUIFactory extends BoxComponentFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "TableColumnUI";
    
    public TableColumnUIFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
    }

    /** override to create instance with arguments */
    @Override
    protected TableColumnUI newInstance(Element element) {
        throw new RuntimeException("override to create instance with arguments");
    }
    
    public TableColumnUI create(java.util.List<Object> ancestors,final Element element) {
        final TableColumnUI item = (TableColumnUI)createInstance(element);
        new WidgetDOMConverter<TableColumnUI>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
