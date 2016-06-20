// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.CellPanel;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.gwt.ComplexPanelFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  abstract  class CellPanelFactory extends ComplexPanelFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "CellPanel";
    
    public CellPanelFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("borderWidth", new IntegerAttributeSetter<CellPanel>() {
            public void set(CellPanel widget, Element element, String name, int value) {
                widget.setBorderWidth(value);
            }
        });
        register("spacing", new IntegerAttributeSetter<CellPanel>() {
            public void set(CellPanel widget, Element element, String name, int value) {
                widget.setSpacing(value);
            }
        });
    }

}
