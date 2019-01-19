package iocunit;

import javax.enterprise.inject.Produces;

import org.junit.runner.RunWith;
import org.mockito.Mock;

import com.oneandone.iocunit.analyzer.annotations.ExcludedClasses;
import com.oneandone.iocunit.analyzer.annotations.TestClasses;
import com.oneandone.iocunit.IocUnitRunner;
import com.oneandone.iocunit.analyzer.annotations.ProducesAlternative;

import iocunit.cdiunit.AImplementation1;
import iocunit.cdiunit.AInterface;


/**
 * @author aschoerk
 */
@RunWith(IocUnitRunner.class)
@TestClasses({ AImplementation1.class })
@ExcludedClasses({ MockTest.class })
public class MockTestOrg extends MockTest {
    @Mock
    @ProducesAlternative
    @Produces
    private AInterface mockA;
}