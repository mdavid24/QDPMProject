package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;



public class PropertiesReader {


	
	static Properties pr = new Properties();
	
	public static String getPropertyValueByKey(String key) 
	{
		String path = System.getProperty("user.dir")+"/test.Resources/config.properties";
		FileInputStream fi;
		try {
			fi = new FileInputStream(path);
			pr.load(fi);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	String value =	pr.getProperty(key);
	
	if(StringUtils.isEmpty(value))
		try {
		throw new Exception("Value is not found for given: "+key+" in properties file" );
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return value;
	}
	
	
	
	
	
	
}
