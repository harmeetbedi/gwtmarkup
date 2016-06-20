package emforium.gwt.widget.visualization;

import com.google.gwt.user.client.Element;
import com.google.gwt.visualization.client.AbstractDataTable;
import com.google.gwt.visualization.client.visualizations.PieChart;
import com.google.gwt.visualization.client.visualizations.Table;

import emforium.gwt.widget.AttributeSetter.BooleanAttributeSetter;

public class PieChartOptionsFactory extends CommonOptionsFactory<PieChart.Options, PieChartOptions,PieChart> {

    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "PieChartOptions";

    public PieChartOptionsFactory() {
    }

    protected void registerAttributes() {
        super.registerAttributes();
    	register("enable3D", new BooleanAttributeSetter<PieChartOptions>() {
			public void set(final PieChartOptions widget, Element element,String name, boolean value) {
				widget.setEnable3D(value);
			}
        });
    }

    protected PieChartOptions newInstance(Element element) {
    	return new PieChartOptions();
    }
    
    public PieChartOptions create(java.util.List<Object> ancestors,final Element element) {
        final PieChartOptions item = (PieChartOptions)createInstance(element);
        return item;
    }
}

class PieChartOptions extends CommonOptions<PieChart.Options, PieChartOptions,PieChart> {
	protected Boolean enable3D;
	void setEnable3D(boolean enable3D) {
		this.enable3D = enable3D;
	}

	protected boolean isInitializable() {
		if ( enable3D == null ) return false;
		return super.isInitializable();
	}

	protected void initialize(PieChart.Options opt) {
		super.initialize(opt);
		opt.set3D(enable3D);
	}

	@Override
	protected PieChart.Options createChartOptions() {
		return PieChart.Options.create();
	}

	@Override
	public String getVisualizationPackage() {
		return PieChart.PACKAGE;
	}

	@Override
	public PieChart createVisualization(AbstractDataTable tbl,final VisualizationLoadCallback<PieChart> loadCallback) {
		return new PieChart(tbl,getChartOptions()) { 
			  protected void onLoad() {
				  super.onLoad();
				  if ( loadCallback != null )
					  loadCallback.loadDone(this);
			  }
		};
	}
}
