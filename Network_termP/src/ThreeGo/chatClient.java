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

   // ���� ������
   BufferedReader in;
   // ���� ������
   PrintWriter out;
   
   //�����
   Clip clip;
   
   //Game frame ��������
   JFrame frame = new JFrame("ThreeGo");
   JPanel Panel;
   JPanel borderPanel1, borderPanel2;
   JPanel BingoPanel1;
   JButton[] Bingo_B = new JButton[33];
   TitledBorder border1 = new TitledBorder(new LineBorder(Color.black, 1), " ������� �� ");
   TitledBorder border2 = new TitledBorder(new LineBorder(Color.black, 1), " ä�� �� ");

   JPanel textFieldPanel;
   JTextField textField = new JTextField(40); // ä�� �Է�
   JTextArea messageArea = new JTextArea(8, 40); // ä�� ���
   JScrollPane js = new JScrollPane(messageArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
   ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED); // ä�� ��� gui
   
   // ��ũ�� ����߰�
   JButton btn1 = new JButton("�ӼӸ�");
   String receiver = "";
   private Socket socket;
   public int[] board = new int[33];
   private chatClient myClnt = this;
   int[] number = new int[33]; // �������� ���� ���ڸ� �ο��ϱ� ���� array
   public static int cnt = 0;
   public int index;
   
   //ä�� frame ����
   public chatClient() {
      
      frame.setPreferredSize(new Dimension(600 + 7, 1000));
      frame.setResizable(false);
      frame.setLocation(700, 50);
      frame.pack();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
      
      //BGM
      Sound("Client.wav", true);
      
      // ����
      Panel = new JPanel();
      Panel.setLayout(null);

      // ������ ����
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

      //���� ����
      Random random = new Random();

      for(int i = 1; i < 33; i++)
      {
         number[i] = i + 1;
      }

      int temp;
      int x, y;

      // ���� ���� swap �Ѵ�.
      for(int i = 1; i < 33; i++)
      {
         x = random.nextInt(32)+1;
         y = random.nextInt(32)+1;

         temp = number[x];
         number[x] = number[y];
         number[y] = temp;   
      }

       String num;
      // ������(��ư ����) �� �̺�Ʈ �߻�
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

      // ä�ù� ����
      border2.setTitleJustification(TitledBorder.LEFT);
      border2.setTitlePosition(TitledBorder.TOP);

      borderPanel2 = new JPanel();
      borderPanel2.setLayout(null);
      borderPanel2.setBounds(20, 600, 560, 350);
      borderPanel2.setBorder(border2);

      // ä�ù�
      textFieldPanel = new JPanel();
      textFieldPanel.setLayout(null);
      textFieldPanel.setBounds(10, 20, 540, 325);
      //textFieldPanel.setBackground(Color.white); // ������ ������ panel ��ġ Ȯ�ο�
      // borderPanel2.add(textFieldPanel);

      messageArea.setEditable(false);
      js.setBounds(0, 0, 540, 290);
      textField.setBounds(0, 292, 445, 30);
      btn1.setBounds(450, 292, 90, 30);

      textFieldPanel.add(js);
      textFieldPanel.add(textField);
      textFieldPanel.add(btn1);

      borderPanel2.add(textFieldPanel);

      //��׶��� �̹��� ����
      JLabel image = new JLabel(new ImageIcon("game4.png"));
      
      //��׶�  panel ���� �߰�
       image.setBounds(0, 0,600, 1300);
       image.add(borderPanel1);
      image.add(borderPanel2);
       frame.add(image);

      // �޽��� �Է�â�� �Է��� ���� �̺�Ʈ
      textField.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {
            // �޽��� �Է�â�� �Է��� ������ server���� ������.
            out.println("MESSAGE " + textField.getText());
            textField.setText("");
         }
      });

      // �ӼӸ� ��ư�� ���� ��� ���Ǵ� �̺�Ʈ
      btn1.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {
            // �ӼӸ� ��ư�� Ŭ���� ��� ������ ����� �̸��� �Է¶��� ������ �Է��� ������ ����� �̸��� �޽����� ���� ������.
            receiver = sendTo();
            out.println(textField.getText() + " /w " + receiver);
            textField.setText("");
         }
      });

   }

   // IP�ּҸ� �Է��ϴ� â
   private String getServerAddress() {

      return JOptionPane.showInputDialog(frame, "Enter IP Address of the Server:", "Welcome to the Chatter",
            JOptionPane.QUESTION_MESSAGE);

   }

   // ��ȭâ���� ���� �̸��� �Է��ϴ� â
   private String getName() {
      return JOptionPane.showInputDialog(frame, "Choose a screen name:", "Screen name selection",
            JOptionPane.PLAIN_MESSAGE);

   }

   // �ӼӸ��� ����� �Է��ϴ� â
   private String sendTo() {
      return JOptionPane.showInputDialog(frame, "Who do you want to send a message to?", "",
            JOptionPane.PLAIN_MESSAGE);
   }

   // start()�� ���ư��� run �޼ҵ�
   public void run() {

      // getServerAddress�� ���ؼ� �Էµ� ip address�� serverAddress�� �־��ش�.
      String serverAddress = getServerAddress();
      try {
      socket = new Socket(serverAddress, 9001);
      // ������ �޽�����, ���� �޽��� (in, out)
      in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      out = new PrintWriter(socket.getOutputStream(), true);

      // ����Ǿ� �ִ� ���� ����ؼ� �����Ѵ�.
      while (true) {
         // ������ �޽���
         String line = in.readLine();
         // �޽����� ���� �� �ӼӸ��� ��� �ӼӸ� ���� ���� ����ϴ� �̸��� ������ ������.
         if (line.startsWith("SUBMITNAME")) {
            out.println(getName() + receiver);
         }
         // �̸��� ������ ��ȭâ�� ����ϰ� �Ѵ�.
         else if (line.startsWith("NAMEACCEPTED")) {
            textField.setEditable(true);
         }
         // �α����ߴٰ� �˸��� ���ؼ� ����Ѵ�.
         else if (line.startsWith("REGISTER")) {
            messageArea.append("<" + line.substring(8) + "Login >\n");
         }
         // �ӼӸ� ��ȭ�� ��� �ӼӸ���󿡰Ը� �޽��� ����Ѵ�.
         else if (line.startsWith("SMESSAGE")) {
            messageArea.append(line.substring(8) + "\n");

         }
         // �ӼӸ� ��ȭ�� �ƴ� ��� ��ο��� �޽��� ����Ѵ�.
         else if (line.startsWith("MESSAGE")) {
            messageArea.append(line.substring(8) + "\n");
         }
         // ��ȭâ���� ������ ������ �̸��� ������ش�.
         else if (line.startsWith("Logout")) {
            messageArea.append("<< " + line.substring(6) + " Logout >> \n");
         }else if (line.startsWith("CORRECT")){
            System.out.println(line);
            String correctNumStr = line.substring(8);
            int correctNumInt = Integer.parseInt(correctNumStr);
            setBoard(correctNumInt);
         }
      }
      
      //throw�� catch�κ�
      } catch (UnknownHostException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

   //timer Ŭ����
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
   
   //��� �ҷ����� ��� Ÿ�̸Ӹ� �ο�
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
   
   //������ ���� ��
   public void sendComplete(int value, int index, int qNum){
      board[index] = value;
      out.println("CORRECT "+qNum);
   }
   
   //������ ��� button�� �̹����� �ٲ��ְ� ������ ���� ���̻� ������ ���ϰ� �Ѵ�.
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
   
   // JFrame ���� ��ư �ִ� Frame�� ����Ѵ�. �����ư�� ���� ������ ����ؼ� â Ȱ��ȭ
   public static void main(String[] args) throws Exception {
      chatClient client = new chatClient();
      client.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      client.frame.setVisible(true);
      client.run();
   }
}