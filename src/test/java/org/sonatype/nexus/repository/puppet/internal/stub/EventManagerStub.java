package org.sonatype.nexus.repository.puppet.internal.stub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonatype.nexus.common.event.EventManager;

import javax.inject.Named;

/**
 * @author <a href="mailto:krzysztof.suszynski@wavesoftware.pl">Krzysztof Suszynski</a>
 * @since 0.1.0
 */
@Named
public final class EventManagerStub implements EventManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(EventManagerStub.class);
    @Override
    public void register(Object handler) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void unregister(Object handler) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void post(Object event) {
        LOGGER.debug("Post: {}", event);
    }

    @Override
    public boolean isCalmPeriod() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public boolean isAffinityEnabled() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
