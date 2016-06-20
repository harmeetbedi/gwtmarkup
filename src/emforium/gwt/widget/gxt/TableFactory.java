// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.table.Table;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  class TableFactory extends ContainerFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "Table";
    
    public TableFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("bulkRender", new BooleanAttributeSetter<Table>() {
            public void set(Table widget, Element element, String name, boolean value) {
                widget.setBulkRender(value);
            }
        });
        register("columnContextMenu", new BooleanAttributeSetter<Table>() {
            public void set(Table widget, Element element, String name, boolean value) {
                widget.setColumnContextMenu(value);
            }
        });
        register("highlight", new BooleanAttributeSetter<Table>() {
            public void set(Table widget, Element element, String name, boolean value) {
                widget.setHighlight(value);
            }
        });
        register("horizontalScroll", new BooleanAttributeSetter<Table>() {
            public void set(Table widget, Element element, String name, boolean value) {
                widget.setHorizontalScroll(value);
            }
        });
        register("stripeRows", new BooleanAttributeSetter<Table>() {
            public void set(Table widget, Element element, String name, boolean value) {
                widget.setStripeRows(value);
            }
        });
        register("verticalLines", new BooleanAttributeSetter<Table>() {
            public void set(Table widget, Element element, String name, boolean value) {
                widget.setVerticalLines(value);
            }
        });
    }

    @Override
    protected Table newInstance(Element element) {
        return new Table();
    }
    
    public Table create(java.util.List<Object> ancestors,final Element element) {
        final Table item = (Table)createInstance(element);
        new WidgetDOMConverter<Table>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
                String function = GwtXMLHelper.getAttribute(element,emforium.gwt.widget.MarkupConstants.CHILDTYPE_XML_ATTRIBUTE_NAME);
                String setFunc = "set"+function;
                String addFunc = "add"+function;
                if ( widget instanceof com.extjs.gxt.ui.client.widget.menu.Menu && "setContextMenu".equalsIgnoreCase(setFunc) )
                    item.setContextMenu((com.extjs.gxt.ui.client.widget.menu.Menu)widget);
                else 
                if ( widget instanceof com.extjs.gxt.ui.client.widget.table.TableItem && "setSelectedItem".equalsIgnoreCase(setFunc) )
                    item.setSelectedItem((com.extjs.gxt.ui.client.widget.table.TableItem)widget);
                else 
                if ( widget instanceof com.extjs.gxt.ui.client.widget.table.TableItem )
                    item.add((com.extjs.gxt.ui.client.widget.table.TableItem)widget);
                else 
                if ( widget instanceof com.extjs.gxt.ui.client.widget.table.TableHeader )
                    item.setTableHeader((com.extjs.gxt.ui.client.widget.table.TableHeader)widget);
            }
        };
        return item;
    }
}
