package jp.tyabata.sample.apisamplegraalvm.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;

@Data
@Component
@Configuration
@ConfigurationProperties("spring.ai.llama-cpp")
public class LlamaCppProperties {

    private String modelPath;

    public String getModelAbsolutePath() throws FileNotFoundException {
        final var resource = ResourceUtils.getFile("classpath:" + modelPath);
        return resource.getAbsolutePath();
    }
}
