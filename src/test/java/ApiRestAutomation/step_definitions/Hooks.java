package ApiRestAutomation.step_definitions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Hooks {
    private static final Logger logger = LoggerFactory.getLogger(Hooks.class);

    //Implements actions to start Api escenarios
    public void beforeScenario() {
        logger.info("*** Start API test Automation escenarios ****");
    }
}
