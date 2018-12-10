package ejbcdiunit2.first.cdiunit;

import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;

import org.jboss.weld.environment.se.WeldSEBeanRegistrant;

import com.oneandone.cdi.testanalyzer.annotations.TestClasses;
import com.oneandone.cdi.tester.ProducesAlternative;
import com.oneandone.cdi.tester.contexts.ContextController;
import com.oneandone.cdi.tester.contexts.internal.InConversationInterceptor;
import com.oneandone.cdi.tester.contexts.internal.InRequestInterceptor;
import com.oneandone.cdi.tester.contexts.internal.InSessionInterceptor;
import com.oneandone.cdi.tester.contexts.internal.InitialListenerProducer;
import com.oneandone.cdi.tester.contexts.internal.jsf.ViewScopeExtension;
import com.oneandone.cdi.tester.contexts.servlet.MockHttpServletRequestImpl;
import com.oneandone.cdi.tester.contexts.servlet.MockHttpServletResponseImpl;
import com.oneandone.cdi.tester.contexts.servlet.MockHttpSessionImpl;
import com.oneandone.cdi.tester.contexts.servlet.MockServletContextImpl;

@TestClasses({ ScopedFactory.class,
        // added in cdiunit
        ViewScopeExtension.class,
        ContextController.class,
        InRequestInterceptor.class,
        InSessionInterceptor.class,
        InConversationInterceptor.class,
        WeldSEBeanRegistrant.class,
        // ProducerConfigExtension.class,
        MockServletContextImpl.class,
        MockHttpSessionImpl.class,
        MockHttpServletRequestImpl.class,
        MockHttpServletResponseImpl.class,
        InitialListenerProducer.class,
        ProducesAlternative.class
})
public class BaseTest {
    @Inject
    private BeanManager beanManager;

    public BeanManager getBeanManager() {
        return beanManager;
    }
}