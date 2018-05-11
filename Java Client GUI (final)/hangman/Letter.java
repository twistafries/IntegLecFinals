/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import javafx.animation.RotateTransition;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

/**
 *
 * @author asus
 */
public class Letter extends StackPane {
    private static final Font TEXT_FONT = new Font("System", 24);
    private Rectangle textBox = new Rectangle(40, 50);
    private Text text;
    
    public Letter(String letter) {
        textBox.setFill(Color.WHITE);
        textBox.setStroke(Color.GRAY);
        
        text = new Text(String.valueOf(letter).toUpperCase());
        text.setFont(TEXT_FONT);
        text.setVisible(false);
        
        setAlignment(Pos.CENTER);
        getChildren().addAll(textBox, text);
    }
    
    public void show() {
        RotateTransition rotation = new RotateTransition(Duration.seconds(0.6), textBox);
        rotation.setAxis(Rotate.X_AXIS);
        rotation.setToAngle(180.0);
        rotation.setOnFinished(e -> text.setVisible(true));
        rotation.play();
    }
    
    public boolean isEqual(String guess) {
        return text.getText().equalsIgnoreCase(String.valueOf(guess));
    }
    
    public boolean isGuessedRight() {
        return text.isVisible();
    }
}
