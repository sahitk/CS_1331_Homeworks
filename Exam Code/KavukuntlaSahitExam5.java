import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
import javafx.scene.shape.Circle;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Spinner;

public class KavukuntlaSahitExam5 extends Application {
	public void start(Stage stage) {
		stage.setTitle("1331 Exam 5 - SAHITKAVUKUNTLA");
		VBox vbox = new VBox(5);
		vbox.setPrefSize(300, 300);
		Label label = new Label("The color of this text changes!");
		Button button = new Button("This is how you change the color!");
		HBox hbox = new HBox();
		StackPane sPane = new StackPane();
		sPane.setPadding(new Insets(5, 5, 5, 5));
		Circle circle = new Circle(20, Color.BLUE);
		VBox radio = new VBox(20);
		RadioButton top = new RadioButton("Top");
		RadioButton mid = new RadioButton("Center");
		RadioButton bot = new RadioButton("Bottom");
		radio.getChildren().addAll(top, mid, bot);

		ToggleGroup group = new ToggleGroup();
		top.setToggleGroup(group);
		mid.setToggleGroup(group);
		bot.setToggleGroup(group);

		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
            public void handle(ActionEvent e) {
                if(label.getTextFill().equals(Color.web("#000000"))) {
                	//label.setStyle("-fx-color: #800080");
                	label.setTextFill(Color.web("#800080"));
                } else {
                	//label.setStyle("-fx-color: #000000");
                	label.setTextFill(Color.web("#000000"));
                }
            }
        });

		top.setOnAction(e -> {
			if (top.isSelected()) {
				sPane.setAlignment(circle, Pos.TOP_CENTER);
			}
		});
		mid.setOnAction(e -> {
			if (mid.isSelected()) {
				sPane.setAlignment(circle, Pos.CENTER);
			}
		});
		bot.setOnAction(e -> {
			if (bot.isSelected()) {
				sPane.setAlignment(circle, Pos.BOTTOM_CENTER);
			}
		});

		Spinner opac = new Spinner(0.0, 1.0, 1.0, 0.05);

		sPane.getChildren().addAll(circle);
		hbox.getChildren().addAll(sPane, radio);
		vbox.getChildren().addAll(label, button, hbox, opac);
		vbox.setAlignment(Pos.CENTER);
		hbox.setAlignment(Pos.CENTER);

		opac.setOnMouseClicked(e -> {
			circle.opacityProperty().set((double) opac.getValue());
		});

		Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.show();


	}
}