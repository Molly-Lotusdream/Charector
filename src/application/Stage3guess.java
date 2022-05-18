package application;

import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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

public class Stage3guess extends Application {
	private int WINDOW_WIDTH = 800;
	private int WINDOW_HEIGHT = 570;
	private int Score = 0;
	public void start(Stage stage3) {
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

			Image show = new Image("image/guess.jpg");
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

			Button retrn = new Button("返回主界面");
			Button lastStage = new Button("上一模块");
			Button nextStage = new Button("下一模块");
			Button extend = new Button("挑战更高难度");

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
			choose.getChildren().addAll(extend,lastStage,nextStage);
			score.getChildren().add(bingo);
			top.getChildren().addAll(image,score);
			bottom.getChildren().addAll(guess,choose);
			main.getChildren().addAll(top,bottom);
			root.getChildren().addAll(main);
			image.setTranslateX(-50);
			image.setTranslateY(-20);
			guess.setTranslateX(-90);
			guess.setTranslateY(-20);
			bingo.setTranslateX(65);
			bingo.setTranslateY(50);
			choose.setTranslateY(-50);

			Timer timer = new Timer();
			timer.schedule(new TimerTask() {

				@Override
				public void run() {
					Score =0;
					// TODO Auto-generated method stub
					if(blank00.getText().equals("不堪入目")){
						Score+=1;
						blank00.setEditable(false);
						bingo.setText("本轮猜对成语个数：" + String.valueOf(Score));

					}
					if(blank10.getText().equals("万人空巷")){
						Score+=1;
						blank10.setEditable(false);
						bingo.setText("本轮猜对成语个数：" + String.valueOf(Score));
					}
					if(blank20.getText().equals("倒背如流")){
						Score+=1;
						blank20.setEditable(false);
						bingo.setText("本轮猜对成语个数：" + String.valueOf(Score));
					}
					if(blank01.getText().equals("萍水相逢")){
						Score+=1;
						blank01.setEditable(false);
						bingo.setText("本轮猜对成语个数：" + String.valueOf(Score));

					}
					if(blank11.getText().equals("不可思议")){
						Score+=1;
						blank11.setEditable(false);
						bingo.setText("本轮猜对成语个数：" + String.valueOf(Score));
					}
					if(blank21.getText().equals("胜券在握")){
						Score+=1;
						blank21.setEditable(false);
						bingo.setText("本轮猜对成语个数：" + String.valueOf(Score));
					}
					if(blank02.getText().equals("堤溃蚁穴")){
						Score+=1;
						blank02.setEditable(false);
						bingo.setText("本轮猜对成语个数：" + String.valueOf(Score));

					}
					if(blank12.getText().equals("情窦初开")){
						Score+=1;
						blank12.setEditable(false);
						bingo.setText("本轮猜对成语个数：" + String.valueOf(Score));
					}
					if(blank22.getText().equals("藕断丝连")){
						Score+=1;
						blank22.setEditable(false);
						bingo.setText("本轮猜对成语个数：" + String.valueOf(Score));
					}
					if(Score==9){
						timer.cancel();
					}
				}
			}, 100,100);
			if(Score==9){
				Alert full = new Alert(AlertType.INFORMATION);
			full.setHeaderText("恭喜你已完成所有题目！");
			full.setTitle("全部猜对");
			full.show();
			}



			lastStage.setOnMouseClicked(e->{
				Stage2question stage2 = new Stage2question();
				try {
					stage2.start(new Stage());
					stage3.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}


			});
			nextStage.setOnMouseClicked(e->{
				Stage4show stage4 = new Stage4show();
				try {
					stage4.start(new Stage());
					stage3.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}


			});
			retrn.setOnMouseClicked(e->{
				MainStage mainStage = new MainStage();
				try {
					mainStage.start(new Stage());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				stage3.hide();

			});
			extend.setOnMouseClicked(e->{
				extend stage = new extend();
				try {
					stage.start(new Stage());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				stage3.close();

			});






			Scene scene3 = new Scene(root,WINDOW_WIDTH,WINDOW_HEIGHT);
			stage3.setTitle("看图猜成语");
			scene3.getStylesheets().add(show1.class.getResource("../css/stage3.css").toExternalForm());
			stage3.setScene(scene3);
			stage3.initStyle(StageStyle.UTILITY);
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
			stage3.setResizable(false);
			stage3.show();


		}catch(Exception e) {
			e.printStackTrace();
		}



	}


	public static void main(String[] args){
		launch(args);
	}

}
