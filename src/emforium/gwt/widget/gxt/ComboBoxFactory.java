// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  class ComboBoxFactory extends TriggerFieldFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "ComboBox";
    
    public ComboBoxFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("allQuery", new StringAttributeSetter<ComboBox>() {
            public void set(ComboBox widget, Element element, String name, String value) {
                widget.setAllQuery(value);
            }
        });
        register("displayField", new StringAttributeSetter<ComboBox>() {
            public void set(ComboBox widget, Element element, String name, String value) {
                widget.setDisplayField(value);
            }
        });
        register("editable", new BooleanAttributeSetter<ComboBox>() {
            public void set(ComboBox widget, Element element, String name, boolean value) {
                widget.setEditable(value);
            }
        });
        register("expanded", new BooleanAttributeSetter<ComboBox>() {
            public void set(ComboBox widget, Element element, String name, boolean value) {
                widget.setExpanded(value);
            }
        });
        register("forceSelection", new BooleanAttributeSetter<ComboBox>() {
            public void set(ComboBox widget, Element element, String name, boolean value) {
                widget.setForceSelection(value);
            }
        });
        register("itemSelector", new StringAttributeSetter<ComboBox>() {
            public void set(ComboBox widget, Element element, String name, String value) {
                widget.setItemSelector(value);
            }
        });
        register("lazyRender", new BooleanAttributeSetter<ComboBox>() {
            public void set(ComboBox widget, Element element, String name, boolean value) {
                widget.setLazyRender(value);
            }
        });
        register("listAlign", new StringAttributeSetter<ComboBox>() {
            public void set(ComboBox widget, Element element, String name, String value) {
                widget.setListAlign(value);
            }
        });
        register("listStyle", new StringAttributeSetter<ComboBox>() {
            public void set(ComboBox widget, Element element, String name, String value) {
                widget.setListStyle(value);
            }
        });
        register("loadingText", new StringAttributeSetter<ComboBox>() {
            public void set(ComboBox widget, Element element, String name, String value) {
                widget.setLoadingText(value);
            }
        });
        register("maxHeight", new IntegerAttributeSetter<ComboBox>() {
            public void set(ComboBox widget, Element element, String name, int value) {
                widget.setMaxHeight(value);
            }
        });
        register("minChars", new IntegerAttributeSetter<ComboBox>() {
            public void set(ComboBox widget, Element element, String name, int value) {
                widget.setMinChars(value);
            }
        });
        register("minListWidth", new IntegerAttributeSetter<ComboBox>() {
            public void set(ComboBox widget, Element element, String name, int value) {
                widget.setMinListWidth(value);
            }
        });
        register("pageSize", new IntegerAttributeSetter<ComboBox>() {
            public void set(ComboBox widget, Element element, String name, int value) {
                widget.setPageSize(value);
            }
        });
        register("queryDelay", new IntegerAttributeSetter<ComboBox>() {
            public void set(ComboBox widget, Element element, String name, int value) {
                widget.setQueryDelay(value);
            }
        });
        register("rawValue", new StringAttributeSetter<ComboBox>() {
            public void set(ComboBox widget, Element element, String name, String value) {
                widget.setRawValue(value);
            }
        });
        register("selectedStyle", new StringAttributeSetter<ComboBox>() {
            public void set(ComboBox widget, Element element, String name, String value) {
                widget.setSelectedStyle(value);
            }
        });
        register("simpleTemplate", new StringAttributeSetter<ComboBox>() {
            public void set(ComboBox widget, Element element, String name, String value) {
                widget.setSimpleTemplate(value);
            }
        });
        register("template", new StringAttributeSetter<ComboBox>() {
            public void set(ComboBox widget, Element element, String name, String value) {
                widget.setTemplate(value);
            }
        });
        register("typeAhead", new BooleanAttributeSetter<ComboBox>() {
            public void set(ComboBox widget, Element element, String name, boolean value) {
                widget.setTypeAhead(value);
            }
        });
        register("typeAheadDelay", new IntegerAttributeSetter<ComboBox>() {
            public void set(ComboBox widget, Element element, String name, int value) {
                widget.setTypeAheadDelay(value);
            }
        });
        register("valueField", new StringAttributeSetter<ComboBox>() {
            public void set(ComboBox widget, Element element, String name, String value) {
                widget.setValueField(value);
            }
        });
    }

    @Override
    protected ComboBox newInstance(Element element) {
        return new ComboBox();
    }
    
    public ComboBox create(java.util.List<Object> ancestors,final Element element) {
        final ComboBox item = (ComboBox)createInstance(element);
        new WidgetDOMConverter<ComboBox>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
                String function = GwtXMLHelper.getAttribute(element,emforium.gwt.widget.MarkupConstants.CHILDTYPE_XML_ATTRIBUTE_NAME);
                String setFunc = "set"+function;
                String addFunc = "add"+function;
                if ( widget instanceof com.extjs.gxt.ui.client.widget.ListView && "setView".equalsIgnoreCase(setFunc) )
                    item.setView((com.extjs.gxt.ui.client.widget.ListView)widget);
            }
        };
        return item;
    }
}
