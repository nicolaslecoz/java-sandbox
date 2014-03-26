package guava;

import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;


//import com.google.common.base.Preconditions;
//import com.google.common.collect.Collections2;

public class GuavaTest {

	@Test
	public void test01() {
		
		// java.util
		@SuppressWarnings("rawtypes")
		List empty = Collections.EMPTY_LIST;
		
		Assert.assertNotNull(empty);
		
		// com.google.common.collect
		
		//Collections2.filter(unfiltered, predicate);
	}
	

	
}
