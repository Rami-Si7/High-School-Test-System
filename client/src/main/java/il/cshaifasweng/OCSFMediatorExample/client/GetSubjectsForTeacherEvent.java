package il.cshaifasweng.OCSFMediatorExample.client;

import il.cshaifasweng.OCSFMediatorExample.entities.Message;

public class GetSubjectsForTeacherEvent
{
    private Message message;
    public Message getMessage() {
        return message;
    }

    GetSubjectsForTeacherEvent(Message message){
        this.message = message;
    }
}
