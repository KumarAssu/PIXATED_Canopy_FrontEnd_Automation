package com.pixated.crm.generic.fileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FisUtility {
public FileInputStream getJavaPhysicalFileFIS(String path) throws Exception {
	
	FileInputStream fis=new FileInputStream(path);
	return fis;
}
public FileOutputStream getJavaPhysicalFileFOS(String path) throws Exception {
	
	FileOutputStream fos=new FileOutputStream(path);
	return fos;
}
}
