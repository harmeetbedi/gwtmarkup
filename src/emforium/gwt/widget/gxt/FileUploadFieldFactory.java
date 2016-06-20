// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.form.FileUploadField;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  class FileUploadFieldFactory extends TextFieldFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "FileUploadField";
    
    public FileUploadFieldFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("name", new StringAttributeSetter<FileUploadField>() {
            public void set(FileUploadField widget, Element element, String name, String value) {
                widget.setName(value);
            }
        });
        register("buttonIconStyle", new StringAttributeSetter<FileUploadField>() {
            public void set(FileUploadField widget, Element element, String name, String value) {
                widget.setButtonIconStyle(value);
            }
        });
        register("buttonOffset", new IntegerAttributeSetter<FileUploadField>() {
            public void set(FileUploadField widget, Element element, String name, int value) {
                widget.setButtonOffset(value);
            }
        });
    }

    @Override
    protected FileUploadField newInstance(Element element) {
        return new FileUploadField();
    }
    
    public FileUploadField create(java.util.List<Object> ancestors,final Element element) {
        final FileUploadField item = (FileUploadField)createInstance(element);
        new WidgetDOMConverter<FileUploadField>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
