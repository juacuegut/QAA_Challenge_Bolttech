package pages;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.time.temporal.TemporalUnit;

public class MyFluentWaitHelper<K> implements ExpectedCondition<K> {

    final long start;
    MyFluentWait myFluentWait;
    final long time;
    TemporalUnit unit;
    ExpectedCondition expectedCondition;

    MyFluentWaitHelper(MyFluentWait myFluentWait, long time, TemporalUnit unit, ExpectedCondition expectedCondition) {
        this.start = System.currentTimeMillis();
        this.myFluentWait = myFluentWait;
        this.time = time;
        this.unit = unit;
        this.expectedCondition = expectedCondition;
    }

    @NullableDecl
    @Override
    public K apply(@NullableDecl WebDriver driver) { return (K) this.expectedCondition.apply(driver); }
}
