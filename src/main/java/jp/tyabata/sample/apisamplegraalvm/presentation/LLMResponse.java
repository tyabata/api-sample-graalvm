package jp.tyabata.sample.apisamplegraalvm.presentation;

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.tyabata.sample.apisamplegraalvm.domain.chat.ChatResponse;

public class LLMResponse {

    @JsonProperty("message")
    private final String message;


    public LLMResponse(final ChatResponse chatResponse) {
        this.message = chatResponse.message();
    }
}
