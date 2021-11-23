package com.keyin;

import java.util.Scanner;

public class SubMenu {

    public static void actionOptions(String table) {

        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Select from the following options:");
            System.out.println("     [l]ist all " + table + "s");
            System.out.println("     [a]dd a new " + table);
            System.out.println("     [u]pdate an existing " + table);
            System.out.println("     [d]elete an existing " + table);
            System.out.println("     [s]earch for a " + table);
            String action = scan.nextLine();
            if (!action.equals("l") &&
                !action.equals("a") &&
                !action.equals("u") &&
                !action.equals("d") &&
                !action.equals("s")) {
                System.out.println("Invalid action!");
            } else {
                String actionTable = action + table;
                if (actionTable.equals("ltournament")) {
                    RestClient.getAll("tournament");
                    break;
                }
                else if (actionTable.equals("atournament")) {
                    // CREATE tournament
                    break;
                }
                else if (actionTable.equals("utournament")) {
                    // UPDATE tournament
                    break;
                }
                else if (actionTable.equals("dtournament")) {
                    // DELETE tournament
                    break;
                }
                else if (actionTable.equals("stournament")) {
                    // GET ONE tournament
                    break;
                }
                else if (actionTable.equals("lmember")) {
                    RestClient.getAll("people");
                    break;
                }
                else if (actionTable.equals("amember")) {
                    // CREATE member
                    break;
                }
                else if (actionTable.equals("umember")) {
                    // UPDATE member
                    break;
                }
                else if (actionTable.equals("dmember")) {
                    // DELETE member
                    break;
                }
                else if (actionTable.equals("smember")) {
                    // GET ONE member
                    RestClient.getOneMember();
                    break;
                }
            }
        }
    }
}

