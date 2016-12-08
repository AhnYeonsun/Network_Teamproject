package ThreeGo;

import java.io.*;
import java.net.*;
import java.util.*;

public class chatServer {

	// port 번호 9001
	private static final int PORT = 9001;

	// 이름을 저장할 공간을 arrayList로 새롭게 선언
	private static ArrayList<String> names = new ArrayList<String>();

	// 모든 사용자들에게 출력하기위해서 사용하는 arrayList 새롭게 선언
	private static ArrayList<PrintWriter> writers = new ArrayList<PrintWriter>();

	public static void main(String[] args) throws Exception {
		System.out.println("The chat server is running.");
		// ServerSocket port번호 9001로 개방
		ServerSocket listener = new ServerSocket(PORT);
		try {
			while (true) {
				// 사용자가 server와 연결이 될 때까지 기다린다.
				new Handler(listener.accept()).start();
			}
		} finally {
			// 모든 사용자가 종료될 경우 close해준다.
			listener.close();
		}
	}

	private static class Handler extends Thread {

		private String name; // 사용자 id
		private Socket socket; // client에게 받은 connection 저장
		private BufferedReader in; // 받은 데이터
		private PrintWriter out; // 보낼 데이터

		// 순서 상관없이 socket사용이 가능
		public Handler(Socket socket) {
			this.socket = socket;
		}

		// 모든 채팅 서버 작업이 여기서 이용된다.
		public void run() {
			try {

				// 받을 메시지 (in), 보낼 메시지 (out)
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = new PrintWriter(socket.getOutputStream(), true);

				while (true) {
					// 현재 사용하는 사용자 이름을 보내라 사용자에게 보내는 메시지
					out.println("SUBMITNAME");
					// 사용자가 보내온 이름을 저장한다.
					name = in.readLine();

					// 이름이 null이면 종료
					if (name == null) {
						return;
					}

					// 이름이 현재 존재하는지 확인후 만약에 존재한다면 다시 입력/ 아니면 이름을 names에 저장
					synchronized (names) {
						if (!names.contains(name)) {
							names.add(name);
							break;
						}
					}
				}

				// 메시지 창 개방해라고 사용자에게 보낸다.
				out.println("NAMEACCEPTED");
				// writers에 보낸 문구 저장
				writers.add(out);
				// 로그인 하면 뜨는 공지와 자신의 chat screen을 알리기위한 message 출력
				out.println("MESSAGE" + " ------------------- This " + name + " chat screen!! -------------------");
				out.println("MESSAGE" + " <Notice> Typing Text + \\w + user_name) : Secret Mode");

				// 그전에 있었던 사용자들 로그인 상태 알려주기
				for (int i = 0; i < writers.size(); i++) {
					// 자신의 이름과 같으면 자신의 이름을 출력을 안해도 된다.
					if (!name.equals(names.get(i)))
						out.println("REGISTER" + names.get(i));
				}

				// 로그인 했다고 사용자에게 보낸다.(전체 출력)
				for (PrintWriter writer : writers) {
					writer.println("REGISTER" + name);
				}

				while (true) {
					// 사용자가 보낸 메시지를 읽는다.
					String input = in.readLine();
					// 클라이언트가 종료했으면 반복을 종료
					if (input == null) {
						return;
					}

					// 귓속말이 왔는지 확인 (special key /w로 확인)
					String tok[] = input.split(" /w ");
					// 해당 id를 찾았다면 1로 할당해준다.
					int find_check = 0;

					// 귓속말이 왔다면
					if (tok.length > 1) {
						for (int i = 0; i < writers.size(); i++) {
							// 본인이 본인에게 보낸다면 오류 메시지가 뜸
							if (tok[1].equals(name) && i == 0) {
								out.println("SMESSAGE" + "<Failed> Can't send to myself");
								find_check = 1;
								break;
							}

							// 그 이름이 어디있는지 위치를 파악후
							if (tok[1].equals(names.get(i))) {
								// 그 이름에 대화메시지를 보낸다. (누가 보냈는지 그리고 내용이 무엇인지)
								writers.get(i).println("SMESSAGE" + "Secret Message from " + name + " : " + tok[0]);
								out.println("SMESSAGE" + "Secret Message to " + tok[1] + " : " + tok[0]);
								writers.get(i).flush();
								find_check = 1;
								break;
							}
						}
						// 만약 잘못 입력한 사용자였다면
						if (find_check == 0)
							out.println("SMESSAGE" + "<Failed> " + tok[1] + " is not exist");
						// 귓속말이 아니라면 모든 사용자에게 메시지 전달
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
			// 모두 끝난후 모든 ArrayList에 있는 내용을 지워준다.
			finally {
				if (name != null) {
					// 나간 client의 id를 사용자들에게 알려줌
					for (PrintWriter writer : writers) {
						writer.println("Logout" + name);
					}
					names.remove(name);

				}
				if (out != null) {
					writers.remove(out);
				}
				try {
					// 해당 client의 connection 을 close함.
					socket.close();
				} catch (IOException e) {

				}
			}
		}
	}
}