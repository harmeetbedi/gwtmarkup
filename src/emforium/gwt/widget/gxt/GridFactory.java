// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  class GridFactory extends BoxComponentFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "Grid";
    
    public GridFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("autoExpandColumn", new StringAttributeSetter<Grid>() {
            public void set(Grid widget, Element element, String name, String value) {
                widget.setAutoExpandColumn(value);
            }
        });
        register("autoExpandMax", new IntegerAttributeSetter<Grid>() {
            public void set(Grid widget, Element element, String name, int value) {
                widget.setAutoExpandMax(value);
            }
        });
        register("autoExpandMin", new IntegerAttributeSetter<Grid>() {
            public void set(Grid widget, Element element, String name, int value) {
                widget.setAutoExpandMin(value);
            }
        });
        register("enableColumnResize", new BooleanAttributeSetter<Grid>() {
            public void set(Grid widget, Element element, String name, boolean value) {
                widget.setEnableColumnResize(value);
            }
        });
        register("hideHeaders", new BooleanAttributeSetter<Grid>() {
            public void set(Grid widget, Element element, String name, boolean value) {
                widget.setHideHeaders(value);
            }
        });
        register("loadMask", new BooleanAttributeSetter<Grid>() {
            public void set(Grid widget, Element element, String name, boolean value) {
                widget.setLoadMask(value);
            }
        });
        register("minColumnWidth", new IntegerAttributeSetter<Grid>() {
            public void set(Grid widget, Element element, String name, int value) {
                widget.setMinColumnWidth(value);
            }
        });
        register("stripeRows", new BooleanAttributeSetter<Grid>() {
            public void set(Grid widget, Element element, String name, boolean value) {
                widget.setStripeRows(value);
            }
        });
        register("trackMouseOver", new BooleanAttributeSetter<Grid>() {
            public void set(Grid widget, Element element, String name, boolean value) {
                widget.setTrackMouseOver(value);
            }
        });
    }

    /** override to create instance with arguments */
    @Override
    protected Grid newInstance(Element element) {
        throw new RuntimeException("override to create instance with arguments");
    }
    
    public Grid create(java.util.List<Object> ancestors,final Element element) {
        final Grid item = (Grid)createInstance(element);
        new WidgetDOMConverter<Grid>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
                String function = GwtXMLHelper.getAttribute(element,emforium.gwt.widget.MarkupConstants.CHILDTYPE_XML_ATTRIBUTE_NAME);
                String setFunc = "set"+function;
                String addFunc = "add"+function;
                if ( widget instanceof com.extjs.gxt.ui.client.widget.menu.Menu && "setContextMenu".equalsIgnoreCase(setFunc) )
                    item.setContextMenu((com.extjs.gxt.ui.client.widget.menu.Menu)widget);
            }
        };
        return item;
    }
}
