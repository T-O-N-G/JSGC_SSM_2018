package util;

public class UpdateCache {
    public static void  updateCache(String url){
        new Thread(() -> {
            String url2= "http://192.168.55.121:8002/"+url;
            String param = "projectID=" + 0;
            HttpRequestMethod.sendGet(url2, param);
        }).start();
    }
}
