package runner;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final String MAX_RETRY_COUNT = System.getProperty("retryCount");

    public boolean retry(ITestResult result) {
        if (retryCount < Integer.parseInt(MAX_RETRY_COUNT)) {
            retryCount++;
            return true;
        }
        return false;
    }

}
