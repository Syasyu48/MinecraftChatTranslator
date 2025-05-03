package com.github.Syasyu48; // ←ここもあなたのパッケージ名に！

import java.util.LinkedHashMap;
import java.util.Map;

public class RomajiToHiraganaTranslator {
    private static final Map<String, String> ROMAJI_TO_HIRAGANA = new LinkedHashMap<>();

    static {

        ROMAJI_TO_HIRAGANA.put("zya", "じゃ");
        ROMAJI_TO_HIRAGANA.put("zyu", "じゅ");
        ROMAJI_TO_HIRAGANA.put("zyo", "じょ");

        ROMAJI_TO_HIRAGANA.put("jya", "じゃ");
        ROMAJI_TO_HIRAGANA.put("jyu", "じゅ");
        ROMAJI_TO_HIRAGANA.put("jyo", "じょ");

        // 母音
        ROMAJI_TO_HIRAGANA.put("a", "あ");
        ROMAJI_TO_HIRAGANA.put("i", "い");
        ROMAJI_TO_HIRAGANA.put("u", "う");
        ROMAJI_TO_HIRAGANA.put("e", "え");
        ROMAJI_TO_HIRAGANA.put("o", "お");

        // か行
        ROMAJI_TO_HIRAGANA.put("ka", "か");
        ROMAJI_TO_HIRAGANA.put("ki", "き");
        ROMAJI_TO_HIRAGANA.put("ku", "く");
        ROMAJI_TO_HIRAGANA.put("ke", "け");
        ROMAJI_TO_HIRAGANA.put("ko", "こ");

        // さ行
        ROMAJI_TO_HIRAGANA.put("sa", "さ");
        ROMAJI_TO_HIRAGANA.put("shi", "し");
        ROMAJI_TO_HIRAGANA.put("si", "し");
        ROMAJI_TO_HIRAGANA.put("su", "す");
        ROMAJI_TO_HIRAGANA.put("se", "せ");
        ROMAJI_TO_HIRAGANA.put("so", "そ");

        // た行
        ROMAJI_TO_HIRAGANA.put("ta", "た");
        ROMAJI_TO_HIRAGANA.put("chi", "ち");
        ROMAJI_TO_HIRAGANA.put("ti", "ち");
        ROMAJI_TO_HIRAGANA.put("tsu", "つ");
        ROMAJI_TO_HIRAGANA.put("tu", "つ");
        ROMAJI_TO_HIRAGANA.put("te", "て");
        ROMAJI_TO_HIRAGANA.put("to", "と");

        // な行
        ROMAJI_TO_HIRAGANA.put("na", "な");
        ROMAJI_TO_HIRAGANA.put("ni", "に");
        ROMAJI_TO_HIRAGANA.put("nu", "ぬ");
        ROMAJI_TO_HIRAGANA.put("ne", "ね");
        ROMAJI_TO_HIRAGANA.put("no", "の");

        // は行
        ROMAJI_TO_HIRAGANA.put("ha", "は");
        ROMAJI_TO_HIRAGANA.put("hi", "ひ");
        ROMAJI_TO_HIRAGANA.put("fu", "ふ");
        ROMAJI_TO_HIRAGANA.put("hu", "ふ");
        ROMAJI_TO_HIRAGANA.put("he", "へ");
        ROMAJI_TO_HIRAGANA.put("ho", "ほ");

        // ま行
        ROMAJI_TO_HIRAGANA.put("ma", "ま");
        ROMAJI_TO_HIRAGANA.put("mi", "み");
        ROMAJI_TO_HIRAGANA.put("mu", "む");
        ROMAJI_TO_HIRAGANA.put("me", "め");
        ROMAJI_TO_HIRAGANA.put("mo", "も");

        // や行
        ROMAJI_TO_HIRAGANA.put("ya", "や");
        ROMAJI_TO_HIRAGANA.put("yu", "ゆ");
        ROMAJI_TO_HIRAGANA.put("yo", "よ");

        // ら行
        ROMAJI_TO_HIRAGANA.put("ra", "ら");
        ROMAJI_TO_HIRAGANA.put("ri", "り");
        ROMAJI_TO_HIRAGANA.put("ru", "る");
        ROMAJI_TO_HIRAGANA.put("re", "れ");
        ROMAJI_TO_HIRAGANA.put("ro", "ろ");

        // わ行
        ROMAJI_TO_HIRAGANA.put("wa", "わ");
        ROMAJI_TO_HIRAGANA.put("wo", "を");
        ROMAJI_TO_HIRAGANA.put("nn", "ん");

        // 拗音 (きゃ、きゅ、きょ、しゃ、しゅ、しょなど)
        ROMAJI_TO_HIRAGANA.put("kya", "きゃ");
        ROMAJI_TO_HIRAGANA.put("kyu", "きゅ");
        ROMAJI_TO_HIRAGANA.put("kyo", "きょ");
        ROMAJI_TO_HIRAGANA.put("sha", "しゃ");
        ROMAJI_TO_HIRAGANA.put("sya", "しゃ");
        ROMAJI_TO_HIRAGANA.put("shu", "しゅ");
        ROMAJI_TO_HIRAGANA.put("syu", "しゅ");
        ROMAJI_TO_HIRAGANA.put("sho", "しょ");
        ROMAJI_TO_HIRAGANA.put("syo", "しょ");
        ROMAJI_TO_HIRAGANA.put("cha", "ちゃ");
        ROMAJI_TO_HIRAGANA.put("chu", "ちゅ");
        ROMAJI_TO_HIRAGANA.put("cho", "ちょ");
        ROMAJI_TO_HIRAGANA.put("nya", "にゃ");
        ROMAJI_TO_HIRAGANA.put("nyu", "にゅ");
        ROMAJI_TO_HIRAGANA.put("nyo", "にょ");
        ROMAJI_TO_HIRAGANA.put("hya", "ひゃ");
        ROMAJI_TO_HIRAGANA.put("hyu", "ひゅ");
        ROMAJI_TO_HIRAGANA.put("hyo", "ひょ");
        ROMAJI_TO_HIRAGANA.put("mya", "みゃ");
        ROMAJI_TO_HIRAGANA.put("myu", "みゅ");
        ROMAJI_TO_HIRAGANA.put("myo", "みょ");
        ROMAJI_TO_HIRAGANA.put("rya", "りゃ");
        ROMAJI_TO_HIRAGANA.put("ryu", "りゅ");
        ROMAJI_TO_HIRAGANA.put("ryo", "りょ");

        // 濁音 (がぎぐげご など)
        ROMAJI_TO_HIRAGANA.put("ga", "が");
        ROMAJI_TO_HIRAGANA.put("gi", "ぎ");
        ROMAJI_TO_HIRAGANA.put("gu", "ぐ");
        ROMAJI_TO_HIRAGANA.put("ge", "げ");
        ROMAJI_TO_HIRAGANA.put("go", "ご");
        ROMAJI_TO_HIRAGANA.put("za", "ざ");
        ROMAJI_TO_HIRAGANA.put("ji", "じ");
        ROMAJI_TO_HIRAGANA.put("zi", "じ");
        ROMAJI_TO_HIRAGANA.put("zu", "ず");
        ROMAJI_TO_HIRAGANA.put("ze", "ぜ");
        ROMAJI_TO_HIRAGANA.put("zo", "ぞ");
        ROMAJI_TO_HIRAGANA.put("da", "だ");
        ROMAJI_TO_HIRAGANA.put("di", "ぢ");
        ROMAJI_TO_HIRAGANA.put("du", "づ");
        ROMAJI_TO_HIRAGANA.put("de", "で");
        ROMAJI_TO_HIRAGANA.put("do", "ど");
        ROMAJI_TO_HIRAGANA.put("ba", "ば");
        ROMAJI_TO_HIRAGANA.put("bi", "び");
        ROMAJI_TO_HIRAGANA.put("bu", "ぶ");
        ROMAJI_TO_HIRAGANA.put("be", "べ");
        ROMAJI_TO_HIRAGANA.put("bo", "ぼ");

        // 半濁音 (ぱぴぷぺぽ)
        ROMAJI_TO_HIRAGANA.put("pa", "ぱ");
        ROMAJI_TO_HIRAGANA.put("pi", "ぴ");
        ROMAJI_TO_HIRAGANA.put("pu", "ぷ");
        ROMAJI_TO_HIRAGANA.put("pe", "ぺ");
        ROMAJI_TO_HIRAGANA.put("po", "ぽ");

        // 小さい文字
        ROMAJI_TO_HIRAGANA.put("la", "ぁ");
        ROMAJI_TO_HIRAGANA.put("li", "ぃ");
        ROMAJI_TO_HIRAGANA.put("lu", "ぅ");
        ROMAJI_TO_HIRAGANA.put("le", "ぇ");
        ROMAJI_TO_HIRAGANA.put("lo", "ぉ");
        ROMAJI_TO_HIRAGANA.put("lya", "ゃ");
        ROMAJI_TO_HIRAGANA.put("lyu", "ゅ");
        ROMAJI_TO_HIRAGANA.put("lyo", "ょ");
        ROMAJI_TO_HIRAGANA.put("ltu", "っ");
        ROMAJI_TO_HIRAGANA.put("xtu", "っ");
    }


