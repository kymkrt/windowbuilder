package t23_Hoewon;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HoewonMain extends JFrame{
	JPanel pn1, pn2, pn3;
	JLabel lblTitle, lblImage;
	JButton btnInput, btnSearch, btnList, btnExit;
	
	
	public HoewonMain() {
		
		//UI
		setTitle("회원관리프로그램(v1.0)");
		setSize(800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		pn1 = new JPanel();
		pn1.setBounds(0, 0, 784, 82);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		lblTitle = new JLabel("회원관리 프로그램(v1.0)");
		lblTitle.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 22));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(0, 0, 784, 82);
		pn1.add(lblTitle);
		
		pn2 = new JPanel();
		pn2.setBounds(0, 81, 784, 298);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		lblImage = new JLabel("New label");
		lblImage.setIcon(new ImageIcon(HoewonMain.class.getResource("/t22_Swing/images/22.jpg")));
		lblImage.setBounds(0, 0, 784, 298);
		pn2.add(lblImage);
		
		pn3 = new JPanel();
		pn3.setBounds(0, 379, 784, 82);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		btnInput = new JButton("회원등록");
		btnInput.setFont(new Font("굴림", Font.BOLD, 20));
		btnInput.setBounds(36, 10, 151, 62);
		pn3.add(btnInput);
		
		btnSearch = new JButton("개별조회");
		btnSearch.setFont(new Font("굴림", Font.BOLD, 20));
		btnSearch.setBounds(223, 10, 151, 62);
		pn3.add(btnSearch);
		
		btnList = new JButton("전체조회");
		btnList.setFont(new Font("굴림", Font.BOLD, 20));
		btnList.setBounds(410, 10, 151, 62);
		pn3.add(btnList);
		
		btnExit = new JButton("종료");
		btnExit.setFont(new Font("굴림", Font.BOLD, 20));
		btnExit.setBounds(597, 10, 151, 62);
		pn3.add(btnExit);
		
		
		
		
		//============================
		setVisible(true);
		//============================
		
		//회원등록버튼 클릭
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); //현재 창(프레임)만 닫는다
				new HoewonInput();
			}
		});
		//회원개별조회 클릭
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); //현재 창(프레임)만 닫는다
				
			}
		});
		//회원전체조회 클릭
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); //현재 창(프레임)만 닫는다
				new HoewonList();
			}
		});
		//종료버튼 클릭
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		new HoewonMain();
	}
}
