//I worked on the homework assignment alone, using only course materials.

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
* class that creates and manages Starbase GUI.
* @author Sahit Kavukuntla
* @version 1.0
*/
public class Starbase extends Application {

    /**
    * method to create and run Starbase GUI.
    * @param stage the stage to display the starbase
    */
    public void start(Stage stage) {
        //title
        stage.setTitle("Starbase Command");

        //label the field
        Label label = new Label("Welcome to Starbase 1331!");
        Font font = Font.font("Times New Roman", 50);
        label.setFont(font);
        label.setTextFill(Color.WHITE);
        label.setTranslateY(25);

        //text box insert starship name
        TextField textfield = new TextField();
        textfield.setPromptText("Starship Name");

        //button to insert ship
        Button dockingButton = new Button("Request Docking Clearance");
        //dropdown for type of ship
        ComboBox shipType = new ComboBox();
        shipType.getItems().addAll(Starship.DEFIANT, Starship.INTREPID, Starship.CONSTITUTION, Starship.GALAXY);
        //button to clear docks
        Button evacButton = new Button("Evacuate!");
        evacButton.setStyle("-fx-background-color: #FF0000");

        Image image = new Image("space.jpg");
        ImageView imageView = new ImageView(image);

        StackPane sPane = new StackPane();
        BorderPane bPane = new BorderPane();

        sPane.getChildren().addAll(imageView, bPane);

        GridPane gPane = new GridPane();
        gPane.setAlignment(Pos.CENTER);
        gPane.setVgap(50);
        gPane.setHgap(50);

        HBox hBox = new HBox(25);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(0, 0, 50, 0));

        bPane.setTop(label);
        bPane.setAlignment(label, Pos.CENTER);
        bPane.setCenter(gPane);
        bPane.setBottom(hBox);

        //gridpane elements: docks
        Button dock1 = new Button("EMPTY");
        gPane.add(dock1, 0, 0);
        Button dock2 = new Button("EMPTY");
        gPane.add(dock2, 1, 0);
        Button dock3 = new Button("EMPTY");
        gPane.add(dock3, 2, 0);
        Button dock4 = new Button("EMPTY");
        gPane.add(dock4, 3, 0);
        Button dock5 = new Button("EMPTY");
        gPane.add(dock5, 0, 1);
        Button dock6 = new Button("EMPTY");
        gPane.add(dock6, 1, 1);
        Button dock7 = new Button("EMPTY");
        gPane.add(dock7, 2, 1);
        Button dock8 = new Button("EMPTY");
        gPane.add(dock8, 3, 1);

        Button[] buttonList = new Button[]{dock1, dock2, dock3, dock4, dock5, dock6, dock7, dock8};
        for (Button dock:buttonList) {
            dock.setPrefSize(150, 150);
            dock.setStyle("-fx-background-color: #006400; -fx-font-size: 2em");
        }

        EventHandler<ActionEvent> dockingEvent = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                String type = shipType.getValue().toString();
                shipType.setValue(null);
                int i = add(buttonList, textfield.getText(), type);
                textfield.clear();
                if (i > -1) {
                    buttonList[i].setStyle("-fx-background-color: #808080;-fx-text-fill: #FFFFFF");
                } else {
                    Alert a = new Alert(AlertType.WARNING);
                    String name;
                    if (textfield.getText().equals("")) {
                        name = "Unnamed Ship";
                    } else {
                        name = textfield.getText();
                    }
                    a.setContentText(String.format("%s did not receive docking clearance!", name));
                    a.show();
                }
            }
        };
        EventHandler<ActionEvent> evacEvent = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                for (int i = 0; i < buttonList.length; i++) {
                    resetToEmpty(buttonList[i]);
                }
            }
        };

        dock1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                resetToEmpty(dock1);
            }
        });
        dock2.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                resetToEmpty(dock2);
            }
        });
        dock3.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                resetToEmpty(dock3);
            }
        });
        dock4.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                resetToEmpty(dock4);
            }
        });
        dock5.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                resetToEmpty(dock5);
            }
        });
        dock6.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                resetToEmpty(dock6);
            }
        });
        dock7.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                resetToEmpty(dock7);
            }
        });
        dock8.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                resetToEmpty(dock8);
            }
        });

        // when buttons are pressed
        dockingButton.setOnAction(dockingEvent);
        evacButton.setOnAction(evacEvent);

        hBox.getChildren().addAll(textfield, shipType, dockingButton, evacButton);

        Scene scene = new Scene(sPane);
        stage.setScene(scene);
        stage.show();
    }

    /**
    * method to reset a dock to empty state.
    * @param button the button dock to reset
    */
    public void resetToEmpty(Button button) {
        button.setText("EMPTY");
        button.setStyle("-fx-background-color: #006400; -fx-font-size: 2em");
    }

    /**
    * method to add a starship to the next empty dock.
    * @param list list of docks
    * @param shipName name of ship
    * @param shipType type of ship
    * @return index of dock where ship was added, or -1 if all docks full
    */
    public int add(Button[] list, String shipName, String shipType) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].getText().equals("EMPTY")) {
                list[i].setText(String.format("%s%n%s", shipName, shipType));
                return i;
            }
        }
        return -1;
    }
}

//to do: clear wildcard imports
//how: delete each import, find errors, import those symbols specifically

//to compile: javac --module-path javafx-sdk-11.0.2/lib --add-modules=javafx.controls Starbase.java
//compile w/ warnings: javac -Xlint:unchecked --module-path javafx-sdk-11.0.2/lib
// --add-modules=javafx.controls Starbase.java
//to run: java --module-path javafx-sdk-11.0.2/lib --add-modules=javafx.controls Starbase