package com.github.Syasyu48;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.bukkit.Bukkit;
import java.nio.charset.StandardCharsets;
import org.json.JSONArray;
import org.json.JSONTokener;

public class GoogleCGIJapaneseConverter {

    private static final Map<String, String> CACHE = Collections.synchronizedMap(
            new LinkedHashMap<>(100, 0.75f, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                    return size() > 100;
                }
            });

    public static String convert(String kanaText) {
        if (CACHE.containsKey(kanaText)) {
            return CACHE.get(kanaText);
        }
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
                String converted = result.toString();
                CACHE.put(kanaText, converted);
                return converted;
            }

        } catch (Exception e) {
            Bukkit.getLogger().warning("GoogleCGI conversion failed: " + e.getMessage());
        }

        return kanaText;
    }
}
