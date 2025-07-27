package QuoteGenie.src;

import org.json.JSONObject;
import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Quote {

    public static void disableSSLCertificateChecking() {
        try {
            javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[]{
                new javax.net.ssl.X509TrustManager() {
                    @Override
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() { return null; }
                    @Override
                    public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) { }
                    @Override
                    public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) { }
                }
            };
            javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     public static void main(String[] args) {
        disableSSLCertificateChecking();  
        try {
            URL url = new URL("https://api.quotable.io/random?tags=technology,famous-quotes");
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder jsonStr = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                jsonStr.append(inputLine);
            }
            in.close();

            JSONObject quoteObj = new JSONObject(jsonStr.toString());

            String quote = quoteObj.getString("content");
            String author = quoteObj.getString("author");

           
            System.out.println("\n--- Quote of the Day ---");
            System.out.println("\"" + quote + "\"");
            System.out.println("   -- " + author);
            System.out.println("------------------------\n");

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}