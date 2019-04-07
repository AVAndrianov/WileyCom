package avandrianov.com.helpers;

import org.openqa.selenium.TimeoutException;
import ru.sbtqa.tag.qautils.properties.Props;

import java.util.Date;

public class TimeoutHelper {
    private static long initTime;

    public static Long getDefaultTimeoutInMilliseconds() {
        return Long.valueOf(Props.get("page.load.timeout"));
    }

    public static void initTimeout() {
        Date date = new Date();
        TimeoutHelper.initTime = date.getTime();
    }

    public static long getCurrentTime() {
        Date date = new Date();
        return date.getTime();
    }

    public static boolean isTimeout(String assertText) {
        if (TimeoutHelper.initTime < (getCurrentTime() - getDefaultTimeoutInMilliseconds())) {
            throw new TimeoutException(assertText + "\n" + "Истекло время ожидания");
        } else {
            return false;
        }
    }
}