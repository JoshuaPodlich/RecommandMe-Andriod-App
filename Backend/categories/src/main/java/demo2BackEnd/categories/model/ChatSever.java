package demo2BackEnd.categories.model;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import demo2BackEnd.categories.repository.MessageRepository;
import demo2BackEnd.categories.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@ServerEndpoint("/Chat/{user}")
@Controller
public class ChatSever {

    private static MessageRepository msRepo;
    @Autowired
    public void setMessageRepository(MessageRepository repo){
        msRepo = repo;
    }

    @Autowired
    UserRepository usr;

    // Store all socket session and their corresponding username.
    private static Map < Session, String > sessionUsernameMap = new Hashtable < > ();
    private static Map < String, Session > usernameSessionMap = new Hashtable < > ();

    private final Logger logger = LoggerFactory.getLogger(ChatSever.class);

    @OnOpen
    public void onOpen(Session session, @PathParam("user") String username)
            throws IOException {
        logger.info("Entered into Open");
        sessionUsernameMap.put(session, username);
        usernameSessionMap.put(username, session);
        String message = "[" + username + "] joined!";
        broadcast(message);
    }

    @OnMessage
    public void onMessage(Session session, String message) throws IOException {
        // Handle new messages
        logger.info("Entered into Message: Got Message:" + message);
        String username = sessionUsernameMap.get(session);

        if (message.startsWith("@")) // Direct message to a user using the format "@username <message>"
        {
            sendMessageToPArticularUser(username, "[DM] [" + username + "]: " + message);
        } else // Message to whole chat
        {
            broadcast("[" + username + "]: " + message);
        }
        msRepo.save(new Message(username, message));
    }

    @OnClose
    public void onClose(Session session) throws IOException {
        logger.info("Entered into Close");

        String username = sessionUsernameMap.get(session);
        sessionUsernameMap.remove(session);
        usernameSessionMap.remove(username);

        String message = username + " left!";
        broadcast(message);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        // Do error handling here
        logger.info("Entered into Error");
    }

    private void sendMessageToPArticularUser(String username, String message) {
        try {
            usernameSessionMap.get(username).getBasicRemote().sendText(message);
        } catch (IOException e) {
            logger.info("Exception: " + e.getMessage().toString());
            e.printStackTrace();
        }
    }

    private void broadcast(String message) {
        sessionUsernameMap.forEach((session, username) -> {
            try {
                session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                logger.info("Exception: " + e.getMessage().toString());
                e.printStackTrace();
            }
        });

    }
}
