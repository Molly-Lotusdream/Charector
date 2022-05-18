//程序从这里开始
package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginInterface extends Application{
private int WINDOW_WIDTH = 600;
private int WINDOW_HEIGHT = 400;
@SuppressWarnings("unused")
private Text user;
private TextField idTF;
//登录界面
@Override
public void start( Stage loginStage) throws Exception {
try{
	StackPane root = new StackPane();
	BorderPane borderPane = new BorderPane();
	VBox vPane = new VBox(20);
	vPane.setAlignment(Pos.CENTER);
	HBox hPane1 = new HBox(25);
	hPane1.setAlignment(Pos.CENTER);
	HBox hPane2 = new HBox(25);
	hPane2.setAlignment(Pos.CENTER);
	HBox hPane3 = new HBox(25);
	hPane3.setAlignment(Pos.CENTER);
	HBox hPane4 = new HBox(25);
	hPane4.setAlignment(Pos.CENTER);


	Image back = new Image("image/scene.jpeg");
	ImageView view = new ImageView(back);

	Text welcome = new Text("学汉语用汉字，弘扬汉语言文化");

	Label id = new Label("账号:");
	Label password = new Label("密码:");//账号密码标签

	Button login = new Button("登录");
	Button register = new Button("注册");
	Button clear = new Button("重新输入");

	 idTF = new TextField();
	TextField passwordTF = new TextField();

	passwordTF.setPrefWidth(120);//按钮及文本框

	hPane1.getChildren().addAll(welcome);
	hPane2.getChildren().addAll(id,idTF);
	hPane3.getChildren().addAll(password,passwordTF);
	hPane4.getChildren().addAll(login,clear,register);
	vPane.getChildren().addAll(hPane2,hPane3,hPane4);
	borderPane.setCenter(vPane);
	borderPane.setTop(hPane1);
	hPane1.setPadding(new Insets(20, 20, 0, 20));//界面搭建
	root.getChildren().add(view);
    root.getChildren().add(borderPane);



	login.setOnMouseClicked(e->{

			if (idTF.getText().equals("")&&passwordTF.getText().equals("")){
				Alert warning =  new Alert(AlertType.WARNING,"请输入账号密码！");
				warning.setTitle("账号密码未输入");
				warning.show();
			}
			else{
				MainStage mainPane = new MainStage();
				try {
					int count1 = 0,count2 = 0,count3 = 0;
					File f = new File("txt/compete.txt");
					@SuppressWarnings("resource")
					BufferedReader br = new BufferedReader(new FileReader(f));
					String com1 =idTF.getText() + " " + passwordTF.getText();
					String com2 = null;
					while((com2 = br.readLine())!=null){
						String idsave = new String();
						String passwordsave = new String();
						String[] tokens = com2.split(" ");
						idsave = tokens[0];
						passwordsave = tokens[1];
						if(com1.equals(com2)){
							count1++;
								}
						if(idTF.getText().equals(idsave)){
							count2++;
						}
						if(password.getText().equals(passwordsave)){
							count3++;
						}
					}//count1判断用户账号密码是否全部一致，count2判断账号名是否一致，count3判断密码是否一致
					if(count1==1) {
						mainPane.start(new Stage());
						String trans = idTF.getText();
						if(!trans.equals(null))
						mainPane.setUser(trans);
						loginStage.close();
					}


					else if(count1==0&&count2==0&&count3==0){
							Alert warning =  new Alert(AlertType.WARNING,"您暂未注册账号，请前往登录界面进行注册！");
							warning.setTitle("用户信息不存在");
							warning.show();
						}


					else if((count2==1||count3==1)&&count1!=1){
						Alert warning =  new Alert(AlertType.WARNING,"账号或密码填写有误 ，请重新填写！"+ " \n" +"密码长度至少八位，只能包含字母和数字");
						warning.setTitle("账号或密码错误");
						warning.show();

					}



				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
	});
	//登录按钮，成功跳转至Stage1，无账号密码提示注册
	register.setOnMouseClicked(e->{
		RegisterInterface registerStage =new RegisterInterface();
		try {
			registerStage.start(new Stage());
			loginStage.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	});
	//注册按钮，跳转至登录界面
	clear.setOnMouseClicked(e->{
		idTF.setText("");
		passwordTF.setText("");
	});
	//重置按钮，重新输入账号密码
	Scene loginScene = new Scene(root,WINDOW_WIDTH,WINDOW_HEIGHT);
	loginStage.setTitle("学汉语用汉字，弘扬汉语言文化");
	loginScene.getStylesheets().add(show1.class.getResource("../css/login.css").toExternalForm());
	root.getStyleClass().add("image");
    id.getStyleClass().add("lable");
    password.getStyleClass().add("lable");
    welcome.setId("font");
    idTF.setId("font");
    passwordTF.setId("font");
	loginStage.setScene(loginScene);
	loginStage.show();
	loginStage.setResizable(false);
	//Scene,Stage,大小不可变

}catch(Exception e) {
	e.printStackTrace();
}

}









public static void main(String[] args){
	launch(args);
}
public void setIdTF(String user){
	idTF.setText(user);

}



}
