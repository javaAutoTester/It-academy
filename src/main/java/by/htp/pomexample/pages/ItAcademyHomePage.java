/**
 * 
 */
package by.htp.pomexample.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * @author papa
 *
 */
public class ItAcademyHomePage {
private WebDriver driver;
By cityChooserPopUp = By.xpath("/html/body/div[2]/div[1]");
By buttonGrodnoPopUp = By.xpath("/html/body/div[2]/div[1]/div/div/div[2]/a[2]");
By buttonMinskPopUp = By.xpath("/html/body/div[2]/div[1]/div/div/div[2]/a[1]");
By sectionLearning = By.xpath("/html/body/div[1]/asside/div/div/div[2]/div[2]/ul/li[1]/a/span");
By sectionLearningPopUp = By.xpath("/html/body/div[1]/main/section[1]/section[1]/div");
// String urlHomePage = "https://www.it-academy.by/";
String urlHomePage = "https://www.grodno.it-academy.by/?set_city=147";
public ItAcademyHomePage(WebDriver driver) {
	super();
	this.driver = driver;
}

public void getHomePage() {
	driver.get(urlHomePage);
}

public boolean cityChooserPopUpPresence(){
	return driver.findElements(cityChooserPopUp).size()>0;
}

public String getHomePageTitle() {
	return driver.getTitle();
}

public void chooseMinskInPopUp() {
	driver.findElement(buttonMinskPopUp).click();
}

public void chooseGrodnoInPopUp() {
	driver.findElement(buttonGrodnoPopUp).click();
}

public void mouseIsOverLearningSection() {
	WebElement learning = driver.findElement(sectionLearning);
	new Actions(driver).moveToElement(learning).build();
}

public boolean learningSectionPopUpPresence() {
//	driver.findElements(sectionLearningPopUp).size()>0;
	return driver.findElement(sectionLearningPopUp).isDisplayed();
}

}
