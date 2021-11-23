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
            System.out.println("     [s]earch for " + table + "s");
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
                    // search tournaments
                    break;
                }
                else if (actionTable.equals("lmember")) {
                    RestClient.getAll("member");
                    break;
                }
                else if (actionTable.equals("amember")) {
                    System.out.println("Please enter a JSON object with the following keys:");
                    System.out.println("firstName, lastName, address, email, phone, memberStartDate, memberType");
                    Scanner postInput = new Scanner(System.in);
                    String jsonObject = postInput.nextLine();
                    RestClient.post(jsonObject);
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
                    System.out.println("Choose one of the following member search parameters:");
                    System.out.println("      [1] Last name");
                    System.out.println("      [2] First name");
                    Scanner searchInput = new Scanner(System.in);
                    int searchKeyInt = searchInput.nextInt();
                    String searchKey;
                    if(searchKeyInt == 1) {
                        searchKey = "lastName";
                    }
                    else if(searchKeyInt == 2) {
                        searchKey = "firstName";
                    } else {
                        searchKey = "lastName";
                    }

                    System.out.println("You chose to search by " + searchKey + ". Please enter your search terms: ");
                    Scanner termsInput = new Scanner(System.in);
                    String searchTerms = termsInput.nextLine();
                    RestClient.searchMember(searchKey, searchTerms);
                    break;
                }
            }
        }
    }
}

