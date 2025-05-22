package drivers.strategy;

import utils.Constants;

// This classes helps us to choose the driver to use
public class DriverStrategyImplementer {
    public static DriverStrategy chooseStrategy(String strategy){
        switch (strategy){
            case Constants.CHROME:
                return new Chrome();
            case Constants.PHANTOMJS:
                return new PhantomJs();
            case Constants.FIREFOX:
                return new Firefox();
            default:
                return null;
        }
    }
}
