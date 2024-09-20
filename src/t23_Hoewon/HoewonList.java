package t23_Hoewon;

import java.awt.Font;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

public class HoewonList extends JFrame{
	private JTable table;
	private JPanel pn1, pn2, pn3;
	JButton btnJoindayAsc, btnExit;
	JScrollPane scrollPane;
	Vector title,vData;
	DefaultTableModel dtm;
	
	HoewonDAO dao = new HoewonDAO();//생성해서 여기서 쓴다 부모객체의 것도 사용가능
	private JButton btnJoindayDesc;
	private JComboBox cbCondition;
	private JTextField txtCondition;
	private JButton btnCondition;
	private JButton btnList;
	
	
	public HoewonList() {
		
	//UI
		setTitle("회원리스트");
		setSize(800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		pn1 = new JPanel();
		pn1.setBounds(12, 10, 760, 67);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		cbCondition = new JComboBox();
		cbCondition.setFont(new Font("굴림", Font.BOLD, 25));
		cbCondition.setModel(new DefaultComboBoxModel(new String[] {"성명", "나이", "성별", "입사일", "주소"}));
		cbCondition.setBounds(26, 0, 151, 67);
		pn1.add(cbCondition);
		
		txtCondition = new JTextField();
		txtCondition.setFont(new Font("굴림", Font.PLAIN, 20));
		txtCondition.setHorizontalAlignment(SwingConstants.CENTER);
		txtCondition.setBounds(203, 0, 164, 67);
		pn1.add(txtCondition);
		txtCondition.setColumns(10);
		
		btnCondition = new JButton("조건검색");
		btnCondition.setFont(new Font("굴림", Font.BOLD, 15));
		btnCondition.setBounds(393, 0, 156, 67);
		pn1.add(btnCondition);
		
		btnList = new JButton("전체검색");
		btnList.setFont(new Font("굴림", Font.BOLD, 15));
		btnList.setBounds(575, 0, 156, 67);
		pn1.add(btnList);
		
		pn2 = new JPanel();
		pn2.setBounds(12, 74, 760, 288);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		
		pn3 = new JPanel();
		pn3.setBounds(12, 361, 760, 90);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		btnJoindayAsc = new JButton("가입일오름차순");
		btnJoindayAsc.setBounds(12, 24, 160, 45);
		btnJoindayAsc.setFont(new Font("굴림", Font.BOLD, 15));
		pn3.add(btnJoindayAsc);
		
		btnJoindayDesc = new JButton("가입일내림차순");
		btnJoindayDesc.setFont(new Font("굴림", Font.BOLD, 15));
		btnJoindayDesc.setBounds(184, 24, 160, 45);
		pn3.add(btnJoindayDesc);
		
		btnExit = new JButton("작업종료");
		btnExit.setBounds(613, 24, 135, 45);
		btnExit.setFont(new Font("굴림", Font.BOLD, 15));
		pn3.add(btnExit);
		
		//JTable 설계
		//1. '부제목' 을 vector로 만들어준다(저장)
		title = new Vector<>();
		title.add("번호");
		title.add("성명");
		title.add("나이");
		title.add("성별");
		title.add("가입일");
		title.add("주소");
		
		//2.'데이터'를 vector로 만들어준다 회원데이터는 데이터베이스에서 가져온다 vo로 가져와야하는데 여기는 벡터 
		vData =dao.getHoewonList();
//		System.out.println("vData : "+vData); //아래 방법 사용
		//3. DB에서 가져온 자료(vData)와 타이틀(title)을 DefaultTableModel(데이터, 타이틀) 객체에 생성하면서 담아준다
		dtm = new DefaultTableModel(vData, title);//
		
		//4.DefaultTableModel에 담긴 벡터타입의 '데이터/타이틀'을 JTable객체에 생성시에 담아준다 그냥 담으면 안됨
		table = new JTable(dtm);//데이터를 넣어야 하기 때문에 데이터쪽으로 옮긴것
		
		
		//5.자료가 담긴 JTable 객체를 JScrollPane 객체 생성시에 담아준다 
//		scrollPane.setViewportView(table); 생성시에 담는거니까 필요없음
		//데이터를 뿌릴때 처음부터 보일수 있도록 해야하기 때문에 ui 쪽에 넣어야 한다
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 760, 288);
		pn2.add(scrollPane);
		
		//6.실행시킨후, 출력된 화면에서 결과를 확인한다
		
		//JTable 속성 제어 연습
		//table의 컬럼크기/크기고정/셀의위치고정
		table.getColumnModel().getColumn(0).setMaxWidth(50); //컬럼의 최대크기 지정
		table.getColumnModel().getColumn(2).setMaxWidth(50); //컬럼의 최대크기 지정
		table.getColumnModel().getColumn(0).setResizable(false);//컬럼크기 변경불가
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getTableHeader().setReorderingAllowed(false);//컬럼 고정
		
		//테이블안의 셀의 내용을 수평정렬하기
		//객체가 하나 더 필요함 셀 렌더링을 해야함
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER); //가운데 정렬 이거만 하면 그대로다
		TableColumnModel tcm = table.getColumnModel();
//		tcm.getColumn(3).setCellRenderer(dtcr); 숫자가 나오는건 반복문이 좋다
		
		//열의 갯수 getColumnCount()
		//전체셀 가운데 정렬
		for(int i=0;i<tcm.getColumnCount();i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
		
		//======================
		setVisible(true);
		//======================
		
		//전체 검색 버튼 클릭
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData =dao.getHoewonList();
				dtm.setDataVector(vData, title);
			}
		});
		
		//조건검색 버튼 클릭
		btnCondition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cbCondi = cbCondition.getSelectedItem().toString();//객체라 문자로 바꿔야함
				String txtCondi = txtCondition.getText();
				
				if(txtCondi.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "검색할 내용을 입력하세요");
					txtCondition.requestFocus();
					return;
				}
				//유효성검사 필수
				if(cbCondi.equals("성명")) vData = dao.getConditionSearch("name",txtCondi);
				else if(cbCondi.equals("나이")) {
					//나이 정규식으로 유효성검사해야함 중괄호 열고 여기 추가
					vData = dao.getConditionSearch("age",txtCondi);
				}
				else if(cbCondi.equals("성별")) vData = dao.getConditionSearch("gender",txtCondi);
				else if(cbCondi.equals("가입일")) vData = dao.getConditionSearch("joinday",txtCondi);
				else if(cbCondi.equals("주소")) vData = dao.getConditionSearch("address",txtCondi);
				
				dtm.setDataVector(vData, title);
			}
		});
		
		//작업종료버튼클릭
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new HoewonMain();
			}
		});
		//가입일 오름차순 버튼 클릭
		btnJoindayAsc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData=dao.getHoewonAlign("joinday","a");
				dtm.setDataVector(vData, title);
			}
		});
		//가입일 내림차순 버튼 클릭
		btnJoindayDesc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData=dao.getHoewonAlign("joinday","d");
				dtm.setDataVector(vData, title);
			}
		});
		
	}
//	public static void main(String[] args) {
//		new HoewonList();
//	}
}
