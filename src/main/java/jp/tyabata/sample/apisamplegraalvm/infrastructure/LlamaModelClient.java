package jp.tyabata.sample.apisamplegraalvm.infrastructure;

import de.kherud.llama.InferenceParameters;
import de.kherud.llama.LlamaModel;
import de.kherud.llama.ModelParameters;
import jp.tyabata.sample.apisamplegraalvm.config.LlamaCppProperties;
import jp.tyabata.sample.apisamplegraalvm.domain.chat.ChatMessage;
import jp.tyabata.sample.apisamplegraalvm.domain.chat.ChatRepository;
import jp.tyabata.sample.apisamplegraalvm.domain.chat.ChatResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Repository
public class LlamaModelClient implements ChatRepository {

    private final ModelParameters modelParameters;
    private final InferenceParameters inferenceParameters;
    private final String modelPath;

    public LlamaModelClient(final LlamaCppProperties properties) throws FileNotFoundException {
        this.modelParameters = new ModelParameters()
                .setNGpuLayers(1);

        this.inferenceParameters = new InferenceParameters()
                .setTemperature(0.7f)
                .setPenalizeNl(true)
                .setMirostat(InferenceParameters.MiroStat.V2)
                .setAntiPrompt("User: ");

        this.modelPath = properties.getModelAbsolutePath();
        log.info("model llama : {}", this.modelPath);
    }

    @Override
    public ChatResponse chat(final ChatMessage chatMessage) {
        try (final var model = new LlamaModel(this.modelPath, this.modelParameters)) {
            final var iterator = model.generate(chatMessage.getPrompt().getContents(), this.inferenceParameters);

            final var responseMessage = StreamSupport.stream(iterator.spliterator(), false)
                    .map(output -> output.text)
                    .collect(Collectors.joining());

            return new ChatResponse(responseMessage);
        }
    }
}