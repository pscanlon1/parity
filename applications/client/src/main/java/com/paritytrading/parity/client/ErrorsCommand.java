package com.paritytrading.parity.client;

import java.util.Scanner;

class ErrorsCommand implements Command {

    @Override
    public void execute(TerminalClient client, Scanner arguments) {
        if (arguments.hasNext())
            throw new IllegalArgumentException();

        client.printf("\n%s\n", Error.HEADER);
        for (Error error : Errors.collect(client.getEvents()))
            client.printf("%s\n", error.format());
        client.printf("\n");
    }

    @Override
    public String getName() {
        return "errors";
    }

    @Override
    public String getDescription() {
        return "Display occurred errors";
    }

    @Override
    public String getUsage() {
        return "errors";
    }

}
