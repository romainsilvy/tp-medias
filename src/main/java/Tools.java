import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Tools {
    public static void displayMenu() {
        System.out.println("  __  __   ______   _   _   _    _ \n" +
                " |  \\/  | |  ____| | \\ | | | |  | |\n" +
                " | \\  / | | |__    |  \\| | | |  | |\n" +
                " | |\\/| | |  __|   | . ` | | |  | |\n" +
                " | |  | | | |____  | |\\  | | |__| |\n" +
                " |_|  |_| |______| |_| \\_|  \\____/");
        System.out.println("[1] Recherche ");
        System.out.println("[2] Detail");
        System.out.println("[3] Fermer l'application");
    }

    public static void ManageArgs(String[] args) {
        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("--search")) {
                    search("https://api.themoviedb.org/3/search/multi?api_key=8ac8920a6691cfb0e988250f77cb8e67&query=", args[i+1], "");
                } else if (args[i].equals("--detail")) {
                    detail("https://api.themoviedb.org/3/movie/", args[i+1], "?api_key=061128256033c2efcf30e88914540437");
                }
            }
        }
    }

    public static Request apiRequest(String url1, String strToFind, String url2) {
        System.out.println("searching " + strToFind + ".....\n\n");
        Request request = new Request.Builder()
                .url("\n" + (url1 + strToFind + url2))
                .get()
                .build();
        return request;
    }

    public static SearchResponse parseJsonSearch(Request request) {
        OkHttpClient client = new OkHttpClient();
        try{
            Gson gson = new GsonBuilder().create();
            Response response = client.newCall(request).execute();
            SearchResponse request1 = gson.fromJson(response.body().string(), SearchResponse.class);
            return request1;

        }catch (Exception e){
            System.out.println("Error: "+e);
        }
        return null;
    }

    public static Movie parseJsonDetail(Request request) {
        OkHttpClient client = new OkHttpClient();
        try{
            Gson gson = new GsonBuilder().create();
            Response response = client.newCall(request).execute();
            Movie request1 = gson.fromJson(response.body().string(), Movie.class);
            return request1;

        }catch (Exception e){
            System.out.println("Error: "+e);
        }
        return null;
    }

    public static void search(String url1, String strToFind, String url2) {
        Request request = apiRequest(url1, strToFind, url2);
        SearchResponse request1 = parseJsonSearch(request);
        request1.printAll();
    }

    public static void detail(String url1, String strToFind, String url2) {
        Request request = apiRequest(url1, strToFind, url2);
        Movie request1 = parseJsonDetail(request);
        request1.printAll();
    }
}
