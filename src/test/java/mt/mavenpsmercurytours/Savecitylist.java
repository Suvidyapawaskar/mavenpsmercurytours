package mt.mavenpsmercurytours;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;


public class Savecitylist extends mercurytours {
	
	public static FileInputStream fis ;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	
	
   public void SetCellData(String filename, String sheetname,int rowno,int colno,String datastring) throws IOException{
		
		FileInputStream file= new FileInputStream(new File(filename));
		XSSFWorkbook workbook= new XSSFWorkbook(file);
		XSSFSheet worksheet =workbook.getSheet(sheetname);
		XSSFRow row= worksheet.createRow(rowno);
		XSSFCell cell = row.createCell(colno);
		cell.setCellValue(datastring);
		FileOutputStream fileout= new FileOutputStream(filename);
		workbook.write(fileout);
	}

  public static void main(String[] args) throws IOException {
	
	  
}
   
   
}
