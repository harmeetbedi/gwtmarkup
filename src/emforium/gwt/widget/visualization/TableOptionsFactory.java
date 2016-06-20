package emforium.gwt.widget.visualization;

import com.google.gwt.user.client.Element;
import com.google.gwt.visualization.client.AbstractDataTable;
import com.google.gwt.visualization.client.visualizations.Table;
import com.google.gwt.visualization.client.visualizations.Table.Options.Policy;

import emforium.gwt.util.GwtHelper;
import emforium.gwt.widget.GwtObjectFactory;
import emforium.gwt.widget.AttributeSetter.BooleanAttributeSetter;
import emforium.gwt.widget.AttributeSetter.IntegerAttributeSetter;
import emforium.gwt.widget.AttributeSetter.StringAttributeSetter;

public class TableOptionsFactory extends GwtObjectFactory<TableOptions> { 

    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "TableOptions";

    public TableOptionsFactory() {
    }

    protected void registerAttributes() {
        super.registerAttributes();
    	register("allowHtml", new BooleanAttributeSetter<TableOptions>() {
			public void set(final TableOptions widget, Element element,String name, boolean value) {
				widget.setAllowHtml(value);
			}
        });
    	register("showRowNumber", new BooleanAttributeSetter<TableOptions>() {
			public void set(final TableOptions widget, Element element,String name, boolean value) {
				widget.setShowRowNumber(value);
			}
        });
    	register("pageSize", new IntegerAttributeSetter<TableOptions>() {
			public void set(final TableOptions widget, Element element,String name, int value) {
				widget.setPageSize(value);
			}
        });
    	register("pagePolicy", new StringAttributeSetter<TableOptions>() {
			public void set(final TableOptions widget, Element element,String name, String value) {
				widget.setPagePolicy(value);
			}
        });
    	register("sortPolicy", new StringAttributeSetter<TableOptions>() {
			public void set(final TableOptions widget, Element element,String name, String value) {
				widget.setSortPolicy(value);
			}
        });
    }

    protected TableOptions newInstance(Element element) {
    	return new TableOptions();
    }
    
    public TableOptions create(java.util.List<Object> ancestors,final Element element) {
        final TableOptions item = (TableOptions)createInstance(element);
        return item;
    }
}

class TableOptions extends AbstractDrawOptions<Table.Options,Table> {
	private Boolean allowHtml;
	private Boolean showRowNumber;
	private String pagePolicy;
	private Integer pageSize;
	private String sortPolicy;

	public void setAllowHtml(boolean allowHtml) {
		this.allowHtml = allowHtml;
	}

	public final void setPagePolicy(String pagePolicy) {
		this.pagePolicy = pagePolicy;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setShowRowNumber(boolean showRowNumber) {
		this.showRowNumber = showRowNumber;
	}

	public final void setSortPolicy(String sortPolicy) {
		this.sortPolicy = sortPolicy;
	}

	protected boolean isInitializable() {
		if (showRowNumber == null)
			return false;
		if (allowHtml == null)
			return false;
		if (pagePolicy == null)
			return false;
		if (pageSize == null)
			return false;
		if (sortPolicy == null)
			return false;
		return true;
	}

	protected void initialize(Table.Options opt) {
		if (allowHtml != null)
			opt.setAllowHtml(allowHtml);
		if (pageSize != null)
			opt.setPageSize(pageSize);
		if (showRowNumber != null)
			opt.setShowRowNumber(showRowNumber);
		if (GwtHelper.isNotEmpty(pagePolicy))
			opt.setPage(Policy.valueOf(pagePolicy.toUpperCase()));
		if (GwtHelper.isNotEmpty(sortPolicy))
			opt.setSort(Policy.valueOf(sortPolicy.toUpperCase()));
	}

	protected Table.Options createChartOptions() {
		return Table.Options.create();
	}

	@Override
	public String getVisualizationPackage() {
		return Table.PACKAGE;
	}

	@Override
	public Table createVisualization(AbstractDataTable tbl,final VisualizationLoadCallback<Table> loadCallback) {
		return new Table(tbl,getChartOptions()) { 
			  protected void onLoad() {
				  super.onLoad();
				  if ( loadCallback != null )
					  loadCallback.loadDone(this);
			  }
		}; 
	}
}
