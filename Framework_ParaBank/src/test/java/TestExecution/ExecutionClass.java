package TestExecution;

import java.io.IOException;

import org.testng.annotations.Test;

import BasePack.BaseClass;

public class ExecutionClass extends BaseClass {
	@Test
	public void Execute() throws IOException, InterruptedException {
		Scripting s = new Scripting();

		//s.register();
		//s.multipleRegister();
		s.Login();
		//s.LoginMultipleUsers();
		//s.addAccount();
		s.addMultipleAccounts();
		//s.addMultipleAccounts1();
		//s.fundsTransfer();
		//s.fundsTransferFromSingleAccounttoMultiple();
	}
}
