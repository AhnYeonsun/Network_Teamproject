package ThreeGo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Quiz extends JFrame {
	public boolean bingo;
	public static String temp = "aaaa";
	
	TitledBorder border1 = new TitledBorder(new LineBorder(Color.black, 1), " < ���� 1 > ");
	TitledBorder border2 = new TitledBorder(new LineBorder(Color.black, 1), " < �� ���� > ");

	JPanel panel1 = new JPanel();
	JPanel p = new JPanel();

	JPanel problemBorderPanel = new JPanel();
	JPanel ProblemPanel = new JPanel();

	JPanel answerBorderPanel = new JPanel();
	JPanel answerPanel = new JPanel();

	JLabel timer = new JLabel("Timer : 00��");

	JTextField answerField = new JTextField(40); // �� �Է�
	JButton answerButton = new JButton("Submit");

	public Quiz() {
		// â ���� (Readyâ)
		super("Quiz");

		
		
		setPreferredSize(new Dimension(600 + 7, 440));
		setResizable(false);
		setLocation(800, 100);
		pack();
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		panel1.setLayout(null);

		// panel ����
		p.setLayout(null);
		p.setBounds(10, 10, 580, 380);
		p.setBorder(new LineBorder(Color.black, 1));

		// ���� ����
		problemBorderPanel.setLayout(null);
		problemBorderPanel.setBounds(20, 20, 540, 250);
		border1.setTitleJustification(TitledBorder.LEFT);
		border1.setTitlePosition(TitledBorder.TOP);
		problemBorderPanel.setBorder(border1);

		// ������ ������ �κ�
		ProblemPanel.setLayout(null);
		ProblemPanel.setBounds(20, 20, 500, 215);
		ProblemPanel.setBackground(Color.WHITE); // �г��� �����ϱ� ���� �ӽ������� �־����
		connectDatabase cD = new connectDatabase();
		
		
		// Ÿ�̸� �κκ�
		timer.setFont(new Font("���� ��ü B", Font.PLAIN, 13));
		timer.setBounds(470, 270, 100, 30);

		// �� �Է� �����κ�
		answerBorderPanel.setLayout(null);
		answerBorderPanel.setBounds(20, 300, 540, 60);
		border2.setTitleJustification(TitledBorder.LEFT);
		border2.setTitlePosition(TitledBorder.TOP);
		answerBorderPanel.setBorder(border2);

		// ���� �Է��ϴ� �κ�
		answerField.setBounds(20, 20, 400, 30);
		answerButton.setBounds(425, 20, 100, 30);
		
		//��ư�� ���� �̺�Ʈ�� ���� ���
				ActionListener buttonlistner = new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
					}

				};

				//submit�� ���� �̺�Ʈ��� �߰�
				answerButton.addActionListener(buttonlistner);

		
		//�� �г��� �߰����ش�
		problemBorderPanel.add(ProblemPanel);
		
		answerBorderPanel.add(answerField);
		answerBorderPanel.add(answerButton);
		
		p.add(problemBorderPanel);
		p.add(timer);
		p.add(answerBorderPanel);
				
	
		panel1.add(p);
		add(panel1);

		revalidate();

	}
	//bingo check
	public void is_Bingo(int[][] array,int check){
		for(int i=0;i<array.length;i++){
			for(int j=0;j<=i;j++){
				if(array[0][j]==check&&array[1][j]==check&&array[2][j]==check&&array[3][j]==check&&array[4][j]==check){ //check for vertical bingos
					bingo = true;
				}
				else if(array[i][0]==check&&array[i][1]==check&&array[i][2]==check&&array[i][3]==check&&array[i][4]==check){//check for horizontal bingos
					bingo = true;
				}
				else if(array[0][0]==check&&array[1][1]==check&&array[2][2]==check&&array[3][3]==check&&array[4][4]==check){ //check for S.E diagonal bingos
					bingo =true;
				}
				else if(array[0][4]==check&&array[1][3]==check&&array[2][2]==check&&array[3][1]==check&&array[4][0]==check){ //check for S.W diagonal bingos
					bingo= true;
				}
				else // if no bingos
					bingo = false;
			}
		}   
	}
}
