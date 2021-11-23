package com.keyin;

import com.fasterxml.jackson.databind.util.JSONPObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

public class RestClient {
    public static void getAll(String table) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/" + table)).build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode()==200) {
                System.out.println(response.body());
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void getOneMember() {
        Scanner input =  new Scanner(System.in);
        System.out.println("Please enter the ID number of the member you are searching for: ");
        int memberID = input.nextInt();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/people/" + memberID)).build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode()==200) {
                System.out.println(response.body());
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void postMember() {
        var uri = new URI("http://localhost.:8080/people");
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the last name of the new member: ");
        String lastName = input.nextLine();
        System.out.println("Please enter the first name of the new member: ");
        String firstName = input.nextLine();
        String postMessage = """
                {"firstName": firstName,
                "lastName": lastName}
                """;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(uri).POST(BodyPublishers.ofString(postMessage))
                .header("Content-type", "application/json").build();
    }
}
