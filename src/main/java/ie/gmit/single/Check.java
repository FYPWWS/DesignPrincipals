package ie.gmit.single;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Check {

    public boolean sendIsPresent(String value) {
        return isPresent(value);
    }

    public boolean sendIsValidAlphaNumeric(String value) {
        return isValidAlphaNumeric(value);
    }

    public boolean sendIsValidEmail(String value) {
        return isValidEmail(value);
    }


    //Simply checks if value is null or empty.
    private boolean isPresent(String value) {
        return value != null && value.trim().length() > 0;
    }

    //check string for special characters
    private boolean isValidAlphaNumeric(String value) {
        Pattern pattern = Pattern.compile("[^A-Za-z0-9]");
        Matcher matcher = pattern.matcher(value);
        return !matcher.find();
    }

    //check string for valid email address - this is not for prod.
    //Just for demo. This fails for lots of valid emails.
    private boolean isValidEmail(String value) {
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(value);
        return matcher.find();
    }
}
