package emforium.gwt.widget.visualization;

import emforium.gwt.widget.GwtObjectFactoryRegistry;
import emforium.gwt.widget.GwtObjectFactory;

import java.util.Map;

public class GwtFactoryRegistryImpl implements GwtObjectFactoryRegistry {
    
    public void registerFactories(String prefix,Map<String, GwtObjectFactory<?>> types) {
        // register widgets
		types.put(prefix+PieChartOptionsFactory.XML_TAG, new PieChartOptionsFactory() );
		types.put(prefix+BarChartOptionsFactory.XML_TAG, new BarChartOptionsFactory() );
		types.put(prefix+LineChartOptionsFactory.XML_TAG, new LineChartOptionsFactory() );
		types.put(prefix+ColumnChartOptionsFactory.XML_TAG, new ColumnChartOptionsFactory() );
		types.put(prefix+ScatterChartOptionsFactory.XML_TAG, new ScatterChartOptionsFactory() );
		types.put(prefix+AreaChartOptionsFactory.XML_TAG, new AreaChartOptionsFactory() );
		types.put(prefix+OrgChartOptionsFactory.XML_TAG, new OrgChartOptionsFactory() );
		types.put(prefix+MotionChartOptionsFactory.XML_TAG, new MotionChartOptionsFactory() );
		types.put(prefix+AnnotatedTimeLineOptionsFactory.XML_TAG, new AnnotatedTimeLineOptionsFactory() );
		types.put(prefix+TableOptionsFactory.XML_TAG, new TableOptionsFactory() );

		types.put(prefix+ChartFactory.XML_TAG, new ChartFactory() );
		types.put(prefix+DataFactory.XML_TAG, new DataFactory() );
    }
}
