package blog.surapong.example.unit_test.sample;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class OrderUtil {
	
	public static int indexOfOrder(int[] array, int order) {
		
		if (array == null) {
			return -1;
		}
		
		if ( order > array.length || order < 1 ) {
			return -1;
		}
		
		Set<Integer> set = Arrays.stream(array).boxed().collect(Collectors.toSet());
		
		if (set.size() != array.length) {
			throw new IllegalArgumentException("Not UniqueArray");
		}
		
		
		int[] temp = new int[array.length]; 
		System.arraycopy(array, 0, temp, 0, array.length);
		
		Arrays.sort(temp);
		int orderValue = temp[order - 1];
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] == orderValue ) {
				return i;
			}
		}
		
		return -1;
	}
}
