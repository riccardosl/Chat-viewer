package sample;

/**
 * This class is used to hold one complete message context.
 * This includes a time, a name, and the message.
 */
public class ChatEntry extends Object {
    protected String chatTime;
    protected String fromPerson;
    protected String msgText;

    /**
     * Constructor to use if you want to initialize this object
     * at create time
     * @param whatTime String chat time in hh:mm:ss format
     * @param fromWho String The name of the person who sent the message
     * @param msgBody String This is the complete message text
     */
    public ChatEntry(String whatTime, String fromWho, String msgBody) {
        chatTime = whatTime;
        fromPerson = fromWho;
        msgText = msgBody;
    }

    public String getChatTime() {
        return chatTime;
    }

    public String getFromPerson() {
        return fromPerson;
    }

    public String getMsgText() {
        return msgText;
    }

    @Override
    public String toString() {
        return "\nTime: " + chatTime + "\nName: " + fromPerson + "\nMessage: " + msgText;
    }
}
