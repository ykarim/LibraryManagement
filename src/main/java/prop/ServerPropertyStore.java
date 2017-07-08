package prop;

import log.Logger;
import org.apache.logging.log4j.Level;
import util.Constants;
import view.util.GuiConstants;

public class ServerPropertyStore {

    private static final String propertyFileLocation = System.getProperty("user.home") + "/LibManage/prop.xml";
    private static PropertiesDAO propertiesDAO = new PropertiesDAO(propertyFileLocation);

    public static void loadPropertiesFromFile() {
        if (propertiesDAO.loadPropertiesFile()) {
            try {
                Constants.CUSTOM_PORT = Integer.parseInt(propertiesDAO.getProperty(PropertyKey.PORT.getKey()));
                Constants.CUSTOM_PASSWORD_MIN_LENGTH = Integer.parseInt(propertiesDAO.
                        getProperty(PropertyKey.MIN_PASS_LENGTH.getKey()));
                Constants.CUSTOM_PASSWORD_MAX_LENGTH = Integer.parseInt(propertiesDAO.
                        getProperty(PropertyKey.MAX_PASS_LENGTH.getKey()));
            } catch (NumberFormatException nfe) {
                Logger.writeException("Certain properties in properties file are not integers", nfe);
            }

            GuiConstants.companyName = propertiesDAO.getProperty(PropertyKey.COMPANY_NAME.getKey());
            Logger.writeToLog(Level.ALL, "Found properties file. Will use properties given");
        } else {
            Logger.writeToLog(Level.ALL, "Did not find properties file. Will use program-default properties");
        }
    }

    public static void savePropertiesToFile() {
        propertiesDAO.storeProperty(PropertyKey.PORT.getKey(), String.valueOf(Constants.CUSTOM_PORT));
        propertiesDAO.storeProperty(PropertyKey.MIN_PASS_LENGTH.getKey(),
                String.valueOf(Constants.CUSTOM_PASSWORD_MIN_LENGTH));
        propertiesDAO.storeProperty(PropertyKey.MAX_PASS_LENGTH.getKey(),
                String.valueOf(Constants.CUSTOM_PASSWORD_MAX_LENGTH));
        propertiesDAO.storeProperty(PropertyKey.COMPANY_NAME.getKey(), GuiConstants.companyName);
        propertiesDAO.savePropertiesToXml();
    }
}
