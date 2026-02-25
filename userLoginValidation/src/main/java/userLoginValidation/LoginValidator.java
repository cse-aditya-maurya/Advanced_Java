package userLoginValidation;

public class LoginValidator {
      public boolean isValidUserName(String username) {
    	  if(username==null || username.isEmpty()) {
    		  return false;
    	  }
    	  if(username.length()<5 || username.length()>15) {
    		  return false;
    	  }
    	  if(!username.matches("[a-zA-Z0-9]+")) {
    		  return false;
    	  }
    	  return true;
      }
      
      public boolean isValidPassword(String password) {
    	  if(password==null ||password.isEmpty()) {
    		  return false;
    	  }
    	  if(password.length()<8) {
    		  return false;
    	  }
    	  boolean hasLetter=password.matches(".*[a-zA-Z].*");
    	  boolean hasDigit=password.matches(".*[0-9].*");
    	  boolean hasSpecialCharacter=password.matches(".*[@$!%*?&].*");
    	  return hasLetter && hasDigit && hasSpecialCharacter;
    	   
      }
      
      public boolean canLogin(String username,String password) {
    	  return isValidUserName(username) && isValidPassword(password);
      }
      
      
}


