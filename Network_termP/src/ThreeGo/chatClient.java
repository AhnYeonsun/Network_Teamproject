package ThreeGo;

import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class chatClient {

	//받을 데이터
	BufferedReader in;
	// 보낼 데이터
	PrintWriter out;
	
	//frame 이름을   Chatter 로 지정
	JFrame frame = new JFrame("Chatter");
	//textField는 40 사이즈
	JTextField textField = new JTextField(40);
	//messageArea는 새로 8에 가로 40 사이즈
	JTextArea messageArea = new JTextArea(8, 40);
	// 귓속말 버튼 이름
	JButton whisper = new JButton("whisper");
	// 받는 사람(귓속말 모드에 사용)
	String receiver = "";

	public chatClient() {

		//메시지 입력창, 메시지 출력창, 귓속말 버튼 창 frame 할당
		textField.setEditable(false);
		messageArea.setEditable(false);

		//메시지 입력창 하단
		frame.getContentPane().add(textField, "South");
		//메시지 출력창 중간
		frame.getContentPane().add(new JScrollPane(messageArea), "Center");
		//귓속말 버튼 오른쪽
		frame.getContentPane().add(whisper, "East");
		frame.pack();

		//메시지 입력창에 입력할 때의 이벤트
		textField.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
		//메시지 입력창에 입력한 내용을  server에게 보낸다.
				out.println(textField.getText());
				textField.setText("");
			}
		});

		//귓속말 버튼을 누를 경우 사용되는 이벤트
		whisper.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//귓속말 버튼을 클릭할 경우 보내느 사람의 이름을 입력란이 나오면 입력후 보내는 사람의 이름과 메시지를 같이 보낸다.
				receiver = sendTo();
				out.println(textField.getText() + " /w " + receiver);
				textField.setText("");
			}
		});
	}

	//IP주소를 입력하는 창
	private String getServerAddress() {
		return JOptionPane.showInputDialog(frame, "Enter IP Address of the Server:", "Welcome to the Chatter",
				JOptionPane.QUESTION_MESSAGE);
	}

	//대화창에서 사용될 이름을 입력하는 창
	private String getName() {
		return JOptionPane.showInputDialog(frame, "Choose a screen name:", "Screen name selection",
				JOptionPane.PLAIN_MESSAGE);
	}

	//귓속말의 대상을 입력하는 창
	private String sendTo() {
		return JOptionPane.showInputDialog(frame, "Who do you want to send a message to?", "",
				JOptionPane.PLAIN_MESSAGE);
	}

	//start()시 돌아가는 run 메소드
	private void run() throws IOException {
		
		// getServerAddress를 통해서 입력된 ip address를 serverAddress에 넣어준다.
		String serverAddress = getServerAddress();
		// serverAddress,port number 9001을 통해서 채팅 서버에 접속
		Socket socket = new Socket(serverAddress, 9001);
		//가져올 메시지와, 보낼 메시지 (in, out)
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream(), true);

		//연결되어 있는 동안 계속해서 실행한다.
		while (true) {
			//가져온 메시지
			String line = in.readLine();
			//메시지를 보낼 때 귓속말일 경우 귓속말 대상과 현재 사용하는 이름을 서버에 보낸다.
			if (line.startsWith("SUBMITNAME")) {
				out.println(getName() + receiver);
			} 
			//이름을 보낸후 대화창을 사용하게 한다.
			else if (line.startsWith("NAMEACCEPTED")) {
				textField.setEditable(true);
			}
			//로그인했다고 알리기 위해서 사용한다.
			else if (line.startsWith("REGISTER")) {
				messageArea.append("<" + line.substring(8) + "Login >\n");
			} 
			//귓속말 대화일 경우 귓속말대상에게만 메시지 출력한다.
			else if (line.startsWith("SMESSAGE")) {
				messageArea.append(line.substring(8) + "\n");
			} 
			//귓속말 대화가 아닐 경우 모두에게 메시지 출력한다.
			else if (line.startsWith("MESSAGE")) {
				messageArea.append(line.substring(8) + "\n");
			}
			//대화창에서 나갈때 유저의 이름을 출력해준다.
			else if (line.startsWith("Logout"))
			{
				messageArea.append("<< " + line.substring(6) + " Logout >> \n");
			}
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
