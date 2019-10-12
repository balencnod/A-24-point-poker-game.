package Project5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Cal {
	
	int num1;
	int num2;
	int num3;
	int num4;
	String formula;

    ImageView imageView1 = new ImageView();
    ImageView imageView2 = new ImageView();
    ImageView imageView3 = new ImageView();
    ImageView imageView4 = new ImageView();
    
	Label label = new Label();
	
	Cal(GridPane pane){
		GridPane.setConstraints(label, 2, 0);
		pane.getChildren().add(label);
	}
	
	//获取四张图片
	void getNum(int i,int index) {
		switch(index) {
		case 1:
			num1 = i%13;
			if(num1 == 0) {
				num1 =13;
			}
		break;	
		case 2:
			num2 = i%13;
			if(num2 == 0) {
				num2 =13;
			}
		break;	
		case 3:
			num3 = i%13;
			if(num3 == 0) {
				num3 =13;
			}
		break;	
		case 4:
			num4 = i%13;
			if(num4 == 0) {
				num4 =13;
			}
		break;	
		}
	}
	
	//打印四张图片
	void prtImage(GridPane pane) {
		String filename = new String();
        int randNum;
        
        randNum = (int)(1+Math.random()*51);
        getNum(randNum, 1);
        filename = "file:src\\Project5\\image\\" + randNum + ".png";
        Image image1 = new Image(filename);
    	imageView1.setImage(image1);
    	GridPane.setConstraints(imageView1, 0, 1);
        pane.getChildren().add(imageView1);
        
        randNum = (int)(1+Math.random()*51);
        getNum(randNum, 2);
        filename = "file:src\\Project5\\image\\" + randNum + ".png";
        Image image2 = new Image(filename);
    	imageView2.setImage(image2);
    	GridPane.setConstraints(imageView2, 1, 1);
        pane.getChildren().add(imageView2);
        
        randNum = (int)(1+Math.random()*51);
        getNum(randNum, 3);
        filename = "file:src\\Project5\\image\\" + randNum + ".png";
        Image image3 = new Image(filename);
    	imageView3.setImage(image3);
    	GridPane.setConstraints(imageView3, 2, 1);
        pane.getChildren().add(imageView3);
        
        randNum = (int)(1+Math.random()*51);
        getNum(randNum, 4);
        filename = "file:src\\Project5\\image\\" + randNum + ".png";
        Image image4 = new Image(filename);
    	imageView4.setImage(image4);
    	GridPane.setConstraints(imageView4, 3, 1);
        pane.getChildren().add(imageView4);
        
        if(num1 == num2 || num1 == num3 || num1 == num4 || num2 == num3 || num2 == num4 || num3 == num4) {
        	if(pane.getChildren().contains(imageView1)) {
    			delImage(pane);
			}
			prtImage(pane);
        }
           
	}
	
	//删除四张图片
		void delImage(GridPane pane) {
	        for(int i=0;i<4;i++) {
	        	pane.getChildren().removeAll(imageView1,imageView2,imageView3,imageView4);
	        }
		}
	
	//返回表达式结果
	int check(TextField textField) {
		formula = new String(textField.getText().trim());
		return Integer.parseInt(countExp(formula));
	}
	
	void delSolution(GridPane pane){
		label.setText("");
	}
	
	//以下代码参考网上的代码。其中被注释掉的是我尝试写的，使用的是网上的。
	
	//将中缀表达式转换为后缀表达式
	/*void midTransfDePoland() {
		stack.clear();
		int j = 0;
		for(int i=0;i<formula.length;i++) {
			if(formula[i] == '1') {
				dePoland[j] = '1';
				j++;
			}
			else if(formula[i] == '2') {
				dePoland[j] = '2';
				j++;
			}
			else if(formula[i] == '3') {
				dePoland[j] = '3';
				j++;
			}
			else if(formula[i] == '4') {
				dePoland[j] = '4';
				j++;
			}
			else if(formula[i] == '5') {
				dePoland[j] = '5';
				j++;
			}
			else if(formula[i] == '6') {
				dePoland[j] = '6';
				j++;
			}
			else if(formula[i] == '7') {
				dePoland[j] = '7';
				j++;
			}
			else if(formula[i] == '8') {
				dePoland[j] = '8';
				j++;
			}
			else if(formula[i] == '9') {
				dePoland[j] = '9';
				j++;
			}
			else if(formula[i] == 'A') {
				dePoland[j] = 'A';
				j++;
			}
			else if(formula[i] == 'B') {
				dePoland[j] = 'B';
				j++;
			}
			else if(formula[i] == 'C') {
				dePoland[j] = 'C';
				j++;
			}
			else if(formula[i] == '+') {
				if(stack.empty()) {
					stack.push('+');
				}
				else {
					for(boolean isL = false;isL;) {
						if((char) stack.peek()=='+') {
							dePoland[j] = (char)stack.pop();
							j++;
						}
						else if((char) stack.peek()=='-') {
							dePoland[j] = (char)stack.pop();
							j++;
						}
						else if((char) stack.peek()=='*') {
							dePoland[j] = (char)stack.pop();
							j++;
						}
						else if((char) stack.peek()=='/') {
							dePoland[j] = (char)stack.pop();
							j++;
						}
						else if((char) stack.peek()=='(') {
							isL = true;
						}
					}
					stack.push('+');
				}
			}
			else if(formula[i] == '-') {
				if(stack.empty()) {
					stack.push('-');
				}
				else {
					for(boolean isL = false;isL;) {
						if((char) stack.peek()=='+') {
							dePoland[j] = (char)stack.pop();
							j++;
						}
						else if((char) stack.peek()=='-') {
							dePoland[j] = (char)stack.pop();
							j++;
						}
						else if((char) stack.peek()=='*') {
							dePoland[j] = (char)stack.pop();
							j++;
						}
						else if((char) stack.peek()=='/') {
							dePoland[j] = (char)stack.pop();
							j++;
						}
						else if((char) stack.peek()=='(') {
							isL = true;
						}
					}
					stack.push('-');
				}
			}
			else if(formula[i] == '*') {
				if(stack.empty()) {
					stack.push('*');
				}
				else {
					for(boolean isL = false;isL;) {
						if((char) stack.peek()=='+') {
							isL = true;
						}
						else if((char) stack.peek()=='-') {
							isL = true;
						}
						else if((char) stack.peek()=='*') {
							dePoland[j] = (char)stack.pop();
							j++;
						}
						else if((char) stack.peek()=='/') {
							dePoland[j] = (char)stack.pop();
							j++;
						}
						else if((char) stack.peek()=='(') {
							isL = true;
						}
					}
					stack.push('*');
				}
			}
			else if(formula[i] == '/') {
				if(stack.empty()) {
					stack.push('/');
				}
				else {
					for(boolean isL = false;isL;) {
						if((char) stack.peek()=='+') {
							isL = true;
						}
						else if((char) stack.peek()=='-') {
							isL = true;
						}
						else if((char) stack.peek()=='*') {
							dePoland[j] = (char)stack.pop();
							j++;
						}
						else if((char) stack.peek()=='/') {
							dePoland[j] = (char)stack.pop();
							j++;
						}
						else if((char) stack.peek()=='(') {
							isL = true;
						}
					}
					stack.push('/');
				}
			}
			else if(formula[i] == '(') {
				stack.push('(');
			}
			else if(formula[i] == ')') {
				if((char) stack.peek()!='(') {
					dePoland[j] = (char)stack.pop();
					j++;
				}
				else {
					stack.pop();
				}
			}
			else {
				while(!stack.empty()) {
					dePoland[j] = (char)stack.pop();
					j++;
				}
			}
		}
		dePoland[j]='E';
	}*/
	private List<String> middleToBehind(String expression) {
        List<String> result = new ArrayList<String>();
        if (expression.length() == 0)
            return result;
        int begin = 0;
        char[] operator = new char[100];
        int oTop = -1;
        while (begin < expression.length()) {
            String now = "";
            if (expression.charAt(begin) <= '9' && expression.charAt(begin) >= '0') {
                while (true) {
                    if (begin < expression.length() && expression.charAt(begin) <= '9'
                            && expression.charAt(begin) >= '0') {
                        now = now + expression.charAt(begin++);
                    } else {
                        break;
                    }
                }
                result.add(now);
            } else {
                char o = expression.charAt(begin++);
                if (oTop == -1) {
                    operator[++oTop] = o;
                } else if (o == ')') {
                    // 一直弹出至'('
                    while (true) {
                        if (operator[oTop] == '(') {
                            oTop--;
                            break;
                        } else {
                            result.add("" + operator[oTop--]);
                        }
                    }
                } else if (comOperation(operator[oTop], o)) {
                    result.add("" + operator[oTop--]);
                    operator[++oTop] = o;
                } else {
                    operator[++oTop] = o;
                }
            }
        }
        while (oTop > -1) {
            result.add("" + operator[oTop--]);
        }
        return result;
    }
	
	//判断操作符优先级
	private boolean comOperation(char first, char second) {
        if (first == '+') {
            if (second == '+')
                return true;
            else if (second == '-')
                return true;
            else if (second == '*')
                return false;
            else if (second == '/')
                return false;
            else if (second == '(')
                return false;
            else if (second == ')')
                return true;
        } else if (first == '-') {
            if (second == '+')
                return true;
            else if (second == '-')
                return true;
            else if (second == '*')
                return false;
            else if (second == '/')
                return false;
            else if (second == '(')
                return false;
            else if (second == ')')
                return true;
        } else if (first == '*') {
            if (second == '+')
                return true;
            else if (second == '-')
                return true;
            else if (second == '*')
                return true;
            else if (second == '/')
                return true;
            else if (second == '(')
                return false;
            else if (second == ')')
                return true;
        } else if (first == '/') {
            if (second == '+')
                return true;
            else if (second == '-')
                return true;
            else if (second == '*')
                return true;
            else if (second == '/')
                return true;
            else if (second == '(')
                return false;
            else if (second == ')')
                return true;
        } else if (first == '(') {
            if (second == '+')
                return false;
            else if (second == '-')
                return false;
            else if (second == '*')
                return false;
            else if (second == '/')
                return false;
            else if (second == '(')
                return false;
            else if (second == ')')
                return true;
        } else if (first == ')') {
            return true;
        }
        return false;
    }
	
	//判断是否是运算符
	private boolean isOperator(String s) {
        if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
            return true;
        return false;
    }
	
	//完成四则运算
	private String twoOperators(String operator1, String operator2, String o){
        String result = "";
        int o1 = Integer.parseInt(operator1);
        int o2 = Integer.parseInt(operator2);
        int count = 0;
        if(o.equals("+")){
            count=o1+o2;
        }else if(o.equals("-")){
            count=o1-o2;
        }else if(o.equals("*")){
            count=o1*o2;
        }else if(o.equals("/")){
            count=o1/o2;
        }
        return result+count;
    }
	
	//计算后缀表达式
	/*
	void calDePoland() {
		stack.clear();
		int tmp1,tmp2;
		for(int i=0;i<dePoland.length;i++) {
			if(dePoland[i] == '1') {
				stack.push(1);
			}
			else if(dePoland[i] == '2') {
				stack.push(2);
			}
			else if(dePoland[i] == '3') {
				stack.push(3);
			}
			else if(dePoland[i] == '4') {
				stack.push(4);
			}
			else if(dePoland[i] == '5') {
				stack.push(5);
			}
			else if(dePoland[i] == '6') {
				stack.push(6);
			}
			else if(dePoland[i] == '7') {
				stack.push(7);
			}
			else if(dePoland[i] == '8') {
				stack.push(8);
			}
			else if(dePoland[i] == '9') {
				stack.push(9);
			}
			else if(dePoland[i] == 'A') {
				stack.push(10);
			}
			else if(dePoland[i] == 'B') {
				stack.push(11);
			}
			else if(dePoland[i] == 'C') {
				stack.push(12);
			}
			else if(dePoland[i] == 'D') {
				stack.push(13);
			}
			else if(dePoland[i] == '+') {
				tmp1 = (int)stack.pop();
				tmp2 = (int)stack.pop();
				tmp1 = tmp1 + tmp2;
				stack.push(tmp1);
			}
			else if(dePoland[i] == '-') {
				tmp1 = (int)stack.pop();
				tmp2 = (int)stack.pop();
				tmp1 = tmp2 - tmp1;
				stack.push(tmp1);
			}
			else if(dePoland[i] == '*') {
				tmp1 = (int)stack.pop();
				tmp2 = (int)stack.pop();
				tmp1 = tmp1 * tmp2;
				stack.push(tmp1);
			}
			else if(dePoland[i] == '/') {
				tmp1 = (int)stack.pop();
				tmp2 = (int)stack.pop();
				if(tmp2%tmp1 != 0) {
					notInt = true;
				}
				tmp1 = tmp2 / tmp1;
				stack.push(tmp1);
			}
			else {
				result = (int)stack.pop();
			}
		}*/
	private String countExp(String expression) {
        List<String> expList = middleToBehind(expression);
        while (expList.size() > 1) {
            for (int i = 0; i < expList.size(); i++) {
                if (isOperator(expList.get(i))) {
                    expList.add(i - 2, twoOperators(expList.get(i - 2), expList.get(i - 1), expList.get(i)));
                    expList.remove(i-1);
                    expList.remove(i-1);
                    expList.remove(i-1);
                    break;
                }
            }
        }
        return expList.get(0);
    }
		
	//计算24点解法
	List<Node> result = new ArrayList<Node>();  
    Set<String> calculateSet = new HashSet<String>();
    public void start24(GridPane pane) {  
        int[] values = {num1,num2,num3,num4};  
        traverse(values,pane);
    }  
      
    public void traverse(int[] a,GridPane pane){  
        Double[] dArrays = new Double[4];  
        dArrays[0] = a[0]+0D;  
        dArrays[1] = a[1]+0D;  
        dArrays[2] = a[2]+0D;  
        dArrays[3] = a[3]+0D;  
        List<Node> headerList = null;  
        for(int i=0;i<4;i++){  
            for(int j=0;j<4;j++){  
                if(j==i){  
                    continue;  
                }  
                for(int k=0;k<4;k++){  
                    if(k==i || k==j){  
                        continue;  
                    }  
                    headerList = createHeaderList(dArrays[i],dArrays[j]);  
                    List<Node> chooseThreeNum = null;  
                    for(Node t:headerList){  
                        chooseThreeNum = chooseThreeOrFourNum(t, dArrays[k]);  
                        List<Node> chooseFourNum = null;  
                        for(Node temp:chooseThreeNum ){  
                            chooseFourNum = chooseThreeOrFourNum(temp,dArrays[6-(i+j+k)]);  
                            pickNode(chooseFourNum);  
                        }  
                    }  
                }  
            }  
        }  
        getAllCalculate();  
        if(calculateSet.size()>0){  
            display(pane);  
        }        
    }  
      
    private void display(GridPane pane){  
    	for(String s:calculateSet){  
    		label.setText(s + " = 24");
    		break;
        }  
    	calculateSet.clear();
    	result.clear();
    }  
      
    private void getAllCalculate(){  
        if(result.size()<1){  
        	label.setText("No solution");
        }  
        Node second = null;  
        Node first = null;  
        for(Node t:result){  
            second = t.getPre_node();  
            first = second.getPre_node();  
            if(second.get_a().doubleValue()==first.getValue().doubleValue()){  
                second.setA_cul_str(first.getCul_str());                
            }else{  
                second.setB_cul_str(first.getCul_str());      
            }  
            second.doCalculate();  
              
            if(t.get_a().doubleValue()==second.getValue().doubleValue()){  
                t.setA_cul_str(second.getCul_str());                
            }else{  
                t.setB_cul_str(second.getCul_str());      
            }  
            t.doCalculate();  
            calculateSet.add(filterCalculate(t.getCul_str()));  
              
        }  
    }  
      
    private String filterCalculate(String str){  
        str = str.substring(1, str.length()-1);  
        str = str.replace(".0", "");  
        str = str.replace("*", "×");  
        str = str.replace("/", "÷");  
        return str;  
    }  
      
    private void pickNode(List<Node> list){  
        for(Node t : list){  
            if(judge24(t.getValue())){  
                result.add(t);  
            }  
        }  
    }  
      
    private boolean judge24(Double d){  
        if(Math.abs(d.doubleValue()-24)<=0.000001){  
            return true;  
        }  
        return false;  
          
    }  
    private List<Node> chooseThreeOrFourNum(Node t,Double b){  
        List<Node> result = new ArrayList<Node>();  
        Double a = t.getValue();  
        Node n1 = new Node(a,b,'+');  
        Node n2 = new Node(a,b,'-');  
        Node n3 = new Node(a,b,'-',true);  
        Node n4 = new Node(a,b,'*');  
        Node n5 = new Node(a,b,'/');  
        Node n6 = new Node(a,b,'/',true);  
        n1.doCalculate();  
        n2.doCalculate();  
        n3.doCalculate();  
        n4.doCalculate();  
        n5.doCalculate();  
        n6.doCalculate();  
        insertNode(n1,result);  
        insertNode(n2,result);  
        insertNode(n3,result);  
        insertNode(n4,result);  
        insertNode(n5,result);  
        insertNode(n6,result);  
        n1.setPre_node(t);  
        n2.setPre_node(t);  
        n3.setPre_node(t);  
        n4.setPre_node(t);  
        n5.setPre_node(t);  
        n6.setPre_node(t);      
        return result;  
    }  
      
    private List<Node> createHeaderList(Double a,Double b){  
        List<Node> result = new ArrayList<Node>();  
        Node n1 = new Node(a,b,'+');  
        Node n2 = new Node(a,b,'-');  
        Node n3 = new Node(a,b,'-',true);  
        Node n4 = new Node(a,b,'*');  
        Node n5 = new Node(a,b,'/');  
        Node n6 = new Node(a,b,'/',true);  
        n1.doCalculate();  
        n2.doCalculate();  
        n3.doCalculate();  
        n4.doCalculate();  
        n5.doCalculate();  
        n6.doCalculate();  
        insertNode(n1,result);  
        insertNode(n2,result);  
        insertNode(n3,result);  
        insertNode(n4,result);  
        insertNode(n5,result);  
        insertNode(n6,result);  
        return result;  
    }  
      
      
    private void insertNode(Node p,List<Node> list){  
        if(p.getValue()!=null){  
            list.add(p);  
        }  
    }  
      
}  
  
