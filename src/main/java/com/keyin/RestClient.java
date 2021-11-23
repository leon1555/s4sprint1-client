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

    public static void post (String jsonObject) {
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
}
