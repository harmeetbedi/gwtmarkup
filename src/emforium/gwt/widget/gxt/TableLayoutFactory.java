// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.LayoutFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  class TableLayoutFactory extends LayoutFactory<TableLayout> {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "TableLayout";
    
    public TableLayoutFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("border", new IntegerAttributeSetter<TableLayout>() {
            public void set(TableLayout widget, Element element, String name, int value) {
                widget.setBorder(value);
            }
        });
        register("cellPadding", new IntegerAttributeSetter<TableLayout>() {
            public void set(TableLayout widget, Element element, String name, int value) {
                widget.setCellPadding(value);
            }
        });
        register("cellSpacing", new IntegerAttributeSetter<TableLayout>() {
            public void set(TableLayout widget, Element element, String name, int value) {
                widget.setCellSpacing(value);
            }
        });
        register("columns", new IntegerAttributeSetter<TableLayout>() {
            public void set(TableLayout widget, Element element, String name, int value) {
                widget.setColumns(value);
            }
        });
        register("height", new StringAttributeSetter<TableLayout>() {
            public void set(TableLayout widget, Element element, String name, String value) {
                widget.setHeight(value);
            }
        });
        register("insertSpacer", new BooleanAttributeSetter<TableLayout>() {
            public void set(TableLayout widget, Element element, String name, boolean value) {
                widget.setInsertSpacer(value);
            }
        });
        register("tableStyle", new StringAttributeSetter<TableLayout>() {
            public void set(TableLayout widget, Element element, String name, String value) {
                widget.setTableStyle(value);
            }
        });
        register("width", new StringAttributeSetter<TableLayout>() {
            public void set(TableLayout widget, Element element, String name, String value) {
                widget.setWidth(value);
            }
        });
    }

    @Override
    protected TableLayout newInstance(Element element) {
        return new TableLayout();
    }
    
    public TableLayout create(java.util.List<Object> ancestors,final Element element) {
        final TableLayout item = (TableLayout)createInstance(element);
        new WidgetDOMConverter<TableLayout>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
