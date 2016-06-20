package emforium.gwt.widget.custom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.extjs.gxt.ui.client.Style.SortDir;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BasePagingLoadConfig;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.DataProxy;
import com.extjs.gxt.ui.client.data.DataReader;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.SortInfo;
import com.extjs.gxt.ui.client.store.GroupingStore;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.PagingToolBar;
import com.extjs.gxt.ui.client.widget.grid.EditorGrid;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolItem;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.xml.client.XMLParser;

import emforium.gwt.util.GwtXMLHelper;
import emforium.gwt.widget.AttributeSetter.IntegerAttributeSetter;
import emforium.gwt.widget.AttributeSetter.StringAttributeSetter;


public  class ClientPagedGridFactory extends AbstractGridFactory<ClientPagedGrid> {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "ClientPagedGrid";
    
    public ClientPagedGridFactory() {
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        register("page-size", new IntegerAttributeSetter<ClientPagedGrid>() {
			public void set(final ClientPagedGrid widget, Element element,String name, int value) {
				widget.setPageSize(value);
			}
        });
    }

    @Override
	protected ClientPagedGrid createGrid(Element element) {
		return new ClientPagedGrid();
	}

	@Override
	protected void createPostProcess(ClientPagedGrid widget,Element element) {
//    	String data = element.getInnerHTML();
//    	if ( data == null )
//    		data = "";
//    	else
//    		data = data.trim();
		widget.setXMLData(element);
    }
}

class ClientPagedGrid extends AbstractGrid {
	//protected BasePagingLoadResult<ModelData> dataRows;
	protected List<ModelData> dataRows;
	private PagingToolBar pagingToolbar;
	private int pageSize = -1;
	
	// this is set at widget create instance time.
	void setXMLData(Element data) {
		//this.data = data;
		loadData(data);
		initGrid();
	}

	// this is set at widget create instance time.
	void setPageSize(int pageSize) {
		//this.data = data;
		this.pageSize = pageSize;
		pagingToolbar = new PagingToolBar(pageSize) {
			protected void onRender(Element target, int index) {
				super.onRender(target, index);
				// im-memory grid, so no need to have refresh. 
				// Default render has no option to not add 'refresh' button, so remove needs to be done post render
				int refreshIdx = toolBar.indexOf(refresh);
				toolBar.remove(refresh);
				if ( refreshIdx > 0 ) {
					ToolItem lastSeparatorItem = toolBar.getItem(refreshIdx-1);
					if ( lastSeparatorItem instanceof SeparatorToolItem ) {
						toolBar.remove(lastSeparatorItem);
					}
				}
			}
		};
	    setBottomComponent(pagingToolbar);
		initGrid();
	}

	protected boolean isGridInitializable() {
		return super.isGridInitializable() && ( dataRows != null && columnSpecs != null && pageSize > 0 );
	}

	protected void initGrid() {
		if ( gridInitialized )
			return;
	
		if ( !isGridInitializable() )
			return;
	
		PagedMemoryProxy proxy = new PagedMemoryProxy(dataRows);
		//MemoryProxy proxy = new MemoryProxy(dataRows);
		//PagedListReader reader = new PagedListReader(dataRows);
		//BasePagingLoader<BasePagingLoadConfig, BasePagingLoadResult<ModelData>> loader = new BasePagingLoader<BasePagingLoadConfig, BasePagingLoadResult<ModelData>>(proxy);
		//BasePagingLoader loader = new BasePagingLoader(proxy,reader);
		BasePagingLoader loader = new BasePagingLoader(proxy);
		loader.setRemoteSort(true);
		ListStore<ModelData> store = isGroupedGrid() ? new GroupingStore<ModelData>(loader) : new ListStore<ModelData>(loader);
	
		//PagingToolBar toolBar = new PagingToolBar(pageSize);
		pagingToolbar.bind(loader);
		loader.load(0, pageSize);
		
		Grid<ModelData> grid = newGridInstance(store);
	    add(grid);
	    //setBottomComponent(toolBar);
	
		// for gc. Once grid is initialized, there is no need to keep raw data
		store = null;
		fireGridInitializedEvent();
	}

	// convert inner html into store and column specifications
    private void loadData(Element data) {
    	if ( data == null )
    		return;

    	ListStore<ModelData> store = getClientGridStore(data);
    	
    	//this.dataRows = new BasePagingLoadResult<ModelData>(store,0,store.size());
    	this.dataRows = store.getModels();
    }
}

