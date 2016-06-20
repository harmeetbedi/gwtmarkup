/**
 * 
 */
package emforium.gwt.widget.custom;

import java.util.HashSet;
import java.util.Set;

import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.menu.Item;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.ChangeListener;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.FocusListener;
import com.google.gwt.user.client.ui.FocusWidget;
import com.google.gwt.user.client.ui.KeyboardListener;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MouseListener;
import com.google.gwt.user.client.ui.TextBoxBase;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.visualization.client.Selection;
import com.google.gwt.visualization.client.events.SelectHandler;
import com.google.gwt.visualization.client.events.SelectHandler.SelectEvent;
import com.google.gwt.visualization.client.visualizations.Visualization;

import emforium.gwt.widget.GwtObjectFactory;
import emforium.gwt.widget.InvokeJsArgs;
import emforium.gwt.widget.PageDOMConverter;
import emforium.gwt.widget.WidgetDOMConverter;
import emforium.gwt.widget.AttributeSetter.BooleanAttributeSetter;
import emforium.gwt.widget.AttributeSetter.StringAttributeSetter;
import emforium.gwt.widget.visualization.ChartContainer;

/*
<span id="${IdGen.newGwtFieldId()}" widget-type="custom.EventCallback" sourceId="foo" event="click" jsCallback="func">
</span>
*/

/**
 * Factory for GWT To Javascript event callbacks
 *
 */
public class EventCallbackFactory extends GwtObjectFactory<EventCallback> {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "EventCallback";

	public EventCallbackFactory() {
	}
	
    protected void registerAttributes() {
		register("sourceId", new StringAttributeSetter<EventCallback>() {
			public void set(EventCallback widget, Element element, String name, String value) {
				widget.setSourceId(value);
			}
		});
		register("jsCallback", new StringAttributeSetter<EventCallback>() {
			public void set(EventCallback widget, Element element, String name, String value) {
				widget.setJsCallback(value);
			}
		});
		register("event", new StringAttributeSetter<EventCallback>() {
			public void set(EventCallback widget, Element element, String name, String value) {
				widget.setEvent(value);
			}
		});
		register("sync", new BooleanAttributeSetter<EventCallback>() {
			public void set(EventCallback widget, Element element, String name, boolean value) {
				widget.setSync(value);
			}
		});
    }
    
	protected EventCallback newInstance(Element element) {
		return new EventCallback();
	}

    public EventCallback create(java.util.List<Object> ancestors,final Element element) {
        final EventCallback item = (EventCallback)createInstance(element);
        
        new WidgetDOMConverter<EventCallback>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };	
        return item;
    }
}

class EventCallback {
	private String jsCallback;
	private String sourceId;
	private String event;
	private Boolean deferred;
	private static Set<String> focusEventSet = new HashSet<String>();
	private static Set<String> itemEventSet = new HashSet<String>();
	private static Set<String> rtfEventSet = new HashSet<String>();
	static {
		focusEventSet.add("focus");
		focusEventSet.add("blur");
		focusEventSet.add("keydown");
		focusEventSet.add("keyup");
		focusEventSet.add("keypress");
		focusEventSet.add("click");

		itemEventSet.add("select");
	}

	public EventCallback() {
	}

