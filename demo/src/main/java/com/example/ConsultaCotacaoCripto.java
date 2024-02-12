package com.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConsultaCotacaoCripto {
    public static void main(String[] args) throws IOException, InterruptedException {
        try (Scanner leitura = new Scanner(System.in)) {
            System.out.print("Digite uma cripto moeda para busca: ");
            var busca = leitura.nextLine();

            String endereco = "https://api.coingecko.com/api/v3/search?query=" + busca;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        }
    }
    
}