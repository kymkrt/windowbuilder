package t22_Swing;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class T5_Radio_Checkbox extends JFrame{
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JPanel pn1, pn2, pn3;
	JLabel lblTitle, lblGender, lblHobby, lblMassege;
	JRadioButton rdMale, rdFemale;
	JCheckBox ckHobby1,ckHobby2,ckHobby3,ckHobby4;
	JButton btnGender, btnHobby, btnExit;
	
	
	public T5_Radio_Checkbox() {
		//UI
		setTitle("텍스트박스 연습");
		setSize(600, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		pn1 = new JPanel();
		pn1.setBounds(0, 0, 584, 67);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		lblTitle = new JLabel("라디오버튼/체크박스연습");
		lblTitle.setFont(new Font("굴림", Font.BOLD, 18));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(0, 0, 584, 67);
		pn1.add(lblTitle);
		
		pn2 = new JPanel();
		pn2.setBounds(0, 69, 584, 306);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		lblGender = new JLabel("성별");
		lblGender.setFont(new Font("굴림", Font.BOLD, 20));
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setBounds(47, 54, 111, 43);
		pn2.add(lblGender);
		
		lblHobby = new JLabel("취미");
		lblHobby.setHorizontalAlignment(SwingConstants.CENTER);
		lblHobby.setFont(new Font("굴림", Font.BOLD, 20));
		lblHobby.setBounds(47, 124, 111, 43);
		pn2.add(lblHobby);
		
		rdMale = new JRadioButton("남자");
		buttonGroup.add(rdMale);
		rdMale.setHorizontalAlignment(SwingConstants.CENTER);
		rdMale.setFont(new Font("굴림", Font.PLAIN, 18));
		rdMale.setBounds(166, 65, 121, 23);
		pn2.add(rdMale);
		
		rdFemale = new JRadioButton("여자");
		buttonGroup.add(rdFemale);
		rdFemale.setHorizontalAlignment(SwingConstants.CENTER);
		rdFemale.setFont(new Font("굴림", Font.PLAIN, 18));
		rdFemale.setBounds(317, 66, 121, 23);
		pn2.add(rdFemale);
		
		ckHobby1 = new JCheckBox("등산");
		ckHobby1.setFont(new Font("굴림", Font.BOLD, 18));
		ckHobby1.setBounds(166, 131, 97, 31);
		pn2.add(ckHobby1);
		
		ckHobby2 = new JCheckBox("낚시");
		ckHobby2.setFont(new Font("굴림", Font.BOLD, 18));
		ckHobby2.setBounds(265, 131, 97, 31);
		pn2.add(ckHobby2);
		
		ckHobby3 = new JCheckBox("수영");
		ckHobby3.setFont(new Font("굴림", Font.BOLD, 18));
		ckHobby3.setBounds(366, 131, 97, 31);
		pn2.add(ckHobby3);
		
		ckHobby4 = new JCheckBox("바둑");
		ckHobby4.setFont(new Font("굴림", Font.BOLD, 18));
		ckHobby4.setBounds(467, 131, 97, 31);
		pn2.add(ckHobby4);
		
		lblMassege = new JLabel("메세지출력");
		lblMassege.setFont(new Font("굴림", Font.BOLD, 18));
		lblMassege.setHorizontalAlignment(SwingConstants.CENTER);
		lblMassege.setBounds(47, 192, 506, 90);
		pn2.add(lblMassege);
		
		pn3 = new JPanel();
		pn3.setBounds(0, 374, 584, 67);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		btnGender = new JButton("성별출력");
		btnGender.setFont(new Font("굴림", Font.BOLD, 18));
		btnGender.setBounds(44, 10, 136, 47);
		pn3.add(btnGender);
		
		btnHobby = new JButton("취미출력");
		btnHobby.setFont(new Font("굴림", Font.BOLD, 18));
		btnHobby.setBounds(224, 10, 136, 47);
		pn3.add(btnHobby);
		
		btnExit = new JButton("작업종료");
		btnExit.setFont(new Font("굴림", Font.BOLD, 18));
		btnExit.setBounds(404, 10, 136, 47);
		pn3.add(btnExit);
		
		//=================================
		setVisible(true);
		
		
		//=================================
		//성별버튼
		btnGender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gender = "선택하신 성별은 ";
				if(rdMale.isSelected()) {
					gender+= rdMale.getText();
				}
				else {
					gender+= rdFemale.getText();
				}
				lblMassege.setText(gender);
			}
		});
		
		//취미버튼
		btnHobby.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String hobby ="";
				if(ckHobby1.isSelected()) hobby+=ckHobby1.getText()+"/";
				if(ckHobby2.isSelected()) hobby+=ckHobby2.getText()+"/";
				if(ckHobby3.isSelected()) hobby+=ckHobby3.getText()+"/";
				if(ckHobby4.isSelected()) hobby+=ckHobby4.getText()+"/";
				
				hobby=hobby.substring(0, hobby.length()-1);
				
				lblMassege.setText("선택하신 취미는 "+hobby);
			}
		});
		
		//작업종료버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		new T5_Radio_Checkbox();
	}
}
