package Patryk.company;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try{
            InetAddress address = InetAddress.getLocalHost();
            DatagramSocket datagramSocket = new DatagramSocket();

            Scanner scanner = new Scanner(System.in);
            String echoString;

            do{
                System.out.println(" Enter string to be echoed ");
                echoString = scanner.nextLine();

                byte[] buffer = echoString.getBytes();

                DatagramPacket packet = new DatagramPacket(buffer , buffer.length, address, 5000);
                datagramSocket.send(packet);

                byte[] buffer2 = new byte[50];
                packet = new DatagramPacket(buffer2, buffer2.length);
                datagramSocket.receive(packet);
                System.out.println("Test receive is " + new String(buffer2, 0, packet.getLength()));
            }while (!echoString.equals("exit"));

        }catch (SocketException e){
            System.out.println( e.getMessage());
        }catch (IOException e1){
            System.out.println( e1.getMessage());
        }
    }
}
