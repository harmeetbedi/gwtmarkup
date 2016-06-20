package emforium.gwt.widget.visualization;

import com.google.gwt.user.client.Element;
import com.google.gwt.visualization.client.AbstractDataTable;
import com.google.gwt.visualization.client.visualizations.LineChart;

import emforium.gwt.widget.AttributeSetter.BooleanAttributeSetter;
import emforium.gwt.widget.AttributeSetter.IntegerAttributeSetter;

public class LineChartOptionsFactory extends CommonChartOptionsFactory<LineChart.Options, LineChartOptions,LineChart> {

    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "LineChartOptions";

    public LineChartOptionsFactory() {
    }

    protected void registerAttributes() {
        super.registerAttributes();
    	register("lineSize", new IntegerAttributeSetter<LineChartOptions>() {
			public void set(final LineChartOptions widget, Element element,String name, int value) {
				widget.setLineSize(value);
			}
        });
    	register("pointSize", new IntegerAttributeSetter<LineChartOptions>() {
			public void set(final LineChartOptions widget, Element element,String name, int value) {
				widget.setPointSize(value);
			}
        });
    	register("smoothLine", new BooleanAttributeSetter<LineChartOptions>() {
			public void set(final LineChartOptions widget, Element element,String name, boolean value) {
				widget.setSmoothLine(value);
			}
        });
    }

    protected LineChartOptions newInstance(Element element) {
    	return new LineChartOptions();
    }
    
    public LineChartOptions create(java.util.List<Object> ancestors,final Element element) {
        final LineChartOptions item = (LineChartOptions)createInstance(element);
        return item;
    }
}

class LineChartOptions extends CommonChartOptions<LineChart.Options, LineChartOptions,LineChart> {
	protected Integer lineSize;
	protected Integer pointSize;
	protected Boolean smoothLine;
    public void setLineSize(int size) {
    	this.lineSize = size;
    }

    public void setPointSize(int size) {
    	this.pointSize = size;
    }

    public void setSmoothLine(boolean smooth) {
    	this.smoothLine = smooth;
    }

	protected boolean isInitializable() {
		//if ( lineSize == null ) return false;
		//if ( pointSize == null ) return false;
		if ( smoothLine == null ) return false;
		return super.isInitializable();
	}

	protected void initialize(LineChart.Options opt) {
		super.initialize(opt);
		if ( lineSize != null )
			opt.setLineSize(lineSize);
		if ( pointSize != null )
			opt.setPointSize(pointSize);
		if ( smoothLine != null )
			opt.setSmoothLine(smoothLine);
	}

	@Override
	protected LineChart.Options createChartOptions() {
		return LineChart.Options.create();
	}

	@Override
	public String getVisualizationPackage() {
		return LineChart.PACKAGE;
	}

	@Override
	public LineChart createVisualization(AbstractDataTable tbl,final VisualizationLoadCallback<LineChart> loadCallback) {
		return new LineChart(tbl,getChartOptions()) { 
			  protected void onLoad() {
				  super.onLoad();
				  if ( loadCallback != null )
					  loadCallback.loadDone(this);
			  }
		}; 
	}
}
