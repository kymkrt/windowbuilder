package t21_Swing;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
//라디오 버튼 둘중하나만 고를수 있는것
//모두 고를수 있는건 체크박스 여기선 라디오 버튼 연습
//체크박스 밖에 없는데 라디오버튼으로 만드는것
public class T06 extends JFrame{
	JPanel pn1;
	JButton btnExit;
	//그룹으로 들어간다 하나의 그룹으로 버튼을 만든다 안그러면 따로 따로 됨
	CheckboxGroup gender;
	//라디오버튼 rd
	Checkbox rdGender1, rdGender2, rdGender3; //1남자 2여자
	
	public T06() {
		setTitle("라디오버튼 연습");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		setLayout(new FlowLayout());
		
		pn1 = new JPanel();
		
		//이렇게만 하면 다 됨 체크박스로 작동
//		gender = new CheckboxGroup();
		
		gender = new CheckboxGroup();
		rdGender1 = new Checkbox("남자", gender,true);// 어떤 그룹으로 할건가 기본은 true 여기서는 남자가 자동으로골라짐 true라서 
		rdGender2 = new Checkbox("여자", gender,false);
		rdGender3 = new Checkbox("중성", gender,false);
		
		pn1.add(rdGender1);
		pn1.add(rdGender2);
		pn1.add(rdGender3);
		
		add(pn1);
		
		setVisible(true);
		/*=======================*/
		
	}
	public static void main(String[] args) {
		new T06();
	}
}
