// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.ListView;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  class ListViewFactory extends BoxComponentFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "ListView";
    
    public ListViewFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("displayProperty", new StringAttributeSetter<ListView>() {
            public void set(ListView widget, Element element, String name, String value) {
                widget.setDisplayProperty(value);
            }
        });
        register("itemSelector", new StringAttributeSetter<ListView>() {
            public void set(ListView widget, Element element, String name, String value) {
                widget.setItemSelector(value);
            }
        });
        register("loadingText", new StringAttributeSetter<ListView>() {
            public void set(ListView widget, Element element, String name, String value) {
                widget.setLoadingText(value);
            }
        });
        register("overStyle", new StringAttributeSetter<ListView>() {
            public void set(ListView widget, Element element, String name, String value) {
                widget.setOverStyle(value);
            }
        });
        register("selectOnOver", new BooleanAttributeSetter<ListView>() {
            public void set(ListView widget, Element element, String name, boolean value) {
                widget.setSelectOnOver(value);
            }
        });
        register("selectStyle", new StringAttributeSetter<ListView>() {
            public void set(ListView widget, Element element, String name, String value) {
                widget.setSelectStyle(value);
            }
        });
        register("simpleTemplate", new StringAttributeSetter<ListView>() {
            public void set(ListView widget, Element element, String name, String value) {
                widget.setSimpleTemplate(value);
            }
        });
        register("template", new StringAttributeSetter<ListView>() {
            public void set(ListView widget, Element element, String name, String value) {
                widget.setTemplate(value);
            }
        });
    }

    @Override
    protected ListView newInstance(Element element) {
        return new ListView();
    }
    
    public ListView create(java.util.List<Object> ancestors,final Element element) {
        final ListView item = (ListView)createInstance(element);
        new WidgetDOMConverter<ListView>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
