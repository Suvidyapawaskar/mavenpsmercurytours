package mt.mavenpsmercurytours;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class mercurytours {
  
	
 public WebDriver driver ;
 public static String cityname;
 public static FileInputStream fis ;
 public static XSSFWorkbook wb;
 public static XSSFSheet sheet;
 public static XSSFRow row;
 public static XSSFCell cell;

 @Test(priority=1)
  public void Openbrowser() {
	  
	 System.setProperty("webdriver.chrome.driver", "G:\\Selenium Setup\\setup1\\chromedriver_win32 (8)\\chromedriver.exe");
	 driver = new ChromeDriver();
	 //driver.get("http://newtours.demoaut.com/mercurywelcome.php?osCsid=c630a5ed8fcd98956e9a93e42da0b1d1");
	 
  }
 
 @Test(priority=2)
  public void EnterApplicationurl()
  {
	 driver.get("http://newtours.demoaut.com/mercurywelcome.php?osCsid=c630a5ed8fcd98956e9a93e42da0b1d1");
  }
 
 @Test(priority=3)
 public void Maximizebrowser()
 {
	 driver.manage().window().maximize();
 }
 
 @Test(priority=4)
 public void Loginwithvalidds()
 {
	 driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("suvidyap1");
	 driver.findElement(By.xpath("//input[@type='password']")).sendKeys("P@ssword1");
	 driver.findElement(By.xpath("//input[@name='login']")).click();
	 boolean act_flag=driver.findElement(By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']")).isDisplayed();
	 boolean exp_flag= true;
	 Assert.assertEquals(act_flag, exp_flag);
	 driver.findElement(By.linkText("SIGN-OFF")).click();
 }
 
 @Test(priority=5)
 public void Loginwithinvalidds()
 {
	 driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("suvidyap");
	 driver.findElement(By.xpath("//input[@type='password']")).sendKeys("P@ssword");
	 driver.findElement(By.xpath("//input[@name='login']")).click();
	 boolean act_flag=driver.findElement(By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']")).isDisplayed();
	 boolean exp_flag= true;
	 Assert.assertEquals(act_flag, exp_flag);
	 driver.findElement(By.linkText("SIGN-OFF")).click();
 }
 
 @Test(priority=6)
 public void Bookflight() throws IOException
 {
	 
	// FileInputStream file = new FileInputStream(new File("F:\\Suvidya_data\\Java_Selenium\\mavenpsmercurytours\\src\\test\\resources\\citylist.xlsx"));
	// XSSFWorkbook workbook = new XSSFWorkbook(file);
	// XSSFSheet worksheet =workbook.getSheet("Sheet1");
	 
	 driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("suvidyap1");
	 driver.findElement(By.xpath("//input[@type='password']")).sendKeys("P@ssword1");
	 driver.findElement(By.xpath("//input[@name='login']")).click();
	 driver.findElement(By.xpath("//input[@value='oneway']")).click();
	 WebElement passenger= driver.findElement(By.xpath("//select[@name='passCount']"));
	 Select sel = new Select(passenger);
	 sel.selectByValue("2");
	 
	 WebElement fromport = driver.findElement(By.xpath("//select[@name='fromPort']"));
	 Select sel1 = new Select(fromport);
	 sel1.selectByValue("Frankfurt");
	 Select sel2 = new Select(fromport);
	 List<WebElement> we = sel2.getOptions();
	 List<String> ls = new ArrayList<String>();
	 int rownum=0;
     int cellnum = 0;
	    for(WebElement a : we)
	    {
	       // if(!a.getText().equals("Select"))
	       // {
	            ls.add(a.getText());
	            String cityname= a.getText();
	            System.out.println(cityname);
	            //row= worksheet.createRow(rownum++);
	    		//cell = row.createCell(cellnum++);
	    		//cell.setCellValue(cityname);*/
	    		Savecitylist cl = new Savecitylist();
		        cl.SetCellData("F:\\Suvidya_data\\Java_Selenium\\mavenpsmercurytours\\src\\test\\resources\\citylist.xlsx", "Sheet1", rownum++, cellnum, cityname);
	            
	            //Savecitylist cl = new Savecitylist();
		        //cl.SetCellData("F:\\Suvidya_data\\Java_Selenium\\mavenpsmercurytours\\src\\test\\resources\\citylist.xlsx", "Sheet1", 1, 1, a.getText());
		           
	                        
	     //   }
	        /*Iterator itr = ls.iterator();
	        while(itr.hasNext())
	        {
	        	
	        	String text =(String) itr.next();
	        	System.out.println("list element is:"+text);
	        	Savecitylist cl = new Savecitylist();
		        cl.SetCellData("F:\\Suvidya_data\\Java_Selenium\\mavenpsmercurytours\\src\\test\\resources\\citylist.xlsx", "Sheet1", 1, 1, text);
		           
	        }*/
	    }
	    
	    
	    
	 
 }
}
	 
 
 
 

	    
 
 

