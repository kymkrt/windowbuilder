package t23_Hoewon;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;

public class HoewonInput extends JFrame{
	private JTextField txtName,txtAge,txtAddress;
	JPanel pn1,pn2,pn3;
	JLabel lblTitle,lblName, lblAge, lblGender, lblJoinday, lblAddress, lblYY,lblMM,lblDD;
	JRadioButton rdMale, rdFemale;
	JComboBox cbYY,cbMM,cbDD;
	JButton btnInput,btnReset,btnClose;
	
	HoewonVO vo = new HoewonVO();
	HoewonDAO dao = new HoewonDAO();
	int res = 0;
	
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
			
			pn1 = new JPanel();
			pn1.setBounds(0, 0, 784, 86);
			getContentPane().add(pn1);
			pn1.setLayout(null);
			
			lblTitle = new JLabel("회 원 가 입 폼");
			lblTitle.setFont(new Font("궁서체", Font.PLAIN, 24));
			lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitle.setBounds(0, 0, 784, 86);
			pn1.add(lblTitle);
			
			pn2 = new JPanel();
			pn2.setBounds(0, 83, 784, 293);
			getContentPane().add(pn2);
			pn2.setLayout(null);
			
			lblName = new JLabel("성명");
			lblName.setFont(new Font("굴림", Font.BOLD, 17));
			lblName.setHorizontalAlignment(SwingConstants.CENTER);
			lblName.setBounds(12, 21, 110, 33);
			pn2.add(lblName);
			
			lblAge = new JLabel("나이");
			lblAge.setHorizontalAlignment(SwingConstants.CENTER);
			lblAge.setFont(new Font("굴림", Font.BOLD, 17));
			lblAge.setBounds(12, 75, 110, 33);
			pn2.add(lblAge);
			
			lblGender = new JLabel("성별");
			lblGender.setHorizontalAlignment(SwingConstants.CENTER);
			lblGender.setFont(new Font("굴림", Font.BOLD, 17));
			lblGender.setBounds(12, 129, 110, 33);
			pn2.add(lblGender);
			
			lblJoinday = new JLabel("가입일");
			lblJoinday.setHorizontalAlignment(SwingConstants.CENTER);
			lblJoinday.setFont(new Font("굴림", Font.BOLD, 17));
			lblJoinday.setBounds(12, 183, 110, 33);
			pn2.add(lblJoinday);
			
			lblAddress = new JLabel("주소");
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
			
			rdMale = new JRadioButton("남자");
			buttonGroup.add(rdMale);
			rdMale.setFont(new Font("굴림", Font.PLAIN, 17));
			rdMale.setBounds(220, 135, 121, 23);
			pn2.add(rdMale);
			
			rdFemale = new JRadioButton("여자");
			rdFemale.setSelected(true);
			buttonGroup.add(rdFemale);
			rdFemale.setFont(new Font("굴림", Font.PLAIN, 17));
			rdFemale.setBounds(420, 135, 121, 23);
			pn2.add(rdFemale);
			
			//년도/월/일 초기값 생성하기
			String[] yy = new String[20];
			String[] mm = new String[12];
			String[] dd = new String[31];//원래는 윤달체크
			
			int imsi =0;
			for(int i=0;i<yy.length;i++) {
				imsi =2024 -i;
				yy[i]=imsi+"";//숫자인데 문자 배열에 넣기위해 더해줌
			}
			for(int i=0;i<mm.length;i++) {
				mm[i]=(i+1)+"";//숫자인데 문자 배열에 넣기위해 더해줌
			}
			for(int i=0;i<dd.length;i++) {
				dd[i]=(i+1)+"";//숫자인데 문자 배열에 넣기위해 더해줌
			}
			cbYY = new JComboBox(yy);
			cbYY.setFont(new Font("굴림", Font.BOLD, 17));
			cbYY.setBounds(220, 182, 101, 37);
			pn2.add(cbYY);
			
			
			lblYY = new JLabel("년");
			lblYY.setFont(new Font("굴림", Font.BOLD, 17));
			lblYY.setBounds(329, 182, 57, 37);
			pn2.add(lblYY);
			
			cbMM = new JComboBox(mm);
			cbMM.setFont(new Font("굴림", Font.BOLD, 17));
			cbMM.setBounds(398, 179, 101, 37);
			pn2.add(cbMM);
			
