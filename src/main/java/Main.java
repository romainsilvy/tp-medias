import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;
import okhttp3.Response;
import okhttp3.Request;
import okhttp3.OkHttpClient;


import com.google.gson.*;

public class Main {

    public static Request apiRequest(String strToFind) {
        System.out.println("searching " + strToFind + ".....\n\n");
        Request request = new Request.Builder()
                .url("\n" + ("https://api.themoviedb.org/3/search/multi?api_key=8ac8920a6691cfb0e988250f77cb8e67&query=" + strToFind))
                .get()
                .build();
        return request;
    }

    public static SearchResponse parseJson(Request request) {
        SearchResponse request1 = null;
        OkHttpClient client = new OkHttpClient();
        try{
            Gson gson = new GsonBuilder().create();
            Response response = client.newCall(request).execute();
            request1 = gson.fromJson(response.body().string(), SearchResponse.class);
            return request1;

        }catch (Exception e){
            System.out.println("Error: "+e);
        }
        return request1;
    }

    public static void search(Scanner scanner2) {
        System.out.println("entrez le nom du film que vous voulez rechercher");
        String strToFind = scanner2.nextLine();
        Request request = apiRequest(strToFind);
        SearchResponse request1 = parseJson(request);
        request1.printAll();
    }

    
    public static void main(String[] args) {

        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("--search")) {
                    System.out.println("searching " + args[i+1]);
                } else if (args[i].equals("--detail")) {
                    System.out.println("detailing " + args[i+1]);
                }
            }
        }

        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        boolean menu = true;

        while (menu) {
            System.out.println("  __  __   ______   _   _   _    _ \n" +
                    " |  \\/  | |  ____| | \\ | | | |  | |\n" +
                    " | \\  / | | |__    |  \\| | | |  | |\n" +
                    " | |\\/| | |  __|   | . ` | | |  | |\n" +
                    " | |  | | | |____  | |\\  | | |__| |\n" +
                    " |_|  |_| |______| |_| \\_|  \\____/");
            System.out.println("[1] Recherche ");
            System.out.println("[2] Detail");
            System.out.println("[3] Fermer l'application");

            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    search(scanner2);
                    break;
                case 2:
                    System.out.println("entrez l'id du film sur lequel vous voulez des informations");
                    int intToSearch = scanner2.nextInt();
                    System.out.println("searching " + intToSearch + ".....");

                    OkHttpClient client2 = new OkHttpClient();
                    Request request2 = new Request.Builder()
                            .url("\n" + ("https://api.themoviedb.org/3/movie/" + intToSearch + "?api_key=061128256033c2efcf30e88914540437"))
                            .get()
                            .build();

                    try{
                        Gson gson = new GsonBuilder().create();
                        Response response = client2.newCall(request2).execute();
                        Movie request11 = gson.fromJson(response.body().string(), Movie.class);
                        System.out.println("L'ID du media est " + request11.id);
                        System.out.println("Le nom du media est " + request11.title);
                        System.out.println("La description du media est " + request11.overview);
                        System.out.println("La moyenne des votes du media est " + request11.vote_average);
                        System.out.println("Le nombre de votes du media est " + request11.vote_count);



                    }catch (Exception e){
                        System.out.println("Error: "+e);
                        return;
                    }



                    break;
                case 3:
                    menu = false;
                    break;
                default:
                    System.out.println("merci de choisir un nombre entre 1 et 3");
                    break;
            }
        }
    }
}


