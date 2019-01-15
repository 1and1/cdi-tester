package com.oneandone.ejbcdiunit.excludedclasses;

import static org.hamcrest.Matchers.is;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.oneandone.iocunit.analyzer.annotations.SutPackages;
import com.oneandone.cdi.tester.CdiUnit2Runner;
import com.oneandone.ejbcdiunit.excludedclasses.pcktoinclude.ToExclude;
import com.oneandone.ejbcdiunit.excludedclasses.pcktoinclude.ToInclude;

/**
 * @author aschoerk
 */
@RunWith(CdiUnit2Runner.class)
@SutPackages({ ToInclude.class })
// @ExcludedClasses(ToExclude.ToExcludeProduced.class)
public class ExcludeNegativeTest {

    @Inject
    ToInclude toInclude;
    @Inject
    ToExclude.ToExcludeProduced toExcludeProduced; // produced by not excluded ToExclude

    @BeforeClass
    public static void initToInclude() {
        ToInclude.count = 0;
    }

    @Test
    public void test() {
        Assert.assertThat(toInclude.count, is(2));
        Assert.assertThat(toExcludeProduced.getValue(), is(10));
    }
}