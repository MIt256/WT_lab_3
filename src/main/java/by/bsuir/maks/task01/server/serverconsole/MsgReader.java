package by.bsuir.maks.task01.server.serverconsole;

import by.bsuir.maks.task01.server.service.ServerLogic;

import java.io.IOException;
import java.util.Scanner;

public class MsgReader extends Thread{
    Scanner scan;
    ServerLogic serverLogic;

    public MsgReader(ServerLogic serverLogic){
        this.serverLogic = serverLogic;
        scan = new Scanner(System.in);
    }

    public void run(){
        String command = scan.next();
        if (command.equals("STOP")) {
            try {
                serverLogic.stopConnection();
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
