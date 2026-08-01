package com.openmrs.testdata;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "productData")
    public Object[][] productData() {

        return new Object[][] {
                {"OpenMRS Platform"},
                {"OpenMRS Reference Application"},
                {"OpenMRS 3"}
        };
    }
}