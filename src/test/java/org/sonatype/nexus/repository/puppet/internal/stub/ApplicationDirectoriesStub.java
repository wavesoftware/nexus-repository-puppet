package org.sonatype.nexus.repository.puppet.internal.stub;

import org.sonatype.nexus.common.app.ApplicationDirectories;

import javax.inject.Named;
import javax.inject.Singleton;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author <a href="mailto:krzysztof.suszynski@wavesoftware.pl">Krzysztof Suszynski</a>
 * @since 0.1.0
 */
@Named
@Singleton
public final class ApplicationDirectoriesStub
        implements ApplicationDirectories {

    private final Path tempDir;

    ApplicationDirectoriesStub() {
        try {
            tempDir = Files.createTempDirectory("nexus-puppet-stub-");
            Path esConfigPath = getConfigDirectory("fabric")
                    .toPath()
                    .resolve("elasticsearch.yml");
            Files.createDirectories(esConfigPath.getParent());
            String config = "path.home: " + getWorkDirectory("es");
            Files.write(esConfigPath, config.getBytes(StandardCharsets.UTF_8));
        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                Files.deleteIfExists(tempDir);
            } catch (IOException ex) {
                throw new IllegalStateException(ex);
            }
        }));
    }

    @Override
    public File getInstallDirectory() {
        return tempDir.resolve("install").toFile();
    }

    @Override
    public File getConfigDirectory(String subsystem) {
        return tempDir.resolve("config").resolve(subsystem).toFile();
    }

    @Override
    public File getTemporaryDirectory() {
        return tempDir.resolve("temp").toFile();
    }

    @Override
    public File getWorkDirectory() {
        return tempDir.resolve("work").toFile();
    }

    @Override
    public File getWorkDirectory(String path, boolean create) {
        return tempDir.resolve("work").resolve(path).toFile();
    }

    @Override
    public File getWorkDirectory(String path) {
        return tempDir.resolve("work").resolve(path).toFile();
    }
}
