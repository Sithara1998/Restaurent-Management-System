package lk.ijse.dep11.app.controllers;

import javafx.application.Platform;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import shared.Order;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSceneController {
    public AnchorPane root;
    public TableView tblOrder;

    public void initialize(){

        new Thread(this::startServer).start();
    }
    private void startServer(){
        try {
            ServerSocket serverSocket = new ServerSocket(5050);
            System.out.println("Waiting for a client order");
            Socket localSocket = serverSocket.accept();
            System.out.println("Client order accepted");
            new Thread(()->{
                try {
                    InputStream is = localSocket.getInputStream();
                    BufferedInputStream bis = new BufferedInputStream(is);
                    ObjectInputStream ois = new ObjectInputStream(bis);

                    while(true){
                        Order order = (Order) ois.readObject();
//                        Platform.runLater(() -> tblOrder.getItems().add(order));

                    }
                } catch (EOFException e) {
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
