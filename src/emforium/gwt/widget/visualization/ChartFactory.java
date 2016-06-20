package emforium.gwt.widget.visualization;

import java.util.HashSet;
import java.util.Set;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.visualization.client.AjaxLoader;
import com.google.gwt.visualization.client.Selection;
import com.google.gwt.visualization.client.events.SelectHandler;
import com.google.gwt.visualization.client.visualizations.Visualization;

import emforium.gwt.util.GwtHelper;
import emforium.gwt.widget.InvokeJsArgs;
import emforium.gwt.widget.PageDOMConverter;
import emforium.gwt.widget.gwt.WidgetFactory;

/**
 * creates appropriate chart type. Assumes that the configuration and data has been picked up by DomParser before chart markup element 
 */
public class ChartFactory extends WidgetFactory 
{
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "Chart";
    private static Set<String> loadedPackages = new HashSet<String>();

    public ChartFactory() {
    }

	protected Widget newInstance(Element element) {
		final ChartContainer panel = new ChartContainer();
		return panel;
	}

    @SuppressWarnings("unchecked")
	public Widget create(java.util.List<Object> ancestors,final Element element) {
        final ChartContainer panel = (ChartContainer)createInstance(element);
    	String optId = element.getAttribute("configId");
    	String dataId = element.getAttribute("dataId");
    	final String id = element.getAttribute("id");
    	final String onSingleSelect = element.getAttribute("onSingleSelect");
    	final String onMultiSelect = element.getAttribute("onMultiSelect");
    	if ( GwtHelper.isEmpty(optId) ) {
    		System.out.println("chart configuration not specified");
    		return null;
    	}
    	if ( GwtHelper.isEmpty(dataId) ) {
    		System.out.println("chart data not specified");
    		return null;
    	}
    	final AbstractDrawOptions opt = (AbstractDrawOptions)PageDOMConverter.getRegisteredComponent(optId);
    	final Data data = (Data)PageDOMConverter.getRegisteredComponent(dataId);
    	if ( opt == null ) {
    		System.out.println("could not resolve chart configuration: "+optId);
    		return null;
    	}
    	if ( data == null ) {
    		System.out.println("could not resolve chart data: "+dataId);
    		return null;
    	}

		if ( loadedPackages.size() == 0 ) {
			// attempt to load all the packages together is the safest thing. Alternatively put this in HTML
			final String[] pkgs = new String[] { 
					"piechart", "barchart", "table", "linechart", "columnchart"
					, "scatterchart","areachart","orgchart","motionchart","annotatedtimeline" 
			};
    	    Runnable onLoadCallback = new Runnable() {
				public void run() {
					for ( String pkg: pkgs ) {
						loadedPackages.add(pkg);
					}
					Visualization<?> vis = opt.createVisualization(data.getDataTable(),null);
					panel.addVisualization(vis);
					//panel.layout();
					connectCallbackEvents(id,vis,onSingleSelect,onMultiSelect);
				}
			};
			AjaxLoader.loadVisualizationApi(onLoadCallback, pkgs);
		} else {
			Visualization<?> vis = opt.createVisualization(data.getDataTable(),null);
			panel.addVisualization(vis);
			//panel.layout();
			connectCallbackEvents(id,vis,onSingleSelect,onMultiSelect);
		}
		//opt.lazyAddVisualization(panel,data,loadedPackages);
		return panel;
    }
    
    private void connectCallbackEvents(final String id,final Visualization<?> vis,final String onSingleSelect, final String onMultiSelect) {
    	if ( GwtHelper.isEmpty(onSingleSelect) && GwtHelper.isEmpty(onMultiSelect) )
    		return;
    	SelectHandler handler = new SelectHandler() {
			public void onSelect(SelectEvent event) {
		    	String elemId = GwtHelper.isEmpty(id) ? null : id;
				JsArray<Selection> arr = Selection.getSelections(vis);
				if ( arr.length() == 1 && GwtHelper.isNotEmpty(onSingleSelect) )
					new InvokeJsArgs(elemId, onSingleSelect, true).invokeOnChartSelection(arr.get(0));
				else if ( GwtHelper.isNotEmpty(onMultiSelect) )
					new InvokeJsArgs(elemId, onMultiSelect, true).invokeOnChartSelections(arr);
			}
    	};
    	Selection.addSelectHandler(vis, handler);
    }
}


interface VisualizationLoadCallback<V extends Visualization<?>> {
	public void loadDone(V viz);
}