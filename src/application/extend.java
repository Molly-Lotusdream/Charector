package application;

import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class extend extends Application {
	private int WINDOW_WIDTH = 800;
	private int WINDOW_HEIGHT = 570;
	private int Score = 0;
	public void start(Stage stage) {
		try{
			StackPane root = new StackPane(new ImageView(new Image("image/Scene3.jpeg")));
			VBox main = new VBox(20);
			Pane image = new Pane();
			GridPane guess = new GridPane();
			VBox choose = new VBox(20);
			VBox score = new VBox(8);
			HBox top = new HBox();
			HBox bottom = new HBox();
			guess.setAlignment(Pos.CENTER);
			choose.setAlignment(Pos.CENTER);
			score.setAlignment(Pos.CENTER);
			top.setAlignment(Pos.CENTER);
			bottom.setAlignment(Pos.CENTER);

			Image show = new Image("image/guess_high.jpg");
			ImageView view = new ImageView(show);

			TextField blank00  =new TextField();
			TextField blank01  =new TextField();
			TextField blank02  =new TextField();
			TextField blank10  =new TextField();
			TextField blank11  =new TextField();
			TextField blank12  =new TextField();
			TextField blank20  =new TextField();
			TextField blank21  =new TextField();
			TextField blank22  =new TextField();



			Text bingo = new Text("本轮猜对成语个数：" + String.valueOf(Score));

			Button retrn = new Button("返回");


			guess.add(blank00, 0, 0);
			guess.add(blank01, 0, 1);
			guess.add(blank02, 0, 2);
			guess.add(blank10, 1,0);
			guess.add(blank11, 1,1 );
			guess.add(blank12, 1, 2);
			guess.add(blank20, 2, 0);
			guess.add(blank21, 2, 1);
			guess.add(blank22, 2, 2);
			image.getChildren().add(view);
			choose.getChildren().addAll(retrn);
			score.getChildren().add(bingo);
			top.getChildren().addAll(image,score);
			bottom.getChildren().addAll(guess,choose);
			main.getChildren().addAll(top,bottom);
			root.getChildren().addAll(main);
			image.setTranslateX(-40);
			image.setTranslateY(80);
			guess.setTranslateX(-120);
			guess.setTranslateY(90);
			bingo.setTranslateX(65);
			bingo.setTranslateY(90);
			choose.setTranslateX(120);
			choose.setTranslateY(140);

			Timer timer = new Timer();
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					Score =0;
					// TODO Auto-generated method stub
					if(blank00.getText().equals("吉星高照")){
						Score+=1;
						blank00.setEditable(false);
						bingo.setText("本轮猜对成语个数：" + String.valueOf(Score));

					}
					if(blank10.getText().equals("一五一十")){
						Score+=1;
						blank10.setEditable(false);
						bingo.setText("本轮猜对成语个数：" + String.valueOf(Score));
					}
					if(blank20.getText().equals("大吃一惊")){
						Score+=1;
						blank20.setEditable(false);
						bingo.setText("本轮猜对成语个数：" + String.valueOf(Score));
					}
					if(blank01.getText().equals("交头接耳")){
						Score+=1;
						blank01.setEditable(false);
						bingo.setText("本轮猜对成语个数：" + String.valueOf(Score));

					}
					if(blank11.getText().equals("理屈词穷")){
						Score+=1;
						blank11.setEditable(false);
						bingo.setText("本轮猜对成语个数：" + String.valueOf(Score));
					}
					if(blank21.getText().equals("水火不容")){
						Score+=1;
						blank21.setEditable(false);
						bingo.setText("本轮猜对成语个数：" + String.valueOf(Score));
					}
					if(blank02.getText().equals("篝火狐鸣")){
						Score+=1;
						blank02.setEditable(false);
						bingo.setText("本轮猜对成语个数：" + String.valueOf(Score));

					}
					if(blank12.getText().equals("杳如黄鹤")){
						Score+=1;
						blank12.setEditable(false);
						bingo.setText("本轮猜对成语个数：" + String.valueOf(Score));
					}
					if(blank22.getText().equals("摇尾乞怜")){
						Score+=1;
						blank22.setEditable(false);
						bingo.setText("本轮猜对成语个数：" + String.valueOf(Score));
					}
					if(Score==9){
						timer.cancel();
					}



				}
			}, 100,100);

			if(Score == 9){

			}




			retrn.setOnMouseClicked(e->{
				Stage3guess stage3 = new Stage3guess();
				try {

					stage3.start(new Stage());
					stage.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			});

			Scene scene = new Scene(root,WINDOW_WIDTH,WINDOW_HEIGHT);
			stage.setTitle("看图猜成语");
			scene.getStylesheets().add(show1.class.getResource("../css/stage3.css").toExternalForm());
			stage.setScene(scene);
			stage.initStyle(StageStyle.UTILITY);
			blank00.setId("font");
			blank01.setId("font");
			blank02.setId("font");
			blank10.setId("font");
			blank11.setId("font");
			blank12.setId("font");
			blank20.setId("font");
			blank21.setId("font");
			blank22.setId("font");
			bingo.getStyleClass().add("lable");
			guess.getStyleClass().add("lable");
			stage.setResizable(false);
			stage.show();


		}catch(Exception e) {
			e.printStackTrace();
		}



	}


	public static void main(String[] args){
		launch(args);
	}

}
