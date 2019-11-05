package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import static javafx.stage.StageStyle.DECORATED;
import static javafx.stage.StageStyle.UNDECORATED;
import static javafx.stage.StageStyle.TRANSPARENT;
import static javafx.stage.StageStyle.UNIFIED;
import static javafx.stage.StageStyle.UTILITY;
public class ScreenDetailsApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//       ObservableList<Screen> screenList = Screen.getScreens();
//        System.out.println("Screens count: " + screenList.size());
//
//        // print details
//        for(Screen screen: screenList){
//            print(screen);
//        }

//        Platform.exit();
//        primaryStage.setTitle("Blank Stage with empty scene");
//        Scene scene = new Scene(new Group());
//        Group root = new Group(new Button("Hello"));
//        Scene scene = new Scene(root, 300,100);
//        primaryStage.setScene(scene);
//        // Wrong!!!! Use the logic shown below after the stage.show() call
//        // At this point, stage width and height are not known. They are NaN.
//        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
//        double x = bounds.getMinX() + (bounds.getWidth() - primaryStage.getWidth())/2.0;
//        double y = bounds.getMinY() + (bounds.getHeight() - primaryStage.getHeight())/2.0;
//        primaryStage.setX(x);
//        primaryStage.setY(y);
//
//        primaryStage.close(); // Close the only stage you hava       primaryStage.show();
////        // Right!!!! Use the logic shown below after the stage.show() call
////        // At this point, stage width and height are not known. They are NaN.
////        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
////        double x = bounds.getMinX() + (bounds.getWidth() - primaryStage.getWidth())/2.0;
////        double y = bounds.getMinY() + (bounds.getHeight() - primaryStage.getHeight())/2.0;
////        primaryStage.setX(x);
////        primaryStage.setY(y);
        // A label to display the style type
        Label styleLabel = new Label("Stage Style");
// A button to close the stage
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> primaryStage.close());
        VBox root = new VBox();
        root.getChildren().addAll(styleLabel, closeButton);
        Scene scene = new Scene(root, 100, 70);
        primaryStage.setScene(scene);
// The title of the stage is not visible for all styles.
        primaryStage.setTitle("The Style of a Stage");
        /* Uncomment one of the following statements at a time */
//        this.show(primaryStage, styleLabel, DECORATED);
//        this.show(primaryStage, styleLabel, UNDECORATED);
//        this.show(primaryStage, styleLabel, TRANSPARENT);
//        this.show(primaryStage, styleLabel, UNIFIED);
        this.show(primaryStage, styleLabel, UTILITY);
    }

    private void show(Stage primaryStage, Label styleLabel, StageStyle style) {
        // Set the text for the label to match the style
        styleLabel.setText(style.toString());
// Set the style
        primaryStage.initStyle(style);
// For a transparent style, set the scene fill to null. Otherwise, the
// content area will have the default white background of the scene.
        if (style == TRANSPARENT) {
            primaryStage.getScene().setFill(null);
            primaryStage.getScene().getRoot().setStyle(
                    "-fx-background-color: transparent");
        } else if(style == UNIFIED) {
            primaryStage.getScene().setFill(Color.TRANSPARENT);
        }
// Show the stage
        primaryStage.show();
    }

    public void print(Screen s){
        System.out.println("DPI: "+s.getDpi());
        System.out.print("Screen bounds:");
        Rectangle2D bounds = s.getBounds();
        print(bounds);
        Rectangle2D visualBounds = s.getVisualBounds();
        print(visualBounds);
        System.out.println("----------------------------");
    }
    public void print(Rectangle2D r) {
        System.out.format("minX=%.2f, minY=%.2f, width=%.2f, height=%.2f%n",
                r.getMinX(), r.getMinY(), r.getWidth(), r.getHeight());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
