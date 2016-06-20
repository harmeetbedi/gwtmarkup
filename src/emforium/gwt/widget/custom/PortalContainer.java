package emforium.gwt.widget.custom;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.custom.Portal;
import com.extjs.gxt.ui.client.widget.custom.Portlet;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;

/**
 * lazily creates portal when column width attribute is specified. 
 * Till column width is specified this is an empty component. 
 * After column width is specified this component is a container of portal.
 */
public class PortalContainer extends LayoutContainer {
	private List<Portlet> portlets = new ArrayList<Portlet>();
	private int columns;
	private Portal portal;
	
	public PortalContainer() {
		super(new FitLayout());
	}

	/**
	 * comma separated list of column widths. Portal needs number of columns and relative widths. Both are obtained from this parameter.
	 * @param columnWidths
	 */
	public void setColumnWidths(String columnWidths) {
		// get individual column width
		String[] cols = columnWidths.split(",");
		columns = cols.length;
		portal = new Portal(cols.length);
		for ( int i = 0 ; i < cols.length ; i++ ) {
			Double width = Double.valueOf(cols[i]);
			portal.setColumnWidth(i, width);
			//System.out.println("portal col width ("+i+") : "+width);
		}
		
		// add portal to layout
		this.removeAll();
		add(portal);

		// add known portlets to portal
		for ( int i = 0 ; i < portlets.size() ; i++ ) {
			Portlet portlet = portlets.get(i);
			int portletColumn = i % columns;
			portal.add(portlet,portletColumn);
		}
	}
	
	public void addPortlet(Portlet portlet) {
		if ( portal != null ) {
			int portletColumn = portlets.size() % columns;
			portal.add(portlet,portletColumn);
		}
		portlets.add(portlet);
	}
}