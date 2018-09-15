import java.io.*;
import java.net.*;

public class Server {

    public static void main(String args[]) throws Exception
    {

        //CRIA SOCKET DO SERVIDOR COM A PORTA 9876
        DatagramSocket serverSocket = new DatagramSocket(9876);

        byte[] receiveData = new byte[1024];

        while(true)
        {
            //DECLARA O PACOTE A SER RECEBIDO
            DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);

            //RECEBE O PACOTE DO CLIENTE
            serverSocket.receive(receivePacket);

            //PEGA OS DADOS,O ENDERECO IP E A PORTA DO CLIENTE
            //PARA PODER MANDAR AS MENSAGENS DE VOLTA

            String sentence = new String(receivePacket.getData());
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();

            System.out.println("Mensagem recebida: " + sentence);

        }


    }
}
