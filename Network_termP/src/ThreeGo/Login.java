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
		setVisible(true);
	
		//panel ����
		panel = new JPanel();
		panel.setLayout(null);
		
		//�̹��� ����
		DrawPanel drawpanel = new DrawPanel();
		drawpanel.setBounds(10,10,560,300);
		
		//�α��� ��ȭ�� �� ���� �� ��ġ ǥ��
		login_label = new JLabel("ID");
		login_label.setFont(new Font ("���� ��ü B",Font.PLAIN, 25));
		login_label.setBounds(125,370,50,50);
		
		//��ȭ�� �Է��� TXTâ ���� �� ��ġ ǥ��
		txtNAME = new TextField(20); // ��ȭ�� �Է��� txt â
		txtNAME.setFont(new Font ("���� ��ü B",Font.BOLD,25));
		txtNAME.setBounds(175, 370, 290, 50);
		
		
		ok = new JButton("Start");
		ok.setFont(new Font ("���� ��ü B",Font.PLAIN, 25));
		ok.setBackground(new Color(255,255,224));
		ok.setBounds(0, 475, 300, 100);

		no = new JButton("Exit");
		no.setFont(new Font ("���� ��ü B",Font.PLAIN, 25));
		no.setBackground(new Color(255,255,224));
		no.setOpaque(true);
		no.setBounds(300, 475, 300, 100);
		
		//panel�� �ΰ��� ����� ���δ�.
		panel.add(drawpanel);
		panel.add(login_label);
		panel.add(txtNAME);
		panel.add(ok);
		panel.add(no);
		
		//�� ���� panel�� frame�� �ٿ��ش�.
		add(panel);
		
		ActionListener listner = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}

		};

		ActionListener listner2 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				new Ready();
			}

		};

		no.addActionListener(listner);
		ok.addActionListener(listner2);
		
		
		revalidate();
	}
	
	
}

//�̹��� �����ϴ� �κ�
class DrawPanel extends JPanel
{
	public void paint(Graphics g){
		super.paint(g);
		Image img = Toolkit.getDefaultToolkit().getImage("bingo.jpg");
		g.drawImage(img, 15, 15, this);
	}
		
}

