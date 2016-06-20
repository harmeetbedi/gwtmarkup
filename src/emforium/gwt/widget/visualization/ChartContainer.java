package emforium.gwt.widget.visualization;

import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.visualization.client.visualizations.Visualization;

/**
 * container for chart visualization 
 */
public class ChartContainer extends SimplePanel 
{
	private Visualization<?> widget;
	public void addVisualization(Visualization<?> widget) {
		this.clear();
		add(widget);
	}
	public Visualization<?> getVisualization() {
		return widget;
	}
}
