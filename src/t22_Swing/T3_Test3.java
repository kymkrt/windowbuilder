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

public class T3_Test3 extends JFrame{
	JPanel pn1, pn2, pn3;
	JButton btn1, btn2, btn3, btn4, btn5, btnRandom, btnExit;
	JLabel lblTitle, lbl1, lbl2, lbl3, lbl4, lblcnt1,lblcnt2,lblcnt3,lblcnt4;
	int cnt1=0, cnt2=0, cnt3=0, cnt4=0;
	
	public T3_Test3() {
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
		
		lblTitle = new JLabel("이미지연습창");
		lblTitle.setFont(new Font("굴림", Font.BOLD, 20));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(195, 10, 396, 104);
		pn1.add(lblTitle);
		
		btnExit = new JButton("종료");
		btnExit.setFont(new Font("굴림", Font.BOLD, 18));
		btnExit.setBounds(603, 21, 169, 76);
		pn1.add(btnExit);
		
		btnRandom = new JButton("랜덤보기");
		btnRandom.setFont(new Font("굴림", Font.BOLD, 18));
		btnRandom.setBounds(12, 21, 169, 76);
		pn1.add(btnRandom);
		
		pn2 = new JPanel();
		pn2.setBounds(0, 127, 784, 311);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		lbl1 = new JLabel("");
		lbl1.setIcon(new ImageIcon(T3_Test3.class.getResource("/t22_Swing/images/112.jpg")));
		lbl1.setBounds(40, 10, 145, 291);
		pn2.add(lbl1);
		
		lbl2 = new JLabel("");
		lbl2.setIcon(new ImageIcon(T3_Test3.class.getResource("/t22_Swing/images/113.jpg")));
		lbl2.setBounds(225, 10, 145, 291);
		pn2.add(lbl2);
		
		lbl3 = new JLabel("");
		lbl3.setIcon(new ImageIcon("D:\\javaGroup\\java\\work2\\windowBuilder\\Images\\12.PNG"));
		lbl3.setBounds(410, 10, 145, 291);
		pn2.add(lbl3);
		
		lbl4 = new JLabel("");
		lbl4.setIcon(new ImageIcon("D:\\javaGroup\\java\\work2\\windowBuilder\\Images\\11_1.PNG"));
		lbl4.setBounds(595, 10, 145, 291);
		pn2.add(lbl4);
		
		pn3 = new JPanel();
		pn3.setBounds(0, 437, 784, 114);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		btn1 = new JButton("그림1");
		
		btn1.setBounds(29, 10, 122, 57);
		pn3.add(btn1);
		
		btn2 = new JButton("그림2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn2.setBounds(180, 10, 122, 57);
		pn3.add(btn2);
		
		btn3 = new JButton("그림3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn3.setBounds(331, 10, 122, 57);
		pn3.add(btn3);
		
		btn4 = new JButton("그림4");
		btn4.setBounds(482, 10, 122, 57);
		pn3.add(btn4);
		
		btn5 = new JButton("모두보기");
		btn5.setBounds(633, 10, 122, 57);
		pn3.add(btn5);
		
		lblcnt1 = new JLabel("1번 횟수 "+cnt1);
		lblcnt1.setFont(new Font("굴림", Font.BOLD, 14));
		lblcnt1.setHorizontalAlignment(SwingConstants.CENTER);
		lblcnt1.setBounds(29, 77, 122, 27);
		pn3.add(lblcnt1);
		
		lblcnt2 = new JLabel("2번횟수 "+cnt2);
		lblcnt2.setHorizontalAlignment(SwingConstants.CENTER);
		lblcnt2.setFont(new Font("굴림", Font.BOLD, 14));
		lblcnt2.setBounds(180, 77, 122, 27);
		pn3.add(lblcnt2);
		
		lblcnt3 = new JLabel("3번 횟수 "+cnt3);
		lblcnt3.setHorizontalAlignment(SwingConstants.CENTER);
		lblcnt3.setFont(new Font("굴림", Font.BOLD, 14));
		lblcnt3.setBounds(331, 77, 122, 27);
		pn3.add(lblcnt3);
		
		lblcnt4 = new JLabel("4번 횟수 "+cnt4);
		lblcnt4.setHorizontalAlignment(SwingConstants.CENTER);
		lblcnt4.setFont(new Font("굴림", Font.BOLD, 14));
		lblcnt4.setBounds(482, 77, 122, 27);
		pn3.add(lblcnt4);
		
		
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
		//랜덤버튼
		btnRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					lbl1.setVisible(false);
					lbl2.setVisible(false);
					lbl3.setVisible(false);
					lbl4.setVisible(false);
					int rand = (int) (Math.random()*4)+1;
					if(rand==1) { 
						lbl1.setVisible(true);
						cnt1++;
						lblcnt1.setText("1번 횟수 " + cnt1);
					}
					if(rand==2) { 
						lbl2.setVisible(true);
						cnt2++;
						lblcnt2.setText("2번 횟수 " + cnt2);
					}
					if(rand==3) { 
						lbl3.setVisible(true);
						cnt3++;
						lblcnt3.setText("3번 횟수 " + cnt3);
					}
					if(rand==4) { 
						lbl4.setVisible(true);
						cnt4++;
						lblcnt4.setText("4번 횟수 " + cnt4);
					}
			}
		});
		
	}
	public static void main(String[] args) {
		new T3_Test3();
	}
}
