package dev.qt.runnerz.foo.bar;

import org.springframework.stereotype.Component;

@Component
public class WelcomeMessage {

    public String getWelcomeMessage() {
        return "Welcome to the Runnerz Runner";
    }
}
