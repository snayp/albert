package me.datalight.albert.utils;

import com.ullink.slack.simpleslackapi.SlackSession;
import com.ullink.slack.simpleslackapi.impl.SlackSessionFactory;

import java.io.IOException;

public class Slack {
    public static SlackSession connect() throws IOException {
        SlackSession session = SlackSessionFactory.createWebSocketSlackSession("");//ключ в слак
        session.connect();
        return session;
    }
}
