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
        URL url = new URL("https://api.sportradar.com/nba/trial/v8/en/players/8ec91366-faea-4196-bbfd-b8fab7434795/profile.json?api_key=JZ0tJ7HOgsC9Q9tjKI3MPavkfj8tN4mg7AZho64k");
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        httpConn.setRequestMethod("GET");

        httpConn.setRequestProperty("accept", "application/json");

        InputStream responseStream = httpConn.getResponseCode() / 100 == 2
                ? httpConn.getInputStream()
                : httpConn.getErrorStream();
        Scanner s = new Scanner(responseStream).useDelimiter("\\A");
        String response = s.hasNext() ? s.next() : "";
        System.out.println("Response" + response);

        /*
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(response);
        System.out.println("JSON ARRAY: " + jsonArray);

//        JSONObject character = (JSONObject) jsonArray.get(0);// 0 index is the first character
        JSONArray pointspergame = (JSONArray) character.get("points per game");
        System.out.println("points per game of " + character.get("full_name") + ":");
//        for (Object ally : allies) {
//            System.out.println(ally);
//        }

        System.out.println("\nNames of all characters:");
        for (Object obj : jsonArray) {
            JSONObject charObj = (JSONObject) obj;
            System.out.println(charObj.get("full_name"));
        }
        */
    }
}


