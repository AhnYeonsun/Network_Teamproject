package ThreeGo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import java.io.*;
import java.net.*;
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

	/*
	 * //frame 이름을 Chatter 로 지정 JFrame frame = new JFrame("Chatter");
	 * //textField는 40 사이즈 JTextField textField = new JTextField(40);
	 * //messageArea는 새로 8에 가로 40 사이즈 JTextArea messageArea = new JTextArea(8,
	 * 40); // 귓속말 버튼 이름 JButton whisper = new JButton("whisper"); // 받는 사람(귓속말
	 * 모드에 사용) String receiver = "";
	 */
	JFrame frame = new JFrame("Game");
	JPanel Panel;
	JPanel borderPanel1, borderPanel2;
	JPanel BingoPanel1;
	JButton[] Bingo_B = new JButton[26];
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
	public int[] board = new int[26];
	private chatClient myClnt = this;
	int[] number = new int[26]; // 빙고판의 랜덤 숫자를 부여하기 위한 array
	
	public chatClient() {
		/*
		 * //메시지 입력창, 메시지 출력창, 귓속말 버튼 창 frame 할당 textField.setEditable(false);
		 * messageArea.setEditable(false);
		 *  
		 * //메시지 입력창 하단 frame.getContentPane().add(textField, "South"); //메시지
		 * 출력창 중간 frame.getContentPane().add(new JScrollPane(messageArea),
		 * "Center"); //귓속말 버튼 오른쪽 frame.getContentPane().add(whisper, "East");
		 * frame.pack();
		 */
		frame.setPreferredSize(new Dimension(600 + 7, 1000));
		frame.setResizable(false);
		frame.setLocation(700, 50);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

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

		//랜덤 숫자

		Random random = new Random();

		for(int i = 1; i < 26; i++)
		{
			number[i] = i;
		}

		int temp;
		int x, y;

		// 랜덤 숫자 swap 한다.
		for(int i = 1; i < 26; i++)
		{
			x = random.nextInt(24)+1;
			y = random.nextInt(24)+1;

			temp = number[x];
			number[x] = number[y];
			number[y] = temp;   
		}

		// 빙고판(버튼 형식)
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				Bingo_B[j + i * 5 + 1] = new JButton(String.valueOf(number[j + i * 5 + 1]));
				Bingo_B[j + i * 5 + 1].setLayout(null);
				Bingo_B[j + i * 5 + 1].setBounds(j * 85, i * 85, 80, 80);
				BingoPanel1.add(Bingo_B[j + i * 5 + 1]);
				Bingo_B[j + i * 5 + 1].addActionListener(new PageActionListener(number[j + i * 5 + 1], j + i * 5 + 1));
				
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
		frame.add(Panel);

		// 메시지 입력창에 입력할 때의 이벤트
		textField.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// 메시지 입력창에 입력한 내용을 server에게 보낸다.
				out.println(textField.getText());
				textField.setText("");
			}
		});

		// 귓속말 버튼을 누를 경우 사용되는 이벤트
		btn1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// 귓속말 버튼을 클릭할 경우 보내느 사람의 이름을 입력란이 나오면 입력후 보내는 사람의 이름과 메시지를 같이
				// 보낸다.
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
			}
		}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

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
	private class PageActionListener implements ActionListener{
		private int page;
		private int index;
		public PageActionListener(int page, int index){
			this.page = page;
			this.index = index;
		}
		public void actionPerformed(ActionEvent e){
			System.out.println();
			Quiz myquiz = new Quiz(myClnt, page, board, index);
			Timer t = new Timer(true);
			TimerTask tk = new timeoutTask(myquiz);
			t.schedule(tk, 30000);
		}
	}
	public void setBoard(int i, int value) {
		board[i] = value;
		System.out.println(board[i]);
	} 
	// JFrame 종료 버튼 있는 Frame을 사용한다. 종료버튼을 누를 때까지 계속해서 창 활성화
	public static void main(String[] args) throws Exception {
		chatClient client = new chatClient();
		client.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		client.frame.setVisible(true);
		client.run();
	}
}