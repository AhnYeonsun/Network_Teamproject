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
   
      //panel 생성
      //panel = new JPanel();
      //panel.setLayout(null);
      
      /*
      //이미지 삽입
      DrawPanel drawpanel = new DrawPanel();
      drawpanel.setBounds(0,0,607,475);
      */
      
      //로그인 대화명 라벨 생성 후 위치 표시
      login_label = new JLabel("ID");
      login_label.setFont(new Font ("한컴 윤체 B",Font.PLAIN, 25));
      login_label.setBounds(125,370,50,50);
      
      //대화명 입력할 TXT창 삽입 및 위치 표시
      txtNAME = new TextField(20); // 대화명 입력할 txt 창
      txtNAME.setFont(new Font ("한컴 윤체 B",Font.BOLD,25));
      txtNAME.setBounds(175, 370, 290, 50);
      
      
      
      //title
      title = new JButton(new ImageIcon("Threego.png"));
      title.setBorderPainted(false);
      title.setContentAreaFilled(false);
      title.setFocusPainted(false);
      
      title.setFont(new Font ("한컴 윤체 B",Font.PLAIN, 25));
      title.setBackground(new Color(255,255,224));
      title.setBounds(0, 0, 600, 200);
      
      
      //ok = new JButton("Start");
      ok = new JButton(new ImageIcon("STARTFUL.png"));
      ok.setBorderPainted(false);
      ok.setContentAreaFilled(false);
      ok.setFocusPainted(false);
      
      ok.setFont(new Font ("한컴 윤체 B",Font.PLAIN, 25));
      ok.setBackground(new Color(255,255,224));
      ok.setBounds(150, 330, 300, 100);

      no = new JButton(new ImageIcon("EXITFUL.png"));
      no.setBorderPainted(false);
      no.setContentAreaFilled(false);
      no.setFocusPainted(false);
      
      no.setFont(new Font ("한컴 윤체 B",Font.PLAIN, 25));
      no.setBackground(new Color(255,255,224));
      no.setBounds(150, 445, 300, 100);
      
      //panel에 두개의 기능을 붙인다.
     // drawpanel.add(login_label);
      //drawpanel.add(txtNAME);
     // panel.add(drawpanel);
      
      JLabel image = new JLabel(new ImageIcon("bingo.png"));

      image.setBounds(0, 0,600, 500);

      add(image);
      image.add(title);
      image.add(ok);
      image.add(no);
      
      //이 붙인 panel을 fr0ame에 붙여준다.
      //add(panel);
      
      ActionListener listner = new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            System.exit(0);
         }

      };

      ActionListener listner2 = new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            chatClient a = new chatClient();
            new Thread(a).start();
            setVisible(false);
            
         }

      };
      

      no.addActionListener(listner);
      ok.addActionListener(listner2);
      
      
      revalidate();
   }
}

//이미지 삽입하는 부분
class DrawPanel extends JPanel
{
   public void paint(Graphics g){
      super.paint(g);
      Image img = Toolkit.getDefaultToolkit().getImage("bingo2.jpg");
      g.drawImage(img, 0, 0, this);
   }
      
}