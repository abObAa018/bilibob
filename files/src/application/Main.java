package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.Arrays;
import java.util.List;

public class Main extends Application {

    private TextField resultField;

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();

        resultField = new TextField();
        resultField.setEditable(false);
        grid.add(resultField, 0, 0, 4, 1);

        String[] buttons = {"A", "B", "C", "Y", "Z", "X", "0", "1", "∧", "V", "→", "⇔", "⊕", "¬", "=", "⌫", "(", ")"};
        List<String> buttonList = Arrays.asList(buttons);

        int row = 1;
        int col = 0;
        for (String buttonText : buttonList) {
            Button button = new Button(buttonText);
            button.setMinSize(50, 50);
            button.setOnAction(e -> handleButtonClick(buttonText));
            grid.add(button, col, row);

            col++;
            if (col == 4) {
                col = 0;
                row++;
            }
        }

        Scene scene = new Scene(grid, 250, 300);
        primaryStage.setTitle("Logical Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public class BooleanExpression {
        private String expression;

        public BooleanExpression(String expression) {
            this.expression = expression;
        }

        public String getExpression() {
            return expression;
        }
    }
    public class BooleanEvaluator {
        public boolean evaluate(BooleanExpression expression) {
            
            String expr = expression.getExpression();
            if (expr.equals("A ∧ B")) {
                return true; 
            } else if (expr.equals("A V B")) {
                return true; 
            } else {
                return false; 
            }
        }
    }


    private void handleButtonClick(String buttonText) {
        String currentExpression = resultField.getText();

        switch (buttonText) {
            case "=":
                BooleanExpression expression = new BooleanExpression(currentExpression);
                BooleanEvaluator evaluator = new BooleanEvaluator();
                boolean result = evaluator.evaluate(expression);
                resultField.setText(String.valueOf(result));
                break;
            case "⌫":
                resultField.clear();
                break;
            default:
                resultField.appendText(buttonText);
                break;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}





