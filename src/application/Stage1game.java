package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Stage1game extends Application {
	private int WINDOW_WIDTH = 800;
	private int WINDOW_HEIGHT = 570;
    private wordSelector selector = new wordSelector();
    private StackPane root = new StackPane();

    public void start(Stage stage1) throws Exception {

    	Button lastStage = new Button("上一模块");
		Button nextStage = new Button("下一模块");
		Button returnmenu = new Button("返回主界面");


		lastStage.setPrefHeight(30);
		nextStage.setPrefHeight(30);

		Image back = new Image("image/scene1.jpeg");
		ImageView view = new ImageView(back);

    	Text Tip = new Text("欢迎来到拼音记忆模块，屏幕下方会随机出现不同的汉" + "\n" +"语拼音，请通过在键盘上打出所显示的拼音来把它消除");

    	StackPane root = new StackPane();
        HBox tip = new HBox();
        HBox jump = new HBox(50);
        VBox mainPane = new VBox(30);
        tip.setAlignment(Pos.CENTER);
        jump.setAlignment(Pos.CENTER);
        mainPane.setAlignment(Pos.CENTER);



        lastStage.setOnMouseClicked(e->{
        	Alert warning =  new Alert(AlertType.WARNING,"已经是第一模块！");
        	warning.show();
		});
		nextStage.setOnMouseClicked(e->{
			Stage2question stage2 = new Stage2question();
			try {
				stage2.start(new Stage());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			stage1.close();

		});
		returnmenu.setOnMouseClicked(e->{
			MainStage mainStage = new MainStage();
			try {
				mainStage.start(new Stage());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			stage1.hide();

		});


        tip.getChildren().addAll(Tip);
        jump.getChildren().addAll(lastStage,nextStage,returnmenu);
        mainPane.getChildren().addAll(tip,createContent(),jump);
        root.getChildren().add(view);
        root.getChildren().add(mainPane);
        mainPane.setPadding(new Insets(20,20,20,20));
        Scene scene = new Scene(root,WINDOW_WIDTH,WINDOW_HEIGHT);
        scene.getStylesheets().add(show1.class.getResource("../css/stage1.css").toExternalForm());
        tip.setId("font");;
        scene.setOnKeyPressed(e -> onKeyPress(e.getCode().toString()));
        stage1.setScene(scene);
        stage1.initStyle(StageStyle.UTILITY);
        stage1.setTitle("拼音小达人");
        stage1.show();
        }
    private Parent createContent() {
        root.setPrefSize(600, 280);
        root.setAlignment(Pos.CENTER);
        showNextWord();
        return root;
    }

    private void showNextWord() {
        String word = selector.getNextWord();

        WordView view = new WordView(word);

        root.getChildren().setAll(view);


    }

    private void onKeyPress(String letter) {
        WordView view = (WordView) root.getChildren().get(0);

        view.handleKeyPress(letter);
        if (view.isFinished()) {
            showNextWord();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}

