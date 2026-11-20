import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Project3 {
    public static void main(String[] args) throws Exception {
        String url = "https://itunes.apple.com/search?term=21+Savage&media=music&entity=song&limit=20&country=US";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            System.out.println(response.body());
        } else {
            System.out.println("Request failed with status code: " + response.statusCode());
        }
    }
}