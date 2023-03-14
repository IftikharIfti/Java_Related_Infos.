import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;

public class fxctrl {
    @FXML
    private Circle myCircle;
    private double x;
    private double y;
     @FXML
    void down(ActionEvent event) {
    System.out.println("DOWN");
    myCircle.setCenterY(y+=10);
    }

    @FXML
    void left(ActionEvent event) {
    System.out.println("LEFT");
    myCircle.setCenterX(x-=10);
    }

    @FXML
    void right(ActionEvent event) {
System.out.println("RIGHT");
myCircle.setCenterX(x+=10);
    }

    @FXML
    void up(ActionEvent event) {
  System.out.println("UP");
  myCircle.setCenterY(y-=10);
    }

}
