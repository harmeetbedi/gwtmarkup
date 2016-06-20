// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.DataViewItem;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;


public  class DataViewItemFactory extends ComponentFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "DataViewItem";
    
    public DataViewItemFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
    }

    /** override to create instance with arguments */
    @Override
    protected DataViewItem newInstance(Element element) {
        throw new RuntimeException("override to create instance with arguments");
    }
    
    public DataViewItem create(java.util.List<Object> ancestors,final Element element) {
        final DataViewItem item = (DataViewItem)createInstance(element);
        new WidgetDOMConverter<DataViewItem>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
