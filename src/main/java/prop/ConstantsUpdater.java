package prop;

import log.Logger;
import util.Constants;
import view.util.GuiConstants;

/**
 * Updates all constant variables
 */
public class ConstantsUpdater implements PropertyUpdater {

    @Override
    public void update(PropertiesDAO propertiesDAO) {
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
    }
}
