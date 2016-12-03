package ThreeGo;

import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class chatClient {

	//���� ������
	BufferedReader in;
	// ���� ������
	PrintWriter out;
	
	//frame �̸���   Chatter �� ����
	JFrame frame = new JFrame("Chatter");
	//textField�� 40 ������
	JTextField textField = new JTextField(40);
	//messageArea�� ���� 8�� ���� 40 ������
	JTextArea messageArea = new JTextArea(8, 40);
	// �ӼӸ� ��ư �̸�
	JButton whisper = new JButton("whisper");
	// �޴� ���(�ӼӸ� ��忡 ���)
	String receiver = "";

	public chatClient() {

		//�޽��� �Է�â, �޽��� ���â, �ӼӸ� ��ư â frame �Ҵ�
		textField.setEditable(false);
		messageArea.setEditable(false);

		//�޽��� �Է�â �ϴ�
		frame.getContentPane().add(textField, "South");
		//�޽��� ���â �߰�
		frame.getContentPane().add(new JScrollPane(messageArea), "Center");
		//�ӼӸ� ��ư ������
		frame.getContentPane().add(whisper, "East");
		frame.pack();

		//�޽��� �Է�â�� �Է��� ���� �̺�Ʈ
		textField.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
		//�޽��� �Է�â�� �Է��� ������  server���� ������.
				out.println(textField.getText());
				textField.setText("");
			}
		});

		//�ӼӸ� ��ư�� ���� ��� ���Ǵ� �̺�Ʈ
		whisper.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//�ӼӸ� ��ư�� Ŭ���� ��� ������ ����� �̸��� �Է¶��� ������ �Է��� ������ ����� �̸��� �޽����� ���� ������.
				receiver = sendTo();
				out.println(textField.getText() + " /w " + receiver);
				textField.setText("");
			}
		});
	}

	//IP�ּҸ� �Է��ϴ� â
	private String getServerAddress() {
		return JOptionPane.showInputDialog(frame, "Enter IP Address of the Server:", "Welcome to the Chatter",
				JOptionPane.QUESTION_MESSAGE);
	}

	//��ȭâ���� ���� �̸��� �Է��ϴ� â
	private String getName() {
		return JOptionPane.showInputDialog(frame, "Choose a screen name:", "Screen name selection",
				JOptionPane.PLAIN_MESSAGE);
	}

	//�ӼӸ��� ����� �Է��ϴ� â
	private String sendTo() {
		return JOptionPane.showInputDialog(frame, "Who do you want to send a message to?", "",
				JOptionPane.PLAIN_MESSAGE);
	}

	//start()�� ���ư��� run �޼ҵ�
	private void run() throws IOException {
		
		// getServerAddress�� ���ؼ� �Էµ� ip address�� serverAddress�� �־��ش�.
		String serverAddress = getServerAddress();
		// serverAddress,port number 9001�� ���ؼ� ä�� ������ ����
		Socket socket = new Socket(serverAddress, 9001);
		//������ �޽�����, ���� �޽��� (in, out)
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream(), true);

		//����Ǿ� �ִ� ���� ����ؼ� �����Ѵ�.
		while (true) {
			//������ �޽���
			String line = in.readLine();
			//�޽����� ���� �� �ӼӸ��� ��� �ӼӸ� ���� ���� ����ϴ� �̸��� ������ ������.
			if (line.startsWith("SUBMITNAME")) {
				out.println(getName() + receiver);
			} 
			//�̸��� ������ ��ȭâ�� ����ϰ� �Ѵ�.
			else if (line.startsWith("NAMEACCEPTED")) {
				textField.setEditable(true);
			}
			//�α����ߴٰ� �˸��� ���ؼ� ����Ѵ�.
			else if (line.startsWith("REGISTER")) {
				messageArea.append("<" + line.substring(8) + "Login >\n");
			} 
			//�ӼӸ� ��ȭ�� ��� �ӼӸ���󿡰Ը� �޽��� ����Ѵ�.
			else if (line.startsWith("SMESSAGE")) {
				messageArea.append(line.substring(8) + "\n");
			} 
			//�ӼӸ� ��ȭ�� �ƴ� ��� ��ο��� �޽��� ����Ѵ�.
			else if (line.startsWith("MESSAGE")) {
				messageArea.append(line.substring(8) + "\n");
			}
			//��ȭâ���� ������ ������ �̸��� ������ش�.
			else if (line.startsWith("Logout"))
			{
				messageArea.append("<< " + line.substring(6) + " Logout >> \n");
			}
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
