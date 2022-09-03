package CodeForProxy;

import java.util.HashMap;

public class CacheProxyWork implements ISomeWork {
	RealWork rw = new RealWork();
	HashMap<Integer, Integer> f1map = new HashMap<>();
	
	@Override
	public int fun1(int x) {
		if(f1map.containsKey(x) == true) {
			return f1map.get(x);
		}
		int res = rw.fun1(x);
		f1map.put(x,  res);
		return res;
		
	}

	@Override
	public int fun2(int x, int y) {
		rw.fun2(x, y);
		
	}
	
}
