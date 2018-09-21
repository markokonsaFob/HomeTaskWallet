package helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by FOB Solutions
 */
public class TestDataManager {

    private static Map<String, String> testData = new HashMap<>();

    /**
     * Returns test data from map
     *
     * @param key
     * @return
     */
    public static String getTestData(String key) {
        if (testData.isEmpty()) {
            initTestData();
        }
        return testData.get(key);
    }

    /**
     * Adds test data to map
     *
     * @param key
     * @param value
     */
    public static void addTestData(String key, String value) {
        testData.put(key, value);
    }

    /**
     * Initialises test data from properties and command line
     */
    private static void initTestData() {
        Properties prop = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream("src/test/resources/data.properties");
            // load a properties file
            prop.load(input);

            addTestData(Constants.FACEBOOK_USERNAME, System.getProperty(Constants.FACEBOOK_USERNAME) == null ? prop.getProperty(Constants.FACEBOOK_USERNAME) : System.getProperty(Constants.FACEBOOK_USERNAME));
            addTestData(Constants.FACEBOOK_PASSWORD, System.getProperty(Constants.FACEBOOK_PASSWORD) == null ? prop.getProperty(Constants.FACEBOOK_PASSWORD) : System.getProperty(Constants.FACEBOOK_PASSWORD));

            addTestData(Constants.WALLETHUB_PAGE, System.getProperty(Constants.WALLETHUB_PAGE) == null ? prop.getProperty(Constants.WALLETHUB_PAGE) : System.getProperty(Constants.WALLETHUB_PAGE));
            addTestData(Constants.WALLETHUB_USERNAME, System.getProperty(Constants.WALLETHUB_USERNAME) == null ? prop.getProperty(Constants.WALLETHUB_USERNAME) : System.getProperty(Constants.WALLETHUB_USERNAME));
            addTestData(Constants.WALLETHUB_PASSWORD, System.getProperty(Constants.WALLETHUB_PASSWORD) == null ? prop.getProperty(Constants.WALLETHUB_PASSWORD) : System.getProperty(Constants.WALLETHUB_PASSWORD));
            addTestData(Constants.WALLETHUB_REVIEW_COMP, System.getProperty(Constants.WALLETHUB_REVIEW_COMP) == null ? prop.getProperty(Constants.WALLETHUB_REVIEW_COMP) : System.getProperty(Constants.WALLETHUB_REVIEW_COMP));


        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
