package utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer  implements IRetryAnalyzer   {

	int count=1;
	int retrylimit =Integer.valueOf(PropertiesReader.getPropertyValueByKey("retryCount"));
	
	
	
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		if(count<retrylimit)
		{
			count++;
			return true;
		}
		
		
		
		return false;
	}

	

}
