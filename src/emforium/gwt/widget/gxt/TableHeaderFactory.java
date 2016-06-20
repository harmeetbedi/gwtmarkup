// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.table.TableHeader;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.util.GwtXMLHelper;


public  class TableHeaderFactory extends BoxComponentFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "TableHeader";
    
    public TableHeaderFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
    }

    @Override
    protected TableHeader newInstance(Element element) {
        return new TableHeader();
    }
    
    public TableHeader create(java.util.List<Object> ancestors,final Element element) {
        final TableHeader item = (TableHeader)createInstance(element);
        new WidgetDOMConverter<TableHeader>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
                String function = GwtXMLHelper.getAttribute(element,emforium.gwt.widget.MarkupConstants.CHILDTYPE_XML_ATTRIBUTE_NAME);
                String setFunc = "set"+function;
                String addFunc = "add"+function;
                if ( widget instanceof com.extjs.gxt.ui.client.widget.table.TableColumnUI && "addColumn".equalsIgnoreCase(addFunc) )
                    item.addColumn((com.extjs.gxt.ui.client.widget.table.TableColumnUI)widget);
            }
        };
        return item;
    }
}
