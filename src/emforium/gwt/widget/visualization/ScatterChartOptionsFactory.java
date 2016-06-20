package emforium.gwt.widget.visualization;

import com.google.gwt.user.client.Element;
import com.google.gwt.visualization.client.AbstractDataTable;
import com.google.gwt.visualization.client.visualizations.PieChart;
import com.google.gwt.visualization.client.visualizations.ScatterChart;
import com.google.gwt.visualization.client.visualizations.Table;

import emforium.gwt.widget.AttributeSetter.IntegerAttributeSetter;

public class ScatterChartOptionsFactory extends CommonChartOptionsFactory<ScatterChart.Options, ScatterChartOptions,ScatterChart> {

    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "ScatterChartOptions";

    public ScatterChartOptionsFactory() {
    }

    protected void registerAttributes() {
        super.registerAttributes();
    	register("lineSize", new IntegerAttributeSetter<ScatterChartOptions>() {
			public void set(final ScatterChartOptions widget, Element element,String name, int value) {
				widget.setLineSize(value);
			}
        });
    	register("pointSize", new IntegerAttributeSetter<ScatterChartOptions>() {
			public void set(final ScatterChartOptions widget, Element element,String name, int value) {
				widget.setPointSize(value);
			}
        });
    }

    protected ScatterChartOptions newInstance(Element element) {
    	return new ScatterChartOptions();
    }
    
    public ScatterChartOptions create(java.util.List<Object> ancestors,final Element element) {
        final ScatterChartOptions item = (ScatterChartOptions)createInstance(element);
        return item;
    }
}

class ScatterChartOptions extends CommonChartOptions<ScatterChart.Options, ScatterChartOptions,ScatterChart> {
	protected Integer lineSize;
	protected Integer pointSize;
    public void setLineSize(int size) {
    	this.lineSize = size;
    }

    public void setPointSize(int size) {
    	this.pointSize = size;
    }

	protected boolean isInitializable() {
		//if ( lineSize == null ) return false;
		//if ( pointSize == null ) return false;
		return super.isInitializable();
	}

	protected void initialize(ScatterChart.Options opt) {
		super.initialize(opt);
		if ( lineSize != null )
			opt.setLineSize(lineSize);
		if ( pointSize != null )
			opt.setPointSize(pointSize);
	}

	@Override
	protected ScatterChart.Options createChartOptions() {
		return ScatterChart.Options.create();
	}

	@Override
	public String getVisualizationPackage() {
		return ScatterChart.PACKAGE;
	}

	@Override
	public ScatterChart createVisualization(AbstractDataTable tbl,final VisualizationLoadCallback<ScatterChart> loadCallback) {
		return new ScatterChart(tbl,getChartOptions()) { 
			  protected void onLoad() {
				  super.onLoad();
				  if ( loadCallback != null )
					  loadCallback.loadDone(this);
			  }
		}; 
	}
}
