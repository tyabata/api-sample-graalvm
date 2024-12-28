package jp.tyabata.sample.apisamplegraalvm.presentation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class LLMMessageBody {
    @JsonProperty("message")
    private String message;
}
