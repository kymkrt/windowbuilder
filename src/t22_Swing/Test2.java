package t22_Swing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Test2 extends JFrame{
	JPanel pn1, pn2, pn3;
	
	public Test2() {
		setTitle("연습하기");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		pn1 = new JPanel();
		pn1.setBounds(0, 0, 784, 124);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblTitle = new JLabel("이미지연습창");
		lblTitle.setFont(new Font("굴림", Font.BOLD, 20));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(195, 10, 396, 104);
		pn1.add(lblTitle);
		
		JButton btnExit = new JButton("종료");
		btnExit.setFont(new Font("굴림", Font.BOLD, 18));
		btnExit.setBounds(603, 21, 169, 76);
		pn1.add(btnExit);
		
		JButton btnRandom = new JButton("랜덤보기");
		btnRandom.setFont(new Font("굴림", Font.BOLD, 18));
		btnRandom.setBounds(12, 21, 169, 76);
		pn1.add(btnRandom);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 127, 784, 311);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JLabel lbl1 = new JLabel("");
		lbl1.setIcon(new ImageIcon(Test2.class.getResource("/t22_Swing/images/112.jpg")));
		lbl1.setBounds(40, 10, 145, 291);
		pn2.add(lbl1);
		
		JLabel lbl2 = new JLabel("");
		lbl2.setIcon(new ImageIcon(Test2.class.getResource("/t22_Swing/images/113.jpg")));
		lbl2.setBounds(225, 10, 145, 291);
		pn2.add(lbl2);
		
		JLabel lbl3 = new JLabel("");
		lbl3.setIcon(new ImageIcon("D:\\javaGroup\\java\\work2\\windowBuilder\\Images\\12.PNG"));
		lbl3.setBounds(410, 10, 145, 291);
		pn2.add(lbl3);
		
		JLabel lbl4 = new JLabel("");
		lbl4.setIcon(new ImageIcon("D:\\javaGroup\\java\\work2\\windowBuilder\\Images\\11_1.PNG"));
		lbl4.setBounds(595, 10, 145, 291);
		pn2.add(lbl4);
		
		pn3 = new JPanel();
		pn3.setBounds(0, 437, 784, 114);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		JButton btn1 = new JButton("그림1");
		
		btn1.setBounds(29, 10, 122, 77);
		pn3.add(btn1);
		
		JButton btn2 = new JButton("그림2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn2.setBounds(180, 10, 122, 77);
		pn3.add(btn2);
		
		JButton btn3 = new JButton("그림3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn3.setBounds(331, 10, 122, 77);
		pn3.add(btn3);
		
		JButton btn4 = new JButton("그림4");
		btn4.setBounds(482, 10, 122, 77);
		pn3.add(btn4);
		
		JButton btn5 = new JButton("모두보기");
		btn5.setBounds(633, 10, 122, 77);
		pn3.add(btn5);
		
		
		setVisible(true);
		//이 위로 다 뷰 
		/*=============================*/
		
		//종료버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		//1번그림보기
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl1.setVisible(true);
				lbl2.setVisible(false);
				lbl3.setVisible(false);
				lbl4.setVisible(false);
			}
		});
		//2번그림보기
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl1.setVisible(false);
				lbl2.setVisible(true);
				lbl3.setVisible(false);
				lbl4.setVisible(false);
			}
		});
		//3번그림보기
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl1.setVisible(false);
				lbl2.setVisible(false);
				lbl3.setVisible(true);
				lbl4.setVisible(false);
			}
		});
		//4번그림보기
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl1.setVisible(false);
				lbl2.setVisible(false);
				lbl3.setVisible(false);
				lbl4.setVisible(true);
			}
		});
		//모든 그림보기
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl1.setVisible(true);
				lbl2.setVisible(true);
				lbl3.setVisible(true);
				lbl4.setVisible(true);
			}
		});
		
	}
	public static void main(String[] args) {
		new Test2();
	}
}
