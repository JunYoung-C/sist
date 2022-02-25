package day0217;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ex11_ServerChat extends JFrame implements Runnable {
  JTextArea area;
  ServerSocket serverSocket;
  // 클라이언트 정보 담을 리스트변수
  Vector<ClientList> list = new Vector<Ex11_ServerChat.ClientList>();

  public Ex11_ServerChat(String title) {
    super(title);
    this.setBounds(100, 100, 430, 400);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setDesign();

    this.setVisible(true);
  }

  // 클라이언트를 담을 내부클래스
  class ClientList extends Thread {
    Socket socket;
    BufferedReader br;
    PrintWriter pw;
    String nickName;

    public ClientList(Socket socket) {
      this.socket = socket;

      // 네트워크 통해서 메세지 읽고 쓰기위한 io 변수
      try {
        pw = new PrintWriter(socket.getOutputStream());
        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }

    // 대화용
    @Override
    public void run() {
      super.run();

      while (true) {
        // 클라이언트가 보낸 메세지를 한줄 단위로 읽는다.
        try {
          String msg = br.readLine();
          System.out.println(msg);
          StringTokenizer st = new StringTokenizer(msg, "|");

          String num = st.nextToken();
          String data = st.nextToken();
//          System.out.println(num + " " + data);
          switch (num) {
            case "1":
              this.nickName = data;
              for (ClientList cc : list) {
                cc.pw.write(nickName + "님이 입장하셨습니다.\n");
                cc.pw.flush(); // flush를 해야 네트워크 전송이 됨
              }
              break;
            case "2":
              String send = st.nextToken();
              for (ClientList cc : list) {
                cc.pw.write(send + "==>" + data + "\n");
                cc.pw.flush();
              }
              break;
            case "9":
              for (int i = 0; i < list.size(); i++) {
                ClientList cc = list.get(i);
                cc.pw.write(data + "님이 퇴장했습니다.\n");
                cc.pw.flush();
              }

              // data가 퇴장하는 사람 닉네임이므로 벡터에서 찾아 삭제
              for (int i = 0; i < list.size(); i++) {
                ClientList cc = list.get(i);

                if (data.equals(cc.nickName)) {
                  list.remove(i);
                  break;
                }
              }

              
              break;
          }

        } catch (IOException e) {
          // TODO Auto-generated catch block
          // e.printStackTrace();
          break;
        }
      }
    }
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
    while (true) {
      try {
        Socket socket = serverSocket.accept();
        area.append(socket.getInetAddress().getHostAddress() + " IP로 접속됨\n");

        // 벡터에 접속한 클라이언트 추가
        ClientList client = new ClientList(socket);

        list.add(client); // 리스트 접속한 클라이언트 추가
        client.start(); // run 호출
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
