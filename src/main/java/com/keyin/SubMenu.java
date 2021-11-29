package com.keyin;

import java.io.IOException;
import java.util.Scanner;

public class SubMenu {

    public static void actionOptions(String table) throws IOException, InterruptedException {

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
                    String name, start, end, location;
                    int fee, prize;
                    System.out.println("New Tournament Record:");
                    System.out.println("Please enter the tournament name:");
                    Scanner postInput = new Scanner(System.in);
                    name = postInput.nextLine();
                    System.out.println("Please enter the start date:");
                    start = postInput.nextLine();
                    System.out.println("Please enter the end date:");
                    end = postInput.nextLine();
                    System.out.println("Please enter the location:");
                    location = postInput.nextLine();
                    System.out.println("Please enter the entry fee in dollars:");
                    fee = postInput.nextInt();
                    System.out.println("Please enter the prize value in dollars:");
                    prize = postInput.nextInt();
                    RestClient.postTournament(name, start, end, location, fee, prize);
                    break;
                }
                else if (actionTable.equals("utournament")) {
                    int id, fee, prize;
                    String name, start, end, location;
                    System.out.println("Please enter the ID of the tournament you'd like to update:");
                    Scanner putInputId = new Scanner(System.in);
                    id = putInputId.nextInt();
                    System.out.println("Please enter the tournament name:");
                    Scanner putInput = new Scanner(System.in);
                    name = putInput.nextLine();
                    System.out.println("Please enter the start date:");
                    start = putInput.nextLine();
                    System.out.println("Please enter the end date:");
                    end = putInput.nextLine();
                    System.out.println("Please enter the location:");
                    location = putInput.nextLine();
                    System.out.println("Please enter the entry fee in dollars:");
                    fee = putInput.nextInt();
                    System.out.println("Please enter the prize value in dollars:");
                    prize = putInput.nextInt();
                    RestClient.putTournament(id, name, start, end, location, fee, prize);
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
                    String firstName, lastName, address, email, phone, memberStartDate;
                    int membershipType;
                    System.out.println("New Member Record:");
                    System.out.println("Please enter the first name:");
                    Scanner postInput = new Scanner(System.in);
                    firstName = postInput.nextLine();
                    System.out.println("Please enter the last name:");
                    lastName = postInput.nextLine();
                    System.out.println("Please enter the address:");
                    address = postInput.nextLine();
                    System.out.println("Please enter the email:");
                    email = postInput.nextLine();
                    System.out.println("Please enter the phone number:");
                    phone = postInput.nextLine();
                    System.out.println("Please enter the membership start date (YYYY-MM-DD):");
                    memberStartDate = postInput.nextLine();
                    System.out.println("Please enter the membership type:");
                    System.out.println("     [1] normal");
                    System.out.println("     [2] family");
                    System.out.println("     [3] trial");
                    System.out.println("     [4] special");
                    System.out.println("     [5] other");
                    membershipType = postInput.nextInt();
                    RestClient.postMember(firstName, lastName, address, email, phone, memberStartDate, membershipType);
                    break;
                }
                else if (actionTable.equals("umember")) {
                    int id, memberType;
                    String firstName, lastName, address, email, phone, memberStartDate;
                    System.out.println("Please enter the ID of the member record you'd like to update:");
                    Scanner putIdInput = new Scanner(System.in);
                    id = putIdInput.nextInt();
                    System.out.println("Please enter the first name:");
                    Scanner putInput = new Scanner(System.in);
                    firstName = putInput.nextLine();
                    System.out.println("Please enter the last name:");
                    lastName = putInput.nextLine();
                    System.out.println("Please enter the address:");
                    address = putInput.nextLine();
                    System.out.println("Please enter the email:");
                    email = putInput.nextLine();
                    System.out.println("Please enter the phone number:");
                    phone = putInput.nextLine();
                    System.out.println("Please enter the membership start date (YYYY-MM-DD):");
                    memberStartDate = putInput.nextLine();
                    System.out.println("Please enter the membership type:");
                    System.out.println("     [1] normal");
                    System.out.println("     [2] family");
                    System.out.println("     [3] trial");
                    System.out.println("     [4] special");
                    System.out.println("     [5] other");
                    memberType = putInput.nextInt();
                    RestClient.putMember(id, firstName, lastName, address, email, phone, memberStartDate, memberType);
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
                    System.out.println("      [3] Phone number");
                    System.out.println("      [4] Membership Type");
                    Scanner searchInput = new Scanner(System.in);
                    int searchKeyInt = searchInput.nextInt();
                    String searchKey;
                    if(searchKeyInt == 1) {
                        searchKey = "lastName";
                    }
                    else if(searchKeyInt == 2) {
                        searchKey = "firstName";
                    } else if(searchKeyInt == 3) {
                        searchKey = "phone";
                    } else if(searchKeyInt == 4) {
                        searchKey = "membershipType";
                    }
                      else {
                        searchKey = "lastName";
                    }

                    System.out.println("You chose to search by " + searchKey + ". Please enter your search terms: ");
                      if(searchKey == "membershipType") {
                          System.out.println("Reminder: categories for membership type are: " +
                                  "normal, family, trial, special, other.");
                      }
                    Scanner termsInput = new Scanner(System.in);
                    String searchTerms = termsInput.nextLine();
                    RestClient.searchMember(searchKey, searchTerms);
                    break;
                }
            }
        }
    }
}

