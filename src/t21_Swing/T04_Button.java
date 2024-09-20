package t21_Swing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
//스윙 버튼
//스윙은 한글 안깨짐 윈도우와 독립이기 때문 
//AWT는 윈도우에 종속적 윈도우는 utf8안써서 한글깨짐
import javax.swing.JFrame;

public class T04_Button extends JFrame{
	JButton btnExit; //스윙은 전부 j
	
	public T04_Button() {
		super("버튼 연습");
		setSize(300, 250);//사이즈는 줘야함
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);//객체들어가는데 지금은 널
		setResizable(false);//기본적으로 트루다
		
		btnExit = new JButton("종료");
		add(btnExit);
		
		setVisible(true);
		
		/*=====================*/
		
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	public static void main(String[] args) {
		new T04_Button();
	}
}