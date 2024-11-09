package compleFlowWithDataShare;

import java.util.HashMap;
import java.util.Map;

public class DataShare {
	
	private static ThreadLocal<Map<String,Object>> tlMap = ThreadLocal.withInitial(() -> new HashMap<String,Object>());
	
	public static Object getMap(String key) {
		return tlMap.get().get(key);
	}
	
	public static void setMap(String key, Object val) {
		tlMap.get().put(key, val);
	}
	
	//Below methods are for data share between methods without ThreadLocal
	
//	private static Map<String,Object> map = new HashMap<String,Object>();
//	
//	public static Object getMap(String key) {
//		return map.get(key);
//	}
//	
//	public static void setMap(String key, Object val) {
//		map.put(key, val);
//	}
}
