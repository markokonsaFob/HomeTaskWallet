package impl;

import impl.facebook.home.FacebookHomeActions;
import impl.facebook.login.FacebookLoginActions;
import impl.wallethub.common.navbar.NavbarActions;
import impl.wallethub.login.LoginActions;
import impl.wallethub.profile.CompanyProfileActions;
import impl.wallethub.profile.UserProfileActions;
import impl.wallethub.review.ConfirmationActions;
import impl.wallethub.review.ReviewActions;
import io.cify.framework.core.Device;
import io.cify.framework.core.DeviceManager;

/**
 * Created by FOB Solutions
 */
public class ActionsImpl {

    /**
     * Returns Facebook login Actions
     * @return
     */
    public static FacebookLoginActions getFacebookLoginActions() {
        Device device = DeviceManager.getInstance().getActiveDevice();
        return new FacebookLoginActions(device);
    }

    /**
     * Gets Facebook home actions
     * @return
     */
    public static FacebookHomeActions getFacebookHomeActions() {
        Device device = DeviceManager.getInstance().getActiveDevice();
        return new FacebookHomeActions(device);
    }

    /**
     * Gets navigation bar actions
     * @return
     */
    public static NavbarActions getNavigationBarActions() {
        Device device = DeviceManager.getInstance().getActiveDevice();
        return new NavbarActions(device);
    }

    /**
     * Gets wallet hub login actions
     * @return
     */
    public static LoginActions getWalletHubLoginActions() {
        Device device = DeviceManager.getInstance().getActiveDevice();
        return new LoginActions(device);
    }


    /**
     * Gets wallet hub company actions
     * @return
     */
    public static CompanyProfileActions getWalletHubCompanyProfileActions() {
        Device device = DeviceManager.getInstance().getActiveDevice();
        return new CompanyProfileActions(device);
    }

    /**
     * Gets user profile actions
     * @return
     */
    public static UserProfileActions getWalletHubUserProfileActions() {
        Device device = DeviceManager.getInstance().getActiveDevice();
        return new UserProfileActions(device);
    }

    /**
     * Get wallet hub confirmation actions
     * @return
     */
    public static ConfirmationActions getWalletHubConfirmationActions() {
        Device device = DeviceManager.getInstance().getActiveDevice();
        return new ConfirmationActions(device);
    }

    /**
     * Get review actions
     * @return
     */
    public static ReviewActions getReviewActions() {
        Device device = DeviceManager.getInstance().getActiveDevice();
        return new ReviewActions(device);
    }

}