    public static String translate(String input) {
        String lower = input.toLowerCase();

        // ⭐ "ん" の特別処理（先に置き換える）
        lower = lower.replaceAll("nn", "ん");
        lower = lower.replaceAll("n(?![aiueoyn])", "ん");

        StringBuilder output = new StringBuilder();
        int i = 0;
        while (i < lower.length()) {
            // 長音記号対応: ハイフンを「ー」に変換
            if (lower.charAt(i) == '-') {
                output.append("ー");
                i++;
                continue;
            }

            // 小さい「っ」対応: 同じ子音が続く場合
            if (i + 1 < lower.length() && lower.charAt(i) == lower.charAt(i + 1)
                    && isConsonant(lower.charAt(i))) {
                output.append("っ");
                i++;
                continue;
            }

            // 普通のローマ字変換
            boolean matched = false;
            for (int len = 3; len > 0; len--) {
                if (i + len <= lower.length()) {
                    String part = lower.substring(i, i + len);
                    if (ROMAJI_TO_HIRAGANA.containsKey(part)) {
                        output.append(ROMAJI_TO_HIRAGANA.get(part));
                        i += len;
                        matched = true;
                        break;
                    }
                }
            }
            if (!matched) {
                output.append(lower.charAt(i));
                i++;
            }
        }
        return output.toString();
    }

    private static boolean isConsonant(char c) {
        return "bcdfghjklmnpqrstvwxyz".indexOf(c) >= 0;
    }
}