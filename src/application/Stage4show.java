package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Optional;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Stage4show extends Application {
private int WINDOW_WIDTH = 800;
private int WINDOW_HEIGHT = 570;
	@Override
public void start(Stage stage4) throws Exception {
	try{

		StackPane root = new StackPane();
		HBox tip = new HBox();
		HBox select = new HBox(50);
		HBox show1 = new HBox(20);
		HBox show2 = new HBox(20);
		VBox mainPane = new VBox(80);
		Text welcome = new Text();
		Button last = new Button("上一模块");
		Button next = new Button("下一模块");
		Button returnmenu = new Button("返回主界面");
		Text s1 = new Text("《诗经》");
		Text s2 = new Text("《楚辞》");
		Text s3 = new Text("汉乐府诗");
		Text s4 = new Text("魏晋南北朝民歌");
		Text s5 = new Text("唐诗");
		Text s6 = new Text("宋词");
		Text s7 = new Text("元诗");
		Text s8 = new Text("明清诗歌");
		Text s9 = new Text("现代诗、新诗");
		Image image = new Image("image/scene4.jpeg");
		ImageView view = new ImageView(image);
		select.setAlignment(Pos.BOTTOM_CENTER);
		tip.setAlignment(Pos.CENTER);
		show1.setAlignment(Pos.CENTER);
		show2.setAlignment(Pos.CENTER);
		mainPane.setAlignment(Pos.CENTER);
		mainPane.setPadding(new Insets(60,20,40,20));


		StringBuffer buffer = new StringBuffer();
        BufferedReader bf= new BufferedReader(new FileReader("txt/introduction4.txt"));
        String s = null;
        while((s = bf.readLine())!=null){//使用readLine方法，一次读一行
            buffer.append(s.trim());
            buffer.append('\n');
        }
        bf.close();
        String xml = buffer.toString();
        welcome.setText(xml);

		s1.setOnMouseClicked(e->{
        	show1 showStage1 = new show1();
        	try {
				showStage1.start(new Stage());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	stage4.close();
	});
		s2.setOnMouseClicked(e->{
        	show2 showStage2 = new show2();
        	try {
				showStage2.start(new Stage());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	stage4.close();
	});
		s3.setOnMouseClicked(e->{
        	show3 showStage3 = new show3();
        	try {
				showStage3.start(new Stage());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	stage4.close();
	});
		s4.setOnMouseClicked(e->{
        	show4 showStage4 = new show4();
        	try {
				showStage4.start(new Stage());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	stage4.close();
	});
		s5.setOnMouseClicked(e->{
        	show5 showStage5 = new show5();
        	try {
				showStage5.start(new Stage());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	stage4.close();
	});
		s6.setOnMouseClicked(e->{
        	show6 showStage6 = new show6();
        	try {
				showStage6.start(new Stage());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	stage4.close();
	});
		s7.setOnMouseClicked(e->{
        	show7 showStage7 = new show7();
        	try {
				showStage7.start(new Stage());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	stage4.close();
	});
		s8.setOnMouseClicked(e->{
        	show8 showStage8 = new show8();
        	try {
				showStage8.start(new Stage());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	stage4.close();
	});
		s9.setOnMouseClicked(e->{
        	show9 showStage9 = new show9();
        	try {
				showStage9.start(new Stage());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	stage4.close();
	});
		returnmenu.setOnMouseClicked(e->{
			MainStage mainStage = new MainStage();
			try {
				mainStage.start(new Stage());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			stage4.hide();

		});

		last.setOnMouseClicked(e->{
			Stage3guess stage3 = new Stage3guess();
			try {

				stage3.start(new Stage());
				stage4.close();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		});
		next.setOnMouseClicked(e->{
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setTitle("已经是最后一个模块");
			alert.setHeaderText("当前已经是最后一个模块！" + "\n" +"是否切换至第一个模块？");
			Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {
					Stage1game stage1 = new Stage1game();
					try {

						stage1.start(new Stage());
						stage4.close();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					MainStage mainStage = new MainStage();
					try {
						mainStage.start(new Stage());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					stage4.close();
				}

		});

		tip.getChildren().add(welcome);
		select.getChildren().addAll(last,next,returnmenu);
		show1.getChildren().addAll(s1,s2,s3,s4,s5);
		show2.getChildren().addAll(s6,s7,s8,s9);
		mainPane.getChildren().addAll(welcome,show1,show2,select);
		root.getChildren().add(view);
		root.getChildren().add(mainPane);





		// TODO Auto-generated method stub

		Scene scene4 = new Scene(root,WINDOW_WIDTH,WINDOW_HEIGHT);
		stage4.setTitle("学汉语用汉字，弘扬汉语言文化");
		scene4.getStylesheets().add(show1.class.getResource("../css/stage4.css").toExternalForm());
		s1.setId("font");
		s2.setId("font");
		s3.setId("font");
		s4.setId("font");
		s5.setId("font");
		s6.setId("font");
		s7.setId("font");
		s8.setId("font");
		s9.setId("font");
		welcome.setId("lable");
		last.getStyleClass().add("button");
		next.getStyleClass().add("button");
		//returnmenu.getStyleClass().add("button");
		stage4.setScene(scene4);
		stage4.initStyle(StageStyle.UTILITY);
		stage4.setResizable(false);
		stage4.show();
	}catch(Exception e) {
		e.printStackTrace();
	}

	}
	public static void main(String[] args){
		launch(args);
	}


}
