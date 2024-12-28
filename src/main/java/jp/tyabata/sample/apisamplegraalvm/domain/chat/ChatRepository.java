package jp.tyabata.sample.apisamplegraalvm.domain.chat;

public interface ChatRepository {

    ChatResponse chat(final ChatMessage chatMessage);
}
