package t21_Swing;
//스윙
import javax.swing.JFrame;
//인터페이스 사용법도 똑같다
public class T02_Basic extends JFrame{
	
	public T02_Basic() {
		super("스윙 연습");
		setBounds(300,250,300,250);
		
		
		
		setVisible(true);
		
		//윈도우 창닫기 이거 없으면 창은 없어지는데 실행은 그대로다 
		//많이 써서 이렇게 따로 빼둠
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		new T02_Basic();
	}
}