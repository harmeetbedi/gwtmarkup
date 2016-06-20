package emforium.gwt.widget;

import java.util.Map;

//import emforium.gwt.widget.gxt.GeneratedObjectFactoryLookup;

/**
 * There may be many component registries in the system. Each registry implements this interface 
 */
public interface GwtObjectFactoryRegistry {
	/**
	 * called by class that aggregates various registries
	 * @param prefix namespace assigned to registry
	 * @param types Factories should add themselves to this map of registries. Key must be prefixed with @param prefix
	 */
	public void registerFactories(String prefix,Map<String, GwtObjectFactory<?>> types);
}
