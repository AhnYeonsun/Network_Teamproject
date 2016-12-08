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
      //â ���� (�α����� ���� ǥ����)
      super("Login");
      setPreferredSize(new Dimension(600+7,600+10));
      setResizable(false); 
      
      //â�� ��ġ �� x���� ��� ������.
      setLocation(651, 100);
      pack();
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      //title�� ���� ����
      title = new JButton(new ImageIcon("Threego.png"));
      title.setBorderPainted(false);
      title.setContentAreaFilled(false);
      title.setFocusPainted(false);
      
      title.setFont(new Font ("���� ��ü B",Font.PLAIN, 25));
      title.setBackground(new Color(255,255,224));
      title.setBounds(0, 0, 600, 200);
      
      
      //START��ư
      ok = new JButton(new ImageIcon("STARTFUL.png"));
      ok.setBorderPainted(false);
      ok.setContentAreaFilled(false);
      ok.setFocusPainted(false);
      ok.setBounds(150, 330, 300, 100);

      //EXIT��ư
      no = new JButton(new ImageIcon("EXITFUL.png"));
      no.setBorderPainted(false);
      no.setContentAreaFilled(false);
      no.setFocusPainted(false);
      no.setBounds(150, 445, 300, 100);
      
      //Login�� ��׶��忡 bingo ������ �����ش�. 
      JLabel image = new JLabel(new ImageIcon("bingo.png"));
      image.setBounds(0, 0,600, 500);
      
      //��׶��忡 ����� ��ư�� �־��ش�. 
      add(image);
      image.add(title);
      image.add(ok);
      image.add(no);
      
      //�� ��ư�� �̺�Ʈ ����
      //������
      ActionListener listner = new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            System.exit(0);
         }

      };

      //Game client�� ����
      ActionListener listner2 = new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            chatClient a = new chatClient();
            new Thread(a).start();
            setVisible(false);
            
         }

      };
      
      //�̺�Ʈ �߰�
      no.addActionListener(listner);
      ok.addActionListener(listner2);
      
      revalidate();
   }
}