package exceptions;

import java.time.Duration;
import java.time.temporal.TemporalUnit;

public class FrameworkTimeoutException extends AssertionError{

    public FrameworkTimeoutException(String message, long time, TemporalUnit unit) {
        super(String.format("Tested time out after waiting %s seconds for condition: %s", Duration.of(time, unit).getSeconds(), message));

    }
}
