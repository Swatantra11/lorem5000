package com.crm.reqing.SampleTest;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.reqing.GenericUtility.BaseClass;

import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;





public class RetrySampleTest  extends BaseClass {
	@Test(retryAnalyzer =com.crm.reqing.GenericUtility.RetryTryImplimentation.class)
	public void allone() {
		SoftAssert softa=new SoftAssert();
		System.out.println("hiii");
		AssertJUnit.assertTrue("a".equals("a"));

		System.out.println("byee");
		softa.assertAll();
	}
	@Test(retryAnalyzer =com.crm.reqing.GenericUtility.RetryTryImplimentation.class)
	public void alltwo() {
		SoftAssert softa=new SoftAssert();
		System.out.println("hiii");
		AssertJUnit.assertTrue("a".equals("a"));

		System.out.println("byee");
		softa.assertAll();
	}
}

