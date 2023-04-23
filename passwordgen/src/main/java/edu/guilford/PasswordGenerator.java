package edu.guilford;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PasswordGenerator {
    
    public String genPassword(User user, int length) {
        // Create a list of characters to be used in the password
        List<Character> chars = new ArrayList<>();

        // Add user attributes to the list of characters
        String name = user.getName();
        String lastName= user.getLastName();
        int birthYear = user.getBirthYear();
        String favoriteColor = user.getFavoriteColor();
        
        //add the characters from the user attributes to the list of characters
        for (char c : name.toCharArray()) {
            chars.add(c);
        }
        for (char c : lastName.toCharArray()) {
            chars.add(c);
        }
        
        chars.add((char) (birthYear % 10));

        for (char c : favoriteColor.toCharArray()) {
            chars.add(c);
        }
        

        //shuffle the list of characters
        Collections.shuffle(chars);

        //loop through the list of characters and add them to a string
        String password = "";
         for (int i = 0; i < length; i++) {
         password += chars.get(i % chars.size());
         }
        return password;
        
        //could also use this string builder method to create the password
        //StringBuilder sb = new StringBuilder();
        //for (int i = 0; i < length; i++) {
          // sb.append(chars.get(i % chars.size()));
        //}
        //return sb.toString();
    }

}