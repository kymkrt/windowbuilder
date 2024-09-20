package t21_Swing;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

//메세지 띄우기
//버튼을 누르면 메세지가 나오는 방식
//창으로 메세지가 나오는 방식
public class T07_Message extends JFrame{
	JPanel pn1, pn2;
	JButton btn1, btn2, btn3, btn4, btn5;
	JLabel lblMessage;
	
	public T07_Message() {
		super("메세지 연습");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(new GridLayout(2,1));
		
		pn1 = new JPanel();
		btn1 = new JButton("경고");
		btn2 = new JButton("입력");
		btn3 = new JButton("종료");
		btn4 = new JButton("종료(예/아니오)");
		btn5 = new JButton("예/아니오/취소");
		
		pn1.add(btn1);
		pn1.add(btn2);
		pn1.add(btn3);
		pn1.add(btn4);
		pn1.add(btn5);
		
		pn2 = new JPanel();
		lblMessage = new JLabel("메세지가 출력됩니다");
		pn2.add(lblMessage);
		
		this.add(pn1);//this 생략가능
		add(pn2);
		
		setVisible(true);
		
		/*====================*/
		
		//경고메세지 버튼
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblMessage.setText("경고버튼을 누르셨습니다");
				//메세지띄우기
//				JOptionPane.showMessageDialog(null, "경고합니다");//특정한 위치를 줘야하는데 그냥 화면에 띄우고싶으면 null
				JOptionPane.showMessageDialog(null, "경고합니다", "경고메세지",JOptionPane.WARNING_MESSAGE );//창제목을 주려면 아이콘도 줘야함 열거클래스라 클래스명으로 들어감
			}
		});
		
		//입력메세지 버튼
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblMessage.setText("입력버튼을 누르셨습니다");
			}
		});
		
		//종료버튼 클릭
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblMessage.setText("종료버튼을 누르셨습니다");
				System.exit(0);
			}
		});
		
		//예/아니오버튼
		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//물어보는거 int로 받는게 있으면 보통 0 1인데 인덱스 순서라 0번이다
				int ans=JOptionPane.showConfirmDialog(null, "종료할까요?", "작업종료창", JOptionPane.YES_NO_OPTION);
				if(ans==0) {
					lblMessage.setText("작업을 계속 진행합니다");
				}else {
					lblMessage.setText("작업을 종료합니다");
				}
			}
		});
		
		//예/아니오/취소
		btn5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//물어보는거 int로 받는게 있으면 보통 0 1인데 인덱스 순서라 0번이다
				int ans=JOptionPane.showConfirmDialog(null, "종료할까요?", "작업종료창", JOptionPane.YES_NO_CANCEL_OPTION);
				if(ans==0) {
					lblMessage.setText("작업을 계속 진행합니다");
				}else if(ans ==1) {
					lblMessage.setText("작업을 종료합니다");
				}else {
					JOptionPane.showMessageDialog(null, "작업취소합니다","작업취소",JOptionPane.CANCEL_OPTION);
					lblMessage.setText("작업을 취소합니다");
				}
			}
		});
	}
	
	public static void main(String[] args) {
		new T07_Message();
	}
}
