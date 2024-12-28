package jp.tyabata.sample.apisamplegraalvm.presentation;

import jp.tyabata.sample.apisamplegraalvm.domain.chat.ChatMessage;
import jp.tyabata.sample.apisamplegraalvm.domain.chat.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/models")
@RequiredArgsConstructor
public class LLMController {

    private final ChatRepository repository;

    @PostMapping("/llama")
    public LLMResponse postMessageToLlama(@RequestBody final LLMMessageBody body) {
        return new LLMResponse(
                repository.chat(new ChatMessage(body.getMessage()))
        );
    }
}
