package emforium.gwt.widget;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.visualization.client.Selection;

import emforium.gwt.util.GwtJSHelper;

/**
 * common arguments passed to all javascript function
 */
public class InvokeJsArgs {
	private String sourceId;
	private String jsCallback;
	private Object source;
	private com.google.gwt.user.client.Element element;
	private boolean deferred;
	public InvokeJsArgs(final String sourceId, final String jsCallback,boolean deferred) {
		Object obj = null;
		if ( sourceId != null ) { 
			obj = PageDOMConverter.getRegisteredComponent(sourceId);
		}
		com.google.gwt.user.client.Element elem = null; 
		if ( ( obj != null ) && ( obj instanceof UIObject ) ) {
			elem = ((UIObject)obj).getElement();
		}
		this.sourceId = sourceId;
		this.jsCallback = jsCallback;
		this.source = obj;
		this.element = elem;
		this.deferred = deferred;
	}
	public void invoke() {
		execute(new Command() {
			public void execute() {
				GwtJSHelper.invokeJS(sourceId,source, element, jsCallback);
			}
		});
	}
	public void invoke(final Object value) {
		execute(new Command() {
			public void execute() {
				GwtJSHelper.invokeJS(sourceId,source, element, jsCallback, String.valueOf(value));
			}
		});
	}
	public void invokeOnChartSelections(final JsArray<Selection> value) {
		execute(new Command() {
			public void execute() {
				GwtJSHelper.invokeOnChartSelections(sourceId,source, element, jsCallback, value);
			}
		});
	}
	public void invokeOnChartSelection(final Selection value) {
		execute(new Command() {
			public void execute() {
				GwtJSHelper.invokeOnChartSelection(sourceId,source, element, jsCallback, value);
			}
		});
	}
	private void execute(Command cmd) {
		if ( deferred ) {
			DeferredCommand.addCommand(cmd);
		} else {
			cmd.execute();
		}
	}
}
