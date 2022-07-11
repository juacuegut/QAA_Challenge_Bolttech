package pages;

import driver.DriverManager;
import exceptions.FrameworkTimeoutException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Optional;

public class MyFluentWait {

    public MyFluentWait() {}

    protected <K> Optional<K> waitFor(ExpectedCondition<K> condition) {
        return waitFor(condition, true);
    }

    protected <K> Optional<K> waitFor(ExpectedCondition<K> condition, boolean shouldFail) {
        return waitFor(condition, 50, ChronoUnit.MILLIS, shouldFail);
    }
/*
    protected <K> Optional<K> waitFor(ExpectedCondition<K> condition, int time, TemporalUnit unit, boolean shouldFail) {
        return this.waitFor(condition, FrameworkConstants.getWaitTimeInSeconds(), ChronoUnit.MILLIS, shouldFail);
    }
 */

    protected <K> Optional<K> waitFor(ExpectedCondition<K> condition, long time, TemporalUnit unit, boolean shouldFail) {
        try {
            K result = (K) (new FluentWait(DriverManager.getDriver())).pollingEvery(Duration.ofMillis(750)).withTimeout(Duration.of(time, unit))
                    .withMessage(condition.toString()).ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class)
                    .until(new MyFluentWaitHelper(this, time, unit, condition));
            return Optional.of(result);
        } catch (TimeoutException var7) {
            if (shouldFail) {
                throw new FrameworkTimeoutException(condition.toString(), time, unit);
            } else {
                return Optional.empty();
            }
        }
    }

}
