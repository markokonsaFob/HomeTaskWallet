package impl.wallethub.login;

import io.cify.framework.core.Device;

/**
 * Created by FOB Solutions
 */
public class LoginActions {

    private LoginPage page;

    public LoginActions(Device device) {
        page = new LoginPage(device);
    }

    /**
     * Login to WalletHub account with given credentials
     * @param username
     * @param password
     */
    public void login(String username, String password) {
        page.getEmailField().sendKeys(username);
        page.getPasswordField().sendKeys(password);
        page.getLoginForm().submit();
    }

}
