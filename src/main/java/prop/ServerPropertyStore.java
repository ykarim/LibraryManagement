package prop;

import log.Logger;
import org.apache.logging.log4j.Level;

public class ServerPropertyStore {

    private static final String propertyFileLocation = System.getProperty("user.home") + "/LibManage/prop.xml";
    private static PropertiesDAO propertiesDAO = new PropertiesDAO(propertyFileLocation);

    public static void loadPropertiesFromFile(PropertyUpdater... propertyUpdater) {
        if (propertiesDAO.loadPropertiesFile()) {
            Logger.writeToLog(Level.ALL, "Found properties file. Will use properties given");
            for (PropertyUpdater updaters : propertyUpdater) {
                updaters.update(propertiesDAO);
            }
        } else {
            Logger.writeToLog(Level.ALL, "Did not find properties file. Will use program-default properties");
        }
    }

    public static void savePropertiesToFile(PropertyStorage... propertyStorage) {
        for (PropertyStorage storage : propertyStorage) {
            storage.storeProperties(propertiesDAO);
        }
        propertiesDAO.savePropertiesToXml();
    }
}
