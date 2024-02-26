package TestCaseExecution;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ScriptCoding extends ResuableMethods {

	public void login() {

		driver.get(p.getProperty("URL"));

		xp("XUN").sendKeys(p.getProperty("UN"));

		xp("XPWD").sendKeys(p.getProperty("PWD"));

		xp("XSUB").click();

	}

	// ADD Employee

	public void addEmployee() throws InterruptedException, AWTException {
		Actions a = new Actions(driver);

		a.moveToElement(xp("XPIM")).perform();

		sleep(2);

		xp("XADD").click();

		driver.switchTo().frame(xp("XFRAME"));

		xp("XID").clear();

		sleep(1);

		xp("XID").sendKeys("209");

		xp("XLAST").sendKeys("M");

		xp("XFIRST").sendKeys("Vinaykumar");

		xp("XMID").sendKeys("Reddy");

		xp("XNICK").sendKeys("Vinay");

		sleep(1);

		a.moveToElement(xp("XPHOTO")).click().perform();

		sleep(1);

		StringSelection s = new StringSelection(
				"C:\\Users\\vinod\\OneDrive\\Pictures\\Screenshots\\Screenshot (4).png");

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);

		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);

		sleep(1);

		r.keyPress(KeyEvent.VK_ENTER);

		r.keyRelease(KeyEvent.VK_ENTER);

		sleep(1);

		xp("XSAVE").click();

		sleep(1);

		xp("XBACK").click();

	}

	// ADD One Employee From EXcel

	public void addOneEmployeeFromExcel() throws InterruptedException, AWTException, IOException {

		FileInputStream f = new FileInputStream(
				"C:\\Users\\vinod\\eclipse-workspace\\FrameWork_OrangeHRM\\src\\data\\java\\TestData\\EmpData.xlsx");

		XSSFWorkbook w = new XSSFWorkbook(f);

		XSSFSheet s = w.getSheet("ADDEMP");

		int eid = (int) s.getRow(1).getCell(0).getNumericCellValue();

		String elast = s.getRow(1).getCell(2).getStringCellValue();

		String efirst = s.getRow(1).getCell(1).getStringCellValue();

		String emid = s.getRow(1).getCell(3).getStringCellValue();

		String enick = s.getRow(1).getCell(4).getStringCellValue();

		Actions a = new Actions(driver);

		a.moveToElement(xp("XPIM")).perform();

		sleep(2);

		xp("XADD").click();

		driver.switchTo().frame(xp("XFRAME"));

		xp("XID").clear();

		sleep(1);

		xp("XID").sendKeys(String.valueOf(eid));

		xp("XLAST").sendKeys(elast);

		xp("XFIRST").sendKeys(efirst);

		xp("XMID").sendKeys(emid);

		xp("XNICK").sendKeys(enick);

		sleep(1);

		a.moveToElement(xp("XPHOTO")).click().perform();

		sleep(1);

		StringSelection sec = new StringSelection(
				"C:\\Users\\vinod\\eclipse-workspace\\FrameWork_OrangeHRM\\MyPics\\Anil.jpeg");

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sec, null);

		sleep(4);

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);

		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);

		sleep(1);

		r.keyPress(KeyEvent.VK_ENTER);

		r.keyRelease(KeyEvent.VK_ENTER);

		sleep(1);

		xp("XSAVE").click();

		sleep(1);

		xp("XBACK").click();

	}

	// ADD Multiple Employees From EXcel

	public void addMultipleEmployeesFromExcel() throws InterruptedException, AWTException, IOException {

		FileInputStream f = new FileInputStream(
				"C:\\Users\\vinod\\eclipse-workspace\\FrameWork_OrangeHRM\\src\\data\\java\\TestData\\EmpData.xlsx");

		XSSFWorkbook w = new XSSFWorkbook(f);

		XSSFSheet s = w.getSheet("ADDEMP");

		for (int i = 1; i <= s.getLastRowNum(); i++) {

			int eid = (int) s.getRow(i).getCell(0).getNumericCellValue();

			String elast = s.getRow(i).getCell(2).getStringCellValue();

			String efirst = s.getRow(i).getCell(1).getStringCellValue();

			String emid = s.getRow(i).getCell(3).getStringCellValue();

			String enick = s.getRow(i).getCell(4).getStringCellValue();

			Actions a = new Actions(driver);

			a.moveToElement(xp("XPIM")).perform();

			sleep(2);

			xp("XADD").click();

			driver.switchTo().frame(xp("XFRAME"));

			xp("XID").clear();

			sleep(1);

			Screenshot("Before Entering Data\\ Before Entering Data " + efirst);

			xp("XID").sendKeys(String.valueOf(eid));

			xp("XLAST").sendKeys(elast);

			xp("XFIRST").sendKeys(efirst);

			xp("XMID").sendKeys(emid);

			xp("XNICK").sendKeys(enick);

			sleep(1);

			a.moveToElement(xp("XPHOTO")).click().perform();

			sleep(1);

			StringSelection sec = new StringSelection(
					"C:\\Users\\vinod\\eclipse-workspace\\FrameWork_OrangeHRM\\MyPics\\" + efirst + ".jpeg");

			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sec, null);

			sleep(4);

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);

			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_V);

			sleep(1);

			r.keyPress(KeyEvent.VK_ENTER);

			r.keyRelease(KeyEvent.VK_ENTER);

			sleep(1);

			Screenshot("Before Saving\\Before Saving " + efirst);

			xp("XSAVE").click();

			sleep(2);

			Screenshot("After Saving\\After Saving " + efirst);

			xp("XBACK").click();

			Screenshot("EMployee List\\EMployee List " + efirst);

			driver.switchTo().defaultContent();

		}

	}

	// Deleting One Employee

	public void deleteEmployee() throws InterruptedException {
		Actions a = new Actions(driver);

		a.moveToElement(xp("XPIM")).perform();

		sleep(2);

		xp("XEmpList").click();

		driver.switchTo().frame(xp("XFRAME"));

		xp("XOneEmp").click();

		xp("XDel").click();
		;
	}

	// Deleting Multiple Employees

	public void deleteMultipleEmployee() throws InterruptedException {
		Actions a = new Actions(driver);

		a.moveToElement(xp("XPIM")).perform();

		sleep(2);

		xp("XEmpList").click();

		driver.switchTo().frame(xp("XFRAME"));

		List<WebElement> allEmp = empData("XList");

		System.out.println(allEmp.size());

		for (int i = 0; i < allEmp.size(); i++) {

			if (i % 2 == 0) {

				driver.findElement(By.xpath("//*[@id=\"standardView\"]/table/tbody/tr[" + (i + 1) + "]/td[1]/input"))
						.click();

			}
		}

		// xp("XDel").click();

	}

	// Deleting All Employees

	public void deleteAllEmployees() throws InterruptedException, IOException {
		Actions a = new Actions(driver);

		a.moveToElement(xp("XPIM")).perform();

		sleep(2);

		xp("XEmpList").click();

		driver.switchTo().frame(xp("XFRAME"));

		List<WebElement> allEmp = empData("XList");

		for (int i = 0; i < allEmp.size(); i++) {

			driver.findElement(By.xpath("//*[@id=\"standardView\"]/table/tbody/tr[" + (i + 1) + "]/td[1]/input"))
					.click();
		}

		Screenshot("Before Deleting//Before Deleting ");

		xp("XDel").click();

		Screenshot("After Deleting//After Deleting ");

	}

	// Searching Employee
	public void searchEmployee() throws InterruptedException, IOException {
		Actions a = new Actions(driver);

		a.moveToElement(xp("XPIM")).perform();

		sleep(2);

		xp("XEmpList").click();

		driver.switchTo().frame(xp("XFRAME"));

		WebElement dropdown = xp("XDrp");

		Select drpdwsel = new Select(dropdown);

		drpdwsel.selectByVisibleText("Emp. ID");

		FileInputStream f = new FileInputStream(
				"C:\\Users\\vinod\\eclipse-workspace\\FrameWork_OrangeHRM\\src\\data\\java\\TestData\\EmpData.xlsx");

		XSSFWorkbook w = new XSSFWorkbook(f);

		XSSFSheet s = w.getSheet("ADDEMP");

		int eid = (int) s.getRow(1).getCell(0).getNumericCellValue();

		xp("XSch").sendKeys(String.valueOf(eid));

		xp("XSchBtn").click();

	}

	// Edit One Employee From EXcel

	public void editPersonalDetails() throws InterruptedException, AWTException, IOException {

		FileInputStream f = new FileInputStream(
				"C:\\Users\\vinod\\eclipse-workspace\\FrameWork_OrangeHRM\\src\\data\\java\\TestData\\EmpData.xlsx");

		XSSFWorkbook w = new XSSFWorkbook(f);

		XSSFSheet s = w.getSheet("EditPersonal");

		String elast = s.getRow(1).getCell(2).getStringCellValue();

		Actions a = new Actions(driver);

		a.moveToElement(xp("XPIM")).perform();

		sleep(2);

		xp("XEmpList").click();

		driver.switchTo().frame(xp("XFRAME"));

		xp("XEmp").click();

		sleep(2);

		xp("XEdit").click();

		xp("XLAST").clear();

		sleep(2);

		xp("XLAST").sendKeys(elast);

		xp("XSave1").click();

		xp("XBACK").click();

	}

	// Edit All Employee From EXcel

	public void editAllEmpPersonalDetails() throws InterruptedException, AWTException, IOException {

		FileInputStream f = new FileInputStream(
				"C:\\Users\\vinod\\eclipse-workspace\\FrameWork_OrangeHRM\\src\\data\\java\\TestData\\EmpData.xlsx");

		XSSFWorkbook w = new XSSFWorkbook(f);

		XSSFSheet s = w.getSheet("EditPersonal");

		for (int i = 1; i <= s.getLastRowNum(); i++) {

			String elast = s.getRow(i).getCell(2).getStringCellValue();

			Actions a = new Actions(driver);

			a.moveToElement(xp("XPIM")).perform();

			sleep(2);

			xp("XEmpList").click();

			driver.switchTo().frame(xp("XFRAME"));

			for (int j = i; j <= i; j++) {
				driver.findElement(By.xpath("//*[@id=\"standardView\"]/table/tbody/tr[" + j + "]/td[3]/a")).click();

			}

			sleep(2);

			xp("XEdit").click();

			xp("XLAST").clear();

			sleep(2);

			xp("XLAST").sendKeys(elast);

			xp("XSave1").click();

			sleep(1);

			xp("XBACK").click();

			driver.switchTo().defaultContent();

		}

	}

	// Filling Blank Info of One Employee From EXcel Using Edit

	public void fillingPersonalDetailsUsingEdit() throws InterruptedException, AWTException, IOException {

		FileInputStream f = new FileInputStream(
				"C:\\Users\\vinod\\eclipse-workspace\\FrameWork_OrangeHRM\\src\\data\\java\\TestData\\EmpData.xlsx");

		XSSFWorkbook w = new XSSFWorkbook(f);

		XSSFSheet s = w.getSheet("EditPersonal");

		String ssnno = s.getRow(1).getCell(5).getStringCellValue();

		String sino = s.getRow(1).getCell(6).getStringCellValue();

		// String DOB =s.getRow(1).getCell(7).getStringCellValue();

		// System.out.println(DOB);

		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date d = s.getRow(1).getCell(7).getDateCellValue();
		String buy_date = df.format(d);
		// System.out.println("date is :- " + buy_date);

		String maritalStatus = s.getRow(1).getCell(8).getStringCellValue();

		String Gender = s.getRow(1).getCell(9).getStringCellValue();

		Actions a = new Actions(driver);

		a.moveToElement(xp("XPIM")).perform();

		sleep(2);

		xp("XEmpList").click();

		driver.switchTo().frame(xp("XFRAME"));

		xp("XEmp").click();

		sleep(2);

		xp("XEdit").click();

		sleep(2);

		xp("XSsn").sendKeys(ssnno);

		xp("XSin").sendKeys(sino);

		xp("XDOB").sendKeys(buy_date);

		WebElement dd = xp("XDrpMatstat");

		List<WebElement> drp = dd.findElements(By.tagName("option"));

		// System.out.println(drp.size());

		for (int i = 0; i < drp.size(); i++) {
			if (drp.get(i).getText().equals(maritalStatus)) {
				drp.get(i).click();
			}
		}

		if (Gender.equals("Male")) {

			sleep(2);

			xp("XMale").click();
		} else {
			xp("XFemale").click();
		}

		xp("XSave1").click();

		xp("XBACK").click();

	}

	// Filling Blank Info of All Employees From EXcel Using Edit

	public void fillingPersonalDetailsofALlUsingEdit() throws InterruptedException, AWTException, IOException {

		FileInputStream f = new FileInputStream(
				"C:\\Users\\vinod\\eclipse-workspace\\FrameWork_OrangeHRM\\src\\data\\java\\TestData\\EmpData.xlsx");

		XSSFWorkbook w = new XSSFWorkbook(f);

		XSSFSheet s = w.getSheet("EditPersonal");

		for (int i = 1; i < s.getLastRowNum(); i++) {

			String ssnno = s.getRow(i).getCell(5).getStringCellValue();

			String sino = s.getRow(i).getCell(6).getStringCellValue();

			// String DOB =s.getRow(1).getCell(7).getStringCellValue();

			// System.out.println(DOB);

			DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
			java.util.Date d = s.getRow(i).getCell(7).getDateCellValue();
			String buy_date = df.format(d);
			// System.out.println("date is :- " + buy_date);

			String maritalStatus = s.getRow(i).getCell(8).getStringCellValue();

			String Gender = s.getRow(i).getCell(9).getStringCellValue();

			Actions a = new Actions(driver);

			a.moveToElement(xp("XPIM")).perform();

			sleep(2);

			xp("XEmpList").click();

			driver.switchTo().frame(xp("XFRAME"));

			for (int j = i; j <= i; j++) {
				driver.findElement(By.xpath("//*[@id=\"standardView\"]/table/tbody/tr[" + j + "]/td[3]/a")).click();

			}

			xp("XEdit").click();

			sleep(2);

			xp("XSsn").sendKeys(ssnno);

			xp("XSin").sendKeys(sino);

			xp("XDOB").sendKeys(buy_date);

			WebElement dd = xp("XDrpMatstat");

			List<WebElement> drp = dd.findElements(By.tagName("option"));

			// System.out.println(drp.size());

			for (int j = 0; j < drp.size(); j++) {
				if (drp.get(j).getText().equals(maritalStatus)) {
					drp.get(j).click();
				}
			}

			if (Gender.equals("Male")) {

				sleep(2);

				xp("XMale").click();
			} else {

				xp("XFemale").click();
			}

			xp("XSave1").click();

			xp("XBACK").click();

			driver.switchTo().defaultContent();

		}

	}

}