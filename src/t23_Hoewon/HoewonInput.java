package t23_Hoewon;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;

public class HoewonInput extends JFrame{
	private JTextField txtName;
	private JTextField txtAge;
	private JTextField txtAddress;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	public HoewonInput() {
		//크기바꾸지 말기 바꾸면 사이즈가 달라서 헷갈린다 착시 같아짐
	//UI
			setTitle("회원등록");
			setSize(800, 500);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLocationRelativeTo(null);
			setResizable(false);
			getContentPane().setLayout(null);
			
			JPanel pn1 = new JPanel();
			pn1.setBounds(0, 0, 784, 86);
			getContentPane().add(pn1);
			pn1.setLayout(null);
			
			JLabel lblTitle = new JLabel("회 원 가 입 폼");
			lblTitle.setFont(new Font("궁서체", Font.PLAIN, 24));
			lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitle.setBounds(0, 0, 784, 86);
			pn1.add(lblTitle);
			
			JPanel pn2 = new JPanel();
			pn2.setBounds(0, 83, 784, 293);
			getContentPane().add(pn2);
			pn2.setLayout(null);
			
			JLabel lblName = new JLabel("성명");
			lblName.setFont(new Font("굴림", Font.BOLD, 17));
			lblName.setHorizontalAlignment(SwingConstants.CENTER);
			lblName.setBounds(12, 21, 110, 33);
			pn2.add(lblName);
			
			JLabel lblAge = new JLabel("나이");
			lblAge.setHorizontalAlignment(SwingConstants.CENTER);
			lblAge.setFont(new Font("굴림", Font.BOLD, 17));
			lblAge.setBounds(12, 75, 110, 33);
			pn2.add(lblAge);
			
			JLabel lblGender = new JLabel("성별");
			lblGender.setHorizontalAlignment(SwingConstants.CENTER);
			lblGender.setFont(new Font("굴림", Font.BOLD, 17));
			lblGender.setBounds(12, 129, 110, 33);
			pn2.add(lblGender);
			
			JLabel lblJoinday = new JLabel("가입일");
			lblJoinday.setHorizontalAlignment(SwingConstants.CENTER);
			lblJoinday.setFont(new Font("굴림", Font.BOLD, 17));
			lblJoinday.setBounds(12, 183, 110, 33);
			pn2.add(lblJoinday);
			
			JLabel lblAddress = new JLabel("주소");
			lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
			lblAddress.setFont(new Font("굴림", Font.BOLD, 17));
			lblAddress.setBounds(12, 237, 110, 33);
			pn2.add(lblAddress);
			
			txtName = new JTextField();
			txtName.setFont(new Font("굴림", Font.PLAIN, 17));
			txtName.setBounds(220, 22, 444, 33);
			pn2.add(txtName);
			txtName.setColumns(10);
			
			txtAge = new JTextField();
			txtAge.setFont(new Font("굴림", Font.PLAIN, 17));
			txtAge.setColumns(10);
			txtAge.setBounds(220, 77, 444, 33);
			pn2.add(txtAge);
			
			JRadioButton rdMale = new JRadioButton("남자");
			buttonGroup.add(rdMale);
			rdMale.setFont(new Font("굴림", Font.PLAIN, 17));
			rdMale.setBounds(220, 135, 121, 23);
			pn2.add(rdMale);
			
			JRadioButton rdFemale = new JRadioButton("여자");
			buttonGroup.add(rdFemale);
			rdFemale.setFont(new Font("굴림", Font.PLAIN, 17));
			rdFemale.setBounds(420, 135, 121, 23);
			pn2.add(rdFemale);
			
			JComboBox cbYY = new JComboBox();
			cbYY.setFont(new Font("굴림", Font.BOLD, 17));
			cbYY.setBounds(220, 182, 101, 37);
			pn2.add(cbYY);
			
			JLabel lblYY = new JLabel("년");
			lblYY.setFont(new Font("굴림", Font.BOLD, 17));
			lblYY.setBounds(329, 182, 57, 37);
			pn2.add(lblYY);
			
			JComboBox cbMM = new JComboBox();
			cbMM.setFont(new Font("굴림", Font.BOLD, 17));
			cbMM.setBounds(398, 179, 101, 37);
			pn2.add(cbMM);
			
			JLabel lblMM = new JLabel("월");
			lblMM.setFont(new Font("굴림", Font.BOLD, 17));
			lblMM.setBounds(507, 179, 57, 37);
			pn2.add(lblMM);
			
			JComboBox cbDD = new JComboBox();
			cbDD.setFont(new Font("굴림", Font.BOLD, 17));
			cbDD.setBounds(576, 179, 101, 37);
			pn2.add(cbDD);
			
			JLabel lblDD = new JLabel("일");
			lblDD.setFont(new Font("굴림", Font.BOLD, 17));
			lblDD.setBounds(685, 179, 57, 37);
			pn2.add(lblDD);
			
			txtAddress = new JTextField();
			txtAddress.setFont(new Font("굴림", Font.PLAIN, 17));
			txtAddress.setColumns(10);
			txtAddress.setBounds(220, 242, 444, 33);
			pn2.add(txtAddress);
			
			JPanel pn3 = new JPanel();
			pn3.setBounds(0, 375, 784, 86);
			getContentPane().add(pn3);
			pn3.setLayout(null);
			
			JButton btnInput = new JButton("가입하기");
			btnInput.setFont(new Font("굴림", Font.BOLD, 18));
			btnInput.setBounds(58, 10, 184, 66);
			pn3.add(btnInput);
			
			JButton btnReset = new JButton("다시입력");
			btnReset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnReset.setFont(new Font("굴림", Font.BOLD, 18));
			btnReset.setBounds(300, 10, 184, 66);
			pn3.add(btnReset);
			
			JButton btnClose = new JButton("창닫기");
			btnClose.setFont(new Font("굴림", Font.BOLD, 18));
			btnClose.setBounds(542, 10, 184, 66);
			pn3.add(btnClose);
			
			
			
			
			//======================
			setVisible(true);
			//======================
			
			//창닫기
			btnClose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			//창닫기
			btnClose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			//창닫기
			btnClose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			
	}
	public static void main(String[] args) {
		new HoewonInput();
	}
}
