package emforium.gwt.util;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * helps profile. Map of profile token to total time taken is maintained
 */
public class GwtProfiler {
	private static Map<String,Long> s_token = new LinkedHashMap<String,Long>();

	private boolean enabled = false;

	public static void dump() {
		for ( Map.Entry<String, Long> entry : s_token.entrySet() )
			System.out.println(entry.getKey()+": "+entry.getValue());
	}
	
	private String token;
	private long startTime = System.currentTimeMillis();
	public GwtProfiler(String token) {
		this.token = token;
	}
	public void done() {
		if ( enabled ) {
			long timeTaken = System.currentTimeMillis()-startTime;
			Long prevTimeTaken = s_token.get(token);
			if ( prevTimeTaken != null )
				timeTaken += prevTimeTaken;
			s_token.put(token, timeTaken);
		}
	}
}

