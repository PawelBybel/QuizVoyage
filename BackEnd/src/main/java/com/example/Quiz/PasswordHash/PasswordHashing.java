//package com.example.Quiz.PasswordHash;
//
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//import java.security.SecureRandom;
//import java.util.Base64;
//
//public class PasswordHashing {
//    public static String hashPassword(String password) throws NoSuchAlgorithmException {
//        // Generate salt
//        SecureRandom random = new SecureRandom();
//        byte[] salt = new byte[16];
//        random.nextBytes(salt);
//
//        // Hash password with salt
//        MessageDigest md = MessageDigest.getInstance("SHA-256");
//        md.update(salt);
//        byte[] hashedPassword = md.digest(password.getBytes());
//
//        // Convert to Base64
//        Base64.Encoder encoder = Base64.getEncoder();
//        String saltString = encoder.encodeToString(salt);
//        String hashedPasswordString = encoder.encodeToString(hashedPassword);
//
//        // Combine salt and hashed password and return
//        return saltString + "$" + hashedPasswordString;
//    }
//
//    public static boolean verifyPassword(String providedPassword, String storedPassword) throws NoSuchAlgorithmException {
//        // Split stored password into salt and hashed password
//        String[] parts = storedPassword.split("\\$");
//        String saltString = parts[0];
//        String hashedPasswordString = parts[1];
//
//        // Convert salt and provided password to bytes
//        Base64.Decoder decoder = Base64.getDecoder();
//        byte[] salt = decoder.decode(saltString);
//        byte[] providedPasswordBytes = providedPassword.getBytes();
//
//        // Hash provided password with stored salt
//        MessageDigest md = MessageDigest.getInstance("SHA-256");
//        md.update(salt);
//        byte[] hashedProvidedPassword = md.digest(providedPasswordBytes);
//
//        // Compare hashed passwords
//        String hashedProvidedPasswordString = encoder.encodeToString(hashedProvidedPassword);
//        return hashedProvidedPasswordString.equals(hashedPasswordString);
//    }
//
//    public static void main(String[] args) throws NoSuchAlgorithmException {
//        // Example usage
//        String password = "password123";
//        String hashedPassword = hashPassword(password);
//        System.out.println("Hashed Password: " + hashedPassword);
//
//        boolean isPasswordCorrect = verifyPassword(password, hashedPassword);
//        System.out.println("Is Password Correct: " + isPasswordCorrect);
//    }
//}
