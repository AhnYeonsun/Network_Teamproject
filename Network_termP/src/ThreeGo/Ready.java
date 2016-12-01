package ThreeGo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Ready extends JFrame {
	
	JPanel panel1;
	JPanel textFieldPanel;
	JTextField textField = new JTextField(40); // ä�� �Է�
	JTextArea messageArea = new JTextArea(8, 40); // ä�� ���
	JScrollPane js = new JScrollPane(messageArea,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED); // ä�� ��� gui ��ũ�� ����߰�
	JButton btn1 = new JButton("Submit");
	JButton ok = new JButton("Ready");
	JButton no = new JButton("Exit");
	
	public Ready() {
		// â ���� (Readyâ)
		super("READY");

		setPreferredSize(new Dimension(600 + 7, 500));
		setResizable(false);
		setLocation(700, 100);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		panel1 = new JPanel();
		panel1.setLayout(null);
		
		messageArea.setEditable(false);
		js.setBounds(20, 20, 560, 275);
		textField.setBounds(20, 300 , 460, 30);
		btn1.setBounds(480,300,100,30);
		
		ok.setFont(new Font ("���� ��ü B",Font.PLAIN, 25));
		//ok.setBackground(new Color(255,255,224));
		ok.setBounds(20, 340, 275, 100);

		no.setFont(new Font ("���� ��ü B",Font.PLAIN, 25));
		//no.setBackground(new Color(255,255,224));
		no.setOpaque(true);
		no.setBounds(305, 340, 275, 100);
		
		panel1.add(js);
		panel1.add(textField);
		panel1.add(btn1);
		panel1.add(ok);
		panel1.add(no);
		
		add(panel1);
		
		
		//���� ������ ������ settext�� ������ �����ʸ� �����ؾ��Ѵ�. (����)
		
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
				new GameFrame();
			}

		};
		
		ok.addActionListener(listner2);
		no.addActionListener(listner);
		
		revalidate();
		
	}
}
