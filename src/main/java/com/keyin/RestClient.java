package com.keyin;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;

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
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/member/search/" + findByString)).build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode()==200) {
                System.out.println(response.body());
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void postMember(String jsonObject) {
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/member/"))
                .POST(BodyPublishers.ofString(jsonObject))
                .build();
        HttpResponse<?> response = null;
        try {
            response = client.send(request, BodyHandlers.discarding());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(response.statusCode());
    }

    public static void putMember(int id, String jsonObject) {
        // Tried to implement a PUT request with HttpClient, but I couldn't figure out how to make it work.
        // The problem might be related to the fact that both the Spring Boot RepositoryRestResource and HttpClient
        // seem to require a PUT request to be sent not as plain text but rather as application/json.
        // I didn't have time to figure out how to convert the user's inputted string to a JSON object.
        System.out.println("Computer says no! Please do the update request through Postman following these steps:");
        System.out.println("     Select PUT from the drop down menu.");
        System.out.println("     Navigate to localhost:8080/member/" + id + ".");
        System.out.println("     Copy and paste the following JSON object: " + jsonObject);

    }

    public static void deleteMember(int id) {
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/member/" + id))
                .DELETE()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode()==200) {
                System.out.println("Deletion successful.");
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void postTournament(String jsonObject) {
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/tournament/"))
                .POST(BodyPublishers.ofString(jsonObject))
                .build();
        HttpResponse<?> response = null;
        try {
            response = client.send(request, BodyHandlers.discarding());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(response.statusCode());
    }

    public static void putTournament(int id, String jsonObject) {
        // Tried to implement a PUT request with HttpClient, but I couldn't figure out how to make it work.
        // The problem might be related to the fact that both the Spring Boot RepositoryRestResource and HttpClient
        // seem to require a PUT request to be sent not as plain text but rather as application/json.
        // I didn't have time to figure out how to convert the user's inputted string to a JSON object.
        System.out.println("Computer says no! Please do the update request through Postman following these steps:");
        System.out.println("     Select PUT from the drop down menu.");
        System.out.println("     Navigate to localhost:8080/tournament/" + id + ".");
        System.out.println("     Copy and paste the following JSON object: " + jsonObject);

    }

    public static void deleteTournament(int id) {
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/tournament/" + id))
                .DELETE()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode()==200) {
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
