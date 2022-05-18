package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RegisterInterface extends Application  implements read {
private int WINDOW_WIDTH = 800;
private int WINDOW_HEIGHT = 570;
//界面大小定义
public void start(Stage registerStage) throws Exception {
	try{
		StackPane root = new StackPane();
		VBox vPane = new VBox(35);
		vPane.setAlignment(Pos.CENTER);
		HBox hPane1 = new HBox(15);
		hPane1.setAlignment(Pos.CENTER);
		HBox hPane2 = new HBox(15);
		hPane2.setAlignment(Pos.CENTER);
		HBox hPane3 = new HBox(15);
		hPane3.setAlignment(Pos.CENTER);
		HBox hPane4 = new HBox(15);
		hPane4.setAlignment(Pos.CENTER);
		HBox hPane5 = new HBox(15);
		hPane5.setAlignment(Pos.CENTER);
		HBox hPane6 = new HBox(15);
		hPane6.setAlignment(Pos.CENTER);
		HBox hPane7 = new HBox(15);
		hPane7.setAlignment(Pos.CENTER);
		//界面基本布局，StackPane,一个VBox，7个HBox

		Image back = new Image("image/scene.jpeg");
		ImageView view = new ImageView(back);
		//StackPane底部放置背景

		Text tip = new Text("请在此注册一个新的账号 ");
		Text setId = new Text("      请输入账号名： ");
		Text setPassword = new Text("请输入密码(至少8位)：");
		Text confirmPassword = new Text("    请再次输入密码： ");
		Text sex = new Text("请在此输入您的性别： ");
		Text age = new Text("请在此输入您的年龄： ");
		//text提示输入内容

		TextField idTF = new TextField();
		TextField passwordTF = new TextField();
		TextField confirmpasswordTF = new TextField();
		TextField sexTF = new TextField();
		TextField ageTF = new TextField();
		idTF.setPrefWidth(150);
		sexTF.setPrefWidth(150);
		ageTF.setPrefWidth(150);
		passwordTF.setPrefWidth(150);
		confirmpasswordTF.setPrefWidth(150);
		//用户输入基本信息，ID、性别年龄及密码，确认密码

		Button set = new Button("注册并返回");
		set.setPrefHeight(30);
		set.setPadding(new Insets(15,20,15,20));
		//注册后返回登录界面

		hPane1.getChildren().addAll(tip);
		hPane2.getChildren().addAll(setId,idTF);
		hPane3.getChildren().addAll(sex,sexTF);
		hPane4.getChildren().addAll(age,ageTF);
		hPane5.getChildren().addAll(setPassword,passwordTF);
		hPane6.getChildren().addAll(confirmPassword,confirmpasswordTF);
		hPane7.getChildren().addAll(set);
		vPane.getChildren().addAll(hPane1,hPane2,hPane3,hPane4,hPane5,hPane6,hPane7);
		root.getChildren().add(view);
		root.getChildren().add(vPane);
		//界面搭建，HBox放入VBox，root中放入image与VBox





	set.setOnMouseClicked(e->{
		try{
			if(idTF.getText().equals("")||
					sexTF.getText().equals("")||
					ageTF.getText().equals("")||
					ageTF.getText().equals("")||
					passwordTF.getText().equals("")||
					confirmpasswordTF.getText().equals("")){
							Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
							alert.setTitle("信息填写不完整");
							alert.setHeaderText("您的用户信息尚未填写完整！确定要返回登录界面吗？" + "\n" +"返回后您刚刚填写的信息不会注册");
							Optional<ButtonType> result = alert.showAndWait();
								if (result.get() == ButtonType.OK) {
									alert.close();
									LoginInterface loginStage = new LoginInterface();
									loginStage.start(new Stage());
									registerStage.hide();
								} else {
									alert.close();
								}

				}//第一种情况，用户信息填写不完整，提示填写
			else if(!passwordTF.getText().matches("[\\da-zA-Z]+")||passwordTF.getText().length()<8){
				Alert warning =  new Alert(AlertType.WARNING,"密码只能包含字母后数字且至少八位，请重新输入！");
				warning.setTitle("密码格式错误");
				warning.show();
			}//密码长度及格式设定
			else if(!passwordTF.getText().equals(confirmpasswordTF.getText())) {
				Alert warning =  new Alert(AlertType.WARNING,"请重新输入密码！");
				warning.setTitle("两次输入密码不一致");
				warning.show();
			}//两次输入密码不一致，提示用户修改

			else if (passwordTF.getText().equals(confirmpasswordTF.getText())){
				int count = 0;
				File f = new File("txt/compete.txt");
				BufferedReader br = new BufferedReader(new FileReader(f));
				String com1 =idTF.getText() + " " + passwordTF.getText();
				String com2 = null;
				while((com2 = br.readLine())!=null){
					if(com1.equals(com2)){
						count++;
							}
				}
				if(count!=0){
					Alert warning =  new Alert(AlertType.WARNING,"您的账号信息与已有用户重复，请您修改信息后重新注册！");
					warning.setTitle("用户信息冲突");
					warning.show();

				}
				else{
					FileWriter User = new FileWriter("txt/userInput.txt",true);
					FileWriter Com = new FileWriter("txt/compete.txt",true);
					String save = idTF.getText() +
							"  " + passwordTF.getText() +
							" " + sexTF.getText() +
							" " + ageTF.getText() + "\n" ;//用户信息合并
					String com = idTF.getText() + " " + passwordTF.getText() + "\n" ;
					Com.write(com);
					Com.close();
					User.write(save);
					User.close();
					LoginInterface loginStage = new LoginInterface();
					loginStage.start(new Stage());
					loginStage.setIdTF(idTF.getText());
					registerStage.close();

				}

				br.close();



			}//两次密码输入一直且符合格式，打开仅存放用户信息的文件开始查询，若用户信息没有重复，允许用户注册














			        }//密码长度合适且信息输入无误，允许用户进行注册，将用户信息写入文件







			 catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		});
		//lambda表达式,鼠标点击按钮后对事件进行处理,若用户输入符合要求，将用户信息写入存放用户信息的文件内，若不符合要求，提示具体内容让用户进行修改


		Scene registerScene = new Scene(root,WINDOW_WIDTH,WINDOW_HEIGHT);//scene搭建
		registerStage.setTitle("学汉语用汉字，弘扬汉语言文化");//title设置
		registerScene.getStylesheets().add(show1.class.getResource("../css/register.css").toExternalForm());
		root.getStyleClass().add("image");
		tip.getStyleClass().add("lable");
	    setId.getStyleClass().add("lable");
	    setPassword.getStyleClass().add("lable");
	    sex.getStyleClass().add("lable");
	    age.getStyleClass().add("lable");
	    set.getStyleClass().add("button");
	    confirmPassword.getStyleClass().add("button");
	    idTF.setId("font");
	    sexTF.setId("font");
	    ageTF.setId("font");
	    passwordTF.setId("font");
	    confirmpasswordTF.setId("font");//用CSS对界面进行美化
		registerStage.setScene(registerScene);
		registerStage.setResizable(false);
		registerStage.show();
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
