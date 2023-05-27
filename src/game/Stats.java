package game;

import java.util.HashMap;
import java.util.Map;
 
/**
 * Created by Kyle at Sep 13, 2014
 */
public class Stats {
	private static Map<String, Object> stats = new HashMap<>();
	
	public static <T> T get(String stat) {
		return (T) stats.get(stat);
	}
	
	public static void set(String key, Object value) {
		stats.put(key, value);
	}
}
