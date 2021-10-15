import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ManageApi {

    public static Request CreateApiRequest(String url1, String strToFind, String url2) {
        try {
            System.out.println("requesting " + strToFind + ".....\n\n");
            Request request = new Request.Builder()
                    .url("\n" + (url1 + strToFind + url2))
                    .get()
                    .build();
            return request;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public static void parseJson(Request request, String typeOfSearch) {
        OkHttpClient client = new OkHttpClient();
        try{
            Gson gson = new GsonBuilder().create();
            Response response = client.newCall(request).execute();
            switch (typeOfSearch) {
                case "search":
                    SearchResponse requestSearch = gson.fromJson(response.body().string(), SearchResponse.class);
                    requestSearch.printAll();
                case "detail":
                    Detail requestDetail = gson.fromJson(response.body().string(), Detail.class);
                    requestDetail.printAll();
            }
        }catch (Exception e){
            System.out.println("Error: "+e);
        }
    }
}
