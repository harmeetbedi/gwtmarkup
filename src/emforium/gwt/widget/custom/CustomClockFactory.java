/**
 * 
 */
package emforium.gwt.widget.custom;

import java.util.Date;

import com.extjs.gxt.ui.client.Events;
import com.extjs.gxt.ui.client.XDOM;
import com.extjs.gxt.ui.client.event.DatePickerEvent;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.DatePicker;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.DateTimePropertyEditor;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.UIObject;

import emforium.gwt.widget.GwtObjectFactory;
import emforium.gwt.widget.WidgetDOMConverter;
import emforium.gwt.widget.AttributeSetter.IntegerAttributeSetter;
import emforium.gwt.widget.AttributeSetter.StringAttributeSetter;
import emforium.gwt.widget.gxt.ComponentFactory;
import emforium.gwt.widget.gxt.LabelFieldFactory;

/**
 * Factory for the NumberField widget.
 *
 */
public class CustomClockFactory extends GwtObjectFactory<Clock> {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "Clock";

	public CustomClockFactory() {
	}
	
    protected void registerAttributes() {
		register("format", new StringAttributeSetter<Clock>() {
			public void set(Clock widget, Element element, String name, String value) {
				widget.setFormat(value);
			}
		});
		register("target-id", new StringAttributeSetter<Clock>() {
			public void set(Clock widget, Element element, String name, String value) {
				widget.setTargetId(value);
			}
		});
		register("repeat-rate", new IntegerAttributeSetter<Clock>() {
			public void set(Clock widget, Element element, String name, int value) {
				widget.setRepeatRate(value);
			}
		});
	}
	protected Clock newInstance(Element element) {
		return new Clock();
	}

    public Clock create(java.util.List<Object> ancestors,final Element element) {
        final Clock item = (Clock)createInstance(element);
        
        new WidgetDOMConverter<Clock>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };	
        return item;
    }
}

class Clock {
	private DateTimeFormat formatter;
	private String targetId;
	private int repeatRate = -1;

	public Clock() {
	}

	public void setRepeatRate(int repeatRate) {
		this.repeatRate = repeatRate;
		init();
	}
	public void setFormat(String format) {
		this.formatter = DateTimeFormat.getFormat(format);
		init();
	}
	public void setTargetId(String targetId) {
		this.targetId = targetId;
		init();
	}
	private void init() {
		if ( formatter == null || repeatRate == -1 || targetId == null )
			return;
	    Timer timer = new Timer() {
	        public void run()
	        {
	            initText();
	        }
		};
		timer.scheduleRepeating(repeatRate);
	}
	
	private Element elem;
    private void initText() {
    	//System.out.println("in run");
        Date dt = new Date();
        String text = formatter.format(dt);
        if ( elem == null ) {
        	elem = XDOM.getElementById(targetId);
        }
    	elem.setInnerHTML(text);
    }
}