package com.keyin;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;

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

    public static void searchMember(String key, String terms) {
        HttpClient client = HttpClient.newHttpClient();
        String keyCapital = key.substring(0, 1).toUpperCase() + key.substring(1);
        String findByString = "findBy" + keyCapital + "?" + key + "=" + terms;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/member/search/" + findByString))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode()==200) {
                System.out.println(response.body());
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void postMember(String firstName, String lastName, String address, String email, String phone,
                                  String memberStartDate, String memberType) throws IOException, InterruptedException {
        Map<Object, Object> member = new HashMap<>();
        member.put("firstName", firstName);
        member.put("lastName", lastName);
        member.put("address", address);
        member.put("email", email);
        member.put("phone", phone);
        member.put("memberStartDate", memberStartDate);
        member.put("memberType", memberType);

        ObjectMapper posted = new ObjectMapper();
        String requestBody = posted.writeValueAsString(member);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/member"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 201) {
                System.out.println("New record created!");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

//    public static void putMember(int id, String jsonObject) {
//        // Tried to implement a PUT request with HttpClient, but I couldn't figure out how to make it work.
//        // The problem might be related to the fact that both the Spring Boot RepositoryRestResource and HttpClient
//        // seem to require a PUT request to be sent not as plain text but rather as application/json.
//        // I didn't have time to figure out how to convert the user's inputted string to a JSON object.
//        System.out.println("Computer says no! Please do the update request through Postman following these steps:");
//        System.out.println("     Select PUT from the drop down menu.");
//        System.out.println("     Navigate to localhost:8080/member/" + id + ".");
//        System.out.println("     Copy and paste the following JSON object: " + jsonObject);
//
//    }
    public static void putMember(int id, String firstName, String lastName, String address, String email, String phone,
                                  String memberStartDate, String memberType) throws IOException, InterruptedException {
        Map<Object, Object> member = new HashMap<>();
        member.put("firstName", firstName);
        member.put("lastName", lastName);
        member.put("address", address);
        member.put("email", email);
        member.put("phone", phone);
        member.put("memberStartDate", memberStartDate);
        member.put("memberType", memberType);

        ObjectMapper posted = new ObjectMapper();
        String requestBody = posted.writeValueAsString(member);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/member/" + id))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 202) {
                System.out.println("Record updated!");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void deleteMember(int id) {
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/member/" + id))
                .DELETE()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode()==204) {
                System.out.println("Deletion successful.");
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void postTournament(String name, String start, String end, String location, int fee, int prize) throws IOException, InterruptedException {
        Map<Object, Object> tournament = new HashMap<>();
        tournament.put("name", name);
        tournament.put("start", start);
        tournament.put("end", end);
        tournament.put("location", location);
        tournament.put("fee", fee);
        tournament.put("prize", prize);

        ObjectMapper posted = new ObjectMapper();
        String requestBody = posted.writeValueAsString(tournament);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/tournament"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 201) {
                System.out.println("New record created!");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void putTournament(int id, String name, String start, String end, String location, int fee, int prize)
            throws IOException, InterruptedException {
        Map<Object, Object> tournament = new HashMap<>();
        tournament.put("name", name);
        tournament.put("start", start);
        tournament.put("end", end);
        tournament.put("location", location);
        tournament.put("fee", fee);
        tournament.put("prize", prize);

        ObjectMapper posted = new ObjectMapper();
        String requestBody = posted.writeValueAsString(tournament);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/tournament/" + id))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 202) {
                System.out.println("Updated record!");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void deleteTournament(int id) {
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/tournament/" + id))
                .DELETE()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode()==204) {
                System.out.println("Deletion successful.");
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void searchTournament(String key, String terms) {
        HttpClient client = HttpClient.newHttpClient();
        String keyCapital = key.substring(0, 1).toUpperCase() + key.substring(1);
        String findByString = "findBy" + keyCapital + "?" + key + "=" + terms;
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/tournament/search/" + findByString)).build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode()==200) {
                System.out.println(response.body());
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

}
