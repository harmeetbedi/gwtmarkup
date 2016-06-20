package emforium.gwt.widget.custom;

import emforium.gwt.widget.GwtObjectFactoryRegistry;
import emforium.gwt.widget.GwtObjectFactory;

import java.util.Map;

public class GwtFactoryRegistryImpl implements GwtObjectFactoryRegistry {
    
    public void registerFactories(String prefix,Map<String, GwtObjectFactory<?>> types) {
        // register generated widgets
		types.put(prefix+CustomDateFieldFactory.XML_TAG, new CustomDateFieldFactory() );
		types.put(prefix+TagFieldFactory.XML_TAG, new TagFieldFactory() );
		types.put(prefix+TagFieldOptionFactory.XML_TAG, new TagFieldOptionFactory() );
		types.put(prefix+PortalFactory.XML_TAG, new PortalFactory() );
		types.put(prefix+BorderLayoutDataFactory.XML_TAG, new BorderLayoutDataFactory() );
		// list: removeitem, additem, addtemplate, existingitems
		types.put(prefix+ListAddItemFactory.XML_TAG, new ListAddItemFactory() );
		types.put(prefix+ListRemoveItemFactory.XML_TAG, new ListRemoveItemFactory() );
		types.put(prefix+ListExistingItemsFactory.XML_TAG, new ListExistingItemsFactory() );
		types.put(prefix+ListAddTemplateFactory.XML_TAG, new ListAddTemplateFactory() );
		types.put(prefix+TextAreaFactory.XML_TAG, new TextAreaFactory() );
		types.put(prefix+ClientGridFactory.XML_TAG, new ClientGridFactory() );
		types.put(prefix+ServerGridFactory.XML_TAG, new ServerGridFactory() );
		types.put(prefix+ClientPagedGridFactory.XML_TAG, new ClientPagedGridFactory() );
		types.put(prefix+CustomClockFactory.XML_TAG, new CustomClockFactory() );
		types.put(prefix+RichTextContainerFactory.XML_TAG, new RichTextContainerFactory() );
		types.put(prefix+RichTextAreaFactory.XML_TAG, new RichTextAreaFactory() );
		types.put(prefix+CoverFlowFactory.XML_TAG, new CoverFlowFactory() );
		types.put(prefix+EventCallbackFactory.XML_TAG, new EventCallbackFactory() );
		types.put(prefix+TabPanelFactory.XML_TAG, new TabPanelFactory() );
        types.put(prefix+MenuItemFactory.XML_TAG, new MenuItemFactory());
        types.put(prefix+MenuFactory.XML_TAG, new MenuFactory());
    }
}
