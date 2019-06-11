package org.sonatype.nexus.repository.puppet.internal.stub;

import org.sonatype.nexus.security.ClientInfo;
import org.sonatype.nexus.security.ClientInfoProvider;

import javax.annotation.Nullable;
import javax.inject.Named;

/**
 * @author <a href="mailto:krzysztof.suszynski@wavesoftware.pl">Krzysztof Suszynski</a>
 * @since 0.1.0
 */
@Named
public final class ClientInfoProviderStub implements ClientInfoProvider {
    @Nullable
    @Override
    public ClientInfo getCurrentThreadClientInfo() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
