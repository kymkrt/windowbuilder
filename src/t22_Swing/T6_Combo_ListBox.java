package t22_Swing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class T6_Combo_ListBox extends JFrame{
	JPanel pn1, pn2, pn3, pn4;
	JLabel lblTitle, lblMessage;
	JComboBox comboJob;
	JList listJob1, listJob2;
	JButton btnCombo, btnList1, btnList2, btnExit;
	JTextArea textArea;
	
	public T6_Combo_ListBox() {
		//UI
		setTitle("콤보상자/리스트박스 연습");
		setSize(600, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		pn1 = new JPanel();
		pn1.setBounds(0, 0, 290, 264);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		lblTitle = new JLabel("직업을선택하세요");
		lblTitle.setFont(new Font("굴림", Font.PLAIN, 16));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(12, 10, 266, 51);
		pn1.add(lblTitle);
		
		comboJob = new JComboBox();
		comboJob.setFont(new Font("굴림", Font.BOLD, 18));
		comboJob.setModel(new DefaultComboBoxModel(new String[] {"학   생", "군   인", "회사원", "변호사", "프리랜서", "공무원", "기   타"}));
		comboJob.setBounds(12, 45, 266, 41);
		pn1.add(comboJob);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 96, 266, 158);
		pn1.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		pn2 = new JPanel();
		pn2.setBounds(294, 0, 290, 264);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		listJob1 = new JList();
		listJob1.setModel(new AbstractListModel() {
			String[] values = new String[] {"학  생", "군  인", "회사원", "공무원", "자영업", "변호사", "의  사", "판  사", "기  타"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listJob1.setBounds(12, 10, 266, 122);
		pn2.add(listJob1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 142, 266, 112);
		pn2.add(scrollPane_1);
		
		listJob2 = new JList();
		listJob2.setModel(new AbstractListModel() {
			String[] values = new String[] {"학  생", "군  인", "회사원", "공무원", "자영업", "변호사", "의  사", "판  사", "기  타"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane_1.setViewportView(listJob2);
		
		pn3 = new JPanel();
		pn3.setBounds(0, 265, 584, 86);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		JButton btnCombo = new JButton("콤보출력");
		btnCombo.setFont(new Font("굴림", Font.BOLD, 16));
		btnCombo.setBounds(16, 10, 126, 66);
		pn3.add(btnCombo);
		
		JButton btnList1 = new JButton("리스트출력1");
		btnList1.setFont(new Font("굴림", Font.BOLD, 16));
		btnList1.setBounds(158, 10, 126, 66);
		pn3.add(btnList1);
		
		JButton btnList2 = new JButton("리스트출력2");
		btnList2.setFont(new Font("굴림", Font.BOLD, 16));
		btnList2.setBounds(300, 10, 126, 66);
		pn3.add(btnList2);
		
		JButton btnExit = new JButton("작업종료");
		btnExit.setFont(new Font("굴림", Font.BOLD, 16));
		btnExit.setBounds(442, 10, 126, 66);
		pn3.add(btnExit);
		
		pn4 = new JPanel();
		pn4.setBounds(0, 355, 584, 86);
		getContentPane().add(pn4);
		pn4.setLayout(null);
		
		lblMessage = new JLabel("출력 메세지");
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setFont(new Font("굴림", Font.BOLD, 18));
		lblMessage.setBounds(0, 0, 584, 86);
		pn4.add(lblMessage);
		
		//========================
		setVisible(true);
		//========================
		
		//종료버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		//콤보버튼클릭
		btnCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				String msg = (String) comboJob.getSelectedItem();//둘다 가능
				String msg = comboJob.getSelectedItem().toString()+"("+comboJob.getSelectedIndex()+")";
				lblMessage.setText(msg);
				JOptionPane.showMessageDialog(null, msg);//null 위치 안정해줌 화면가운데
				textArea.setText(msg);
			}
		});
		//리스트버튼1 클릭
		btnList1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//배열로 가져와야 함 이름이 같으면 배열로 판단
//				Object[] jobs = listJob1.getSelectedValues();// 줄 예전거나 사용빈도 낮음?
				List<String> jobs = listJob1.getSelectedValuesList();
				//객체 배열이라 향상된 for문
				String msg="";
				for(String job:jobs) {
					msg+=job+"/";
				}
				msg = msg.substring(0, msg.length()-1);
				
				lblMessage.setText(msg);
			}
		});
		//리스트버튼2 클릭
		btnList2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//배열로 가져와야 함 이름이 같으면 배열로 판단
//			Object[] jobs = listJob1.getSelectedValues();// 줄 예전거나 사용빈도 낮음?
			List<String> jobs = listJob2.getSelectedValuesList();
			//객체 배열이라 향상된 for문
			String msg="";
			for(String job:jobs) {
				msg+=job+"/";
			}
			msg = msg.substring(0, msg.length()-1);
			
			lblMessage.setText(msg);
			}
		});
		
	}
	
	public static void main(String[] args) {
		new T6_Combo_ListBox();
	}
}
