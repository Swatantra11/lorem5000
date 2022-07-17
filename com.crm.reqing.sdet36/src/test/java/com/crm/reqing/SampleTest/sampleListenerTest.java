package com.crm.reqing.SampleTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.reqing.GenericUtility.BaseClass;
@Listeners(com.crm.reqing.GenericUtility.ListenerImplimentation.class)
public class sampleListenerTest extends BaseClass{



	@Test
	public void allone() {
		SoftAssert softa=new SoftAssert();
		System.out.println("hiii");
		softa.assertTrue("a".equals("a"));

		System.out.println("byee");
		softa.assertAll();
	}
}
