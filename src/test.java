import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class test {

	// "ADOBECODEBANC"
	// "ABC"
	public static void main(String[] args) {

		
		Map<String,Integer> map = new HashMap<>();
		map.put("hello", 1);
		map.put("hey", 5);
		map.put("heyA", 3);
		map.put("hI", 8);
		map.put("SARVESH", 4);
		
		List<String> list = new ArrayList<>();
		for(String str:map.keySet()) {
			list.add(str);
		}
		list.sort((a,b) ->map.get(b) - map.get(a));
		
		list = list.subList(0, 3);
		for(String str:list) {
			System.out.println(str);
		}
		

	}
	
	
}
