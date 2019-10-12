package Project5;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Project5 extends Application {

	public static void main(String[] args){
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		stage.setTitle("24点小游戏");
        GridPane pane = new GridPane();
        Scene scene = new Scene(pane,500,200);
        stage.setScene(scene);
        
        Cal cal = new Cal(pane);
        
        //四张扑克牌
        cal.prtImage(pane);
       
        //打印请输入解答
        Label label = new Label("Enter an expression:");
		GridPane.setConstraints(label, 0, 2);
        pane.getChildren().add(label);
        
        //解答框
        TextField textField = new TextField();
        GridPane.setConstraints(textField, 1, 2);
        pane.getChildren().add(textField);
        
        stage.show();
        
        //刷新按钮
        Button refresh = new Button("Refresh");
		GridPane.setConstraints(refresh, 1, 0);
        pane.getChildren().add(refresh);
        refresh.setOnAction(new EventHandler<ActionEvent>(){
    		@Override
    		public void handle(ActionEvent e2) {
    			if(pane.getChildren().contains(cal.label)) {
        			cal.delSolution(pane);
    			}
    			if(pane.getChildren().contains(cal.imageView1)) {
        			cal.delImage(pane);
    			}
    			cal.prtImage(pane);
    		}
    	});
        
        //检查答案
        Button check = new Button("Check");
		GridPane.setConstraints(check, 2, 2);
        pane.getChildren().add(check);
        check.setOnAction(new EventHandler<ActionEvent>(){
    		@Override
    		public void handle(ActionEvent e3) {
    			int result = cal.check(textField);
    			if(textField.getText().trim() == null) {
    				
    			}
    			if(result == 24) {
    				Label label = new Label("Ture!");
    				GridPane.setConstraints(label, 0, 4);
    		        pane.getChildren().add(label);
    			}
    			else {
    				Label label = new Label("False!");
    				GridPane.setConstraints(label, 0, 4);
    		        pane.getChildren().add(label);
    			}
    		}
    	});
        
      //找一个解按钮
        Button solution = new Button("Find a solution");
		GridPane.setConstraints(solution, 0, 0);
        pane.getChildren().add(solution);
        solution.setOnAction(new EventHandler<ActionEvent>(){
    		@Override
    		public void handle(ActionEvent e1) {
    			cal.start24(pane);
    		}
    	});

		stage.show();
	}

}
