package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Stage2question extends Application implements read {
	private int WINDOW_WIDTH = 800;
	private int WINDOW_HEIGHT = 570;
	private int score = 0;
	private int i = 0;
	private String[] ans = new String[10];
	@Override
public void start(Stage Stage2) throws Exception {
	try{

		StackPane root = new StackPane();
		VBox mainPane = new VBox(50);
		HBox tip = new HBox();
		HBox fill = new HBox();
		HBox blank = new HBox();
		HBox switchQuestion = new HBox(10);
		mainPane.setAlignment(Pos.CENTER);
		tip.setAlignment(Pos.CENTER);
		fill.setAlignment(Pos.CENTER);
		blank.setAlignment(Pos.CENTER);
		switchQuestion.setAlignment(Pos.CENTER);

		Text tip1 = new Text("");
		Text tip2 = new Text("请在此处输入你的答案：");
		Text question = new Text();

		TextField answer = new TextField();
		Image image = new Image("image/scene2.jpeg");
		ImageView view = new ImageView(image);
		Button submit = new Button("阅卷");
		Button nextQuestion = new Button("下一题");
		Button lastQuestion = new Button("上一题");
		Button lastStage = new Button("上一模块");
		Button nextStage = new Button("下一模块");
		Button returnmenu = new Button("返回主界面");

		tip.getChildren().addAll(tip1);
		fill.getChildren().addAll(question);
		blank.getChildren().addAll(tip2,answer);
		switchQuestion.getChildren().addAll(lastStage,lastQuestion,submit,nextQuestion,nextStage);
		mainPane.getChildren().addAll(tip,fill,blank,switchQuestion);
		root.getChildren().add(view);
		root.getChildren().add(mainPane);



		StringBuffer buffer = new StringBuffer();
        BufferedReader bf= new BufferedReader(new FileReader("txt/introduction2.txt"));
        String s = null;
        while((s = bf.readLine())!=null){//使用readLine方法，一次读一行
            buffer.append(s.trim());
            buffer.append('\n');
        }
        bf.close();
        String xml = buffer.toString();
        tip1.setText(xml);


		File f = new File("txt/fill.txt");
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(f));
		String[] ques = new String[10];

		for(i =0;i<10;i++){
			ques[i] = br.readLine();
			ans[i] = answer.getText();
		}//读取文件内容，放入数组中，实现上下题切换
		question.setText(ques[0]);


		lastStage.setOnMouseClicked(e->{

			Stage1game stage1 = new Stage1game();
			try {

				stage1.start(new Stage());
				Stage2.close();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		nextStage.setOnMouseClicked(e->{
			Stage3guess stage3 = new Stage3guess();
			try {

				stage3.start(new Stage());
				Stage2.close();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		returnmenu.setOnMouseClicked(e->{
			MainStage mainStage = new MainStage();
			try {
				mainStage.start(new Stage());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Stage2.hide();

		});
		nextQuestion.setOnMouseClicked(e->{
			for(int i=0;i<10;i++){
				if(question.getText().equals(ques[i])){
					ans[i] = answer.getText();
					question.setText(ques[i+1]);
					answer.setText(ans[i+1]);
					break;
				}
				if(question.getText().equals(ques[9])){
					ans[9] = answer.getText();
					Alert warning =  new Alert(AlertType.WARNING,"已经是最后一题！");
		         	warning.show();
		         	break;
				}
			}
		});
		lastQuestion.setOnMouseClicked(e->{
			for(int i=9;i>-1;i--){
				if(question.getText().equals(ques[i])){
					ans[i] = answer.getText();
					question.setText(ques[i-1]);
					answer.setText(ans[i-1]);
					break;
				}
				if(question.getText().equals(ques[0])){
					ans[0] = answer.getText();
					Alert warning =  new Alert(AlertType.WARNING,"已经是第一题！");
		         	warning.show();
		         	break;
				}

			}
		});
		submit.setOnMouseClicked(e->{
			int count =0;
			for(int i= 0;i<10;i++){
				if(ans[i].equals("")){
					count++;
				}
			}
			if(count ==0){
				File f2 = new File("txt/fill_answer.txt");
				try {
					@SuppressWarnings("resource")
					BufferedReader br2 = new BufferedReader(new FileReader(f2));
					for(int i =0;i<10;i++){
						String  bingo = br2.readLine();
						if(ans[i].equals(bingo)){
							score += 1;
						}
					}
					Alert result =  new Alert(AlertType.INFORMATION,"本次答对" + String.valueOf(score) + "题！");
					result.show();

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			else{
				if(!answer.getText().equals("")){
					count--;
				}
				if(count!=0){
					Alert warning =  new Alert(AlertType.WARNING,"您还有"+ String.valueOf(count) + "题未进行作答，"
							+ "\n" +"请回答完所有题目后再进行阅卷！");
		         	warning.show();
				}

			}
		});



		Scene Scene2 = new Scene(root,WINDOW_WIDTH,WINDOW_HEIGHT);
		Scene2.getStylesheets().add(show1.class.getResource("../css/stage2.css").toExternalForm());
		tip1.setId("lable");
		tip2.setId("lable");
		question.setId("font");
		answer.setId("font");
		Stage2.setTitle("忆汉字常识");
		Stage2.setScene(Scene2);
		Stage2.initStyle(StageStyle.UTILITY);
		Stage2.setResizable(false);
		Stage2.show();
	}catch(Exception e) {
		e.printStackTrace();
	}

	}

	public static void main(String[] args){

		launch(args);
	}

	@Override
	public void Read(File file) throws IOException {
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			String line;
			while((line = br.readLine()) != null){
			     //process the line
			     System.out.println(line);
			}
			br.close();



	}

}
