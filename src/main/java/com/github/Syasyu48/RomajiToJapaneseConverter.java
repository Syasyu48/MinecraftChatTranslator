package com.github.Syasyu48;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomajiToJapaneseConverter {
    public static String convert(String romaji) {
        try {
            String encoded = URLEncoder.encode(romaji, StandardCharsets.UTF_8);
            String urlStr = "https://www.google.co.jp/transliterate?langpair=ja-Hira|ja&text=" + encoded;
            URL url = new URL(urlStr);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");
            conn.setConnectTimeout(3000);
            conn.setReadTimeout(3000);

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
            String response = reader.readLine();
            reader.close();

            // JSON のようなレスポンスをパターンで解析
            Pattern pattern = Pattern.compile("\\[\\\".*?\\\",\\[(\\\".*?\\\")");
            Matcher matcher = pattern.matcher(response);
            if (matcher.find()) {
                return matcher.group(1).replaceAll("\"", "");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return romaji; // 失敗したらそのまま返す
    }
}
