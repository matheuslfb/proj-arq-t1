import java.io.*;
import java.net.*;

public class Cliente {

    public static void main(String args[]) throws Exception
    {
        // CRIA O STREAM DO TECLADO
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        //DECLARA O SOCKET DO CLIENTE
        DatagramSocket clientSocket = new DatagramSocket();

        //OBTEM O ENDERECO IP DO SERVIDOR COM O DNS
        InetAddress IPAddres = InetAddress.getByName("Localhost");

        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];

        //LE UMA LINHA DO TECLADO
        String sentence = inFromUser.readLine();
        sendData = sentence.getBytes();

        //CRIA O PACOTE COM UM DADO, O ENDERECO DO SERVER E A PORTA DO SERVIDOR
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddres, 9876);

        //ENVIA O PACOTE
        clientSocket.send(sendPacket);

        //FECHA O CLIENTE
        clientSocket.close();




    }

}
