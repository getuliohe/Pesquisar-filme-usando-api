import Models.Title;
import Models.TitleOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchMoviesOnAPI {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);

        String busca = "";

        ArrayList<Title> titles = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        while (!busca.equalsIgnoreCase("sair")){
            System.out.println("Digite um filme para busca: ");
            busca = scanner.nextLine();

            if(busca.equalsIgnoreCase("sair")) {
                break;
            }

            String adress = "https://www.omdbapi.com/?apikey=b2a5f91d&t=" + busca.replace(" ","+");

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(adress))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            //System.out.println(response.body());

            String json = response.body();
            //System.out.println(json);



            TitleOmdb titleOmdb = gson.fromJson(json, TitleOmdb.class);
            //System.out.println(titleOmdb);

            Title myTitle = new Title(titleOmdb);
            System.out.println("Titulo já convertido");
            System.out.println(myTitle);
            titles.add(myTitle);

        }
        FileWriter writer = new FileWriter("filme.json");
        writer.write(gson.toJson(titles));
        writer.close();

        System.out.println("o programa finalizou corretamente");

    }
}