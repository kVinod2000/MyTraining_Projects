package TestExecution;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class ReusedMethods extends ExecutionClass {
	public static Select select;

	public WebElement xp(String d) {
		return driver.findElement(By.xpath(properties.getProperty(d)));
	}

	public void sleep(int a) throws InterruptedException {
		int r = 1000 * a;
		Thread.sleep(r);
	}

	public void Screenshot(String a) throws IOException {
		File s = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File t = new File("C:\\Users\\vinod\\Music\\My Evidences1\\" + a + ".jpeg");
		FileHandler.copy(s, t);

	}

	public void drpdown(String a, String accnum) throws InterruptedException {

		WebElement drp = xp(a);
		sleep(4);
		select = new Select(drp);

		select.selectByVisibleText(accnum);

	}
}
