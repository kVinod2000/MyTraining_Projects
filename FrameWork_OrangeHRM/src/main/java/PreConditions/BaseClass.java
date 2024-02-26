package PreConditions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class BaseClass {

	public static WebDriver driver;
	public static Properties p;

	@BeforeClass
	public void openBrowser() throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\vinod\\eclipse-workspace\\FrameWork_OrangeHRM\\MyDriver\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();

		FileInputStream f = new FileInputStream(
				"C:\\Users\\vinod\\eclipse-workspace\\FrameWork_OrangeHRM\\src\\data\\java\\TestData\\MyData");

		p = new Properties();

		p.load(f);

	}

}
