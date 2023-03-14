import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application
{
   

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
         try{
            System.out.println("OK");
       // Stage stage= new Stage();
        Parent root=FXMLLoader.load(getClass().getResource("trial.fxml"));
        Image icon=new Image("manchester-city.png");
        stage.getIcons().add(icon);
        stage.setTitle("Manchester City!");
        stage.setWidth(1350);
        stage.setHeight(750);
        stage.setResizable(false);
        stage.setFullScreen(false);
        stage.setFullScreenExitHint("");
        stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("q"));

       // Group root =new Group();
        Scene scene =new Scene(root,Color.BLACK);
      //  root.getChildren().add(text);
        // Image image = new Image("cubes.png"); // for setting image on a stage
        // ImageView imgview=new ImageView(image);
        // imgview.setX(400);
        // imgview.setY(400);
        // imgview.setFitWidth(200);
        // imgview.setFitHeight(200);
          
     
      //  root.getChildren().add(imgview);
        stage.setScene(scene);
        System.out.println("OK");
        stage.show();
    }
        catch(Exception e)
        {
            e.printStackTrace();  
        }
    }
  
}
