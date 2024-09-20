package t21_Swing;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class T05_BorderLayout extends JFrame{
	JPanel pn1, pn11, pn12, pn13;
	JButton btn1,btn2,btn3,btn4,btn5;
	
	public T05_BorderLayout() {
		setTitle("borderLayout 연습");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		setLayout(new BorderLayout());
		
		pn1 = new JPanel();
		pn1.setLayout(new GridLayout(3,1));
		
		pn11 = new JPanel();
		pn12 = new JPanel();
		pn13 = new JPanel();

		pn1.add(pn11);
		
		btn5 = new JButton("중앙");//순서지켜야함 이게 여기보다 아래 있으면 에러
		pn12.add(btn5);
		pn1.add(pn12);
		
		pn1.add(pn13);
		
		btn1 = new JButton("동쪽");
		btn2 = new JButton("서쪽");
		btn3 = new JButton("남쪽");
		btn4 = new JButton("북쪽");
		
		add(btn1, BorderLayout.EAST);
		add(btn2, BorderLayout.WEST);
		add(btn3, BorderLayout.SOUTH);
		add(btn4, BorderLayout.NORTH);
		add(pn1, BorderLayout.CENTER);
		
		setVisible(true);
		/*=======================*/
		
	}
	public static void main(String[] args) {
		new T05_BorderLayout();
	}
}