	public void setJsCallback(String jsCallback) {
		this.jsCallback = jsCallback;
		init();
	}
	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
		init();
	}
	public void setSync(Boolean sync) {
		this.deferred = !sync;
		init();
	}
	public void setEvent(String event) {
		// remove on or 'on-' to get the actual event name
		if ( event == null )
			return;
		event = event.toLowerCase();
		if ( event.startsWith("on"))
			event = event.substring(2);
		if ( event.startsWith("-"))
			event = event.substring(1);
		
		this.event = event;
		init();
	}
	private void init() {
		if ( sourceId == null || jsCallback == null || event == null || deferred == null )
			return;

		Object object = PageDOMConverter.getRegisteredComponent(sourceId);
		if ( object == null )
			return;

		if ( "change".equalsIgnoreCase(event) ) {
			if ( object instanceof TextBoxBase ) {
				connectTextBoxWidget((TextBoxBase)object);
			}
			if ( object instanceof ListBox ) {
				connectListBoxWidget((ListBox)object);
			}
			if ( object instanceof CoverFlow ) {
				connectCoverFlowWidget((CoverFlow)object);
			}
		}
		
		if ( "select".equalsIgnoreCase(event) ) {
			if ( object instanceof ChartContainer ) {
				connectChartWidget((ChartContainer)object);
			}
		}
		
		if (focusEventSet.contains(event)) {
			if (object instanceof FocusWidget) {
				connectFocusWidget((FocusWidget)object);
			}
		}
		
		if (itemEventSet.contains(event)) {
			if (object instanceof FocusWidget) {
				connectItemWidget((Item)object);
			}
		}
		
		if (rtfEventSet.contains(event)) {
			if (object instanceof RichTextArea) {
				connectRichTextWidget((RichTextArea)object);
			}
		}
	}
	
	private void connectChartWidget(ChartContainer chartContainer) { 
		final Visualization<?> viz = chartContainer.getVisualization();
		Selection.addSelectHandler(viz, new SelectHandler() {
			  public void onSelect(SelectEvent event) {
				  JsArray<Selection> arr = Selection.getSelections(viz);
				  if ( arr.length() == 0)
					  new InvokeJsArgs(sourceId, jsCallback, deferred).invokeOnChartSelection(arr.get(0));
				  else
					  new InvokeJsArgs(sourceId, jsCallback, deferred).invokeOnChartSelections(arr);
			  }
		});
	}
	
	private void connectCoverFlowWidget(final CoverFlow obj) {
		obj.addChangeListener(new ChangeListener() {
			public void onChange(Widget sender) {
				new InvokeJsArgs(sourceId, jsCallback, deferred).invoke(obj.getSelectedIndex());
			}
		});
	}

	private void connectListBoxWidget(final ListBox obj) {
		obj.addChangeListener(new ChangeListener() {
			public void onChange(Widget sender) {
				new InvokeJsArgs(sourceId, jsCallback, deferred).invoke(obj.getSelectedIndex());
			}
		});
	}

	private void connectTextBoxWidget(final TextBoxBase obj) {
		obj.addChangeListener(new ChangeListener() {
			public void onChange(Widget sender) {
				new InvokeJsArgs(sourceId, jsCallback, deferred).invoke(obj.getText());
			}
		});
	}

	private void connectItemWidget(final Item obj) {
		if (event.equals("select")) {
			obj.addSelectionListener(new SelectionListener<ComponentEvent>() {
				@Override
				public void componentSelected(ComponentEvent ce) {
					new InvokeJsArgs(sourceId, jsCallback, deferred).invoke();
				}
			});
		}
	}
	
	private void connectFocusWidget(final FocusWidget obj) {
		if (event.equals("click")) {
			obj.addClickListener(new ClickListener() {
				public void onClick(Widget sender) {
					new InvokeJsArgs(sourceId, jsCallback, deferred).invoke();
				}
			});
		}

		if (event.equals("focus") || event.equals("blur")) {
			obj.addFocusListener(new FocusListener() {
				public void onFocus(Widget sender) {
					if ( event.equals("focus") )
						new InvokeJsArgs(sourceId, jsCallback, deferred).invoke();
				}

				public void onLostFocus(Widget sender) {
					if ( event.equals("blur") )
						new InvokeJsArgs(sourceId, jsCallback, deferred).invoke();
				}
			});
		}

		if (event.equals("keydown") || event.equals("keyup") || event.equals("keypress")) {
			obj.addKeyboardListener(new KeyboardListener() {
				public void onKeyDown(Widget sender, char keyCode, int modifiers) {
					if ( event.equals("keydown") )
						new InvokeJsArgs(sourceId, jsCallback, deferred).invoke(keyCode);
				}

				public void onKeyPress(Widget sender, char keyCode,int modifiers) {
					if ( event.equals("keypress") )
						new InvokeJsArgs(sourceId, jsCallback, deferred).invoke(keyCode);
				}

				public void onKeyUp(Widget sender, char keyCode, int modifiers) {
					if ( event.equals("keyup") )
						new InvokeJsArgs(sourceId, jsCallback, deferred).invoke(keyCode);
				}
			});
		}
	}

	private void connectRichTextWidget(final RichTextArea obj) {
		obj.addMouseListener(new MouseListener() {
			public void onMouseDown(Widget sender, int x, int y) {
				if ( event.equals("mousedown") )
					new InvokeJsArgs(sourceId, jsCallback, deferred).invoke();
			}

			public void onMouseEnter(Widget sender) {
				if ( event.equals("mouseenter") )
					new InvokeJsArgs(sourceId, jsCallback, deferred).invoke();
			}

			public void onMouseLeave(Widget sender) {
				if ( event.equals("mouseleave") )
					new InvokeJsArgs(sourceId, jsCallback, deferred).invoke();
			}

			public void onMouseMove(Widget sender, int x, int y) {
				if ( event.equals("mousemove") )
					new InvokeJsArgs(sourceId, jsCallback, deferred).invoke();
			}

			public void onMouseUp(Widget sender, int x, int y) {
				if ( event.equals("mouseup") )
					new InvokeJsArgs(sourceId, jsCallback, deferred).invoke();
			}
		});
	}
}