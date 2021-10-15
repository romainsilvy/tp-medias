import okhttp3.Request;

public class Actions {
    public static void search(String url1, String strToFind, String url2) {
        try {
            Request request = ManageApi.CreateApiRequest(url1, strToFind, url2);
            ManageApi.parseJson(request, "search");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void detail(String url1, String strToFind, String url2) {
        try {
            Request request = ManageApi.CreateApiRequest(url1, strToFind, url2);
            ManageApi.parseJson(request, "detail");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
