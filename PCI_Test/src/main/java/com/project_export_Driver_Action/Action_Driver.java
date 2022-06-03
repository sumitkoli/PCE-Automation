package com.project_export_Driver_Action;

import org.openqa.selenium.JavascriptExecutor;
import com.project_expoert_BaseClass.Base_Class;

public class Action_Driver extends Base_Class{

	public void javascript_Executor(String value) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript(value);
	}
	
}
