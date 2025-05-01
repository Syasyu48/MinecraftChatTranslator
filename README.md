# MinecraftChatTranslator
日本語のローマ字から漢字に変換するMinecraft1.21.4用のSpigot(Paper)プラグイン

通称:MCT
個人的に作っているだけなので、別のバージョン用に作ったりするとかは多分ないです。
本プラグインは、LGPL-3.0Licenseの、ucchyocean様のLunaChatを参考にして作成されています。
このプラグインは、LunaChatが1.21.4で自分の環境では使えなくなったので、自作してみました。

### 説明

チャットに入力された**ローマ字**を、Google 日本語入力CGI API を使用し、**漢字**に変換して表示します。

---

## ✅ 特徴

- `mainkurahuto` → `マインクラフト` のように変換！
- チャットの原文もそのまま表示（変換結果はカッコで補足）
- `!` を先頭につけると翻訳せずそのまま表示
- URLも翻訳されずにそのまま表示されます

---

## 🛠 インストール方法

1. このリポジトリの [Releases](https://github.com/Syasyu48/MinecraftChatTranslator/releases) から `MCT.jar` をダウンロード
2. `MCT.jar` をサーバーの`plugins/`フォルダに入れる
3. サーバーを起動

---

## 🧪 使用例

- 入力：`konnichiha`
- 出力：`konnichiha (こんにちは)`

- 入力：`!konnichiha`
- 出力：`!konnichiha`（変換されない）

- 入力：`https://example.com`
- 出力：`https://example.com ()`

---

## 💻 開発・ビルド方法

このプロジェクトは Maven を使用しています。

---

## 参考元・URL

本家であり参考元であるLunaChatのGithubリンク(チェックしてください)
https://github.com/ucchyocean/LunaChat

ライセンス
[MIT license](https://github.com/Syasyu48/MinecraftChatTranslator/blob/main/LICENSE)
