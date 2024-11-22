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
        String teamid = leagueHierarchy();
        teamStats(teamid);
    }

    public String leagueHierarchy() throws IOException, ParseException{
        URL url = new URL("https://api.sportradar.com/nba/production/v8/en/league/hierarchy.json?api_key=ao7A9LW1o6c7uV7hvb675Km1lWQUXIofi9clqylx");
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

        JSONArray conferences = (JSONArray) jsonObject.get("conferences");
        JSONObject conf = (JSONObject) conferences.get(0);
        System.out.println("conf: " + conf);

        JSONArray divisions = (JSONArray) conf.get("divisions");
        System.out.println("divisions: " + divisions);
        JSONObject div = (JSONObject) divisions.get(0);

        System.out.println("div: " + div);

        JSONArray teamsArray = (JSONArray) div.get("teams");
        JSONObject team = (JSONObject) teamsArray.get(0);

        System.out.println("team" + team);
        System.out.println("name: " + team.get("name"));

        if(team.get("name").equals("Wizards")){

            String id = (String) team.get("id");

            System.out.println(id);
            return id;
        }
        return "";

    }

    public void teamStats(String teamid) throws IOException, ParseException{
        URL url = new URL("https://api.sportradar.com/nba/production/v8/en/seasons/2024/REG/teams/" + teamid + "/statistics.json?api_key=ao7A9LW1o6c7uV7hvb675Km1lWQUXIofi9clqylx");
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


        JSONObject rec = (JSONObject) jsonObject.get (0);
        JSONArray record = (JSONArray) rec.get ("own_record");

        System.out.println(record);
            }
        }





