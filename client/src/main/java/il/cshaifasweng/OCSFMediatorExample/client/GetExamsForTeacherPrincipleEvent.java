package il.cshaifasweng.OCSFMediatorExample.client;

import il.cshaifasweng.OCSFMediatorExample.entities.Message;

public class GetExamsForTeacherPrincipleEvent {
    private Message message;

    public Message getMessage() {
        return message;
    }

    public GetExamsForTeacherPrincipleEvent(Message message) {
        this.message = message;
    }
}
