package il.cshaifasweng.OCSFMediatorExample.client;

import il.cshaifasweng.OCSFMediatorExample.entities.Message;

public class FinishExamEvent
{
    private Message message;

    public Message getMessage() {
        return message;
    }

    public FinishExamEvent(Message message) {
        this.message = message;
    }
}
