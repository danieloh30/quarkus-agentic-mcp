import io.quarkus.websockets.next.OnError;
import io.quarkus.websockets.next.OnOpen;
import io.quarkus.websockets.next.OnTextMessage;
import io.quarkus.websockets.next.WebSocket;
import io.quarkus.websockets.next.WebSocketClientConnection;
import io.quarkus.websockets.next.WebSocketConnection;
import io.smallrye.mutiny.Multi;

@WebSocket(path = "/bot")
public class BotWebsocket {

    private final Bot bot;

    public BotWebsocket(Bot bot) {
        this.bot = bot;
    }

    @OnOpen
    public String onOpen() {
        return "Welcome to your personal assistant! How can I help you today?";
    }

    @OnError
    public String onError(Throwable t) {
        return t.getMessage();
    }
    @OnTextMessage
    public Multi<String> onTextMessage(String message) {
        return bot.chat(message);
    }
}
