package com.keyin;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the Golf Country Club Database. Which table would you like to access? " +
                "[m]embers or [t]ournaments: ");
        while(true) {
            String tableSelection = scan.nextLine();
            if(tableSelection.equals("m")) {
                // access members table
                System.out.println("Access members table");
                break;
            } else if(tableSelection.equals("t")) {
                // access tournaments table
                System.out.println("Access tournaments table");
                break;
            } else {
                System.out.println(tableSelection);
                System.out.println(tableSelection + " is an invalid selection. Please input m for members or t for tournaments: ");
            continue;
            }
        }

    }
}
