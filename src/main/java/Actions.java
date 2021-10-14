import okhttp3.Request;

public class Actions {
    public static void search(String url1, String strToFind, String url2) {
        Request request = ManageApi.CreateApiRequest(url1, strToFind, url2);
        SearchResponse request1 = ManageApi.parseJsonSearch(request);
        request1.printAll();
    }

    public static void detail(String url1, String strToFind, String url2) {
        Request request = ManageApi.CreateApiRequest(url1, strToFind, url2);
        Detail request1 = ManageApi.parseJsonDetail(request);
        request1.printAll();
    }
}
