package guava;

import org.junit.Test;

import com.google.common.base.Preconditions;

public class GuavaCheckConditionTest {

	private boolean estNombrePair(int arg) {
		if ((arg % 2) == 0) {
			return true;
		}
		return false;
	}
	
	private String buildStringHello() {
		return "hello";
	}
	
	@Test
	public void test01CheckArguement() {
		Preconditions.checkArgument(estNombrePair(0));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void test02CheckArgumentThrowIllegalArgumentException() {
		Preconditions.checkArgument(estNombrePair(1));
	}
	
	@Test
	public void test03CheckNull() {
		Preconditions.checkNotNull("hello");
	}
	
	@Test(expected=NullPointerException.class)
	public void test04CheckNullThrowNullPointerException() {
		Preconditions.checkNotNull(null);
	}

	@Test
	public void test05CheckState() {
		String obj = buildStringHello();
		
		Preconditions.checkState("hello".equals(obj));
	}
	
	@Test(expected=IllegalStateException.class)
	public void test06CheckStateThrowNullIllegalStateException() {
		String obj = buildStringHello();
		
		Preconditions.checkState("bonjour".equals(obj));
	}
}
