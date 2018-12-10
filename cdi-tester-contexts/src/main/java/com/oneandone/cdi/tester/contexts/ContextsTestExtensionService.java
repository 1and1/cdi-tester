package com.oneandone.cdi.tester.contexts;

import java.util.Collection;
import java.util.HashSet;

import com.oneandone.cdi.tester.contexts.internal.InConversationInterceptor;
import com.oneandone.cdi.tester.contexts.internal.InRequestInterceptor;
import com.oneandone.cdi.tester.contexts.internal.InSessionInterceptor;
import com.oneandone.cdi.tester.contexts.internal.InitialListenerProducer;
import com.oneandone.cdi.tester.contexts.servlet.MockHttpServletRequestImpl;
import com.oneandone.cdi.tester.contexts.servlet.MockHttpServletResponseImpl;
import com.oneandone.cdi.tester.contexts.servlet.MockHttpSessionImpl;
import com.oneandone.cdi.tester.contexts.servlet.MockServletContextImpl;
import com.oneandone.cdi.weldstarter.spi.TestExtensionService;

/**
 * @author aschoerk
 */
public class ContextsTestExtensionService implements TestExtensionService {
    @Override
    public Collection<Class<?>> testClasses() {
        HashSet<Class<?>> result = new HashSet<Class<?>>() {
            private static final long serialVersionUID = -1661631254833065243L;

            {
                add(ContextController.class);
                add(InRequestInterceptor.class);
                add(InSessionInterceptor.class);
                add(InConversationInterceptor.class);
                // add(WeldSEBeanRegistrant.class);
                // ProducerConfigExtension.class,
                add(MockServletContextImpl.class);
                add(MockHttpSessionImpl.class);
                add(MockHttpServletRequestImpl.class);
                add(MockHttpServletResponseImpl.class);
                add(InitialListenerProducer.class);
            }
        };
        return result;
    }
}