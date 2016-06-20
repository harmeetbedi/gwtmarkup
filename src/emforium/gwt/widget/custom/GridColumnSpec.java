package emforium.gwt.widget.custom;


public  class GridColumnSpec {
	private String field;
	private String display;
	private String type="String";
	private boolean hidden = false;
	private boolean sortable = true;
	private boolean fixed = false;
	private boolean groupable = false;
	private int relativeWidth = 10;
	private int absoluteWidth = -1;
	private boolean autoExpand = false; 
	private boolean menuDisabled = false;
	private boolean showToolTip = false;
	private String toolTipTemplate = null;
	private String toolTipTemplateRefId = null;
	private String style;
	private boolean editable;
	private String editChangeJsCallback;
	private boolean rowClickEnabled = true;
//	private Map<String,String> eventActionMap = new HashMap<String,String>();
	
	public boolean isRowClickEnabled() {
		return rowClickEnabled;
	}
	public void setRowClickEnabled(boolean rowClickEnabled) {
		this.rowClickEnabled = rowClickEnabled;
	}
	public boolean isShowToolTip() {
		return showToolTip;
	}
	public void setShowToolTip(boolean showToolTip) {
		this.showToolTip = showToolTip;
	}
	public String getToolTipTemplate() {
		return toolTipTemplate;
	}
	public void setToolTipTemplate(String toolTipTemplate) {
		if ( toolTipTemplate != null && toolTipTemplate.equals("none") )
			toolTipTemplate = "";
		this.toolTipTemplate = toolTipTemplate;
	}
	public String getToolTipTemplateRefId() {
		return toolTipTemplateRefId;
	}
	public void setToolTipTemplateRefId(String toolTipRefId) {
		if ( toolTipRefId != null && toolTipRefId.equals("none") )
			toolTipRefId = "";
		this.toolTipTemplateRefId = toolTipRefId;
	}
	public int getAbsoluteWidth() {
		return absoluteWidth;
	}
	public void setAbsoluteWidth(int absoluteWidth) {
		this.absoluteWidth = absoluteWidth;
	}
	public boolean isEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	public String getEditChangeJsCallback() {
		return editChangeJsCallback;
	}
	public void setEditChangeJsCallback(String editChangeJsCallback) {
		if ( editChangeJsCallback != null && editChangeJsCallback.equals("none") )
			editChangeJsCallback = "";
		this.editChangeJsCallback = editChangeJsCallback;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		if ( style != null && style.equals("none") )
			style = "";
		this.style = style;
	}
	public boolean isMenuDisabled() {
		return menuDisabled;
	}
	public void setMenuDisabled(boolean menuDisabled) {
		this.menuDisabled = menuDisabled;
	}
	public boolean isAutoExpand() {
		return autoExpand;
	}
	public void setAutoExpand(boolean autoExpand) {
		this.autoExpand = autoExpand;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDisplay() {
		if ( display == null )
			return field;
		else
			return display;
	}
	public void setDisplay(String display) {
		this.display = display;
	}
	public boolean isHidden() {
		return hidden;
	}
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
	public boolean isSortable() {
		return sortable;
	}
	public void setSortable(boolean sortable) {
		this.sortable = sortable;
	}
	public int getRelativeWidth() {
		return relativeWidth;
	}
	public void setRelativeWidth(int relativeWidth) {
		this.relativeWidth = relativeWidth;
	}
	public boolean isFixed() {
		return fixed;
	}
	public void setFixed(boolean fixed) {
		this.fixed = fixed;
	}
	public boolean isGroupable() {
		return groupable;
	}
	public void setGroupable(boolean groupable) {
		this.groupable = groupable;
	}

//	public Map<String, String> getEventActionMap() {
//		return eventActionMap;
//	}
//	public void setEventActionMap(Map<String, String> eventActionMap) {
//		this.eventActionMap = eventActionMap;
//	}

	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append((field == null || field.length() == 0) ? " " : field);
		buf.append(",");
		buf.append((display == null || display.length() == 0) ? " " : display);
		buf.append(",");
		buf.append(type);
		buf.append(",");
		buf.append(relativeWidth);
		buf.append(",");
		buf.append(absoluteWidth);
		buf.append(",");
		buf.append(hidden);
		buf.append(",");
		buf.append(sortable);
		buf.append(",");
		buf.append(fixed);
		buf.append(",");
		buf.append(groupable);
//		for ( Map.Entry<String,String> entry : eventActionMap.entrySet() ) {
//			buf.append(",");
//			buf.append(entry.getKey()).append(EVENT_ACTION_SEPARATOR).append(entry.getValue());
//		}
		return buf.toString();
	}
}
