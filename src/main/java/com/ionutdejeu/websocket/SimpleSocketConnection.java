package com.ionutdejeu.websocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

public class SimpleSocketConnection {
    public void create(){
        try{

            Socket socket = new Socket("google.com", 80);
            InputStream input = socket.getInputStream();

            socket.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void CreateDateTimeSocket(){
        String hostname = "time.nist.gov";
        int port = 13;
        try (Socket socket = new Socket(hostname, port)) {

            InputStream input = socket.getInputStream();
            InputStreamReader reader = new InputStreamReader(input);

            int character;
            StringBuilder data = new StringBuilder();

            while ((character = reader.read()) != -1) {
                data.append((char) character);
            }
            System.out.println(data);
        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        }
    }
}
