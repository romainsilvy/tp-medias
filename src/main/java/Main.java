import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;
import okhttp3.Response;
import okhttp3.Request;
import okhttp3.OkHttpClient;


import com.google.gson.*;

public class Main {

    public static void main(String[] args) {



        System.out.println("                                          \n" +
                "     )))           +++           (((      \n" +
                "    (o o)         (o o)         (o o)     \n" +
                "ooO--(_)--Ooo-ooO--(_)--Ooo-ooO--(_)--Ooo-\n");

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
            System.out.println("                                          \n" +
                    "     )))           +++           (((      \n" +
                    "    (o o)         (o o)         (o o)     \n" +
                    "ooO--(_)--Ooo-ooO--(_)--Ooo-ooO--(_)--Ooo-\n");
            System.out.println("[1] Recherche ");
            System.out.println("[2] Detail");
            System.out.println("[3] Fermer l'application");

            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    System.out.println("entrez le nom du film que vous voulez rechercher");
                    String strToFind = scanner2.nextLine();
                    System.out.println("searching " + strToFind + ".....\n\n");

                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url("\n" + ("https://api.themoviedb.org/3/search/multi?api_key=8ac8920a6691cfb0e988250f77cb8e67&query=" + strToFind))
                            .get()
                            .build();

                    try{
                        Gson gson = new GsonBuilder().create();
                        Response response = client.newCall(request).execute();
                        SearchResponse request1 = gson.fromJson(response.body().string(), SearchResponse.class);

                        int rangeOnTab = 15;
                        if (request1.results.length < 15) {
                            rangeOnTab = request1.results.length;
                        }

                        for (int i = 0; i < rangeOnTab; i++) {
                            switch (request1.results[i].media_type) {
                                case "tv":
                                    System.out.println("\u001B[32mL'ID du media est " + request1.results[i].id);
                                    System.out.println("Le nom du media est " + request1.results[i].name);
                                    break;
                                case "movie":
                                    System.out.println("\u001B[34mL'ID du media est " + request1.results[i].id);
                                    System.out.println("Le nom du media est " + request1.results[i].title);
                                    break;
                            }
                            System.out.println("le type est " + request1.results[i].media_type + "\n\n\u001B[0m");
                        }
                    }catch (Exception e){
                        System.out.println("Error: "+e);
                        return;
                    }




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
                        Movie request1 = gson.fromJson(response.body().string(), Movie.class);
                        System.out.println("L'ID du media est " + request1.id);
                        System.out.println("Le nom du media est " + request1.title);
                        System.out.println("La description du media est " + request1.overview);
                        System.out.println("La moyenne des votes du media est " + request1.vote_average);
                        System.out.println("Le nombre de votes du media est " + request1.vote_count);



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


