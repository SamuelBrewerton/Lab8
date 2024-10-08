import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.*;

public class LoginForm extends Application{
    public static void main(String[] args) {
        launch(args);
    }


    
    private Label usernameLbl;
    private TextField usernameTf;
    private Label passwordLbl;
    private PasswordField passwordPf; //Use regular textfield for password?
    private Button loginBtn;
    
    //TODO: Someone said on ed that password correct message is not using label. Check it out.
    //TODO: Create variable for password message.

    @Override
    public void start(Stage stage) throws Exception {
        usernameLbl = new Label("Username:");
        usernameTf = new TextField("");
        passwordLbl = new Label("Password:");
        passwordPf = new PasswordField();
        loginBtn = new Button("Login");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(usernameLbl, 0, 0);
        gridPane.add(usernameTf, 1, 0);

        gridPane.add(passwordLbl, 0, 1);
        gridPane.add(passwordPf, 1, 1);

        gridPane.add(loginBtn, 1, 2);

        stage.setScene(new Scene(gridPane));
        stage.setTitle("Login Form");
        stage.show();
    }
}
