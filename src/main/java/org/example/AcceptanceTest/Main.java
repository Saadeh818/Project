package org.example.AcceptanceTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static
    void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );
        MainScreen.displayPage ( "home-page" );
        MainScreen.setUserInput ( String.valueOf ( new Scanner ( System.in ).next ( ) ) );
        MainScreen.nextScreen ( MainScreen.userInput );
        MainScreen.displayPage ( MainScreen.currentPage );
    }
}
