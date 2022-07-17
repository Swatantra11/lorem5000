package com.crm.reqing.GenericUtility;

public interface IConstantUtility {
	
	/**  
	 * 
	 * @author Chandel
	 * 
	 * it is used to get all the constant properties 
	 * 
	 * @param PropertyFilePath 
	 * @param ExcelFilePath 
	 * @param DatabaseUrl
	 * @param DatabaseUsername 
	 * @param Databasepassword 
	 * @param dateformat 
	 * @param implicitWait 
	 * @param explicitWait
	 * 
	 * 
	 * 
	 */
	
	String PropertyFilePath="./data/commondata.property";
	String ExcelFilePath="./data/vtigerdata.xlsx";
	String DatabaseUrl="jdbc:mysql://localhost:3306/sdet36";
	String Username="root";
	String password="root";
	String dateformat="yyyy/MM/dd HH:mm:ss";
	int implicitWait=20;
	int explicitWait=20;
	
}
