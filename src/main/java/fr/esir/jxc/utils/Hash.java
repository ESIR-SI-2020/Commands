package fr.esir.jxc.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
    public static String hash(String s) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(s.getBytes());
            return new String(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            // TODO: replace with logger
            e.printStackTrace();
            return s; // should not happened
        }
    }
}
