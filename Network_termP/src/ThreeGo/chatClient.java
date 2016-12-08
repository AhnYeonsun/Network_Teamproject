package ThreeGo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import java.io.*;
import java.net.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class chatClient implements Runnable {

   // 받을 데이터
   BufferedReader in;
   // 보낼 데이터
   PrintWriter out;
   
   //오디오
   Clip clip;
   
   //Game frame 구성변수
   JFrame frame = new JFrame("ThreeGo");
   JPanel Panel;
   JPanel borderPanel1, borderPanel2;
   JPanel BingoPanel1;
   JButton[] Bingo_B = new JButton[33];
   TitledBorder border1 = new TitledBorder(new LineBorder(Color.black, 1), " 빙고게임 판 ");
   TitledBorder border2 = new TitledBorder(new LineBorder(Color.black, 1), " 채팅 방 ");

   JPanel textFieldPanel;
   JTextField textField = new JTextField(40); // 채팅 입력
   JTextArea messageArea = new JTextArea(8, 40); // 채팅 출력
   JScrollPane js = new JScrollPane(messageArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
   ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED); // 채팅 출력 gui
   
   // 스크롤 기능추가
   JButton btn1 = new JButton("귓속말");
   String receiver = "";
   private Socket socket;
   public int[] board = new int[33];
   private chatClient myClnt = this;
   int[] number = new int[33]; // 빙고판의 랜덤 숫자를 부여하기 위한 array
   public static int cnt = 0;
   public int index;
   
   //채팅 frame 구성
   public chatClient() {
      
      frame.setPreferredSize(new Dimension(600 + 7, 1000));
      frame.setResizable(false);
      frame.setLocation(700, 50);
      frame.pack();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
      
      //BGM
      Sound("Client.wav", true);
      
      // 바탕
      Panel = new JPanel();
      Panel.setLayout(null);

      // 빙고판 보더
      border1.setTitleJustification(TitledBorder.LEFT);
      border1.setTitlePosition(TitledBorder.TOP);

      borderPanel1 = new JPanel();
      borderPanel1.setLayout(null);
      borderPanel1.setBounds(70, 55, 460, 460);
      borderPanel1.setBorder(border1);

      BingoPanel1 = new JPanel();
      BingoPanel1.setLayout(null);
      BingoPanel1.setBounds(20, 20, 430, 430);
      // BingoPanel1.setBackground(Color.white);

      //랜덤 숫자
      Random random = new Random();

      for(int i = 1; i < 33; i++)
      {
         number[i] = i + 1;
      }

      int temp;
      int x, y;

      // 랜덤 숫자 swap 한다.
      for(int i = 1; i < 33; i++)
      {
         x = random.nextInt(32)+1;
         y = random.nextInt(32)+1;

         temp = number[x];
         number[x] = number[y];
         number[y] = temp;   
      }

       String num;
      // 빙고판(버튼 형식) 과 이벤트 발생
      Bingo_B[0] = new JButton();
      Bingo_B[0].setText("-1");
      for (int i = 0; i < 5; i++) {
         for (int j = 0; j < 5; j++) {
            Bingo_B[j + i * 5 + 1] = new JButton(String.valueOf(number[j + i * 5 + 1]) );
            num = "button1-" + number[j + i * 5 + 1] + ".jpg";
            Bingo_B[j + i * 5 + 1].setLayout(null);
            Bingo_B[j + i * 5 + 1].setIcon(new ImageIcon(num));
            Bingo_B[j + i * 5 + 1].setBounds(j * 85, i * 85, 80, 80);
            BingoPanel1.add(Bingo_B[j + i * 5 + 1]);
            index = j + i * 5 + 1;
            Bingo_B[j + i * 5 + 1].addActionListener(new PageActionListener(number[j + i * 5 + 1], index));
            
         }
      }

      borderPanel1.add(BingoPanel1);

      // 채팅방 보더
      border2.setTitleJustification(TitledBorder.LEFT);
      border2.setTitlePosition(TitledBorder.TOP);

      borderPanel2 = new JPanel();
      borderPanel2.setLayout(null);
      borderPanel2.setBounds(20, 600, 560, 350);
      borderPanel2.setBorder(border2);

      // 채팅방
      textFieldPanel = new JPanel();
      textFieldPanel.setLayout(null);
      textFieldPanel.setBounds(10, 20, 540, 325);
      //textFieldPanel.setBackground(Color.white); // 프레임 수정시 panel 위치 확인용
      // borderPanel2.add(textFieldPanel);

      messageArea.setEditable(false);
      js.setBounds(0, 0, 540, 290);
      textField.setBounds(0, 292, 445, 30);
      btn1.setBounds(450, 292, 90, 30);

      textFieldPanel.add(js);
      textFieldPanel.add(textField);
      textFieldPanel.add(btn1);

      borderPanel2.add(textFieldPanel);

      //백그라운드 이미지 생성
      JLabel image = new JLabel(new ImageIcon("game4.png"));
      
      //백그라운에  panel 종합 추가
       image.setBounds(0, 0,600, 1300);
       image.add(borderPanel1);
      image.add(borderPanel2);
       frame.add(image);

      // 메시지 입력창에 입력할 때의 이벤트
      textField.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {
            // 메시지 입력창에 입력한 내용을 server에게 보낸다.
            out.println("MESSAGE " + textField.getText());
            textField.setText("");
         }
      });

      // 귓속말 버튼을 누를 경우 사용되는 이벤트
      btn1.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {
            // 귓속말 버튼을 클릭할 경우 보내느 사람의 이름을 입력란이 나오면 입력후 보내는 사람의 이름과 메시지를 같이 보낸다.
            receiver = sendTo();
            out.println(textField.getText() + " /w " + receiver);
            textField.setText("");
         }
      });

   }

   // IP주소를 입력하는 창
   private String getServerAddress() {

      return JOptionPane.showInputDialog(frame, "Enter IP Address of the Server:", "Welcome to the Chatter",
            JOptionPane.QUESTION_MESSAGE);

   }

   // 대화창에서 사용될 이름을 입력하는 창
   private String getName() {
      return JOptionPane.showInputDialog(frame, "Choose a screen name:", "Screen name selection",
            JOptionPane.PLAIN_MESSAGE);

   }

   // 귓속말의 대상을 입력하는 창
   private String sendTo() {
      return JOptionPane.showInputDialog(frame, "Who do you want to send a message to?", "",
            JOptionPane.PLAIN_MESSAGE);
   }

   // start()시 돌아가는 run 메소드
   public void run() {

      // getServerAddress를 통해서 입력된 ip address를 serverAddress에 넣어준다.
      String serverAddress = getServerAddress();
      try {
      socket = new Socket(serverAddress, 9001);
      // 가져올 메시지와, 보낼 메시지 (in, out)
      in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      out = new PrintWriter(socket.getOutputStream(), true);

      // 연결되어 있는 동안 계속해서 실행한다.
      while (true) {
         // 가져온 메시지
         String line = in.readLine();
         // 메시지를 보낼 때 귓속말일 경우 귓속말 대상과 현재 사용하는 이름을 서버에 보낸다.
         if (line.startsWith("SUBMITNAME")) {
            out.println(getName() + receiver);
         }
         // 이름을 보낸후 대화창을 사용하게 한다.
         else if (line.startsWith("NAMEACCEPTED")) {
            textField.setEditable(true);
         }
         // 로그인했다고 알리기 위해서 사용한다.
         else if (line.startsWith("REGISTER")) {
            messageArea.append("<" + line.substring(8) + "Login >\n");
         }
         // 귓속말 대화일 경우 귓속말대상에게만 메시지 출력한다.
         else if (line.startsWith("SMESSAGE")) {
            messageArea.append(line.substring(8) + "\n");

         }
         // 귓속말 대화가 아닐 경우 모두에게 메시지 출력한다.
         else if (line.startsWith("MESSAGE")) {
            messageArea.append(line.substring(8) + "\n");
         }
         // 대화창에서 나갈때 유저의 이름을 출력해준다.
         else if (line.startsWith("Logout")) {
            messageArea.append("<< " + line.substring(6) + " Logout >> \n");
         }else if (line.startsWith("CORRECT")){
            System.out.println(line);
            String correctNumStr = line.substring(8);
            int correctNumInt = Integer.parseInt(correctNumStr);
            setBoard(correctNumInt);
         }
      }
      
      //throw할 catch부분
      } catch (UnknownHostException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

   //timer 클래스
   class timeoutTask extends TimerTask {
      Quiz tempquiz;
      public timeoutTask(Quiz myquiz){
         tempquiz = myquiz;
      }
      @Override
      public void run() {
         tempquiz.dispose();
      }
   }
   
   //퀴즈를 불러오고 퀴즈에 타이머를 부여
   private class PageActionListener implements ActionListener{
      private int page;
      private int index;
      public PageActionListener(int page, int index){
         this.page = page;
         this.index = index; 
      }
      public void actionPerformed(ActionEvent e){
         Sound("clickon.wav",false);
         Quiz myquiz = new Quiz(myClnt, page, board, index);
         Timer t = new Timer(true);
         TimerTask tk = new timeoutTask(myquiz);
         t.schedule(tk, 50000);
      }
   }
   
   //정답이 맞을 시
   public void sendComplete(int value, int index, int qNum){
      board[index] = value;
      out.println("CORRECT "+qNum);
   }
   
   //정답일 경우 button의 이미지를 바꿔주고 상대편과 내가 더이상 누르지 못하게 한다.
   public void setBoard(int qNum) {
      int idx = 0;
      for (JButton tmpBtn : Bingo_B){
         String tmpNum = tmpBtn.getText();
         tmpNum = tmpNum.trim();
         if(tmpNum.equals(qNum+"".trim())){
            tmpBtn.setDisabledIcon(new ImageIcon("button.jpg"));
            tmpBtn.setEnabled(false);
            board[idx] = 1;
            break;
         }
         idx++;
      }
      isBingo bgc = new isBingo(board);
   }
   
   private void Sound(String file, boolean Loop) {
         try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream(file)));
            clip = AudioSystem.getClip();
            clip.open(ais);
            clip.start();
            if (Loop)
               clip.loop(-1);
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
   
   // JFrame 종료 버튼 있는 Frame을 사용한다. 종료버튼을 누를 때까지 계속해서 창 활성화
   public static void main(String[] args) throws Exception {
      chatClient client = new chatClient();
      client.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      client.frame.setVisible(true);
      client.run();
   }
}