package impl.wallethub.review;

import helpers.Constants;
import helpers.TestDataManager;
import io.cify.framework.core.Device;

/**
 * Created by FOB Solutions
 */
public class ConfirmationActions {

    private ConfirmationPage page;

    public ConfirmationActions(Device device) {
        page = new ConfirmationPage(device);
    }

    /**
     * Verifies if confirmation is visible
     * @return
     */
    public boolean isConfirmationVisible() {
        return page.getReviewContent().isDisplayed();
    }

    /**
     * Verify review content
     * @return
     */
    public boolean isConfirmationWithCorrectData() {
        return page.getReviewContent().getText().equals(TestDataManager.getTestData(Constants.SAVED_REVIEW));
    }
}
