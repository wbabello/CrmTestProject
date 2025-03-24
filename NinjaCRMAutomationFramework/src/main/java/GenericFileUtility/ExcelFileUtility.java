package GenericFileUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	
	public String  getDataFromExcel(String sheet, int row, int cell ) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\wbabe\\OneDrive\\Desktop\\Automation_Framework\\NinjaCRMAutomationFramework\\src\\test\\resources\\CampaignTestData.xls");
		Workbook workbook = WorkbookFactory.create(fis);
		String excelData = workbook.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		
		return excelData;
		
		
	}
	
	
	

}


