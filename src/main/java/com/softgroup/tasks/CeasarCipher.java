package com.softgroup.tasks;

import java.io.*;

public class CeasarCipher {

    private static final String UPPER_CASE_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER_CASE_ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final int ALPHABET_LENGTH = 26;

    public static String encrypt (String input, int key){
        StringBuilder encryptedString = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            Character character = input.charAt(i);
            encryptedString.append(encryptCharacter(character, key));
        }
        return encryptedString.toString();
    }

    public static void testEncrypt () {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("testEncrypt.txt"));
            String line;
            while ((line = reader.readLine()) != null){
                System.out.println("original:  "+line);
                System.out.println("encrypted: "+encrypt(line, 23));
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String encryptTwoKeys (String input, int key1, int key2){
        StringBuilder encryptedString = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            Character character = input.charAt(i);
            if (i % 2 == 0) encryptedString.append(encryptCharacter(character, key1));
            else encryptedString.append(encryptCharacter(character, key2));
        }
        return encryptedString.toString();
    }

    public static Character encryptCharacter (Character character, int key){
        if (UPPER_CASE_ALPHABET.contains(character.toString())) {
            return UPPER_CASE_ALPHABET.charAt((UPPER_CASE_ALPHABET.indexOf(character) + key) % ALPHABET_LENGTH);
        }else if (LOWER_CASE_ALPHABET.contains(character.toString())) {
            return LOWER_CASE_ALPHABET.charAt((LOWER_CASE_ALPHABET.indexOf(character) + key) % ALPHABET_LENGTH);
        }
        return character;
    }

    public static void main(String[] args) {
        testEncrypt();
    }
}
