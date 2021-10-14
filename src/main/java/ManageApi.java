import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ManageApi {

    public static Request CreateApiRequest(String url1, String strToFind, String url2) {
        System.out.println("requesting " + strToFind + ".....\n\n");
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

    public static Detail parseJsonDetail(Request request) {
        OkHttpClient client = new OkHttpClient();
        try{
            Gson gson = new GsonBuilder().create();
            Response response = client.newCall(request).execute();
            Detail request1 = gson.fromJson(response.body().string(), Detail.class);
            return request1;

        }catch (Exception e){
            System.out.println("Error: "+e);
        }
        return null;
    }

}