class PagedListReader implements DataReader<BasePagingLoadConfig, BasePagingLoadResult<ModelData>> {
	private BasePagingLoadResult<ModelData> list;
	PagedListReader(BasePagingLoadResult<ModelData> list) {
		this.list = list;
	}
	@SuppressWarnings("unchecked")
	public BasePagingLoadResult<ModelData> read(BasePagingLoadConfig loadConfig,Object data) {
		//BasePagingLoadResult<ModelData> list = (BasePagingLoadResult<ModelData>) data;
		//List<ModelData> list = (List<ModelData>) data;
		//return new BasePagingLoadResult(list, 0, list.size());
		List<ModelData> result = new ArrayList<ModelData>();
		int toIdx = loadConfig.getOffset() + loadConfig.getLimit();
		for ( int idx = loadConfig.getOffset() ; idx < toIdx ; idx++ )
			result.add(list.getData().get(idx));
		return new BasePagingLoadResult(list.getData(),loadConfig.getOffset(),list.getTotalLength());
	}
}

class PagedMemoryProxy implements
		DataProxy<BasePagingLoadConfig, BasePagingLoadResult<ModelData>> {
	private List<ModelData> data;
	private SortInfo lastSortInfo;
	
	public PagedMemoryProxy(List<ModelData> data) {
		this.data = data;
	}

	public List<ModelData> getData() {
		return data;
	}

	public void load(DataReader<BasePagingLoadConfig, BasePagingLoadResult<ModelData>> reader,
			BasePagingLoadConfig loadConfig,
			AsyncCallback<BasePagingLoadResult<ModelData>> callback) {
		try {
			sort(loadConfig.getSortInfo());
			List<ModelData> result = new ArrayList<ModelData>();
			int toIdx = loadConfig.getOffset() + loadConfig.getLimit();
			for ( int idx = loadConfig.getOffset() ; idx < toIdx ; idx++ ) {
				if ( idx < data.size() )
					result.add(data.get(idx));
			}
			BasePagingLoadResult loadResult = new BasePagingLoadResult(result,loadConfig.getOffset(),data.size());
			callback.onSuccess(loadResult);
		} catch (Exception e) {
			e.printStackTrace();
			callback.onFailure(e);
		}
	}
	
	// alter stored data to be desired sort order
	private void sort(SortInfo si) {
		// check for valid sort criteria
		if ( si == null || si.getSortField() == null )
			return;
		//System.out.println("sortInfo: "+si.getSortField()+", "+si.getSortDir().name());
		// check if sort criteria matches last sort criteria
		if ( lastSortInfo != null ) {
			//System.out.println("lastSortInfo: "+lastSortInfo.getSortField()+", "+lastSortInfo.getSortDir().name());
			if ( lastSortInfo.getSortField().equals(si.getSortField()) && lastSortInfo.getSortDir() == si.getSortDir() )
				return;
		}
		// change data to match sort criteria
		Collections.sort(data,new ModelDataComparator(si));
		lastSortInfo = new SortInfo(si.getSortField(),si.getSortDir());
	}
}

/**
 * compares 2 model data values based on a SortInfo. Assumes that property is SortInfo exists in model data
 */
class ModelDataComparator implements Comparator<ModelData> {
	private final String property;
	private boolean ascOrder;
	ModelDataComparator(SortInfo si) {
		property = si.getSortField();
		ascOrder = (si.getSortDir().ordinal() != SortDir.DESC.ordinal());
		//System.out.println("sort: "+property+" asc="+ascOrder);
	}
	public int compare(ModelData o1, ModelData o2) {
		int value = compareToAsc(o1,o2);
		if ( !ascOrder )
			value = -1 * value;
		return value;
	}
	@SuppressWarnings("unchecked")
	private int compareToAsc(ModelData o1, ModelData o2) {
		Object obj1 = o1.get(property);
		Object obj2 = o2.get(property);
		if ( obj1 == obj2 )
			return 0;
		if ( obj1 != null && !(obj1 instanceof String) && (obj1 instanceof Comparable)) {
			return ((Comparable)obj1).compareTo(obj2);
		}
		String s1 = String.valueOf(obj1);
		String s2 = String.valueOf(obj2);
		if ( s1 == null )
			return -1;
		else 
			return s1.compareToIgnoreCase(s2);
	}
}