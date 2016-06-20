package emforium.gwt.widget.visualization;

import com.google.gwt.visualization.client.AbstractDataTable;
import com.google.gwt.visualization.client.visualizations.Visualization;


/**
 * base class for chart options
 */
abstract class AbstractDrawOptions
<X extends com.google.gwt.visualization.client.AbstractDrawOptions,V extends Visualization<X>> 
{
	private X chartOptions;
	
	/**
	 * override to check if all options have been set. It is necessary for xml markup to specify all options
	 * @return true if component can be initialized
	 */
	protected abstract boolean isInitializable();

	/**
	 * override to create chart options
	 * @return
	 */
	protected abstract X createChartOptions();
	
	/**
	 * override to add initialization for derived chart attributes
	 * @param opt
	 */
	protected abstract void initialize(X opt);

	/**
	 * visualization package needs to be loaded before a particular type of visualization is rendered
	 * @return package name
	 */
	public abstract String getVisualizationPackage();

	/**
	 * return chart options or null if chart options cannot be initialized  
	 * @return chart options
	 */
	public final X getChartOptions() {
		if ( chartOptions != null )
			return chartOptions;
		if ( isInitializable() ) {
			chartOptions = createChartOptions();
			initialize(chartOptions);
		}
		if ( chartOptions == null )
			System.out.println("Could not initialize chart options. Verify all required attributes have been specified.");
		return chartOptions;
	}

	/**
	 * create visualization widget
	 * @param tbl datamodel that is rendered by the widget
	 * @return widget e.g. pie chart etc.
	 */
	public abstract V createVisualization(AbstractDataTable tbl,VisualizationLoadCallback<V> loadCallback);
}
