package lesson5.Chat.client;


import javax.imageio.IIOException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
// Для удобства ожидания инициализации серверной части
        System.out.print("Введите своё имя: ");
// Укажем своё имя
        String name = scanner.nextLine();
        try {
            InetAddress address = InetAddress.getLocalHost();
            System.out.println("Connect To:" + address + ":" + 8800);
            Socket socket = new Socket(address, 8080);
            Client client = new Client(socket, name);
            InetAddress inetAddress = socket.getInetAddress();
            System.out.println("InetAddress: " + inetAddress);
            String remoteIP = inetAddress.getHostAddress();
            System.out.println("Remote IP: " + remoteIP);
            System.out.println("LocalPort: " + socket.getLocalPort());

            client.ListenForMessages();
            client.sendMessage();

        }
        catch (UnknownHostException e) {
            e.printStackTrace();
        }
        catch (IIOException e) {
            e.printStackTrace();
        }
        catch (IOException e) {

        }
    }
}

