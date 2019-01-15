package com.oneandone.ejbcdiunit.ejb;

import javax.ejb.EJB;
import javax.enterprise.inject.Produces;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.oneandone.iocunit.analyzer.annotations.TestClasses;
import com.oneandone.cdi.tester.CdiUnit2Runner;
import com.oneandone.cdi.tester.ejb.ResourceQualifier;
import com.oneandone.ejbcdiunit.ejbs.ResourceTestEjb;

/**
 * @author aschoerk
 */
@RunWith(CdiUnit2Runner.class)
@TestClasses(ResourceTestEjb.class)
public class TestStringResourceInjection {
    @EJB
    ResourceTestEjb resourceTestEjb;

    @Produces
    @ResourceQualifier(name = "ResourceTestEjbAppName", lookup = "java:app/AppName", mappedName = "RTEAppName")
    String appNameProducer() {
        return "TestStringResourceInjectionAppName";
    }

    @Produces
    @ResourceQualifier(name = "ResourceTestEjbModuleName", lookup = "java:module/ModuleName", mappedName = "RTEModuleName")
    String moduleNameProducer() {
        return "TestStringResourceInjectionModuleName";
    }

    @Produces
    @ResourceQualifier(lookup = "java:app/AppName")
    String appName2Producer() {
        return "TestStringResourceInjectionAppName2";
    }

    @Produces
    @ResourceQualifier(lookup = "java:module/ModuleName")
    String moduleName2Producer() {
        return "TestStringResourceInjectionModuleName2";
    }


    @Test
    public void canInjectFullSpecified() {

        Assert.assertEquals("TestStringResourceInjectionAppName", resourceTestEjb.ejbAppName());
        Assert.assertEquals("TestStringResourceInjectionModuleName", resourceTestEjb.ejbModuleName());

    }

    @Test
    public void canInjectPartlySpecified() {

        Assert.assertEquals("TestStringResourceInjectionAppName2", resourceTestEjb.ejbAppName2());
        Assert.assertEquals("TestStringResourceInjectionModuleName2", resourceTestEjb.ejbModuleName2());

    }

}