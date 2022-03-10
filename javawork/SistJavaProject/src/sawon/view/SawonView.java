package sawon.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import sawon.domain.Sawon;
import sawon.respository.SawonRepository;

public class SawonView extends JFrame implements ItemListener, ActionListener {

	SawonRepository sawonRepository = new SawonRepository();
	Container cp;
	DefaultTableModel model;
	JTable table;
	JRadioButton[] rb = new JRadioButton[6];
	JButton addBtn, deleteBtn;

	public SawonView(String title) {
		super(title);
		cp = this.getContentPane();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(800, 100, 700, 500);
		cp.setBackground(new Color(255, 255, 100));

		initDesign();

		this.setVisible(true);
	}

	private void initDesign() {
		this.setLayout(null);

		String[] title = { "No.", "Id", "사원명", "부서명", "성별", "월급여" };
		model = new DefaultTableModel(title, 0); // 행 개수는 0으로 추가
		table = new JTable(model);
		JScrollPane js = new JScrollPane(table);
		js.setBounds(10, 100, 670, 350);
		this.add(js);

		ButtonGroup bg = new ButtonGroup();

		String[] rb_label = { "전체", "여자", "남자", "개발부", "홍보부", "교육부" };
		int xpos = 10;
		for (int i = 0; i < rb.length; i++) {
			// 라디오 버튼 생성
			rb[i] = new JRadioButton(rb_label[i], i == 0);
			rb[i].setBounds(xpos, 50, 90, 30);
			rb[i].setOpaque(false);
			// 이벤트 추가
			rb[i].addItemListener(this);
			bg.add(rb[i]);
			this.add(rb[i]);
			xpos += 100;
		}

		sawonTableWrite(1);

		addBtn = new JButton("추가");
		addBtn.setBounds(200, 0, 80, 40);
		addBtn.addActionListener(this);
		this.add(addBtn);

		deleteBtn = new JButton("삭제");
		deleteBtn.setBounds(380, 0, 80, 40);
		deleteBtn.addActionListener(this);
		this.add(deleteBtn);
	}

	// db 조회해서 테이블에 추가
	public void sawonTableWrite(int select) {

		// 기존의 데이터 삭제 후 가져오기
		model.setRowCount(0);
		List<Sawon> sawons = sawonRepository.findAll(1);
		for (int i = 0; i < sawons.size(); i++) {
			Vector<String> data = new Vector<String>();
			
			Sawon sawon = sawons.get(i);
			data.add(String.valueOf(i + 1));
			data.add(String.valueOf(sawon.getId()));
			data.add(sawon.getName());
			data.add(sawon.getBuseo());
			data.add(sawon.getGender());
			data.add(String.valueOf(sawon.getPay()));
			
			model.addRow(data);
		}

		
	}

	// 라디오 버튼 이벤트
	@Override
	public void itemStateChanged(ItemEvent e) {
		Object o = e.getSource();

		for (int i = 0; i < rb.length; i++) {
			if (rb[i].isSelected()) {
				sawonTableWrite(i + 1);
				break;
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		if (o == addBtn) {
			// 이름, 성별, 부서, 급여
			String name = JOptionPane.showInputDialog("학생명을 입력해주세요");
			String gender = JOptionPane.showInputDialog("성별을 입력해주세요", "남자");
			String buseo = JOptionPane.showInputDialog("부서를 입력해주세요", "홍보부");
			String pay = JOptionPane.showInputDialog("급여를 입력해주세요");

			sawonRepository.save(new Sawon(name, gender, buseo, Long.parseLong(pay)));
			this.sawonTableWrite(1);
		} else if (o == deleteBtn) {
			int row = table.getSelectedRow();
			if (row == -1) {
				JOptionPane.showMessageDialog(this, "삭제할 행을 선택해주세요");
				return;
			}

			String num = (String) model.getValueAt(row, 1);
			System.out.println(num);
			sawonRepository.deleteById(num);
			sawonTableWrite(1);
		}
	}

	public static void main(String[] args) {
		new SawonView("sawon db swing");
	}

}
