package t22_Swing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import t23_Hoewon.HoewonDAO;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class T7_JTable extends JFrame{
	private JTable table;
	private JPanel pn1, pn2, pn3;
	private JLabel lblTitle;
	JButton btnSelect, btnExit;
	JScrollPane scrollPane;
	Vector title,vData;
	DefaultTableModel dtm;
	
	HoewonDAO dao = new HoewonDAO();//생성해서 여기서 쓴다 부모객체의 것도 사용가능
	
	public T7_JTable() {
		
		//UI
		setTitle("콤보상자/리스트박스 연습");
		setSize(600, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		pn1 = new JPanel();
		pn1.setBounds(12, 10, 560, 58);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		lblTitle = new JLabel("회원리스트");
		lblTitle.setBounds(0, 0, 560, 62);
		lblTitle.setFont(new Font("굴림", Font.BOLD, 20));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		pn1.add(lblTitle);
		
		pn2 = new JPanel();
		pn2.setBounds(12, 74, 560, 277);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		
		pn3 = new JPanel();
		pn3.setBounds(12, 351, 560, 90);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		btnSelect = new JButton("선택셀값출력");
		btnSelect.setBounds(12, 24, 135, 45);
		btnSelect.setFont(new Font("굴림", Font.BOLD, 15));
		pn3.add(btnSelect);
		
		btnExit = new JButton("작업종료");
		btnExit.setBounds(413, 24, 135, 45);
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
		scrollPane.setBounds(0, 0, 560, 277);
		pn2.add(scrollPane);
		
		//6.실행시킨후, 출력된 화면에서 결과를 확인한다
		
		
		//=================
		setVisible(true);
		//=================
		
		//선택한 셀의 내용 출력
		btnSelect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//먼저 선택한 행을 읽어온다 테이블에서 자료를 읽어온다
				int row = table.getSelectedRow(); //없으면 -1반환
				if(row !=-1) {
//					System.out.println("선택된 내용 : "+table.getValueAt(row, 0)); 이렇게 쓸수도 있다 콘솔창에만 나옴
					String temp = "성명: "+table.getValueAt(row, 1)+", 나이: "+table.getValueAt(row, 2)+", 성별: "+table.getValueAt(row, 3)+", 가입일: "+table.getValueAt(row, 4).toString().substring(0,10)+", 주소: "+table.getValueAt(row, 5);
					JOptionPane.showMessageDialog(null, temp);
				}
			}
		});
		//만들어운 jTable을 사용하면 편하다
		
		
		
		//작업종료
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		new T7_JTable();
	}
}
