package emforium.gwt.widget.custom;

import java.util.List;

import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BasePagingLoadConfig;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.HttpProxy;
import com.extjs.gxt.ui.client.data.ListLoadConfig;
import com.extjs.gxt.ui.client.data.ListLoadResult;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.ModelType;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.XmlReader;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.PagingToolBar;
import com.extjs.gxt.ui.client.widget.grid.EditorGrid;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.user.client.Element;

import emforium.gwt.widget.AttributeSetter.StringAttributeSetter;
import emforium.gwt.widget.AttributeSetter.IntegerAttributeSetter;


public  class ServerGridFactory extends AbstractGridFactory<ServerGrid> {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "ServerGrid";
    
    public ServerGridFactory() {
    }

    protected void registerAttributes() {
        super.registerAttributes();
        register("data-url", new StringAttributeSetter<ServerGrid>() {
			public void set(final ServerGrid widget, Element element,String name, String value) {
				widget.setDataUrl(value);
			}
        });
        register("page-size", new IntegerAttributeSetter<ServerGrid>() {
			public void set(final ServerGrid widget, Element element,String name, int value) {
				widget.setPageSize(value);
			}
        });
        register("row-count-attr", new StringAttributeSetter<ServerGrid>() {
			public void set(final ServerGrid widget, Element element,String name, String value) {
				widget.setRowCountAttribute(value);
			}
        });
        register("root-elem", new StringAttributeSetter<ServerGrid>() {
			public void set(final ServerGrid widget, Element element,String name, String value) {
				widget.setDataRootElementName(value);
			}
        });
        register("row-elem", new StringAttributeSetter<ServerGrid>() {
			public void set(final ServerGrid widget, Element element,String name, String value) {
				widget.setDataRowElementName(value);
			}
        });
    }
    
    @Override
	protected ServerGrid createGrid(Element element) {
		return new ServerGrid();
	}
}

class ServerGrid extends AbstractGrid {
	protected String dataUrl;
	private int pageSize = 10;
	private String dataRootElementName = "rows";
	private String dataRowElementName = "row";
	private String rowCountAttribute = "total";
	
	// this is set at widget create instance time.
	void setDataUrl(String dataUrl) {
		this.dataUrl = dataUrl;
		initGrid();
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setDataRootElementName(String dataRootElementName) {
		this.dataRootElementName = dataRootElementName;
	}

	public void setDataRowElementName(String dataRowElementName) {
		this.dataRowElementName = dataRowElementName;
	}

	public void setRowCountAttribute(String rowCountAttribute) {
		this.rowCountAttribute = rowCountAttribute;
	}


	protected boolean isGridInitializable() {
		return super.isGridInitializable() && ( dataUrl != null );
	}

	@SuppressWarnings("unchecked")
	protected void initGrid() {
		if ( gridInitialized )
			return;

		if ( !isGridInitializable() )
    		return;

	    // use a http proxy to get the data  
	    RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, dataUrl);  
	    HttpProxy<BasePagingLoadConfig,ModelData> proxy = new HttpProxy<BasePagingLoadConfig,ModelData>(builder);

	    // defines the xml structure  
	    ModelType type = new ModelType();  
	    type.root = dataRootElementName;  
	    type.recordName = dataRowElementName;
	    type.totalName = rowCountAttribute;
	    for ( GridColumnSpec spec : columnSpecs )
		    type.addField(spec.getField());  

	    // need a loader, proxy, and reader  
	    XmlReader<BasePagingLoadConfig> reader = new XmlReader<BasePagingLoadConfig>(type) {
		    protected ListLoadResult<ModelData> newLoadResult(BasePagingLoadConfig loadConfig, List<ModelData> models) {
		    	BasePagingLoadResult<ModelData> res = new BasePagingLoadResult<ModelData>(models);
		    	res.setOffset(loadConfig.getOffset());
		    	return res;
		      }
	    };

	    // loader  
	    BasePagingLoader loader = new BasePagingLoader(proxy,reader);  
	    loader.setRemoteSort(true);
	    loader.load(0, pageSize);
	    
	    // grid
	    ListStore<ModelData> store = new ListStore<ModelData>(loader);
	    Grid<ModelData> grid = newGridInstance(store);
	    add(grid);
	    
	    // paging toolbar
	    final PagingToolBar toolBar = new PagingToolBar(pageSize);  
	    toolBar.bind(loader); 
		setBottomComponent(toolBar);

		fireGridInitializedEvent();
    }
}
