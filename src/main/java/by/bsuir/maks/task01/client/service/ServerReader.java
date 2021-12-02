package by.bsuir.maks.task01.client.service;

import by.bsuir.maks.task01.client.clientconsole.CommandPrinter;

import java.io.IOException;

public class ServerReader extends Thread {
    Client client;
    String data;
    CommandPrinter commandPrinter;
    ClientLogic clientLogic;
    public ServerReader(Client client, ClientLogic clientLogic) {
        this.clientLogic = clientLogic;
        this.client = client;
        data = "";
        commandPrinter = new CommandPrinter();
    }

    public void run() {
        try {
            while (!data.equals("STOP")){
                data = client.getData();
                commandPrinter.print(data);
            }
            client.sendCommand("STOP");
            client.close();
            clientLogic.setNonEnable();
            commandPrinter.print("Break with the server\n" +
                    "Enter any character");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
