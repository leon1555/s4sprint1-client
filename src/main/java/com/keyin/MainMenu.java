package com.keyin;

import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the Golf Country Club Database. Which table would you like to access? " +
                "[m]embers or [t]ournaments (or [q]uit): ");
        while(true) {
            String tableSelection = scan.nextLine();
            if(tableSelection.equals("m")) {
                SubMenu.actionOptions("member");
                break;
            } else if(tableSelection.equals("t")) {
                SubMenu.actionOptions("tournament");
                break;
            } else if(tableSelection.equals("q")) {
                System.out.println("Keep on swinging!");
                break;
            } else {
                System.out.println(tableSelection);
                System.out.println(tableSelection + " is an invalid selection. Please input m for members or t for tournaments: ");
            continue;
            }
        }

    }
}
