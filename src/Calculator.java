import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
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
        operationLbl = new Label("Operation:");
        addBtn = new Button("+");
        subBtn = new Button("-");
        mulBtn = new Button("*");
        divBtn = new Button("/");
        resultLbl = new Label("Result:");
        resultTf = new TextField("");



    // 2. create the branch node
    //VBox box = new VBox(10, firstNumberLbl, firstNumberTf, secondNumberLbl, secondNumberTf, operationLbl, addBtn, subBtn, mulBtn, divBtn, resultLbl, resultTf);
    //box.setAlignment(Pos.CENTER);

    // 7 . Create gridpane to modify GUI layout
    GridPane gridPane = new GridPane();
    //There is no padding in lab image however earlier it says to make a vbox with 10 pixel  padding so im keeping this:
    gridPane.setPadding(new Insets(10,10,10,10)); //10 pixel padding
    //In lab instruction image there is no spacing however looks better with 10 pixels spacing.
    //gridPane.setHgap(10); //horizontal spacing
    //gridPane.setVgap(10); //vertical spacing
    gridPane.setAlignment(Pos.CENTER);
    //grid pane cell positions are like a matrix: 
    /*
     * 0,0 | 1,0 | 2,0
     * 0,1 | 1,1 | 2,1
     * 0,2 | 1,2 | 2,2
     */
    gridPane.add(firstNumberLbl,0,0);
    gridPane.add(firstNumberTf,1,0);

    gridPane.add(secondNumberLbl,0,1);
    gridPane.add(secondNumberTf,1,1);

    gridPane.add(operationLbl,0,2);
    HBox box = new HBox(10,addBtn,subBtn,mulBtn,divBtn); //Using hbox then add it to gridpane to get buttons next to each other.
    gridPane.add(box,1,2);

    gridPane.add(resultLbl, 0,3);
    gridPane.add(resultTf, 1,3);



    // 3. set the scene, show the stage
    stage.setScene(new Scene(gridPane));
    stage.setTitle("Calculator");
    stage.show();

    //  5. Define event Handlers
    addBtn.setOnAction(new AddHandler());

    //6. 2. Anonymous inner class subBtn
        subBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setResult(getFirstNumber() - getSecondNumber());
            }
        });

    //6. 3. Lambda expression mulBtn
    mulBtn.setOnAction(event -> setResult(getFirstNumber() * getSecondNumber()));
    
    //6. 4. Lambda expression divBtn
    divBtn.setOnAction(event -> setResult(getFirstNumber() / getSecondNumber()));

    }
    //6. 1. Event Handler for Addbtn using inner class.
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