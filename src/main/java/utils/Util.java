package utils;

import java.util.List;

import org.testng.Assert;

public class Util {
	
	public static void compareLists(List<String> actualList, List<String> expectedList) {
			Assert.assertTrue(actualList.equals(expectedList), "Actual List is not matching with the expected one");
	}

}
