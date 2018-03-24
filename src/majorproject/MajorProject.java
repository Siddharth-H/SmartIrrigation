/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorproject;

import Connection.conn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

        //Purvi's code start
        Connection con = conn.getCon();

        String sql = "Select * from users";

        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement(sql);
            ResultSet res = preparedStatement.executeQuery();
            boolean st = res.next();

//            Register.main();
            if (st == false) {
                Register.main();
            } else {
                Index.mainIndex();
                

            }
        } catch (Exception e) {
            System.out.println(e);
        }

        //Purvi's code end
//        
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
