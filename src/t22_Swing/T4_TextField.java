package t22_Swing;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class T4_TextField extends JFrame{
	JPanel pn1, pn2, pn3;
	JTextField txtMid,txtName,txtAge; //여기서만 쓰기 때문에 프라이빗 상관없다
	JLabel lblNewLabel, lblMit, lblPW, lblName, lblAge, lblImage;
	JButton btnInput, btnReset, btnExit;
	private JPasswordField txtPwd;
	
	//정규화 비밀번호용
	String regAge = "^[0-9]+$";
	
	public T4_TextField() {
		//UI
		setTitle("텍스트박스 연습");
		setSize(600, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		pn1 = new JPanel();
		pn1.setBackground(Color.ORANGE);
		pn1.setBounds(12, 10, 560, 60);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		lblNewLabel = new JLabel("회 원 가 입");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 560, 60);
		pn1.add(lblNewLabel);
		
		pn2 = new JPanel();
		pn2.setBounds(12, 80, 560, 281);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		lblMit = new JLabel("아이디");
		lblMit.setFont(new Font("굴림", Font.BOLD, 18));
		lblMit.setHorizontalAlignment(SwingConstants.CENTER);
		lblMit.setBounds(12, 29, 120, 34);
		pn2.add(lblMit);
		
		lblPW = new JLabel("비밀번호");
		lblPW.setHorizontalAlignment(SwingConstants.CENTER);
		lblPW.setFont(new Font("굴림", Font.BOLD, 18));
		lblPW.setBounds(12, 92, 120, 34);
		pn2.add(lblPW);
		
		lblName = new JLabel("성명");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("굴림", Font.BOLD, 18));
		lblName.setBounds(12, 155, 120, 34);
		pn2.add(lblName);
		
		lblAge = new JLabel("나이");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setFont(new Font("굴림", Font.BOLD, 18));
		lblAge.setBounds(12, 218, 120, 34);
		pn2.add(lblAge);
		
		txtMid = new JTextField();
		txtMid.setFont(new Font("굴림", Font.BOLD, 18));
		txtMid.setBounds(144, 29, 324, 34);
		pn2.add(txtMid);
		txtMid.setColumns(10);
		
		txtName = new JTextField();
		txtName.setFont(new Font("굴림", Font.BOLD, 18));
		txtName.setColumns(10);
		txtName.setBounds(144, 155, 324, 34);
		pn2.add(txtName);
		
		txtAge = new JTextField();
		txtAge.setFont(new Font("굴림", Font.BOLD, 18));
		txtAge.setColumns(10);
		txtAge.setBounds(144, 218, 324, 34);
		pn2.add(txtAge);
		
		txtPwd = new JPasswordField();
		txtPwd.setBounds(144, 92, 324, 34);
		pn2.add(txtPwd);
		
		lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon(T4_TextField.class.getResource("/t22_Swing/images/22.jpg")));
		lblImage.setBounds(0, 0, 560, 281);
		pn2.add(lblImage);
		
		pn3 = new JPanel();
		pn3.setBackground(new Color(204, 153, 204));
		pn3.setBounds(12, 371, 560, 60);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		btnInput = new JButton("회원가입");
		btnInput.setFont(new Font("굴림", Font.BOLD, 18));
		btnInput.setBounds(39, 10, 134, 40);
		pn3.add(btnInput);
		
		btnReset = new JButton("다시입력");
		btnReset.setFont(new Font("굴림", Font.BOLD, 18));
		btnReset.setBounds(212, 10, 134, 40);
		pn3.add(btnReset);
		
		btnExit = new JButton("작업종료");
		btnExit.setFont(new Font("굴림", Font.BOLD, 18));
		btnExit.setBounds(385, 10, 134, 40);
		pn3.add(btnExit);
		
		
		/*========================*/
		setVisible(true);
		/*===========CODE=============*/
		
		//다시입력버튼 클릭
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMid.setText("");
				txtPwd.setText("");
				txtName.setText("");
				txtAge.setText("");
				txtMid.requestFocus();
			}
		});
		
		//회원가입버튼 클릭
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtMid.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "아이디를 입력하세요");
					txtMid.requestFocus();//커서이동
				}
				else if(txtPwd.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요");
					txtPwd.requestFocus();//커서이동
				}
				else if(txtName.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "성명을 입력하세요");
					txtName.requestFocus();//커서이동
				}
//				else if(txtAge.getText().trim().equals("")) {
				else if(!Pattern.matches(regAge, txtAge.getText().trim())) {
					JOptionPane.showMessageDialog(null, "나이를 입력하세요(나이는 숫자만 가능)");
					txtAge.requestFocus();//커서이동
				}
				else {
					JOptionPane.showMessageDialog(null,"회원가입이 완료 되었습니다");
				}
			}
		});
		
		//종료버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	public static void main(String[] args) {
		new T4_TextField();
	}
}
