// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.grid.CellEditor;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;


public  class CellEditorFactory extends EditorFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "CellEditor";
    
    public CellEditorFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
    }

    /** override to create instance with arguments */
    @Override
    protected CellEditor newInstance(Element element) {
        throw new RuntimeException("override to create instance with arguments");
    }
    
    public CellEditor create(java.util.List<Object> ancestors,final Element element) {
        final CellEditor item = (CellEditor)createInstance(element);
        new WidgetDOMConverter<CellEditor>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
