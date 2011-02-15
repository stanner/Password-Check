import junit.framework.TestCase;

public class testPasswordCheck extends TestCase{
	
	
	public void testPasswordWasComplex() {
	assertEquals("Complex?", "Your Password is complex.", passwordCheck.checkPassword("Password", 2));
	assertEquals("Complex?", "To make your password more complex, it should contain 1 of the following rules:\nA number\nA special character\n" , passwordCheck.checkPassword("Password", 3));
	assertEquals("Complex?", "Your Password is complex.", passwordCheck.checkPassword("Pa$$word", 3));

	}
	 public static void main(String[] args) {
	        junit.textui.TestRunner.run(
	            testPasswordCheck.class);
	    }

}
