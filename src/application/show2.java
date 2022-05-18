package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class show2 extends Application {
private int WINDOW_WIDTH = 700;
private int WINDOW_HEIGHT = 500;

	@Override
	public void start(Stage showStage2  ) throws Exception {
try{
		StackPane root = new StackPane();
		BorderPane mainPane = new BorderPane();



		Image back = new Image("image/show2.jpeg");
		ImageView view = new ImageView(back);




		HBox button = new HBox(50);
		Label title = new Label("《楚辞▪离骚》(节选)");
		Text display = new Text();


		Button last = new Button("上一首");
		Button next = new Button("下一首");
		Button play = new Button("播放");
		Button pause = new Button("暂停");
		Button rtn = new Button("返回");
		button.setAlignment(Pos.CENTER);
		BorderPane.setAlignment(title, Pos.CENTER);
		BorderPane.setAlignment(button,Pos.CENTER);
		BorderPane.setAlignment(display,  Pos.CENTER);
		Insets padding = new Insets(20,20,20,20);
		title.setPadding(padding);
		button.setPadding(padding);



		File file = new File("audio/play2.mp3");
    	Media media = new Media(file.toURI().toString());
    	MediaPlayer player = new MediaPlayer(media);


		StringBuffer buffer = new StringBuffer();
        BufferedReader bf= new BufferedReader(new FileReader("txt/show2.txt"));
        String s = null;
        while((s = bf.readLine())!=null){//使用readLine方法，一次读一行
            buffer.append(s.trim());
            buffer.append('\n');
        }
        bf.close();
        String xml = buffer.toString();
        display.setText(xml);




        last.setOnMouseClicked(e->{
        	 show1 showStage1 = new show1();
    		 try {
    			 player.stop();
				showStage1.start(new Stage());

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		 showStage2.close();
	});

    	play.setOnMouseClicked(e->{
    	player.play();
	});
    	 next.setOnMouseClicked(e->{
    		 show3 showStage3 = new show3();
    		 try {
    			 player.stop();
				showStage3.start(new Stage());

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		 showStage2.close();
 	});
    	 rtn.setOnMouseClicked(e->{
    		 Stage4show Stage4 = new Stage4show();
    		 try {
    			 player.stop();
				Stage4.start(new Stage());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		 showStage2.close();

 	});
    	 pause.setOnMouseClicked(e->{
    		 player.pause();;
    	 	});

        button.getChildren().addAll(last,play,pause,next,rtn);
        mainPane.setTop(title);
        mainPane.setCenter(display);
        mainPane.setBottom(button);
        root.getChildren().add(view);
        root.getChildren().add(mainPane);







        Scene showScene2 = new Scene(root,WINDOW_WIDTH,WINDOW_HEIGHT);


        showScene2.getStylesheets().add(show1.class.getResource("../css/show2.css").toExternalForm());
        root.getStyleClass().add("image");
        title.getStyleClass().add("lable");
        display.setId("font");
        showStage2.setTitle("经典咏流传");
        showStage2.setScene(showScene2);
        showStage2.setResizable(false);
        showStage2.initStyle(StageStyle.UTILITY);
        showStage2.show();
	}catch(Exception e) {
		e.printStackTrace();
	}


	}
	public static void main(String[] args){
		launch(args);
	}


}
