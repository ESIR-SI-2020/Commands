package fr.esir.jxc.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Hash {
    public static String hash(String s) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(s.getBytes());
            return new String(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            log.error("Cryptographic algorithm is not available in the current environment.");
            e.printStackTrace();
            return s; // should not happen
        }
    }
}
