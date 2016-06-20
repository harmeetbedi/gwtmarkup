package emforium.gwt.widget.custom;

import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.google.gwt.user.client.Element;


public  class ClientGridFactory extends AbstractGridFactory<ClientGrid> {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "ClientGrid";
    
    public ClientGridFactory() {
    }

	@Override
	protected ClientGrid createGrid(Element element) {
		return new ClientGrid();
	}

	@Override
	protected void createPostProcess(ClientGrid widget,Element element) {
		widget.setData(element);
//    	String data = element.getInnerHTML();
//    	if ( data == null )
//    		data = "";
//    	else
//    		data = data.trim();
//		widget.setData(data);
    }
}

class ClientGrid extends AbstractGrid {
	protected ListStore<ModelData> store;
	
	// this is set at widget create instance time.
	void setData(Element element) {
		//this.data = data;
		loadData(element);
		initGrid();
	}

	protected boolean isGridInitializable() {
		return super.isGridInitializable() && ( store != null );
	}

	protected void initGrid() {
		if ( gridInitialized )
			return;
	
		if ( !isGridInitializable() )
			return;
	
		Grid<ModelData> grid = newGridInstance(store);
	    add(grid);
	
		// for gc. Once grid is initialized, there is no need to keep raw data
		store = null;
		fireGridInitializedEvent();
	}

	// convert inner html into store and column specifications
    private void loadData(Element element) {
    	if ( element == null )
    		return;

    	ListStore<ModelData> store = getClientGridStore(element);
    	this.store = store;
    	this.columnSpecs = columnSpecs;
    }
}
