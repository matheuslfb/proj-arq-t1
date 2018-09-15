import java.io.*;
import java.net.*;

public class Cliente {

    private Produto produto;
    private int id;
    private String nome;


    public Cliente(String nome, int id){
        this.id = id;
        this.nome = nome;

    }


    public static void main(String args[]) throws Exception
    {

        while(true) {
            System.out.println("Digite seu nome ");
            // CRIA O STREAM DO TECLADO
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

            //DECLARA O SOCKET DO CLIENTE
            DatagramSocket clientSocket = new DatagramSocket();

            //OBTEM O ENDERECO IP DO SERVIDOR COM O DNS
            InetAddress IPAddres = InetAddress.getByName("Localhost");

            byte[] sendData = new byte[1024];
            byte[] receiveData = new byte[1024];

            //LE UMA LINHA DO TECLADO
            String nome = inFromUser.readLine();
            Cliente p = new Cliente(nome, 1);

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

}
