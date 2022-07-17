package com.crm.reqing.deleteAll;

import com.crm.reqing.CamapinsTest.CreateAndDeleteCampaignTest;
import com.crm.reqing.OrganizationsTest.CreateAndDeleteOrganizationTest;
import com.crm.reqing.ProductTest.CreateAndDeleteProductTest;
import com.crm.reqing.contactTest.CreateDeleteContacTest;
import com.crm.reqing.loginTest.LoginTest;

public class DeleteAllTest extends LoginTest{
	
public void deleteall() {
	CreateAndDeleteCampaignTest cadct=new CreateAndDeleteCampaignTest();
	CreateDeleteContacTest cdct=new CreateDeleteContacTest();
	CreateAndDeleteOrganizationTest cdot=new CreateAndDeleteOrganizationTest();
	CreateAndDeleteProductTest cadpt=new CreateAndDeleteProductTest();
	cadct.finaldelete();
	cdct.finaldelete();
	cdot.finaldelete();	
	cadpt.finaldelete();
	
}
}
