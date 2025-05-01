package org.example; // ←ここは自分のパッケージ名に直してね！

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import com.google.auth.oauth2.ServiceAccountCredentials;

import java.io.FileInputStream;
import java.io.IOException;

public class GoogleJapaneseConverter {
    private static Translate translate;

    // 認証ファイルから初期化
    public static void initialize(String credentialPath) throws IOException {
        translate = TranslateOptions.newBuilder()
                .setCredentials(ServiceAccountCredentials.fromStream(new FileInputStream(credentialPath)))
                .build()
                .getService();
    }

    // ひらがなを自然な日本語に変換
    public static String convert(String text) {
        if (translate == null) {
            return text;
        }

        Translation translation = translate.translate(
                text,
                Translate.TranslateOption.targetLanguage("ja"),
                Translate.TranslateOption.model("nmt")
        );

        return translation.getTranslatedText();
    }
}
