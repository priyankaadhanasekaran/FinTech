package com.parabank.tests;

import com.parabank.base.BaseTest;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ResponsiveTests extends BaseTest {

    @Test
    public void verifyNoHorizontalScrollOnMobile() {
        driver.manage().window().setSize(new Dimension(375, 812)); // iPhone size

        boolean horizontalScroll =
                (boolean) ((org.openqa.selenium.JavascriptExecutor) driver)
                        .executeScript("return document.body.scrollWidth > window.innerWidth;");

        Assert.assertFalse(horizontalScroll, "Page should not require horizontal scrolling.");
    }
}
