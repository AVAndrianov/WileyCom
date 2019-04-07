package avandrianov.com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class HttpURLConnect {
    private final String USER_AGENT = "Mozilla/5.0";
    private Logger logger = LoggerFactory.getLogger(HttpURLConnect.class);


    // HTTP GET request
    void sendGetImage() throws Exception {

        String url = "https://httpbin.org/image/png";

        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        // optional default is GET

        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inp = in.readLine();
        if (inp.equals("�PNG"))
            logger.info("Returns a PNG image.\n");
        else
            logger.error("png image was not returned.\n");
    }
// HTTP GET request
    void sendGetDelay(int presetTime) throws Exception {

        String url = "https://httpbin.org/delay/"+presetTime;

        URL obj = new URL(url);
        long start=System.currentTimeMillis();
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();


        // optional default is GET

        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        long timeHasPassed=(System.currentTimeMillis()-start)/1000;
        if (timeHasPassed <= 10)
            logger.info("The answer came in less than 10 seconds.");
        else
            logger.error("The response time is over 10 seconds.");
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine+"\n");
        }
        in.close();

        //print result
        System.out.println(response.toString());
    }
}