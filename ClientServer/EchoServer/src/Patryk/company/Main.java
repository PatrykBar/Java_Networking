package Patryk.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)){

            while (true){
                new Echoer(serverSocket.accept()).start();
//                Socket socket = serverSocket.accept();
//                System.out.println("Client connected");
//                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
//
//                String echoString = input.readLine();
//
//                try{
//                    Thread.sleep(15000);
//                }catch (InterruptedException e){
//                    System.out.println("Thread interrupted");
//                }
//
//                if(echoString.equals("exit")){
//                    break;
//                }
//                System.out.println("Echo from server: " + echoString);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
