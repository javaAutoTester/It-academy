package by.htp.pomexample.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import by.htp.pomexample.pages.ItAcademyHomePage;

public class TestItAcademyHomePage {
	WebDriver driver;
	ItAcademyHomePage homePage;
	String expectedTitle = "ᐅ Курсы программирования • IT курсы в Минске - Образовательный центр парка высоких технологий";
	String expectedURLGrodno = "https://www.grodno.it-academy.by/?set_city=147&_ga=2.226273308.746503185.1531316711-39925634.1524465435";

	@BeforeSuite
	public void initDriverAndHomePage() {
		System.out.println("@BeforeSuite");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@BeforeTest
	public void initHomePage() {
		System.out.println("@BeforeTest");
		homePage = new ItAcademyHomePage(driver);
		homePage.getHomePage();
	}

	@Test
	public void titleIsCorrect() {
		System.out.println("1-Test");
		String actualTitle = homePage.getHomePageTitle().trim();
		System.out.println("actualTitle: " + actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test
	public void cityChooserPopUpIsPresent() {
		System.out.println("2-Test");
		Assert.assertTrue(homePage.cityChooserPopUpPresence());
	}
/*
	@Test
	public void linkToGrodnoInPopUpIsCorrect() {
		System.out.println("3-Test");
		homePage.chooseGrodnoInPopUp();
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(actualURL, expectedURLGrodno);
		driver.navigate().back();
	}

	@Test
	public void learningSectionPopUpIsAbsent() {
		System.out.println("4-Test");
		Assert.assertFalse(homePage.learningSectionPopUpPresence());
	}

	@Test
	public void popUpInLearninSectionApperWhenMouseOver() {
		System.out.println("5-Test");
		homePage.mouseIsOverLearningSection();
		Assert.assertTrue(homePage.learningSectionPopUpPresence());
	}
*/
	@AfterTest
	public void driverClose() {
		System.out.println("@AfterTest");
		driver.close();
	}
}
