package November20;

import java.io.*;
import java.net.Socket;

public class ClientCreator {
    public Client create(Socket clientSocket) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        PrintWriter clientWriter = new PrintWriter(writer, true);
        BufferedReader clientReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream(), "UTF-8"));
        return new Client(clientSocket, clientWriter, clientReader);
    }
}
