
package hangman;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Hangman extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Stage loginWindow = stage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("login.fxml"));
        loader.load();
        LoginController lc = loader.getController();
        
        Parent root = loader.getRoot();
        
        Scene scene = new Scene(root);
        
        loginWindow.setOnCloseRequest(e -> {
            e.consume();
            try {
                Stage quitWindow = new Stage();
                FXMLLoader quitLoader = new FXMLLoader();
                quitLoader.setLocation(getClass().getResource("quit.fxml"));
                quitLoader.load();
                QuitController qc = quitLoader.getController();

                Parent quitRoot = quitLoader.getRoot();

                Scene quitScene = new Scene(quitRoot);

                quitWindow = new Stage();
                quitWindow.setScene(quitScene);
                quitWindow.initModality(Modality.APPLICATION_MODAL);
                qc.setWindows(loginWindow, quitWindow);
                quitWindow.showAndWait();
            } catch(Exception excep) {
            }
        });
        loginWindow.setScene(scene);
        lc.setLoginWindow(loginWindow);
        loginWindow.show();
    }

    
    public static void main(String[] args) {
        launch(args);
    }
    
}
