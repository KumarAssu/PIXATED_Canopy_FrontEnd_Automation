package com.pixated.crm.generic.fileUtility;
/**
 * This class is for store all reusable method related to excel
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.pixated.crm.generic.webDriverUtility.IconstantUtility;



public class ExcelUtility {
	/**
	 * This method is used for getdatafromexcel using sheetname,row index and cell index
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Exception
	 */
  public String getDataFromExcel(String sheetName,int rowNum,int cellNum) throws Exception{
	//FileInputStream fis=new FileInputStream("./testData/Wrokbook.xlsx");
	  //Workbook wb=WorkbookFactory.create(fis);	     
	  Workbook wb=WorkbookFactory.create(new FileInputStream(IconstantUtility.excelPath));
	      Sheet sh=wb.getSheet(sheetName);
	      DataFormatter format=new DataFormatter();
        String data=format.formatCellValue( sh.getRow(rowNum).getCell(cellNum));
          return data;                        
       }
  /**
   *this method is for get the lastrownum count
   * @param sheetName
   * @return
   * @throws Exception
   */
  public int getRowCount(String sheetName) throws Exception{
	  //FileInputStream fis=new FileInputStream("./testData/Wrokbook.xlsx");
	  //Workbook wb=WorkbookFactory.create(fis);
	  Workbook wb=WorkbookFactory.create(new FileInputStream(IconstantUtility.excelPath));
      
      int rowCount=wb.getSheet(sheetName).getLastRowNum();
      return rowCount;
  }
  /**
   * This method is for get last cell count
   * @param sheetName
   * @param row
   * @return
   * @throws Exception
   */
  public int getCellCount(String sheetName,int row) throws Exception{
	  //FileInputStream fis=new FileInputStream("./testData/Wrokbook.xlsx");
	  //Workbook wb=WorkbookFactory.create(fis);
	  Workbook wb=WorkbookFactory.create(new FileInputStream(IconstantUtility.excelPath));
      int rowCount=wb.getSheet(sheetName).getRow(row).getLastCellNum();
      return rowCount;
  }
  /**
   * This method is create for set data back to excel
   * @param sheetName
   * @param rowNum
   * @param cellNum
   * @param data
   * @throws Exception
   */
  public void setDataIntoExcel(String sheetName,int rowNum, int cellNum,String data) throws Exception{
	  //FileInputStream fis=new FileInputStream("./testData/Wrokbook.xlsx");
	  //Workbook wb=WorkbookFactory.create(fis);
	  Workbook wb=WorkbookFactory.create(new FileInputStream(IconstantUtility.excelPath));
      wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum).setCellValue(data);
//      FileOutputStream fos=new FileOutputStream("./testData/Wrokbook.xlsx");
//      wb.write(fos);
      wb.write(new FileOutputStream(IconstantUtility.excelPath));
      wb.close();
  }
	/*
	 * public String getMultDataFromExcel(String sheetName,int rowNum,int cellNum)
	 * throws Exception{ //FileInputStream fis=new
	 * FileInputStream("./testData/Wrokbook.xlsx"); Workbook
	 * wb=WorkbookFactory.create(new FileInputStream(IconstantUtility.excelPath));
	 * Sheet sh=wb.getSheet(sheetName); DataFormatter format=new DataFormatter();
	 * for(int i=0;i<sh.getLastRowNum();i++) { Row r=sh.getRow(i); for(int
	 * j=0;i<r.getLastCellNum();j++) { String
	 * data=format.formatCellValue(r.getCell(j));
	 * 
	 * }
	 * 
	 * } return data;
	 * 
	 * }
	 */
  }
