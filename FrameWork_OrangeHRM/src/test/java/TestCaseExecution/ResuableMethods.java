package TestCaseExecution;

import java.io.File;

import java.io.IOException;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class ResuableMethods extends ExecuteTestCase {

	public WebElement xp(String d) {
		return driver.findElement(By.xpath(p.getProperty(d)));
	}

	public void sleep(int a) throws InterruptedException {
		int r = 1000 * a;
		Thread.sleep(r);
	}

	public void Screenshot(String a) throws IOException {
		File s = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File t = new File("C:\\Users\\vinod\\Music\\My Evidences\\" + a + ".jpeg");
		FileHandler.copy(s, t);

	}

	public List<WebElement> empData(String a) {
		List<WebElement> allEmpData = driver.findElements(By.xpath(p.getProperty(a)));

		return allEmpData;
	}

	

}
