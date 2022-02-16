package day0216;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;

public class Ex02_SwingSettingSave extends JFrame implements ActionListener {
  Container cp;
  int fsize; // 라디오 박스 글꼴 크기선택
  boolean italic, bold;
  static final String FILENAME = "C:\\sist\\javawork\\setting.txt";
  JCheckBox cbItalic, cbBold;
  JRadioButton[] rbFont = new JRadioButton[4];
  JLabel lblResult;

  public Ex02_SwingSettingSave(String title) {
    super(title);
    cp = this.getContentPane();
    this.setBounds(100, 100, 400, 400);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    cp.setBackground(new Color(255, 255, 155));

    readSetting();
    setDesign();

    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        // TODO Auto-generated method stub
        super.windowClosing(e);

        saveSetting();

        JOptionPane.showMessageDialog(Ex02_SwingSettingSave.this, "세팅값 저장후 종료합니다.");

        System.exit(0);
      }
    });
    this.setVisible(true);
  }

  // 생성시 세팅값 불러오는 메서드
  public void readSetting() {
    FileReader fr = null;
    BufferedReader br = null;

    try {
      fr = new FileReader(FILENAME);
      br = new BufferedReader(fr);

      fsize = Integer.parseInt(br.readLine());
      italic = Boolean.parseBoolean(br.readLine());
      bold = Boolean.parseBoolean(br.readLine());
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      // 초기값이 없을 경우 지정
      fsize = 15;
      italic = false;
      bold = false;
    } catch (IOException e) {
      // TODO: handle exception
    } finally {
      System.out.println("확인: fsize: " + fsize + ", italic: " + italic + ", bold: " + bold);

      try {
        if (br != null) {
          br.close();
        }
        if (fr != null) {
          fr.close();
        }
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }

  }

  public void saveSetting() {
    // fsize, italic,bold순으로 저장
    FileWriter fw = null;
    try {
      fw = new FileWriter(FILENAME);

      fw.write(fsize + "\n");
      fw.write(italic + "\n");
      fw.write(bold + "\n");
    } catch (IOException e) {
      // TODO: handle exception
      e.printStackTrace();
    } finally {
      try {
        fw.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public void setDesign() {
    this.setLayout(null);

    lblResult = new JLabel("스윙파일입출력저장확인", JLabel.CENTER);
    lblResult.setBorder(new LineBorder(Color.green, 4));
    lblResult.setBounds(20, 30, 350, 80);
    this.add(lblResult);

    int init = 10; // 기본 글꼴 사이즈 10
    int xpos = 50;
    ButtonGroup bg = new ButtonGroup();

    for (int i = 0; i < rbFont.length; i++) {
      rbFont[i] = new JRadioButton(String.valueOf(init));
      init += 5;
      bg.add(rbFont[i]);
      rbFont[i].setBounds(xpos, 150, 40, 30);
      rbFont[i].setOpaque(false);
      this.add(rbFont[i]);
      xpos += 60;
      int idx = i;

      rbFont[i].addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
          // TODO Auto-generated method stub
          fsize = Integer.parseInt(rbFont[idx].getText());
          changeFont();
        }
      });
      
      // 체크박스 : 굵게 기울게
      cbItalic = new JCheckBox("기울게", italic);
      cbItalic.setBounds(60, 180, 80, 30);
      this.add(cbItalic);
      cbItalic.addItemListener(new ItemListener() {
        
        @Override
        public void itemStateChanged(ItemEvent e) {
          // TODO Auto-generated method stub
//          italic = cbItalic.isSelected();//선택시 true. 방법 1
          
          JCheckBox ob = (JCheckBox)e.getSource();
          italic = ob.isSelected();
          changeFont();
        }
      });
      
      cbBold = new JCheckBox("굵게", bold);
      cbBold.setBounds(180, 180, 80, 30);
      this.add(cbBold);
      
      cbBold.addActionListener(new ActionListener() {
        
        @Override
        public void actionPerformed(ActionEvent e) {
          // TODO Auto-generated method stub
          bold = cbBold.isSelected();
//          JCheckBox ob = (JCheckBox)e.getSource();
//          bold = ob.isSelected();
//          
          changeFont();
        }
      });
    }
  }

  public void changeFont() {
    if (italic && bold) {
      lblResult.setFont(new Font("", Font.BOLD | Font.ITALIC, 15));
    } else if (italic && !bold) {
      lblResult.setFont(new Font("", Font.ITALIC, 15));
    } else if (!italic && bold) {
      lblResult.setFont(new Font("", Font.BOLD, 15));
    } else {
      lblResult.setFont(new Font("", Font.PLAIN, 15));
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub

  }

  public static void main(String[] args) {
    new Ex02_SwingSettingSave("스윙 파일 저장 2");
  }

}
