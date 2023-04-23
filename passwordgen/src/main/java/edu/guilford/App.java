package edu.guilford;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){

        Scanner scanner = new Scanner(System.in);
        
        //get user input
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        //get user input
        System.out.println("Enter your last name: ");
        String lastName = scanner.nextLine();
        //get user input
        System.out.println("Enter your birth year: ");
        int birthYear = scanner.nextInt();
        //get user input
        System.out.println("Enter your favorite color: ");
        String favoriteColor = scanner.nextLine();
        scanner.close();
        
        

        //create a new user object
       User user = new User(name, lastName, birthYear, favoriteColor);
                    
        //create a new password generato 
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        
        System.out.println("\nGenerating password...");
        //generate a password
        String password = passwordGenerator.genPassword(user, 20);
        //print the password
        System.out.println("\nYour password is: " + password);

        //set key to be used for encryption and decryption
        AES.setKey("myKey");
        //print the key
        //System.out.println("Key: " + AES.getKey());
        
        //encrypt the password from the password generator
        String encrypted = AES.encrypt(password, "myKey");
        //decrypt the encrypted password
         String decrypted = AES.decrypt(encrypted, "myKey");
        
         //print the encrypted and decrypted passwords
         System.out.println("\nEncrypted: " + encrypted);
         System.out.println("Decrypted: " + decrypted);

    }
}
