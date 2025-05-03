package com.github.Syasyu48;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import org.json.JSONArray;
import org.json.JSONTokener;

public class GoogleCGIJapaneseConverter {

    public static String convert(String kanaText) {
        try {
            String encoded = URLEncoder.encode(kanaText, StandardCharsets.UTF_8);
            String apiUrl = "https://www.google.com/transliterate?langpair=ja-Hira|ja&text=" + encoded;

            HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
            connection.setRequestMethod("GET");

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {

                JSONArray response = new JSONArray(new JSONTokener(reader));
                StringBuilder result = new StringBuilder();

                for (int i = 0; i < response.length(); i++) {
                    JSONArray segment = response.getJSONArray(i);
                    JSONArray candidates = segment.getJSONArray(1);
                    if (candidates.length() > 0) {
                        result.append(candidates.getString(0)); // 最初の候補だけ連結
                    }
                }

                return result.toString();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return kanaText;
    }
}
