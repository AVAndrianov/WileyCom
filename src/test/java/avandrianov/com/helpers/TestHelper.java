package avandrianov.com.helpers;

import avandrianov.com.stepdefs.AssertationsSteps;
import ru.sbtqa.tag.stepdefs.ru.StepDefs;

public class TestHelper {

    private static StepDefs stepDefs;
    private static AssertationsSteps assertSteps;

    public static StepDefs getStepDefs() {
        if (null == stepDefs) {
            stepDefs = new StepDefs();
        }
        return stepDefs;
    }

    public static AssertationsSteps getAssertSteps() {
        if (null == assertSteps) {
            assertSteps = new AssertationsSteps();
        }
        return assertSteps;
    }
}