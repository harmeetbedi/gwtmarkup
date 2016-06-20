package emforium.gwt.widget.visualization;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.google.gwt.user.client.Element;
import com.google.gwt.visualization.client.DataTable;
import com.google.gwt.visualization.client.AbstractDataTable.ColumnType;
import com.google.gwt.xml.client.XMLParser;

import emforium.gwt.util.GwtHelper;
import emforium.gwt.widget.GwtObjectFactory;
import emforium.gwt.widget.MarkupConstants;

public class DataFactory extends GwtObjectFactory<Data> 
{
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "Data";

    public DataFactory() {
    }

    protected void registerAttributes() {
        super.registerAttributes();
    }
    
    protected final Data newInstance(Element element) {
    	String txt = element.getInnerHTML();
    	if ( txt == null )
    		txt = "";
    	else
    		txt = txt.trim();
		Data data = new Data(txt);
    	return data;
    }
    
    public Data create(java.util.List<Object> ancestors,final Element element) {
        final Data item = (Data)createInstance(element);
        return item;
    }
}

class Data implements MarkupConstants { 
    private DataTable data = null;
    private String xmlData;
    private Map<String,ColumnType> colTypeMap = new HashMap<String,ColumnType>();
	Data(String xmlData) {
		this.xmlData = xmlData;
	}
	private void loadData() {
		data = DataTable.create();
		com.google.gwt.xml.client.Document doc = XMLParser.parse(xmlData);
		com.google.gwt.xml.client.Element docElem = doc.getDocumentElement();
		com.google.gwt.xml.client.NodeList docNL = docElem.getChildNodes();
		int count = docNL.getLength();
		int dataRowIdx = 0;
		int dataColIdx = 0;
		for ( int ri = 0 ; ri < count ; ri++ ) {
			com.google.gwt.xml.client.Node node = docNL.item(ri);
			if ( !( node instanceof com.google.gwt.xml.client.Element ) )
				continue;
			com.google.gwt.xml.client.Element elem = (com.google.gwt.xml.client.Element)node;
			if ( elem.getNodeName().equalsIgnoreCase("column") ) {
				loadColumn(dataColIdx,elem);
				dataColIdx++;
			}
			else if ( elem.getNodeName().equalsIgnoreCase("row") ) {
	    		loadRow(dataRowIdx,elem); 
    			dataRowIdx++;
	    	}
		}
	}

	private void loadColumn(int dataColIdx, com.google.gwt.xml.client.Element elem) {
		ColumnType type = ColumnType.valueOf(elem.getAttribute("type").toUpperCase());
		String title = elem.getAttribute("title");
		String id = elem.getAttribute("name");
		if ( GwtHelper.isEmpty(id) ) {
			data.addColumn(type,title);
		}
		else {
			data.addColumn(type,title,id);
			colTypeMap.put(id, type);
		}
		colTypeMap.put(dataColIdx+"", type);
	}

	private void loadRow(int dataRowIdx,com.google.gwt.xml.client.Element elem) {
		com.google.gwt.xml.client.NodeList cellNL = elem.getChildNodes();
		int cellLen = cellNL.getLength();
		//System.out.println("Cellcount : "+cellLen);
		int dataColIdx = 0;
		for ( int ci = 0 ; ci < cellLen ; ci++ ) {
			com.google.gwt.xml.client.Node cellNode = cellNL.item(ci);
			if ( !( cellNode instanceof com.google.gwt.xml.client.Element ) )
				continue;
			if ( elem.getNodeName().equalsIgnoreCase("cell") )
				continue;

			com.google.gwt.xml.client.Element cellElem = (com.google.gwt.xml.client.Element)cellNode;
			String id = cellElem.getAttribute("name");
			// support for unspecified values. Since cells don't know the index
			if ( !cellElem.hasAttribute("value") ) {
				dataColIdx++;
				continue;
			}
			String origValue = cellElem.getAttribute("value");
			// this is to get around IE issues
			String value = origValue.replace("lt-x-lt", "<");
			value = value.replace("gt-x-gt", ">");
			if ( GwtHelper.isEmpty(id) ) {
				id = dataColIdx+"";
			}
			ColumnType colType = colTypeMap.get(id);
			//System.out.println("adding cells: "+dataRowIdx+", "+dataColIdx+", "+value);
			if ( dataColIdx == 0 )
				data.addRow();
			if ( colType == ColumnType.DATE || colType == ColumnType.DATETIME ) {
				// try a few ways to parse date, if cannot parse, assume field is text
				Date dtValue = GwtHelper.parseDate(value);
				data.setValue(dataRowIdx, dataColIdx, dtValue);
			} else if ( colType == ColumnType.NUMBER ) {
				Double numValue = Double.parseDouble(value);
				data.setValue(dataRowIdx, dataColIdx, numValue);
			} else if ( colType == ColumnType.BOOLEAN ) {
				Boolean boolValue = Boolean.parseBoolean(value);
				data.setValue(dataRowIdx, dataColIdx, boolValue);
			} else {
				data.setValue(dataRowIdx, dataColIdx, value);
			}
			String origDispValue = cellElem.getAttribute("display");
			if ( GwtHelper.isNotEmpty(origDispValue)) {
				String dispValue = origDispValue.replace("lt-x-lt", "<");
				dispValue = dispValue.replace("gt-x-gt", ">");
				data.setFormattedValue(dataRowIdx, dataColIdx, dispValue);
			}
			dataColIdx++;
		}
	}
	
	public DataTable getDataTable() {
		// lazily load data
		if ( data == null ) {
			if ( xmlData != null ) {
				loadData();
			}
			xmlData = null;
		}
		return data;
	}
}
