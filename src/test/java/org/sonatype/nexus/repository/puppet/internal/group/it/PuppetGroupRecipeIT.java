package org.sonatype.nexus.repository.puppet.internal.group.it;

import org.eclipse.sisu.launch.InjectedTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.sonatype.nexus.repository.Repository;
import org.sonatype.nexus.repository.puppet.internal.group.PuppetGroupRecipe;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * @author <a href="mailto:krzysztof.suszynski@wavesoftware.pl">Krzysztof Suszynski</a>
 * @since 0.1.0
 */
@RunWith(MockitoJUnitRunner.class)
public class PuppetGroupRecipeIT extends InjectedTest {

    @Mock
    private Repository repository;

    @Test
    public void apply() throws Exception {
        // given
        PuppetGroupRecipe recipe = lookup(PuppetGroupRecipe.class);

        // when
        recipe.apply(repository);

        // then
        assertThat(recipe).isNotNull();
    }
}
