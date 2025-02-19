package testcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class DuplicateCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String str = "sdafasdfsdfsda";
		
		char[] ch = str.toCharArray();
		
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
		
		
		for (char c : ch) {
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			} else {
				map.put(c, 1);
			}
		}
		
		Set<Character> set = map.keySet();
		
		for (Character character : set) {
			if(map.get(character) >2 ) {
				System.out.println(character+""+map.get(character));
			}
		}
		
		
		//		for (Map.Entry<Integer, Character> entry : map.entrySet()) {
		//			
		//			if(map.containsValue(entry.getValue()){
		//				map.put(null, null)
		//			} else {
		//				map.put(1, )
		//			}
		//			
		//		}
		
		

	}

}
