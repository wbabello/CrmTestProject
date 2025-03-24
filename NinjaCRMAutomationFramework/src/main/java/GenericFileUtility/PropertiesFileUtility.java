package GenericFileUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileUtility {

	public String getDataFromPropFile(String  key) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\wbabe\\OneDrive\\Desktop\\Automation_Framework\\NinjaCRMAutomationFramework\\src\\test\\resources\\commonData.properties");
		Properties properties = new Properties();
		properties.load(fis);
		String data = properties.getProperty(key);
		return data;
		
	}

}
