package TestExecution;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Scripting extends ReusedMethods {

	static int shtnum = 1;

	public void register() throws IOException, InterruptedException {
		driver.get(properties.getProperty("URL"));
		xp("XREG").click();

		Screenshot("before Details Enter");

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\vinod\\eclipse-workspace\\Framework_ParaBank\\src\\data\\java\\ParaBank1.xlsx");

		XSSFWorkbook w = new XSSFWorkbook(fis);
		XSSFSheet s = w.getSheet("User1");

		String efirst = s.getRow(1).getCell(0).getStringCellValue();

		String elast = s.getRow(1).getCell(1).getStringCellValue();

		String address = s.getRow(1).getCell(2).getStringCellValue();

		String city = s.getRow(1).getCell(3).getStringCellValue();

		String state = s.getRow(1).getCell(4).getStringCellValue();

		int zip = (int) s.getRow(1).getCell(5).getNumericCellValue();

		long phone = (long) s.getRow(1).getCell(6).getNumericCellValue();

		int ssn = (int) s.getRow(1).getCell(7).getNumericCellValue();

		String username = s.getRow(1).getCell(8).getStringCellValue();

		String pass = s.getRow(1).getCell(9).getStringCellValue();

		String cnfrmpass = s.getRow(1).getCell(10).getStringCellValue();

		xp("XFIRST").sendKeys(efirst);
		xp("XLAST").sendKeys(elast);
		xp("XADDRE").sendKeys(address);
		xp("XCITY").sendKeys(city);
		xp("XSTATE").sendKeys(state);
		xp("XZIP").sendKeys(String.valueOf(zip));
		xp("XPHONE").sendKeys(String.valueOf(phone));
		xp("XSSID").sendKeys(String.valueOf(ssn));
		xp("XUSER").sendKeys(username);
		xp("XPASS").sendKeys(pass);
		xp("XCNFMPASS").sendKeys(cnfrmpass);

		Screenshot("after Details Enter");

		xp("XREGBTN").click();

		Screenshot("after clicking Register button");
		sleep(2);

		xp("XLOGUT").click();
	}

	public void multipleRegister() throws IOException {
		driver.get(properties.getProperty("URL"));

		for (int i = 1; i < 6; i++) {
			xp("XREG").click();

			FileInputStream fis = new FileInputStream(
					"C:\\Users\\vinod\\eclipse-workspace\\Framework_ParaBank\\src\\data\\java\\ParaBank1.xlsx");

			XSSFWorkbook w = new XSSFWorkbook(fis);
			XSSFSheet s = w.getSheet("User" + i);

			String efirst = s.getRow(1).getCell(0).getStringCellValue();

			String elast = s.getRow(1).getCell(1).getStringCellValue();

			String address = s.getRow(1).getCell(2).getStringCellValue();

			String city = s.getRow(1).getCell(3).getStringCellValue();

			String state = s.getRow(1).getCell(4).getStringCellValue();

			int zip = (int) s.getRow(1).getCell(5).getNumericCellValue();

			long phone = (long) s.getRow(1).getCell(6).getNumericCellValue();

			int ssn = (int) s.getRow(1).getCell(7).getNumericCellValue();

			String username = s.getRow(1).getCell(8).getStringCellValue();

			String pass = s.getRow(1).getCell(9).getStringCellValue();

			String cnfrmpass = s.getRow(1).getCell(10).getStringCellValue();

			Screenshot("Before Entering Data\\Before Entering Data" + efirst);

			xp("XFIRST").sendKeys(efirst);
			xp("XLAST").sendKeys(elast);
			xp("XADDRE").sendKeys(address);
			xp("XCITY").sendKeys(city);
			xp("XSTATE").sendKeys(state);
			xp("XZIP").sendKeys(String.valueOf(zip));
			xp("XPHONE").sendKeys(String.valueOf(phone));
			xp("XSSID").sendKeys(String.valueOf(ssn));
			xp("XUSER").sendKeys(username);
			xp("XPASS").sendKeys(pass);
			xp("XCNFMPASS").sendKeys(cnfrmpass);

			Screenshot("after Entering Data\\after Entering Data" + efirst);

			xp("XREGBTN").click();

			Screenshot("After Regestering\\After Regestering" + efirst);

			xp("XLOGUT").click();
		}
	}

	public void Login() throws IOException, InterruptedException {
		driver.get(properties.getProperty("URL"));

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\vinod\\eclipse-workspace\\Framework_ParaBank\\src\\data\\java\\ParaBank1.xlsx");

		XSSFWorkbook w = new XSSFWorkbook(fis);
		XSSFSheet s = w.getSheet("User1");

		String username = s.getRow(1).getCell(8).getStringCellValue();

		String pass = s.getRow(1).getCell(9).getStringCellValue();

		xp("XUSERNAME").sendKeys(username);

		xp("XPASSWORD").sendKeys(pass);

		sleep(3);

		xp("XLOGIN").click();

	}

	public void LoginMultipleUsers() throws IOException, InterruptedException {
		driver.get(properties.getProperty("URL"));

		for (int i = 1; i < 6; i++) {
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\vinod\\eclipse-workspace\\Framework_ParaBank\\src\\data\\java\\ParaBank1.xlsx");

			XSSFWorkbook w = new XSSFWorkbook(fis);
			XSSFSheet s = w.getSheet("User" + i);

			String username = s.getRow(1).getCell(8).getStringCellValue();

			String pass = s.getRow(1).getCell(9).getStringCellValue();

			xp("XUSERNAME").sendKeys(username);

			xp("XPASSWORD").sendKeys(pass);

			sleep(3);

			xp("XLOGIN").click();

			// addMultipleAccounts();
			fundsTransfer();
			fundsTransferFromSingleAccounttoMultiple();

		}

	}

	public void addAccount() throws IOException, InterruptedException {

		xp("OPEN").click();
		WebElement accdrp = xp("ACCTYPE");

		List<WebElement> drp = accdrp.findElements(By.tagName("option"));

		select = new Select(accdrp);

		select.selectByIndex(1);

		sleep(2);

		xp("OPENACC").click();

		sleep(3);
		String a = xp("ACCNUM").getText();

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\vinod\\eclipse-workspace\\Framework_ParaBank\\src\\data\\java\\ParaBank1.xlsx");

		XSSFWorkbook w = new XSSFWorkbook(fis);
		XSSFSheet s = w.getSheet("User1AccNum");

		XSSFRow r1 = s.createRow(1);
		XSSFCell r1c12 = r1.createCell(11);
		r1c12.setCellValue(a);

		FileOutputStream fos = new FileOutputStream(
				"C:\\Users\\vinod\\eclipse-workspace\\Framework_ParaBank\\src\\data\\java\\ParaBank1.xlsx");

		w.write(fos);

		fos.close();

	}

	public void addMultipleAccounts() throws IOException, InterruptedException {

		for (int i = 1; i < 16; i++) {

			xp("OPEN").click();
			WebElement accdrp = xp("ACCTYPE");

			List<WebElement> drp = accdrp.findElements(By.tagName("option"));

			Select sec = new Select(accdrp);

			sec.selectByIndex(1);

			sleep(2);

			xp("OPENACC").click();

			sleep(3);
			String a = xp("ACCNUM").getText();

			FileInputStream fis = new FileInputStream(
					"C:\\Users\\vinod\\eclipse-workspace\\Framework_ParaBank\\src\\data\\java\\ParaBank1.xlsx");

			XSSFWorkbook w = new XSSFWorkbook(fis);
			XSSFSheet s = w.getSheet("UserAcc" + shtnum);

			XSSFRow r1 = s.createRow(i);
			XSSFCell r1c12 = r1.createCell(0);
			r1c12.setCellValue(a);

			FileOutputStream fos = new FileOutputStream(
					"C:\\Users\\vinod\\eclipse-workspace\\Framework_ParaBank\\src\\data\\java\\ParaBank1.xlsx");

			w.write(fos);

			fos.close();
		}

		shtnum++;

		xp("XLOGUT").click();

	}

	public void fundsTransfer() throws IOException, InterruptedException {

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\vinod\\eclipse-workspace\\Framework_ParaBank\\src\\data\\java\\ParaBank1.xlsx");

		XSSFWorkbook w = new XSSFWorkbook(fis);
		XSSFSheet s = w.getSheet("UserAcc1");

		for (int i = 1; i < s.getLastRowNum(); i++) {
			xp("XFUNDS").click();

			sleep(4);

			String acc1 = s.getRow(i).getCell(0).getStringCellValue();

			String acc2 = s.getRow(i).getCell(1).getStringCellValue();

			long amt = (long) s.getRow(i).getCell(2).getNumericCellValue();

			xp("XAMOUNT").sendKeys(String.valueOf(amt));

			sleep(3);

			drpdown("XFROM", acc1);

			drpdown("XTO", acc2);

			xp("XTRANSFER").click();
		}

		
	}

	public void fundsTransferFromSingleAccounttoMultiple() throws IOException, InterruptedException {

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\vinod\\eclipse-workspace\\Framework_ParaBank\\src\\data\\java\\ParaBank1.xlsx");

		XSSFWorkbook w = new XSSFWorkbook(fis);
		XSSFSheet s = w.getSheet("UserAcc1");

		for (int j = 1; j < s.getLastRowNum(); j++) {
			for (int i = 1; i < s.getLastRowNum(); i++) {

				xp("XFUNDS").click();

				sleep(4);
				String acc1 = s.getRow(j).getCell(0).getStringCellValue();

				String acc2 = s.getRow(i).getCell(1).getStringCellValue();

				long amt = (long) s.getRow(i).getCell(2).getNumericCellValue();

				if (acc1.equals(acc2)) {
					continue;
				} else {

					xp("XAMOUNT").sendKeys(String.valueOf(amt));

					sleep(1);

					drpdown("XFROM", acc1);

					drpdown("XTO", acc2);
					sleep(1);

					xp("XTRANSFER").click();
				}
			}

		}
		
		xp("XLOGUT").click();
	}

	public void addMultipleAccounts1() throws IOException, InterruptedException {

		int temp = 15;

		for (int i = 1; i <= 15; i++) {

			xp("OPEN").click();
			WebElement accdrp = xp("ACCTYPE");

			List<WebElement> drp = accdrp.findElements(By.tagName("option"));

			Select sec = new Select(accdrp);

			sec.selectByIndex(1);

			sleep(2);

			xp("OPENACC").click();
			// System.out.println("Hii");

			sleep(3);
			String a = xp("ACCNUM").getText();

			FileInputStream fis = new FileInputStream(
					"C:\\Users\\vinod\\eclipse-workspace\\Framework_ParaBank\\src\\data\\java\\ParaBank1.xlsx");

			XSSFWorkbook w = new XSSFWorkbook(fis);
			XSSFSheet s = w.getSheet("UserAcc" + shtnum);

			XSSFRow r1 = s.createRow(i);
			XSSFCell r1c12 = r1.createCell(3);
			r1c12.setCellValue(a);

			XSSFRow r2 = s.createRow(temp);
			XSSFCell r2c2 = r2.createCell(1);
			r2c2.setCellValue(a);

			FileOutputStream fos = new FileOutputStream(
					"C:\\Users\\vinod\\eclipse-workspace\\Framework_ParaBank\\src\\data\\java\\ParaBank1.xlsx");

			w.write(fos);

			fos.close();
			temp--;
		}

		xp("XLOGUT").click();

	}
}