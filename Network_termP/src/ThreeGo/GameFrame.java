package ThreeGo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.metal.MetalBorders.ToolBarBorder;

public class GameFrame extends JFrame {

	public int qNum;
	JPanel Panel;
	JPanel borderPanel1, borderPanel2;
	JPanel BingoPanel1;
	JButton[] Bingo_B = new JButton[26];
	TitledBorder border1 = new TitledBorder(new LineBorder(Color.black, 1)," 빙고게임 판 ");
	TitledBorder border2 = new TitledBorder(new LineBorder(Color.black, 1)," 채팅 방 ");


	JPanel textFieldPanel;
	JTextField textField = new JTextField(40); // 채팅 입력
	JTextArea messageArea = new JTextArea(8, 40); // 채팅 출력
	JScrollPane js = new JScrollPane(messageArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
			ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED); // 채팅 출력 gui
	// 스크롤 기능추가
	JButton btn1 = new JButton("Submit");
	public GameFrame() {
		// 창 설정 (Bingo Game 창)
		super("ThreeGo Game");
		setPreferredSize(new Dimension(600 + 7, 1000));
		setResizable(false);
		setLocation(700, 50);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		// 바탕
		Panel = new JPanel();
		Panel.setLayout(null);

		// 빙고판 보더
		border1.setTitleJustification(TitledBorder.LEFT);
		border1.setTitlePosition(TitledBorder.TOP);

		borderPanel1 = new JPanel();
		borderPanel1.setLayout(null);
		borderPanel1.setBounds(60, 20, 460, 460);
		borderPanel1.setBorder(border1);

		BingoPanel1 = new JPanel();
		BingoPanel1.setLayout(null);
		BingoPanel1.setBounds(20, 20, 430, 430);
		// BingoPanel1.setBackground(Color.white);


		//빙고판 버튼을 클릭할시 이벤트 발생
		ActionListener Buttonlistner = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//new Quiz(qNum);
			}

		};

		// 빙고판(버튼 형식)
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				Bingo_B[j + i * 5] = new JButton(String.valueOf(j + i * 5+1)); //
				Bingo_B[j + i * 5].setLayout(null);
				Bingo_B[j + i * 5].setBounds(j * 85, i * 85, 80, 80);
				BingoPanel1.add(Bingo_B[j + i * 5]);
				Bingo_B[j+i*5].addActionListener(Buttonlistner);
				qNum = j+i*5;
			}
		}

		borderPanel1.add(BingoPanel1);

		// 채팅방 보더
		border2.setTitleJustification(TitledBorder.LEFT);
		border2.setTitlePosition(TitledBorder.TOP);

		borderPanel2 = new JPanel();
		borderPanel2.setLayout(null);
		borderPanel2.setBounds(20, 500, 560, 450);
		borderPanel2.setBorder(border2);

		// 채팅방
		textFieldPanel = new JPanel();
		textFieldPanel.setLayout(null);
		textFieldPanel.setBounds(10, 20, 540, 425);
		// textFieldPanel.setBackground(Color.white);
		// borderPanel2.add(textFieldPanel);

		messageArea.setEditable(false);
		js.setBounds(0, 0, 540, 390);
		textField.setBounds(0, 392, 445, 30);
		btn1.setBounds(450, 392, 90, 30);

		textFieldPanel.add(js);
		textFieldPanel.add(textField);
		textFieldPanel.add(btn1);

		borderPanel2.add(textFieldPanel);

		// panel 종합

		// js.setBounds(20, 500, 560, 275);

		Panel.add(borderPanel1);
		Panel.add(borderPanel2);
		add(Panel);


		revalidate();
	}
}
