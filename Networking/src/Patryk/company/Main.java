package Patryk.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.flickr.com/services/feeds/photos_public.gne?tags=dogs");
//            URI uri = url.toURI();

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("User-Agent", "Chrome");
            httpURLConnection.setReadTimeout(30000);

            int responseCode = httpURLConnection.getResponseCode(); // create connection
            System.out.println(responseCode);

            if (responseCode != 200) {
                System.out.println("Error");
                System.out.println(httpURLConnection.getInputStream());
                return;
            }

            BufferedReader inputStream = new BufferedReader(
                    new InputStreamReader(httpURLConnection.getInputStream())
            );

            String line;
            while ((line = inputStream.readLine()) != null){
                System.out.println(line);
            }
            inputStream.close();

//            URLConnection urlConnection = url.openConnection();
//            urlConnection.setDoInput(true); // every setting have to be before calling connect method
//            urlConnection.connect(); // this same like in line 19
//
//            BufferedReader inputStream = new BufferedReader(
//                    new InputStreamReader(urlConnection.getInputStream())
//            );
//
//            Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
//            for(Map.Entry<String, List<String>> entry : headerFields.entrySet()){
//                String key = entry.getKey();
//                List<String> value = entry.getValue();
//                System.out.println("---------- Key = " + key);
//                for (String string: value){
//                    System.out.println("value = " + value);
//                }
//            }

//            String line = "";
//            while (line != null){
//                line = inputStream.readLine();
//                System.out.println(line);
//            }
//            inputStream.close();


//            URI uri = new URI("http://username:password@myserver.com:500/catalogue/phones?os=android#samsung");

//            URI baseUri = new URI("http://username:password@myserver.com:500");
//            URI uri1 = new URI("/catalogue/phones?os=android#samsung");
//            URI uri2= new URI("/catalogue/tvs?manufacturer=samsung");
//            URI uri3 = new URI("/stores/locations!zip=12345");
//
//            URI resolveUri1 = baseUri.resolve(uri1);
//            URI resolveUri2 = baseUri.resolve(uri2);
//            URI resolveUri3 = baseUri.resolve(uri3);
////            URI uri = new URI("hello");
//
//            URL url1 = resolveUri1.toURL();
//            System.out.println("URL = " + url1);
//            URL url2 = resolveUri2.toURL();
//            System.out.println("URL = " + url2);
//            URL url3 = resolveUri3.toURL();
//            System.out.println("URL = " + url3);
//
//            URI relativizedURI = baseUri.relativize(resolveUri2);
//            System.out.println("Relative URI = " + relativizedURI);

//            System.out.println("Schema = " + uri.getScheme());
//            System.out.println("Schema-specific part = " + uri.getSchemeSpecificPart());
//            System.out.println("Authority = " + uri.getAuthority());
//            System.out.println("User info = " + uri.getUserInfo());
//            System.out.println("Host = " + uri.getHost());
//            System.out.println("Port = " + uri.getPath());
//            System.out.println("Path = " + uri. getPath());
//            System.out.println("Query = " + uri.getQuery());
//            System.out.println("Fragment = " + uri.getFragment());

//        }catch (URISyntaxException e){
//            System.out.println("URI bad syntax: " + e.getMessage());
        }catch (MalformedURLException e){
            System.out.println("URL Malformed: " + e.getMessage());
        }catch (IOException e) {
            System.out.println("IOException = " + e.getMessage());
        }
    }
}
