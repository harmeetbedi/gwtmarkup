// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.grid.EditorGrid;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.util.GwtXMLHelper;


public  class EditorGridFactory extends GridFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "EditorGrid";
    
    public EditorGridFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
    }

    /** override to create instance with arguments */
    @Override
    protected EditorGrid newInstance(Element element) {
        throw new RuntimeException("override to create instance with arguments");
    }
    
    public EditorGrid create(java.util.List<Object> ancestors,final Element element) {
        final EditorGrid item = (EditorGrid)createInstance(element);
        new WidgetDOMConverter<EditorGrid>(ancestors,item,element) {
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
