package fr.esir.jxc.utils;

import java.util.regex.Pattern;

public class EmailFormatChecker {

    private final static String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +  //part before @
            "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    private final static Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    public static boolean isEmailValid(String email)
    {
        return EMAIL_PATTERN.matcher(email).matches();
    }
}
