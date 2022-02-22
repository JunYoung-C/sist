package day0217;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ex11_ClientChat extends JFrame implements Runnable, ActionListener {

  JTextArea area;
  String nickName;
  JTextField tfServerIp, tfNickName, tfMessage;
  JButton btnConnect, btnSend;
  Socket socket; // 소켓이 있어야 서버와 대화 주고받음
  // 서버와 대화 주고받는건 클라이언트. 그래서 미리 변수선언

  BufferedReader br;
  PrintWriter pw;

  boolean isEnd = false;

  public Ex11_ClientChat(String title) {
    super(title);
    this.setBounds(700, 100, 430, 500);
    // this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        super.windowClosing(e);
        
        // 서버에 9번과 닉네임을 보내서 퇴장을 알린다.
        pw.write("9|" + tfNickName.getText() + "\n");
        pw.flush();

        System.exit(0);
      }
    });
    this.setDesign();

    this.setVisible(true);
  }

  void setDesign() {
    this.setLayout(null);
    JLabel label1 = new JLabel("서버 IP");
    label1.setBounds(20, 20, 50, 30);
    this.add(label1);

    tfNickName = new JTextField("이수연");
    tfNickName.setBounds(70, 20, 80, 30);
    this.add(tfNickName);

    tfServerIp = new JTextField("192.168.0.102");
    tfServerIp.setBounds(160, 20, 80, 30);
    this.add(tfServerIp);

    btnConnect = new JButton("접속");
    btnConnect.setBounds(290, 20, 80, 30);
    this.add(btnConnect);

    // 접속 이벤트
    btnConnect.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        // 서버 ip를 읽어온다.
        String serverIp = tfServerIp.getText().trim();
        // 서버에 접속

        try {
          socket = new Socket(serverIp, 6000);
          area.append("서버에 성공적으로 접속\n");

          // 네트워크 통해서 메세지 읽고 쓰기위한 io 변수 생성
          pw = new PrintWriter(socket.getOutputStream());
          br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

          // 창제목을 닉네임으롭 변경
          Ex11_ClientChat.this.setTitle(tfNickName.getText() + "님의 채팅창");

          // 서버에 메세지 보내기
          pw.write("1|" + tfNickName.getText().trim() + "\n");
          pw.flush();

          // run메소드 호출
          Thread th = new Thread(Ex11_ClientChat.this);
          th.start();
        } catch (UnknownHostException e1) {

          e1.printStackTrace();
          area.append("서버 주소나 포트 다시확인: " + e1.getMessage() + "\n");
        } catch (IOException e1) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
          area.append("접속 오류: " + e1.getMessage() + "\n");
        }

      }
    });

    area = new JTextArea();
    area.setFont(new Font("", Font.BOLD, 16));
    JScrollPane js = new JScrollPane(area);
    js.setBounds(20, 70, 350, 330);
    this.add(js);

    tfMessage = new JTextField();
    tfMessage.setBounds(20, 420, 260, 30);
    this.add(tfMessage);

    btnSend = new JButton("전송");
    btnSend.setBounds(290, 420, 80, 30);
    this.add(btnSend);

    tfMessage.addActionListener(this);
    btnSend.addActionListener(this);
  }


  @Override
  public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub

    Object ob = e.getSource();
    // 메세지 입력 후 엔터 혹은 전송버튼
    if (ob == tfMessage || ob == btnSend) {
      // 서버에 메세지. 2|메세지|닉네임 형식으로 보냄
      pw.write("2|" + tfMessage.getText().trim() + "|" + tfNickName.getText() + "\n");
//      System.out.println("2|" + tfMessage.getText().trim() + "|" + tfNickName.getText() + "\n");
      pw.flush();

      // 입력창 메세지 지우기
      tfMessage.setText("");

      // 커서 메세지창에 두기
      tfMessage.requestFocus();
    }
  }

  @Override
  public void run() {
    while (true) {
      if (isEnd) {
        break;
      }
      // 서버가 보내준 메세지를 읽는다.
      try {
        String msg = br.readLine();


        // area에 출력
        area.append(msg + "\n");
      } catch (IOException e) {
        // e.printStackTrace();
        break;
      }
    }
  }

  public static void main(String[] args) {
    Ex11_ClientChat ex = new Ex11_ClientChat("클라이언트입니다.");
    // Thread th = new Thread(ex);
    // th.start();
  }
}
