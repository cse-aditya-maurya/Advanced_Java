package userLoginValidation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginValidatorTest {
	private LoginValidator validator;
	@BeforeEach
	void setup() {
		validator=new LoginValidator();
	}
	
	  @Test
	    @DisplayName("Valid username should pass")
	    void testValidUsername() {
	        assertEquals(true,validator.isValidUserName("User123"));
	    }
	  @Test
	  @DisplayName("Valid username with Specail Character ")
	  void testValidUserNameWithSpecailCharacter() {
		  assertEquals(false, validator.isValidUserName("user@123"));
	  }
	  @Test
	  @DisplayName("Username can not be null")
	  void testNullUserName() {
		  assertEquals(false,validator.isValidUserName(null));
	  }
	  
	  @Test
	  @DisplayName("Username can not be null")
	  void testEmptyUserName() {
		  assertEquals(false,validator.isValidUserName("  "));
	  }
	  
	  @Test
	  @DisplayName("Valid password should be passed")
	  void testValidPassword() {
		  assertEquals(true,validator.isValidPassword("Adi@2552"));
	  }

	  @Test
	  @DisplayName("Valid password should be passed")
	  void testNullPassword() {
		  assertEquals(false,validator.isValidPassword(null));
	  }
	  
	  @Test
	  @DisplayName("Valid password should be passed")
	  void testEmptyPassword() {
		  assertEquals(false,validator.isValidPassword("   "));
	  }
	  
	  @Test
	  void testuserLoginSuccessfully() {
		  assertEquals(true,validator.canLogin("user123","Adi@2552"));
	  }
	  
	  @Test
	  void testuserLoginFail() {
		  assertEquals(false,validator.canLogin("user123","Adi@2"));
	  }
	  
	  


	  
}
