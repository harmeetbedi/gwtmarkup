/**
 * 
 */
package emforium.gwt.widget.custom;

import java.util.Date;

import com.extjs.gxt.ui.client.Events;
import com.extjs.gxt.ui.client.event.DatePickerEvent;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.DatePicker;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.DateTimePropertyEditor;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.UIObject;

import emforium.gwt.widget.WidgetDOMConverter;
import emforium.gwt.widget.AttributeSetter.IntegerAttributeSetter;
import emforium.gwt.widget.AttributeSetter.StringAttributeSetter;
import emforium.gwt.widget.gxt.ComponentFactory;

/**
 * Factory for the NumberField widget.
 *
 */
public class CustomDateFieldFactory extends ComponentFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "DateField";

    public static final String BOUND_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";

	public CustomDateFieldFactory() {
	}
	
    protected void registerAttributes() {
		register("emptyText", new StringAttributeSetter<DateContainer>() {
			public void set(DateContainer widget, Element element, String name, String value) {
				widget.dateField.setEmptyText(value);
			}
		});
		register("name", new StringAttributeSetter<DateContainer>() {
			public void set(DateContainer widget, Element element, String name, String value) {
				widget.hiddenField.setName(value);
			}
		});
		register("tabIndex", new IntegerAttributeSetter<DateContainer>() {
			@Override
			public
			void set(DateContainer widget, Element element, String name, int value) {
				widget.dateField.setTabIndex(value);
			}
		});
		
		register("displayFormat", new StringAttributeSetter<DateContainer>() {
			public void set(DateContainer widget, Element element, String name, String value) {
				widget.dateField.setPropertyEditor( new DateTimePropertyEditor(value) );
			}
		});
		register("value", new StringAttributeSetter<DateContainer>() {
			public void set(DateContainer widget, Element element, String name, String value) {
				widget.hiddenField.setText( value );
				Date dateValue = DateTimeFormat.getFormat(BOUND_DATE_FORMAT).parse(value);
				widget.dateField.setValue( dateValue );
			}
		});
		register("styleName", new StringAttributeSetter<DateContainer>() {
			public void set(DateContainer widget, Element element, String name, String value) {
				widget.dateField.setStyleName(value);
			}
		});
		register("addStyle", new StringAttributeSetter<DateContainer>() {
			public void set(DateContainer widget, Element element, String name, String value) {
				widget.dateField.addStyleName(value);
			}
		});
		register("width", new StringAttributeSetter<DateContainer>() {
			public void set(DateContainer widget, Element element, String name, String value) {
				widget.dateField.setWidth(value);
			}
		});
		register("height", new StringAttributeSetter<DateContainer>() {
			public void set(DateContainer widget, Element element, String name, String value) {
				widget.dateField.setHeight(value);
			}
		});
	}
	protected DateContainer newInstance(Element element) {
		return new DateContainer();
	}

    public DateContainer create(java.util.List<Object> ancestors,final Element element) {
        final DateContainer item = (DateContainer)createInstance(element);
        
        new WidgetDOMConverter<DateContainer>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };	
        return item;
    }
}
class DateContainer extends FlowPanel {
	DateField dateField;
	TextBox hiddenField;
	DateTimeFormat sdf = DateTimeFormat.getFormat(CustomDateFieldFactory.BOUND_DATE_FORMAT);

	public DateContainer() {
		dateField = new DateField();
		hiddenField = new TextBox();
		hiddenField.setVisible(false);
		connectEvents();
		add( dateField );
        add( hiddenField );
	}
	void connectEvents() {
        DatePicker picker = dateField.getDatePicker();
		picker.addListener(Events.Select, new Listener<DatePickerEvent>() {
          public void handleEvent(DatePickerEvent ce) {
        	  if( ce.date == null ) return; 
              hiddenField.setText( sdf.format( (Date)ce.date ) );
          }
        });		
		dateField.addListener(Events.Change, new Listener<FieldEvent>() {
			public void handleEvent(FieldEvent be) {
				hiddenField.setText( sdf.format( (Date)be.value ) );
			}
		});
		dateField.addListener(Events.KeyPress, new Listener<FieldEvent>() {
			public void handleEvent(FieldEvent be) {
				if( be.value == null )  { 
					hiddenField.setText("");
					return;
				}
				hiddenField.setText( sdf.format( (Date)be.value ) );
			}
		});
	}
}