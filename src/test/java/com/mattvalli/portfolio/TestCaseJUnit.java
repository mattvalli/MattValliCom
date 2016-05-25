package com.mattvalli.portfolio;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestCaseJUnit {
	@Test
	public void testAdd() {
		String str = "Junit is working fine";
		assertEquals("Junit is working fine", str);
	}
}
