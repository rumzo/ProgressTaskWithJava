import org.testng.annotations.Test;
import pages.TestFormPage;

public class RegistrationTest extends BaseTest {

    @Test
    public void submitFormPageWithValidData() {
        TestFormPage.goToFormPage();
        TestFormPage.fillFormWithValidData("test", "test", "test@dd.dd" ,"123456", "firmata", "test1234");
        TestFormPage.verifyConfirmationMessage("Thank you for filling out our form.", "There is no error message");
    }

    @Test
    public void submitFormWithInvalidEmail(){
        TestFormPage.goToFormPage();
        TestFormPage.fillFormWithInvalidEmail("test", "test", "testtt" ,"123456", "firmata", "test1234");
        TestFormPage.verifyEmailValidationMessage("Enter a Valid Business Email Address example@yourdomain.com", "There is no error message for the email field");
    }

    @Test
    public void submitFormPageWithCountryUSA(){
        TestFormPage.goToFormPage();
        TestFormPage.fillFormWithCountryUSA("test", "test", "test@dd.dd" ,"123456", "firmata", "test1234");
        TestFormPage.verifyConfirmationMessage("Thank you for filling out our form.", "There is no error message");
    }

    @Test
    public void verifyAllProductInterestOptionsAreShown(){
        TestFormPage.goToFormPage();
        TestFormPage.checkAllProductInterestOptions();
    }

    @Test
    public void submitEmptyForm() throws InterruptedException {
        TestFormPage.goToFormPage();
        TestFormPage.verifyValidationMessages("First Name is Required", "Last Name is Required", "Enter a Valid Business Email Address example@yourdomain.com", "Business Phone is Required", "Organization is Required", "This Field is Required.", "Country is Required", "This Field is Required.", "Validation Message is missing");
    }

}
