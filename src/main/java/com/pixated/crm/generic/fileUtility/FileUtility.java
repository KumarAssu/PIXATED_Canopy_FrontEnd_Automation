 package com.pixated.crm.generic.fileUtility;
/**
 * this class store reusable method for getDataFromProperties file
 */
import java.io.FileInputStream;
import java.util.Properties;

import com.pixated.crm.generic.webDriverUtility.IconstantUtility;

public class FileUtility {
	/**
	 * this method is create reusable method for getDataFromProperties file
	 * @param key
	 * @return
	 * @throws Exception
	 */
      public String getDataFromProperties(String key)throws Exception{
    	  //FileInputStream fis=new FileInputStream("./cofigAppData/V_tiger.properties");
    	  Properties pobj=new Properties();
    	  pobj.load(new FileInputStream(IconstantUtility.propertiesPath));
    	  String data=pobj.getProperty(key);
    	  return data;
      }
}
