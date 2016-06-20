// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.HTMLTable;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.gwt.PanelFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  abstract  class HTMLTableFactory extends PanelFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "HTMLTable";
    
    public HTMLTableFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("borderWidth", new IntegerAttributeSetter<HTMLTable>() {
            public void set(HTMLTable widget, Element element, String name, int value) {
                widget.setBorderWidth(value);
            }
        });
        register("cellPadding", new IntegerAttributeSetter<HTMLTable>() {
            public void set(HTMLTable widget, Element element, String name, int value) {
                widget.setCellPadding(value);
            }
        });
        register("cellSpacing", new IntegerAttributeSetter<HTMLTable>() {
            public void set(HTMLTable widget, Element element, String name, int value) {
                widget.setCellSpacing(value);
            }
        });
    }

}
