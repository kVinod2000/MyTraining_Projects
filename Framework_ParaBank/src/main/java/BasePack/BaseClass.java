package BasePack;

import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	public static WebDriver driver;
	public static Properties properties;

	@BeforeMethod
	public void openBrowser() throws IOException {

		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\vinod\\eclipse-workspace\\Framework_ParaBank\\MyDriver\\chromedriver.exe");
		driver.manage().window().maximize();

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\vinod\\eclipse-workspace\\Framework_ParaBank\\src\\data\\java\\MyData");

		properties = new Properties();

		properties.load(fis);

	}

}
