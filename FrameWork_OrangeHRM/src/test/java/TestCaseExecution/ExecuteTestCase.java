package TestCaseExecution;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import PreConditions.BaseClass;

public class ExecuteTestCase extends BaseClass {
	@Test
	public void testCases() throws InterruptedException, AWTException, IOException {
		ScriptCoding s = new ScriptCoding();
		s.login();

		// s.addEmployee();

		 //s.addOneEmployeeFromExcel();

		 //s.addMultipleEmployeesFromExcel();

		// s.deleteEmployee();

		 //s.deleteMultipleEmployee();

		 //s.deleteAllEmployees();

		// s.searchEmployee();

		 //s.editPersonalDetails();
		
		//s.editAllEmpPersonalDetails();
		
		//s.fillingPersonalDetailsUsingEdit();
		
		//s.fillingPersonalDetailsofALlUsingEdit();
	}

}
