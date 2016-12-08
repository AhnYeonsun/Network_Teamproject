package ThreeGo;

import java.io.*;
import java.net.*;
import java.util.*;

public class chatServer {

	// port ��ȣ 9001
	private static final int PORT = 9001;

	// �̸��� ������ ������ arrayList�� ���Ӱ� ����
	private static ArrayList<String> names = new ArrayList<String>();

	// ��� ����ڵ鿡�� ����ϱ����ؼ� ����ϴ� arrayList ���Ӱ� ����
	private static ArrayList<PrintWriter> writers = new ArrayList<PrintWriter>();

	public static void main(String[] args) throws Exception {
		System.out.println("The chat server is running.");
		// ServerSocket port��ȣ 9001�� ����
		ServerSocket listener = new ServerSocket(PORT);
		try {
			while (true) {
				// ����ڰ� server�� ������ �� ������ ��ٸ���.
				new Handler(listener.accept()).start();
			}
		} finally {
			// ��� ����ڰ� ����� ��� close���ش�.
			listener.close();
		}
	}

	private static class Handler extends Thread {

		private String name; // ����� id
		private Socket socket; // client���� ���� connection ����
		private BufferedReader in; // ���� ������
		private PrintWriter out; // ���� ������

		// ���� ������� socket����� ����
		public Handler(Socket socket) {
			this.socket = socket;
		}

		// ��� ä�� ���� �۾��� ���⼭ �̿�ȴ�.
		public void run() {
			try {

				// ���� �޽��� (in), ���� �޽��� (out)
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = new PrintWriter(socket.getOutputStream(), true);

				while (true) {
					// ���� ����ϴ� ����� �̸��� ������ ����ڿ��� ������ �޽���
					out.println("SUBMITNAME");
					// ����ڰ� ������ �̸��� �����Ѵ�.
					name = in.readLine();

					// �̸��� null�̸� ����
					if (name == null) {
						return;
					}

					// �̸��� ���� �����ϴ��� Ȯ���� ���࿡ �����Ѵٸ� �ٽ� �Է�/ �ƴϸ� �̸��� names�� ����
					synchronized (names) {
						if (!names.contains(name)) {
							names.add(name);
							break;
						}
					}
				}

				// �޽��� â �����ض�� ����ڿ��� ������.
				out.println("NAMEACCEPTED");
				// writers�� ���� ���� ����
				writers.add(out);
				// �α��� �ϸ� �ߴ� ������ �ڽ��� chat screen�� �˸������� message ���
				out.println("MESSAGE" + " ------------------- This " + name + " chat screen!! -------------------");
				out.println("MESSAGE" + " <Notice> Typing Text + \\w + user_name) : Secret Mode");

				// ������ �־��� ����ڵ� �α��� ���� �˷��ֱ�
				for (int i = 0; i < writers.size(); i++) {
					// �ڽ��� �̸��� ������ �ڽ��� �̸��� ����� ���ص� �ȴ�.
					if (!name.equals(names.get(i)))
						out.println("REGISTER" + names.get(i));
				}

				// �α��� �ߴٰ� ����ڿ��� ������.(��ü ���)
				for (PrintWriter writer : writers) {
					writer.println("REGISTER" + name);
				}

				while (true) {
					// ����ڰ� ���� �޽����� �д´�.
					String input = in.readLine();
					// Ŭ���̾�Ʈ�� ���������� �ݺ��� ����
					if (input == null) {
						return;
					}

					// �ӼӸ��� �Դ��� Ȯ�� (special key /w�� Ȯ��)
					String tok[] = input.split(" /w ");
					// �ش� id�� ã�Ҵٸ� 1�� �Ҵ����ش�.
					int find_check = 0;

					// �ӼӸ��� �Դٸ�
					if (tok.length > 1) {
						for (int i = 0; i < writers.size(); i++) {
							// ������ ���ο��� �����ٸ� ���� �޽����� ��
							if (tok[1].equals(name) && i == 0) {
								out.println("SMESSAGE" + "<Failed> Can't send to myself");
								find_check = 1;
								break;
							}

							// �� �̸��� ����ִ��� ��ġ�� �ľ���
							if (tok[1].equals(names.get(i))) {
								// �� �̸��� ��ȭ�޽����� ������. (���� ���´��� �׸��� ������ ��������)
								writers.get(i).println("SMESSAGE" + "Secret Message from " + name + " : " + tok[0]);
								out.println("SMESSAGE" + "Secret Message to " + tok[1] + " : " + tok[0]);
								writers.get(i).flush();
								find_check = 1;
								break;
							}
						}
						// ���� �߸� �Է��� ����ڿ��ٸ�
						if (find_check == 0)
							out.println("SMESSAGE" + "<Failed> " + tok[1] + " is not exist");
						// �ӼӸ��� �ƴ϶�� ��� ����ڿ��� �޽��� ����
					} else {
						if (input.startsWith("MESSAGE")) {
							for (PrintWriter writer : writers) {
								writer.println("MESSAGE " + name + ": " + input.substring(8));
							}
						}else if (input.startsWith("CORRECT")){
							//CORRECT 3
							String correctNumStr = input.substring(8);
							int correctNumInt = Integer.parseInt(correctNumStr);
							
							for (PrintWriter writer : writers) {
								
								writer.println("CORRECT " + correctNumInt);
							}
						}
					}
				}
			} catch (IOException e) {
				System.out.println(e);
			}
			// ��� ������ ��� ArrayList�� �ִ� ������ �����ش�.
			finally {
				if (name != null) {
					// ���� client�� id�� ����ڵ鿡�� �˷���
					for (PrintWriter writer : writers) {
						writer.println("Logout" + name);
					}
					names.remove(name);

				}
				if (out != null) {
					writers.remove(out);
				}
				try {
					// �ش� client�� connection �� close��.
					socket.close();
				} catch (IOException e) {

				}
			}
		}
	}
}