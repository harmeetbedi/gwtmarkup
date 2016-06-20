package emforium.gwt.widget.custom;

import com.extjs.gxt.ui.client.XDOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.ChangeListener;
import com.google.gwt.user.client.ui.KeyboardListener;
import com.google.gwt.user.client.ui.KeyboardListenerAdapter;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;

import emforium.gwt.widget.WidgetDOMConverter;
import emforium.gwt.widget.AttributeSetter.IntegerAttributeSetter;
import emforium.gwt.widget.AttributeSetter.StringAttributeSetter;


public  class TextAreaFactory extends emforium.gwt.widget.gwt.TextAreaFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "TextArea";
    
    public TextAreaFactory() {
    }

    protected void registerAttributes() {
        super.registerAttributes();
        register("remainingNotifId", new StringAttributeSetter<TextArea>() {
			public void set(final TextArea widget, Element element,String name, String value) {
				widget.setRemainingNotifElementId(value);
			}
        });
        register("maxLength", new IntegerAttributeSetter<TextArea>() {
			public void set(final TextArea widget, Element element,String name, final int value) {
				widget.setMaxLength(value);
				widget.resetTextWithMaxLimitCheck();
				KeyboardListener keyListener = new KeyboardListenerAdapter() {
					  public void onKeyUp(Widget sender, char keyCode, int modifiers) {
						  widget.resetTextWithMaxLimitCheck();
					  }
				};
				widget.addKeyboardListener(keyListener);
				ChangeListener listener = new ChangeListener() {
					public void onChange(Widget sender) {
						widget.resetTextWithMaxLimitCheck();
					}
				};
				widget.addChangeListener(listener);
			}
        });
    }

    @Override
    protected TextArea newInstance(Element element) {
    	String txt = element.getInnerText();
    	TextArea ta = new TextArea();
    	if ( txt != null ) {
    		txt = txt.trim();
    		ta.setText(txt);
    	}
    	return ta;
    }
    
    public TextArea create(java.util.List<Object> ancestors,final Element element) {
        final TextArea item = (TextArea)createInstance(element);
        new WidgetDOMConverter<TextArea>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}

class TextArea extends com.google.gwt.user.client.ui.TextArea {
	private String remainingNotifElementId;
	private Integer maxLength;

	public String getRemainingNotifElementId() {
		return remainingNotifElementId;
	}
	public void setRemainingNotifElementId(String remainingNotifElementId) {
		this.remainingNotifElementId = remainingNotifElementId;
	}

	public int getMaxLength() {
		return maxLength;
	}
	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}
	public void setText(String txt) {
		if ( maxLength == null ) {
			super.setText(txt);
			return;
		}
		if ( txt.length() > maxLength ) {
			txt = txt.substring(0,maxLength);
		}
		super.setText(txt);
		if ( remainingNotifElementId != null && remainingNotifElementId.length() > 0 ) {
			Element elem = XDOM.getElementById(remainingNotifElementId);
			if ( elem != null ) {
				int remaining = maxLength - txt.length();
				elem.setInnerHTML(remaining+"");
			}
		}
	}

	void resetTextWithMaxLimitCheck() {
		String txt = getText(); 
		if ( txt == null || maxLength == null )
			return;
		if ( txt.length() > maxLength ) {
			txt = txt.substring(0,maxLength);
			setText(txt);
			return;
		}
		if ( remainingNotifElementId != null && remainingNotifElementId.length() > 0 ) {
			Element elem = XDOM.getElementById(remainingNotifElementId);
			if ( elem != null ) {
				int remaining = maxLength - txt.length();
				elem.setInnerHTML(remaining+"");
			}
		}
	}
}
