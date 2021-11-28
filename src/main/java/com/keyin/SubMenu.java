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
                    System.out.println("Please enter a JSON object with the following keys:");
                    System.out.println("name, start, end, location, fee, prize");
                    Scanner postInput = new Scanner(System.in);
                    String jsonObject = postInput.nextLine();
                    RestClient.postTournament(jsonObject);
                    break;
                }
                else if (actionTable.equals("utournament")) {
                    System.out.println("Please enter the ID of the tournament you'd like to update:");
                    Scanner putIdInput = new Scanner(System.in);
                    int putId = putIdInput.nextInt();
                    System.out.println("Please enter a an updated JSON object for tournament ID " + putId + " with the following keys:");
                    System.out.println("name, start, end, location, fee, prize");
                    Scanner putInput = new Scanner(System.in);
                    String putJsonObject = putInput.nextLine();
                    RestClient.putTournament(putId, putJsonObject);
                    break;
                }
                else if (actionTable.equals("dtournament")) {
                    System.out.println("Please enter the ID of the tournament record you'd like to delete:");
                    Scanner deleteIdInput = new Scanner(System.in);
                    int deleteId = deleteIdInput.nextInt();
                    RestClient.deleteTournament(deleteId);
                    break;
                }
                else if (actionTable.equals("stournament")) {
                    System.out.println("Choose one of the following member search parameters:");
                    System.out.println("      [1] name");
                    System.out.println("      [2] location");
                    Scanner searchInput = new Scanner(System.in);
                    int searchKeyInt = searchInput.nextInt();
                    String searchKey;
                    if(searchKeyInt == 1) {
                        searchKey = "name";
                    }
                    else if(searchKeyInt == 2) {
                        searchKey = "location";
                    } else {
                        searchKey = "name";
                    }

                    System.out.println("You chose to search by " + searchKey + ". Please enter your search terms: ");
                    Scanner termsInput = new Scanner(System.in);
                    String searchTerms = termsInput.nextLine();
                    RestClient.searchTournament(searchKey, searchTerms);
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
                    RestClient.postMember(jsonObject);
                    break;
                }
                else if (actionTable.equals("umember")) {
                    System.out.println("Please enter the ID of the member record you'd like to update:");
                    Scanner putIdInput = new Scanner(System.in);
                    int putId = putIdInput.nextInt();
                    System.out.println("Please enter a an updated JSON object for member ID " + putId + " with the following keys:");
                    System.out.println("firstName, lastName, address, email, phone, memberStartDate, memberType");
                    Scanner putInput = new Scanner(System.in);
                    String putJsonObject = putInput.nextLine();
                    RestClient.putMember(putId, putJsonObject);
                    break;
                }
                else if (actionTable.equals("dmember")) {
                    System.out.println("Please enter the ID of the member record you'd like to delete:");
                    Scanner deleteIdInput = new Scanner(System.in);
                    int deleteId = deleteIdInput.nextInt();
                    RestClient.deleteMember(deleteId);
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

