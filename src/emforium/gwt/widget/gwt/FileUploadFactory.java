// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.WidgetFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  class FileUploadFactory extends WidgetFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "FileUpload";
    
    public FileUploadFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("name", new StringAttributeSetter<FileUpload>() {
            public void set(FileUpload widget, Element element, String name, String value) {
                widget.setName(value);
            }
        });
    }

    @Override
    protected FileUpload newInstance(Element element) {
        return new FileUpload();
    }
    
    public FileUpload create(java.util.List<Object> ancestors,final Element element) {
        final FileUpload item = (FileUpload)createInstance(element);
        new WidgetDOMConverter<FileUpload>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
