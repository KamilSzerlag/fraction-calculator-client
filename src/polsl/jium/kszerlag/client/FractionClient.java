/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polsl.jium.kszerlag.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import polsl.jium.kszerlag.controller.FractionCalculatorController;

/**
 *
 * @author szerlag
 */
public class FractionClient {
    private String host;
    private Integer port;
    
    private FractionCalculatorController controller; 
    
    public FractionClient() {
        PropertiesHelper propertiesHelper = new PropertiesHelper();
        this.host = propertiesHelper.getProperty("host");
        this.port = Integer.valueOf(propertiesHelper.getProperty("port"));
        if (this.host == null) {
            this.host = "localhost";
        }
        if (this.port == null) {
            this.port = 8080;
        }
         
    }
    
    public void setController(FractionCalculatorController controller) {
        this.controller = controller;
    }
    
    public void startClient() {
        try (
        Socket socket = new Socket(host, port);
        PrintWriter out = 
                new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = 
                new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            BufferedReader stdIn =
                new BufferedReader(new InputStreamReader(System.in));
            String fromServer;
            String fromUser;
            while ((fromServer = in.readLine()) != null) {
                System.out.println("Server: " + fromServer);
                if(fromServer.equals("BYE!")) {
                    break;
                }
                fromUser = stdIn.readLine();
                if (fromUser != null ){
                    out.println(fromUser);
                }
                controller.calculate(out.toString());
            }
        } catch (IOException e) {
           System.out.print(e.getMessage());
        }
    }

    
}

