package ie.gmit.single;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    public boolean checkUserDetails(User user) {
        return isValidUser(user);
    }

    Check test = new Check();

    //Validates the user object
    private boolean isValidUser(User user) {
        if(!test.sendIsPresent(user.getName())) {
            return false;
        }
        user.setName(user.getName().trim());

        if(!test.sendIsValidAlphaNumeric(user.getName())) {
            return false;
        }
        if(user.getEmail() == null || user.getEmail().trim().length() == 0) {
            return false;
        }
        user.setEmail(user.getEmail().trim());
        if(!test.sendIsValidEmail(user.getEmail())) {
            return false;
        }
        return true;
    }
}
