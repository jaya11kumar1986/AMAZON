package OracleApex;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;





public class LoginOne extends Base {
	//static WebDriver driver;
	public static void main(String[] args) throws IOException, InterruptedException {
		Report.startReport();
		FileInputStream file=new FileInputStream("D:\\Data.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		//String userName=workbook.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		//String passWord=workbook.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		workbook.close();
		//System.out.println(userName);
		// System.out.println(passWord);
		int rowNum = sheet.getLastRowNum();
		//System.out.println(rowNum);
		for(int i =1;i<rowNum+1;i++) {
			try {

			XSSFRow row = sheet.getRow(i);

			String userName = row.getCell(0).getStringCellValue();
			String passWord = row.getCell(1).getStringCellValue();
			String name=row.getCell(2).getStringCellValue();

			Base.browserLaunch();
			Employee.login(userName, passWord);
			Employee.employeeNameEntry(name);
			//Base.screenShot("Sample",i);
			Base.signOut();
			Report.stopReport();
			}
			 catch (Exception e) {
					
					e.printStackTrace();
					Report.reportStep("Unexpected Fail:"+e.getMessage(),"Fail");
					Report.stopReport();
					
					
				}
			}
		
	

	}
}

