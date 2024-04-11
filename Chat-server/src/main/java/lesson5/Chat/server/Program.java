package lesson5.Chat.server;


import java.io.IOException;
import java.net.ServerSocket;

/**
 * Простой чат на основе сокетов.
 * Сервер принимает сообщения от клиентов и пересылает их всем участникам чата.
 */
public class Program {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            Server server = new Server(serverSocket);
            server.runServer();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

}