package ThreeGo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Login extends JFrame {
   
   JPanel p1,p2;
   JPanel panel;
   
   JLabel login_label;
   TextField txtNAME;
   JButton ok, no;
   JButton title;
   
   String name,ip;
      
   public Login()
   {
      //창 설정 (로그인이 제목 표시줄)
      super("Login");
      setPreferredSize(new Dimension(600+7,600+10));
      setResizable(false); 
      
      //창의 위치 와 x누를 경우 꺼진다.
      setLocation(651, 100);
      pack();
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      //title의 제목 설정
      title = new JButton(new ImageIcon("Threego.png"));
      title.setBorderPainted(false);
      title.setContentAreaFilled(false);
      title.setFocusPainted(false);
      
      title.setFont(new Font ("한컴 윤체 B",Font.PLAIN, 25));
      title.setBackground(new Color(255,255,224));
      title.setBounds(0, 0, 600, 200);
      
      
      //START버튼
      ok = new JButton(new ImageIcon("STARTFUL.png"));
      ok.setBorderPainted(false);
      ok.setContentAreaFilled(false);
      ok.setFocusPainted(false);
      ok.setBounds(150, 330, 300, 100);

      //EXIT버튼
      no = new JButton(new ImageIcon("EXITFUL.png"));
      no.setBorderPainted(false);
      no.setContentAreaFilled(false);
      no.setFocusPainted(false);
      no.setBounds(150, 445, 300, 100);
      
      //Login의 백그라운드에 bingo 파일을 적어준다. 
      JLabel image = new JLabel(new ImageIcon("bingo.png"));
      image.setBounds(0, 0,600, 500);
      
      //백그라운드에 제목과 버튼을 넣어준다. 
      add(image);
      image.add(title);
      image.add(ok);
      image.add(no);
      
      //각 버튼의 이벤트 생성
      //나가기
      ActionListener listner = new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            System.exit(0);
         }

      };

      //Game client의 실행
      ActionListener listner2 = new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            chatClient a = new chatClient();
            new Thread(a).start();
            setVisible(false);
            
         }

      };
      
      //이벤트 추가
      no.addActionListener(listner);
      ok.addActionListener(listner2);
      
      revalidate();
   }
}