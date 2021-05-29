package org.example.ui.pay;

import java.util.UUID;

public class createUUID {
    public static String createID() {
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replace("-", "");
        return uuid;
    }
}
