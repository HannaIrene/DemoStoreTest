package demoqastore.testproject.util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownHandlers {
	public static void selectDDLByIndex(WebElement ddl, int index) {
		Select sct = new Select(ddl);
		sct.selectByIndex(index);
	}

	public static void selectDDLByValue(WebElement ddl, String value) {
		Select sct = new Select(ddl);
		sct.selectByValue(value);
	}

	public static void selectDDLByVisibleText(WebElement ddl, String text) {
		Select sct = new Select(ddl);
		sct.selectByVisibleText(text);
	}

	public static void deselectDDLByIndex(WebElement ddl, int index) {
		Select sct = new Select(ddl);
		sct.deselectByIndex(index);
	}

	public static void deselectDDLByValue(WebElement ddl, String value) {
		Select sct = new Select(ddl);
		sct.deselectByValue(value);
	}

	public static void deselectDDLByText(WebElement ddl, String text) {
		Select sct = new Select(ddl);
		sct.deselectByValue(text);
	}

	public static void deselectAllOptions(WebElement ddl) {
		Select sct = new Select(ddl);
		sct.deselectAll();
	}
}
