import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement as Keys

WebUI.openBrowser('')

WebUI.setViewPortSize(GlobalVariable.viewportWidth, GlobalVariable.viewportHeight)

WebUI.navigateToUrl(GlobalVariable.URL)

WebUI.click(findTestObject('Object Repository/Login/btn_menu-login'))

WebUI.setText(findTestObject('Object Repository/Login/input_username'), usernameLogin)

WebUI.setText(findTestObject('Object Repository/Login/input_password'), passwordLogin)

WebUI.click(findTestObject('Object Repository/Login/btn_login'))

// Cek apakah tombol "Log in" tampil atau tidak
if (WebUI.verifyElementPresent(findTestObject('Object Repository/Login/btn_login'), 5, FailureHandling.OPTIONAL)) {
    
    WebElement linkElement = WebUI.findTestObject('Object Repository/Login/lbl_welcome-username').toWebElement()

    // Dapatkan teks dari elemen <a>
    String linkText = linkElement.getAttribute('innerText')

    WebUI.verifyMatch(linkText, 'Welcome'+usernameLogin, false)
} else {
    WebUI.comment('Tombol "Log in" tidak tampil.')
}

WebUI.closeBrowser()

