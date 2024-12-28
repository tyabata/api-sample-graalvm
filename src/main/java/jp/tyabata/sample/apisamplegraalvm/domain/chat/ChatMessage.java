package jp.tyabata.sample.apisamplegraalvm.domain.chat;

import org.springframework.ai.chat.prompt.Prompt;

public record ChatMessage(
        String message
) {

    public Prompt getPrompt() {
        return new Prompt(message);
    }
}
