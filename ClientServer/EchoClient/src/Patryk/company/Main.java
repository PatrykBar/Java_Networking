package Patryk.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost", 5000)) { // we can also set not "localhost" but ip address

            socket.setSoTimeout(5000);
            BufferedReader echoes =
                    new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));
            PrintWriter stringToEcho =
                    new PrintWriter(socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);
            String echoString;
            String responce;

            do {
                System.out.println("Enter string to be echoed");
                echoString = scanner.nextLine();

                stringToEcho.println(echoString);
                if (!echoString.equals("exit")) {
                    responce = echoes.readLine();
                    System.out.println(responce);
                }
            } while (!echoString.equals("exit"));

        }catch (SocketTimeoutException e){
            System.out.println("Socket time out");
        } catch (IOException E){
            System.out.println("Client error: " + E.getMessage());
        }
    }
}
