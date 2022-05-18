package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainStage extends Application{
	private int WINDOW_WIDTH = 600;
	private int WINDOW_HEIGHT = 400;

	private Text user;
	public void setUser(String trans) {
		user.setText(trans + ",你好！");
	}




	@Override
	public void start(Stage mainStage) throws Exception {
	try{
		StackPane root = new StackPane();
		VBox vPane = new VBox(5);
		vPane.setAlignment(Pos.CENTER);
		Image back = new Image("image/scene.jpeg");
		ImageView view = new ImageView(back);

		Button into1 = new Button("拼音小达人");
		Button into2 = new Button("忆汉字常识");
		Button into3 = new Button("看图猜成语");
		Button into4 = new Button("经典咏流传");
		Button returnLogin = new Button("返回登录界面");
		user = new Text();
		Text welcome = new Text();
		welcome.setText("\n" + "\n" + "欢迎来到\"学汉语用汉字，弘扬汉语言文化\"主题知识学习"+"\n" +"选择你喜欢的模块进入学习吧！");

		Insets padding = new Insets(8,20,8,20);
		into1.setPadding(padding);
		into2.setPadding(padding);
		into3.setPadding(padding);
		into4.setPadding(padding);
		welcome.setTranslateY(-40);
		returnLogin.setTranslateY(20);

		vPane.getChildren().addAll(user,welcome,into1,into2,into3,into4,returnLogin);
		root.getChildren().add(view);
	    root.getChildren().add(vPane);


		returnLogin.setPadding(padding);
		into1.setOnMouseClicked(e->{
			try {
				Stage1game Stage1 = new Stage1game();
				Stage1.start(new Stage());
					mainStage.close();


			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		into2.setOnMouseClicked(e->{
			try {
				Stage2question Stage2 = new Stage2question();
				Stage2.start(new Stage());
				mainStage.close();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		into3.setOnMouseClicked(e->{
			try {
				Stage3guess Stage3 = new Stage3guess();
				Stage3.start(new Stage());
				mainStage.close();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		into4.setOnMouseClicked(e->{
			try {
				Stage4show Stage4 = new Stage4show();
				Stage4.start(new Stage());
				mainStage.close();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		returnLogin.setOnMouseClicked(e->{

			try {
				LoginInterface loginStage = new LoginInterface();
				loginStage.start(new Stage());

				mainStage.close();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		});


		Scene mainScene = new Scene(root,WINDOW_WIDTH,WINDOW_HEIGHT);
		mainStage.setTitle("学汉语用汉字，弘扬汉语言文化");
		mainScene.getStylesheets().add(show1.class.getResource("../css/menu.css").toExternalForm());
		root.getStyleClass().add("image");
		user.setId("font");
	    welcome.setId("font");
	    into1.getStyleClass().add("button");
	    into2.getStyleClass().add("button");
	    into3.getStyleClass().add("button");
	    into4.getStyleClass().add("button");
		returnLogin.getStyleClass().add("button");
		mainStage.setScene(mainScene);
		mainStage.initStyle(StageStyle.UTILITY);
		mainStage.setResizable(false);
		mainStage.show();
	}catch(Exception e) {
		e.printStackTrace();
	}
	}




public static void main(String[] args){
	launch(args);
}

}
