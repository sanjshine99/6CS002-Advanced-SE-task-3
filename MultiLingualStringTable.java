/**
 * MultiLingualStringTable class manages multi-lingual messages based on the selected language setting.
 * The class utilizes an enum LanguageSetting to represent language options and a Map to store messages for each language.
 * Messages can be retrieved using the getMessage method with an index corresponding to the desired message.
 * Note: To add support for additional languages, update the LanguageSetting enum and include corresponding message arrays in the messages Map.
 */

package base;


public class MultiLingualStringTable {
    private static LanguageSetting currentSelectedLanguage = LanguageSetting.English;
    private static String[] englishMessage = {"Enter your name:", "Welcome", "Have a good time playing Abominodo"};
    private static String[] klingonMessages = {"'el lIj pong:", "nuqneH", "QaQ poH Abominodo"};

    public static String getMessage(int index) {
        if (currentSelectedLanguage == LanguageSetting.English) {
            return englishMessage[index];
        } else {
            return klingonMessages[index];
        }

    }

    public static void setCurrentLanguage(LanguageSetting language) {
        currentSelectedLanguage = language;
    }

    enum LanguageSetting {English, Klingon}
}
