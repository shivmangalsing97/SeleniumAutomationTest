package test;

import java.util.Set;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

public class StreamTest {
	
	int a = 10 ;
	double d = a ;
	Double b =  d ;
	
	
	@Test
	public void testStremReduce() {
		
		List<Integer> nums = Arrays.asList(1,2,3,4,5,6);
		int result = nums.stream().reduce(0, (subtotal, element) -> subtotal + element) ;		
		System.out.println(result);
	}
	
	@Test
	public void testStremForEach() {
		
		List<Integer> nums = Arrays.asList(1,2,3,4,5,6);
		nums.stream().forEach((x) -> System.out.println(x));		

	}
	
	@Test
	public void testStremFilter() {
		
		List<Integer> nums = Arrays.asList(1,2,3,4,5,6);
		nums.stream().filter((x) -> x%2==0).forEach(System.out::println );

	}	
	
	
	
	@Test
	public void testStremCount() {
		
		List<Integer> nums = Arrays.asList(1,2,3,4,5,6);
		long result = nums.stream().count() ;		
		System.out.println(result);
	}
	
	@Parameters({"a", "d"})
	@Test
	public void testMethod(int a , double d ) {
		this.a = a;
		this.d = d ;

		System.out.println(this.a +" "+this.d);
	}
	
	@Test
	public void hashMapTest() {		
		HashMap<String, String> map = new HashMap<>();
		map.put("name", "Shiv Mangal");
		map.put("gender", "Male");
		map.put("religion", "Hinduism");
		map.put("education", "Degree");
		
		Set<String> keys =  map.keySet();
		Iterator<String> it = keys.iterator();
		
		while(it.hasNext()) {
			String key = it.next();
			System.out.println(key +": "+map.get(key));
		}		
	}
	
	
}