class Node {  
    Double _a;  
    Double _b;  
    char opr;  
    Double value;  
    boolean is_rev_order;  
    String a_cul_str;//_a的算式  
    String b_cul_str;//_b的算式  
    String cul_str;//自身的算式  
    Node pre_node;  
    Node next_branch1;  
    Node next_branch2;  
    Node next_branch3;  
    Node next_branch4;  
    Node next_branch5;  
    Node next_branch6;  
  
    public Node(Double a, Double b, char opr) {  
        this._a = a;  
        this._b = b;  
        this.opr = opr;  
        this.a_cul_str = Double.toString(_a);  
        this.b_cul_str = Double.toString(_b);  
    }  
  
    public Node(Double a, Double b, char opr, boolean is_rev_order) {  
        this._a = a;  
        this._b = b;  
        this.opr = opr;  
        this.is_rev_order = is_rev_order;  
        this.a_cul_str = Double.toString(_a);  
        this.b_cul_str = Double.toString(_b);  
    }  
  
    public Double getValue(){  
        return value;  
    }  
    public void doCalculate(){  
        switch(opr){  
        case '+':  
            cul_str = "("+a_cul_str+"+"+b_cul_str+")";  
            value = _a+_b;  
            break;  
        case '-':  
            if(is_rev_order){  
                cul_str = "("+b_cul_str+"-"+a_cul_str+")";  
                value = _b-_a;  
            }else{  
                cul_str = "("+a_cul_str+"-"+b_cul_str+")";  
                value = _a-_b;  
            }  
            break;  
        case '*':  
            cul_str = "("+a_cul_str+"*"+b_cul_str+")";  
            value = _a*_b;  
            break;  
        case '/':  
            if(is_rev_order){  
                if(_a!=0){  
                    cul_str = "("+b_cul_str+"/"+a_cul_str+")";  
                    value = _b/_a;  
                }  
                 
            }else{  
                if(_b!=0){  
                    cul_str = "("+a_cul_str+"/"+b_cul_str+")";  
                    value = _a/_b;  
                }  
            }  
            break;  
        }  
    }  
      
