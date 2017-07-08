package prop;

import log.Logger;

import java.io.*;

public class PropertiesDAO {

    private String propFileStorageLocation;
    private java.util.Properties properties;

    public PropertiesDAO(String propFileStorageLocation) {
        this.propFileStorageLocation = propFileStorageLocation;
        properties = new java.util.Properties();
    }

    public String getPropFileStorageLocation() {
        return propFileStorageLocation;
    }

    public void storeProperty(String key, String value) {
        properties.setProperty(key, value);
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    boolean loadPropertiesFile() {
        if (new File(propFileStorageLocation).exists()) {
            try {
                properties.loadFromXML(new FileInputStream(propFileStorageLocation));
                return true;
            } catch (IOException io) {
                Logger.writeException("Error reading from properties file", io);
                return false;
            }
        } else {
            return false;
        }
    }

    void savePropertiesToXml() {
        try {
            properties.storeToXML(new FileOutputStream(propFileStorageLocation), null);
        } catch (FileNotFoundException fnfe) {
            Logger.writeException("File not found", fnfe);
        } catch (IOException io) {
            Logger.writeException("Error outputting to properties file", io);
        }
    }
}
