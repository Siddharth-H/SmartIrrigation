/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorproject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Siddharth
 */
public class MajorProject extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       
        Index index = new Index();
//        index.setVisible(true);
        index.mainIndex();
        index.setSerialPort();
        index.setMinMoisture();
        Thread t = new Thread(){
          public void run(){
            index.startInfiniteLoop();
              
          }  
        };
        t.start();
//        Thread t = new Thread() {
//            @Override
//            public void run() {
//
//                int moistureLevel = index.readMoisture();
//                String valve = null;
//
//                if (Integer.parseInt(index.plantWaterReq)
//                        > 0) {
//                    if (moistureLevel < Integer.parseInt(index.plantMinMoisture)) {
//                        index.changeValveState("ON");
//                        valve = "ON";
//                    }
//
//                    if (moistureLevel >= Integer.parseInt(index.plantMaxMoisture)) {
//                        index.changeValveState("OFF");
//                        valve = "OFF";
//                    }
//                }
//
//                index.changeValveState(
//                        "OFF");
//                index.insertIntoMoisture(index.connectToDatabase(), "" + moistureLevel + "");
//                index.updateInValve(index.connectToDatabase(), valve);
//            }
//        };
//        t.start();
        
        System.out.println("MAIN THREAD");
//        Index index = new Index();
        //setting Serial Port
//        if(index.setSerialPort() && index.setMinMoisture()){
////            index.startInfiniteLoop();
//            try{
//            Index.serialPort.writeString("message");
//            }catch(Exception e){
//                System.out.println("Major ::"+e);
//            }
//        }
//        Index index = new Index();
//        if (index.setSerialPort() && index.setMinMoisture()) {
//            index.startInfiniteLoop();
//        }
//        contact_us cobj = new contact_us();
//        cobj.main(args);
//        Login loginObj = new Login();
//        loginObj.setVisible(true);
//    String arg[] = null;
//        Login.main(arg);
//        launch(args);
//        main m = new main();
//        m.setVisible(true);

    }

}                      