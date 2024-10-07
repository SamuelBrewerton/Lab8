import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.*;

public class Calculator extends Application {
    public static void main(String[] args) { 
        launch(args); 
    }

    private Label firstNumberLbl;
    private TextField firstNumberTf;
    private Label secondNumberLbl;
    private TextField secondNumberTf;
    private Label operationLbl;
    private Button addBtn;
    private Button subBtn;
    private Button mulBtn;
    private Button divBtn;
    private Label resultLbl;
    private TextField resultTf;

    @Override
    public void start(Stage stage) throws Exception {
    // 1. create the leaf nodes
        firstNumberLbl = new Label("First Number:");
        firstNumberTf = new TextField("");
        secondNumberLbl = new Label("Second Number:");
        secondNumberTf = new TextField("");
        operationLbl = new Label("operation:");
        addBtn = new Button("+");
        subBtn = new Button("-");
        mulBtn = new Button("*");
        divBtn = new Button("/");
        resultLbl = new Label("Result:");
        resultTf = new TextField("");



    // 2. create the branch node
    HBox box = new HBox(10, firstNumberLbl, firstNumberTf, secondNumberLbl, 
    secondNumberTf, operationLbl, addBtn, subBtn, mulBtn, divBtn, resultLbl, resultTf);
    box.setAlignment(Pos.CENTER);


    // 3. set the scene, show the stage
    stage.setScene(new Scene(box));
    stage.setTitle("Calculator");
    stage.show();

    //  5. Define event Handlers
    addBtn.setOnAction(new AddHandler());

    }

    //1. Event Handler for Addbtn using inner class.
    private class AddHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            setResult(getFirstNumber() + getSecondNumber());
        }
    }


        //  4. Getters and Setters
    public int getFirstNumber() {
        return Integer.parseInt(firstNumberTf.getText());
    }
    
    public int getSecondNumber() {
        return Integer.parseInt(secondNumberTf.getText());
    }
    
    public void setResult(int value) {
        resultTf.setText(String.valueOf(value));
    }
   }