			lblMM = new JLabel("월");
			lblMM.setFont(new Font("굴림", Font.BOLD, 17));
			lblMM.setBounds(507, 179, 57, 37);
			pn2.add(lblMM);
			
			cbDD = new JComboBox(dd);
			cbDD.setFont(new Font("굴림", Font.BOLD, 17));
			cbDD.setBounds(576, 179, 101, 37);
			pn2.add(cbDD);
			
			lblDD = new JLabel("일");
			lblDD.setFont(new Font("굴림", Font.BOLD, 17));
			lblDD.setBounds(685, 179, 57, 37);
			pn2.add(lblDD);
			
			txtAddress = new JTextField();
			txtAddress.setFont(new Font("굴림", Font.PLAIN, 17));
			txtAddress.setColumns(10);
			txtAddress.setBounds(220, 242, 444, 33);
			pn2.add(txtAddress);
			
			pn3 = new JPanel();
			pn3.setBounds(0, 375, 784, 86);
			getContentPane().add(pn3);
			pn3.setLayout(null);
			
			btnInput = new JButton("가입하기");
			btnInput.setFont(new Font("굴림", Font.BOLD, 18));
			btnInput.setBounds(58, 10, 184, 66);
			pn3.add(btnInput);
			
			btnReset = new JButton("다시입력");
			btnReset.setFont(new Font("굴림", Font.BOLD, 18));
			btnReset.setBounds(300, 10, 184, 66);
			pn3.add(btnReset);
			
			btnClose = new JButton("창닫기");
			btnClose.setFont(new Font("굴림", Font.BOLD, 18));
			btnClose.setBounds(542, 10, 184, 66);
			pn3.add(btnClose);
			
			
			
			
			//======================
			setVisible(true);
			//======================
			
			//회원가입버튼을 키보드 엔터키로 쳤을때 수행
			btnInput.addKeyListener(new KeyAdapter() {//아답터로 안하면 3개 오버라이딩
				@Override
				public void keyPressed(KeyEvent e) {
					setHoewonInput();
				}
			});
			
			//회원가입 버튼 클릭(마우스로 클릭시에 수행된다)
			btnInput.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	setHoewonInput();
		    }
		});
			//다시입력 버튼 클릭
			btnReset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			//창닫기 버튼 클릭
			btnClose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose(); //현재 창(프레임)만 닫는다
					new HoewonMain();
				}
			});
	}

		//회원가입처리 메소드
	protected void setHoewonInput() {
		 String name = txtName.getText().trim();
     String age = txtAge.getText().trim();
     String gender = "";
     String joinday = cbYY.getSelectedItem() + "/" + cbMM.getSelectedItem() + "/" + cbDD.getSelectedItem();
     String address = txtAddress.getText().trim();
     
     // 유효성 검사
     if (name.equals("")) {
         JOptionPane.showMessageDialog(null, "성명을 입력하세요");
         txtName.requestFocus();
     } else if (!Pattern.matches("^[0-9]+$", age)) { // 'age' 변수를 검증
         JOptionPane.showMessageDialog(null, "나이를 숫자로 입력하세요");
         txtAge.requestFocus();
     } else {
         // 성별 설정
         if (rdMale.isSelected()) {
             gender = "남자"; 
         } else {
             gender = "여자";
         }

         // 모든 체크가 정상적으로 끝나면 DB에 새로운 회원을 저장한다
         // 회원 중복처리 할 것
         
         // 회원 중복처리가 끝난 정상적인 자료는 DB에 저장처리한다
         vo.setName(name);
         vo.setAge(Integer.parseInt(age));
         vo.setGender(gender);
         vo.setJoinday(joinday);
         vo.setAddress(address);
         
         int res = dao.setHoewonInput(vo);
         
         if (res != 0) {
             JOptionPane.showMessageDialog(null, "회원가입 되셨습니다");
             dispose();
             new HoewonMain();
         } else {
             JOptionPane.showMessageDialog(null, "회원가입 실패");
             txtName.requestFocus();
         }
     }
	}
	
	//하나의 프로젝트에는 메인이 하나 이 메인은 테스트용
//	public static void main(String[] args) {
//		new HoewonInput();
//	}
}