    public Double get_a() {  
        return _a;  
    }  
  
    public void set_a(Double _a) {  
        this._a = _a;  
    }  
  
    public Double get_b() {  
        return _b;  
    }  
  
    public void set_b(Double _b) {  
        this._b = _b;  
    }  
  
    public String getA_cul_str() {  
        return a_cul_str;  
    }  
  
    public void setA_cul_str(String a_cul_str) {  
        this.a_cul_str = a_cul_str;  
    }  
  
    public String getB_cul_str() {  
        return b_cul_str;  
    }  
  
    public void setB_cul_str(String b_cul_str) {  
        this.b_cul_str = b_cul_str;  
    }  
  
    public String getCul_str() {  
        return cul_str;  
    }  
  
    public void setCul_str(String cul_str) {  
        this.cul_str = cul_str;  
    }  
  
    public Node getPre_node() {  
        return pre_node;  
    }  
  
    public void setPre_node(Node pre_node) {  
        this.pre_node = pre_node;  
    }  
  
    public Node getNext_branch1() {  
        return next_branch1;  
    }  
  
    public void setNext_branch1(Node next_branch1) {  
        this.next_branch1 = next_branch1;  
    }  
  
    public Node getNext_branch2() {  
        return next_branch2;  
    }  
  
    public void setNext_branch2(Node next_branch2) {  
        this.next_branch2 = next_branch2;  
    }  
  
    public Node getNext_branch3() {  
        return next_branch3;  
    }  
  
    public void setNext_branch3(Node next_branch3) {  
        this.next_branch3 = next_branch3;  
    }  
  
    public Node getNext_branch4() {  
        return next_branch4;  
    }  
  
    public void setNext_branch4(Node next_branch4) {  
        this.next_branch4 = next_branch4;  
    }  
  
    public Node getNext_branch5() {  
        return next_branch5;  
    }  
  
    public void setNext_branch5(Node next_branch5) {  
        this.next_branch5 = next_branch5;  
    }  
  
    public Node getNext_branch6() {  
        return next_branch6;  
    }  
  
    public void setNext_branch6(Node next_branch6) {  
        this.next_branch6 = next_branch6;  
    }  
	
}
