package org.eltpoisk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;



public class RandomDataTools {
    public static void main(String[] args) throws Exception {
    URL url = new URL("https://api.randomdatatools.ru/");
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
connection.setRequestMethod("GET");

    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
    String inputLine;
    StringBuilder response = new StringBuilder();

while ((inputLine = in.readLine()) != null) {
        response.append(inputLine);
    }
in.close();

   // JSONObject data = new JSONObject(response.toString());

//System.out.println("Имя: " + data.getString("LastName"));
//System.out.println("Номер телефона: " + data.getString("Phone"));
//System.out.println("Электронная почта: " + data.getString("Email"));
}
}
