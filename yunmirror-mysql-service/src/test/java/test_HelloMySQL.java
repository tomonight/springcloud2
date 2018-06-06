import junit.framework.Assert;

import org.junit.Test;


public class test_HelloMySQL {
	@Test
	public void testMain() {
		HelloMySQL mySQL = new HelloMySQL();
		mySQL.initialize();
		
		Assert.assertEquals(true, mySQL.status());
	}
	
	@Test
	public void testHello() {
		// Given:
		HelloMySQL mySQL = new HelloMySQL();
		mySQL.initialize();
		
		// When:
		
		mySQL.insert();
		// Then:
		
		Assert.assertEquals(1, mySQL.count());

	}

}
