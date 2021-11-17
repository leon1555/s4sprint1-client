package com.keyin;

import java.util.Scanner;

public class SubMenu {

    public static void displayOptions(String option) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Select from the following options:");
        System.out.println("     [g]et a list of " + option + "s");
        System.out.println("     [a]dd a new " + option);
        System.out.println("     [u]pdate an existing " + option);
        System.out.println("     [d]elete an existing " + option);
        String choice = scan.nextLine();

    }
}
