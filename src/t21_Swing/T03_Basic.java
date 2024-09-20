package t21_Swing;
//스윙
import javax.swing.JFrame;
//인터페이스 사용법도 똑같다
public class T03_Basic extends JFrame{
	
	public T03_Basic() {
		super("스윙 연습");
//		setBounds(300,250,300,250);
		setSize(300, 250);//사이즈는 줘야함
			//이 아래 3가지 명령은 거의 한쌍으로 다닌다
		
		//프레임을 윈도우 화면 중앙에 띄우기 이거쓰면 셋바운드 필요없음 
		setLocationRelativeTo(null);//객체들어가는데 지금은 널
		
		//화면크기고정
		setResizable(false);//기본적으로 트루다
		
		//윈도우 창닫기 이거 없으면 창은 없어지는데 실행은 그대로다 
		//많이 써서 이렇게 따로 빼둠
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new T03_Basic();
	}
}