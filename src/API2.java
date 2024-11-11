import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class API2 {

    public static void main(String[] args) throws IOException, ParseException {
        API2 api = new API2();
    }

    public API2() throws IOException, ParseException {
        URL url = new URL("https://api.sportradar.com/nba/trial/v8/en/players/8ec91366-faea-4196-bbfd-b8fab7434795/profile.json?api_key=ao7A9LW1o6c7uV7hvb675Km1lWQUXIofi9clqylx");
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        httpConn.setRequestMethod("GET");

        httpConn.setRequestProperty("accept", "application/json");

        InputStream responseStream = httpConn.getResponseCode() / 100 == 2
                ? httpConn.getInputStream()
                : httpConn.getErrorStream();
        Scanner s = new Scanner(responseStream).useDelimiter("\\A");
        String response = s.hasNext() ? s.next() : "";
        System.out.println("Response" + response);


        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(response);
        System.out.println("JSON: " + jsonObject);

        JSONObject teamInfo = (JSONObject) jsonObject.get("team");
        System.out.println(teamInfo.get("name"));


        }

    }



