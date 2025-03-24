package Login_Test_Cases;

import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.stream.FileImageInputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import GenericFileUtility.ExcelFileUtility;

public class Test_To_Read_DataFrom_Excell {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
// ExcelFileUtility getdataFromExcel = new ExcelFileUtility();
 
		
		
		FileInputStream exFile = new FileInputStream("C:\\Users\\wbabe\\OneDrive\\Desktop\\Automation_Framework\\NinjaCRMAutomationFramework\\src\\test\\resources\\CMDBDataImport.xls");
		Workbook dataF = WorkbookFactory.create(exFile);
		String data1 = dataF.getSheet("Sheet1").getRow(0).getCell(0).getStringCellValue();
		String data2 = dataF.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		String data3 = dataF.getSheet("Sheet1").getRow(2).getCell(2).getStringCellValue();
		
		System.out.println(data1);
		System.out.println(data2);
		System.out.println(data3);
		 
		
		
	}

}