# MinecraftChatTranslator
日本語のローマ字から漢字に変換するMinecraft1.21.4用のSpigot(Paper)プラグイン

通称:MCT

個人的に作っているだけなので、別のバージョン用に作ったりするとかは多分ないです。
本プラグインは、LGPL-3.0Licenseの、ucchyocean様のLunaChatを参考にして作成されています。
このプラグインは、LunaChatが1.21.4で自分の環境では使えなくなったので、自作してみました。


<ins>**このプラグインの作成には、ChatGPTを使用して作成している部分があります。AIを使った物が嫌な方は本プラグインのご使用をお控えください。**</ins>


### 説明

チャットに入力された**ローマ字**を、Google 日本語入力CGI API を使用し、**漢字**に変換します。

- `mainkurahuto` → `マインクラフト` のように変換します。
- `!` を先頭につけると翻訳しません。
- メッセージ内のURL部分は翻訳対象から除外されます。
- 本家様と同じように、変換後の文字は、黄色で表示されます。
- このプラグインは、本家と違い、チャンネル機能は**ありません**。変換機能だけです。

---

## インストール方法

1. このリポジトリの [Releases](https://github.com/Syasyu48/MinecraftChatTranslator/releases) から `MCT_version.jar` をダウンロード
2. `MCT_version.jar` をサーバーの`plugins/`フォルダに入れる
3. サーバーを起動

---

## 使用例

- 入力：`konnichiha`
- 出力：`konnichiha (こんにちは)`

- 入力：`!konnichiha`
- 出力：`!konnichiha`（変換されない）

- 入力：`https://example.com`
- 出力：`https://example.com ()`

- `/mct toggle` コマンドで自身への翻訳表示を切り替えられます。

---

## 開発・ビルド方法

このプロジェクトは Maven を使用しています。
開発には、InteliJ IDEA を使用しています。

---

## 参考元・URL

本家であり参考元であるLunaChatのGithubリンク(チェックしてください)
https://github.com/ucchyocean/LunaChat

ライセンス

[MIT license](https://github.com/Syasyu48/MinecraftChatTranslator/blob/main/LICENSE)

ご自由にご利用・改変・再配布できますが、著作権表記は残してください。
