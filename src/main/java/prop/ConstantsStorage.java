package prop;

import util.Constants;
import view.util.GuiConstants;

public class ConstantsStorage implements PropertyStorage {

    @Override
    public void storeProperties(PropertiesDAO propertiesDAO) {
        propertiesDAO.storeProperty(PropertyKey.PORT.getKey(), String.valueOf(Constants.CUSTOM_PORT));
        propertiesDAO.storeProperty(PropertyKey.MIN_PASS_LENGTH.getKey(),
                String.valueOf(Constants.CUSTOM_PASSWORD_MIN_LENGTH));
        propertiesDAO.storeProperty(PropertyKey.MAX_PASS_LENGTH.getKey(),
                String.valueOf(Constants.CUSTOM_PASSWORD_MAX_LENGTH));
        propertiesDAO.storeProperty(PropertyKey.COMPANY_NAME.getKey(), GuiConstants.companyName);
    }
}
