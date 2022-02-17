package day0217;

import java.awt.Font;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ex11_ServerChat extends JFrame  implements Runnable{

  JTextArea area;
  ServerSocket serverSocket;
  public Ex11_ServerChat(String title) {
    super(title);
    this.setBounds(700, 100, 430, 400);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setDesign();

    this.setVisible(true);
  }

  void setDesign() {
    area = new JTextArea();
    area.setFont(new Font("", Font.BOLD, 16));
    this.add(new JScrollPane(area));
  }



  @Override
  public void run() {
    // 서버 소켓 생성
    try {
      serverSocket = new ServerSocket(6000); // 5000번 이후 아무거나
      area.append("서버 소켓 생성 성공\n");
    } catch (IOException e) {
      area.append("서버 소켓 생성 실패: " + e.getMessage());
    }
    
    // 접속을 시도하는 클라이언트 허용 대기 상태. 쓰레드 안에서 계속 돌아야 누가 접속해도 허용
    // 쓰레드 2개(접속 허용, 클라이언트 대화용)
    while(true) {
      try {
        Socket socket = serverSocket.accept();
        System.out.println(1);
        area.append(socket.getInetAddress().getHostAddress() + " IP로 접속됨\n");
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        area.append("클라이언트 생성 실패: " + e.getMessage());
      }
    }
  }

  public static void main(String[] args) {
    Ex11_ServerChat ex = new Ex11_ServerChat("서버입니다.");
    Thread th = new Thread(ex);
    th.start();
  }
}
