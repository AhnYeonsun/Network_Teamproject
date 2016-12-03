package BingoClient;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Main extends javax.swing.JFrame {

	Socket socket = null;
	ServerSocket listener = null;
	Socket s = null;

	String answer = null;
	int count=1,play=0;
	int flag[] = new int[30];
	int flag1[] = new int[30];
	public Main() {
		initComponents();
	}

	public void match(String a)
	{
		if(jButton1.getText().equals(a))
		{
			flag1[1] = 1;
			jButton1.setEnabled(false);
			jButton1.setBackground(Color.red);
		}
		else if(jButton2.getText().equals(a))
		{
			flag1[2] = 1;
			jButton2.setEnabled(false);
			jButton2.setBackground(Color.red);
		}
		else if(jButton3.getText().equals(a))
		{
			flag1[3] = 1;
			jButton3.setEnabled(false);
			jButton3.setBackground(Color.red);
		}
		else if(jButton4.getText().equals(a))
		{
			flag1[4] = 1;
			jButton4.setEnabled(false);
			jButton4.setBackground(Color.red);
		}
		else if(jButton5.getText().equals(a))
		{
			flag1[5] = 1;
			jButton5.setEnabled(false);
			jButton5.setBackground(Color.red);
		}
		else if(jButton6.getText().equals(a))
		{
			flag1[6] = 1;
			jButton6.setEnabled(false);
			jButton6.setBackground(Color.red);
		}
		else if(jButton7.getText().equals(a))
		{
			flag1[7] = 1;
			jButton7.setEnabled(false);
			jButton7.setBackground(Color.red);

		}
		else if(jButton8.getText().equals(a))
		{
			flag1[8] = 1;
			jButton8.setEnabled(false);
			jButton8.setBackground(Color.red);

		}
		else if(jButton9.getText().equals(a))
		{
			flag1[9] = 1;
			jButton9.setEnabled(false);
			jButton9.setBackground(Color.red);
		}
		else if(jButton10.getText().equals(a))
		{
			flag1[10] = 1;
			jButton10.setEnabled(false);
			jButton10.setBackground(Color.red);
		}
		else if(jButton11.getText().equals(a))
		{
			flag1[11] = 1;
			jButton11.setEnabled(false);
			jButton11.setBackground(Color.red);
		}
		else if(jButton12.getText().equals(a))
		{
			flag1[12] = 1;
			jButton12.setEnabled(false);
			jButton12.setBackground(Color.red);
		}
		else if(jButton13.getText().equals(a))
		{
			flag1[13] = 1;
			jButton13.setEnabled(false);
			jButton13.setBackground(Color.red);
		}
		else if(jButton14.getText().equals(a))
		{
			flag1[14] = 1;
			jButton14.setEnabled(false);
			jButton14.setBackground(Color.red);
		}
		else if(jButton15.getText().equals(a))
		{
			flag1[15] = 1;
			jButton15.setEnabled(false);
			jButton15.setBackground(Color.red);
		}
		else if(jButton16.getText().equals(a))
		{
			flag1[16] = 1;
			jButton16.setEnabled(false);
			jButton16.setBackground(Color.red);
		}
		else if(jButton17.getText().equals(a))
		{
			flag1[17] = 1;
			jButton17.setEnabled(false);
			jButton17.setBackground(Color.red);
		}
		else if(jButton18.getText().equals(a))
		{
			flag1[18] = 1;
			jButton18.setEnabled(false);
			jButton18.setBackground(Color.red);
		}
		else if(jButton19.getText().equals(a))
		{
			flag1[19] = 1;
			jButton19.setEnabled(false);
			jButton19.setBackground(Color.red);
		}
		else if(jButton20.getText().equals(a))
		{
			flag1[20] = 1;
			jButton20.setEnabled(false);
			jButton20.setBackground(Color.red);
		}
		else if(jButton21.getText().equals(a))
		{
			flag1[21] = 1;
			jButton21.setEnabled(false);
			jButton21.setBackground(Color.red);

		}
		else if(jButton22.getText().equals(a))
		{
			flag1[22] = 1;
			jButton22.setEnabled(false);
			jButton22.setBackground(Color.red);
		}
		else if(jButton23.getText().equals(a))
		{
			flag1[23] = 1;
			jButton23.setEnabled(false);
			jButton23.setBackground(Color.red);
		}
		else if(jButton24.getText().equals(a))
		{
			flag1[24] = 1;
			jButton24.setEnabled(false);
			jButton24.setBackground(Color.red);
		}
		else if(jButton25.getText().equals(a))
		{
			flag1[25] = 1;
			jButton25.setEnabled(false);
			jButton25.setBackground(Color.red);
		}
		check();
	}
	public void check()
	{
		int i=0,j=0;
		if(flag1[1]==1 && flag1[2]==1 && flag1[3]==1 && flag1[4]==1 && flag1[5]==1)
			j++;
		if(flag1[6]==1 && flag1[7]==1 && flag1[8]==1 && flag1[9]==1 && flag1[10]==1)
			j++;
		if(flag1[11]==1 && flag1[12]==1 && flag1[13]==1 && flag1[14]==1 && flag1[15]==1)
			j++;
		if(flag1[16]==1 && flag1[17]==1 && flag1[18]==1 && flag1[19]==1 && flag1[20]==1)
			j++;
		if(flag1[21]==1 && flag1[22]==1 && flag1[23]==1 && flag1[24]==1 && flag1[25]==1)
			j++;

		if(flag1[1]==1 && flag1[6]==1 && flag1[11]==1 && flag1[16]==1 && flag1[21]==1)
			j++;
		if(flag1[2]==1 && flag1[7]==1 && flag1[12]==1 && flag1[17]==1 && flag1[12]==1)
			j++;
		if(flag1[3]==1 && flag1[8]==1 && flag1[13]==1 && flag1[18]==1 && flag1[23]==1)
			j++;
		if(flag1[4]==1 && flag1[9]==1 && flag1[14]==1 && flag1[19]==1 && flag1[24]==1)
			j++;
		if(flag1[5]==1 && flag1[10]==1 && flag1[15]==1 && flag1[20]==1 && flag1[25]==1)
			j++;

		if(flag1[1]==1 && flag1[7]==1 && flag1[13]==1 && flag1[19]==1 && flag1[25]==1)
			j++;
		if(flag1[5]==1 && flag1[9]==1 && flag1[13]==1 && flag1[17]==1 && flag1[21]==1)
			j++;

		if(j>=5)
		{
			JOptionPane.showMessageDialog(null, "U win", "U win the match",JOptionPane.INFORMATION_MESSAGE);
			PrintWriter out;
			try {
				out = new PrintWriter(socket.getOutputStream(), true);
				out.printf("U Lose");
			} catch (IOException ex) {
				Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
			}

		}

	}
	public class TextRecieve implements Runnable
	{
		public void run()
		{
			while(true)
			{
				try {
					// 
					BufferedReader input =
							new BufferedReader(new InputStreamReader(s.getInputStream()));
					answer = input.readLine();
					if(answer.equals("U Lose"))
						JOptionPane.showMessageDialog(null,answer, "Retry Later",JOptionPane.ERROR_MESSAGE);
					else 
						match(answer);
					Logger.getLogger(answer);
					JOptionPane.showMessageDialog(null, answer, "Retry Later",JOptionPane.ERROR_MESSAGE);
				} catch (IOException ex) {
					Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
				}
			}


		}
	}
	public class ThreadServer implements Runnable
	{
		public void run()
		{
			String serverAddress = JOptionPane.showInputDialog(
					"Enter IP Address of a machine that is\n" +
					"running the date service on port 9090:");

			try {
				s = new Socket(serverAddress, 9090);
				TextRecieve tr = new TextRecieve();
				Thread t1 = new Thread(tr);
				t1.start();
			} catch (UnknownHostException ex) {
				JOptionPane.showMessageDialog(null, "Invalid IP", "Retry Later",JOptionPane.ERROR_MESSAGE);
				Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
			} catch (IOException ex) {
				Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
				JOptionPane.showMessageDialog(null, "Invalid IP", "Retry Later",JOptionPane.ERROR_MESSAGE);
				jButton2.setEnabled(true);
			}


		}
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jDesktopPane1 = new javax.swing.JDesktopPane();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		jButton5 = new javax.swing.JButton();
		jButton6 = new javax.swing.JButton();
		jButton7 = new javax.swing.JButton();
		jButton8 = new javax.swing.JButton();
		jButton9 = new javax.swing.JButton();
		jButton10 = new javax.swing.JButton();
		jButton11 = new javax.swing.JButton();
		jButton12 = new javax.swing.JButton();
		jButton13 = new javax.swing.JButton();
		jButton14 = new javax.swing.JButton();
		jButton15 = new javax.swing.JButton();
		jButton16 = new javax.swing.JButton();
		jButton17 = new javax.swing.JButton();
		jButton18 = new javax.swing.JButton();
		jButton19 = new javax.swing.JButton();
		jButton20 = new javax.swing.JButton();
		jButton21 = new javax.swing.JButton();
		jButton22 = new javax.swing.JButton();
		jButton23 = new javax.swing.JButton();
		jButton24 = new javax.swing.JButton();
		jButton25 = new javax.swing.JButton();
		jButton26 = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		jMenu2 = new javax.swing.JMenu();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		jButton1.setBounds(70, 80, 50, 40);
		jDesktopPane1.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});
		jButton2.setBounds(120, 80, 50, 40);
		jDesktopPane1.add(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});
		jButton3.setBounds(170, 80, 50, 40);
		jDesktopPane1.add(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});
		jButton4.setBounds(220, 80, 50, 40);
		jDesktopPane1.add(jButton4, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton5ActionPerformed(evt);
			}
		});
		jButton5.setBounds(270, 80, 50, 40);
		jDesktopPane1.add(jButton5, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jButton6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton6ActionPerformed(evt);
			}
		});
		jButton6.setBounds(70, 120, 50, 40);
		jDesktopPane1.add(jButton6, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jButton7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton7ActionPerformed(evt);
			}
		});
		jButton7.setBounds(120, 120, 50, 40);
		jDesktopPane1.add(jButton7, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jButton8.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton8ActionPerformed(evt);
			}
		});
		jButton8.setBounds(170, 120, 50, 40);
		jDesktopPane1.add(jButton8, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jButton9.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton9ActionPerformed(evt);
			}
		});
		jButton9.setBounds(220, 120, 50, 40);
		jDesktopPane1.add(jButton9, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jButton10.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton10ActionPerformed(evt);
			}
		});
		jButton10.setBounds(270, 120, 50, 40);
		jDesktopPane1.add(jButton10, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jButton11.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton11ActionPerformed(evt);
			}
		});
		jButton11.setBounds(70, 160, 50, 40);
		jDesktopPane1.add(jButton11, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jButton12.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton12ActionPerformed(evt);
			}
		});
		jButton12.setBounds(120, 160, 50, 40);
		jDesktopPane1.add(jButton12, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jButton13.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton13ActionPerformed(evt);
			}
		});
		jButton13.setBounds(170, 160, 50, 40);
		jDesktopPane1.add(jButton13, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jButton14.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton14ActionPerformed(evt);
			}
		});
		jButton14.setBounds(220, 160, 50, 40);
		jDesktopPane1.add(jButton14, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jButton15.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton15ActionPerformed(evt);
			}
		});
		jButton15.setBounds(270, 160, 50, 40);
		jDesktopPane1.add(jButton15, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jButton16.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton16ActionPerformed(evt);
			}
		});
		jButton16.setBounds(70, 200, 50, 40);
		jDesktopPane1.add(jButton16, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jButton17.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton17ActionPerformed(evt);
			}
		});
		jButton17.setBounds(120, 200, 50, 40);
		jDesktopPane1.add(jButton17, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jButton18.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton18ActionPerformed(evt);
			}
		});
		jButton18.setBounds(170, 200, 50, 40);
		jDesktopPane1.add(jButton18, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jButton19.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton19ActionPerformed(evt);
			}
		});
		jButton19.setBounds(220, 200, 50, 40);
		jDesktopPane1.add(jButton19, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jButton20.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton20ActionPerformed(evt);
			}
		});
		jButton20.setBounds(270, 200, 50, 40);
		jDesktopPane1.add(jButton20, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jButton21.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton21ActionPerformed(evt);
			}
		});
		jButton21.setBounds(70, 240, 50, 40);
		jDesktopPane1.add(jButton21, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jButton22.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton22ActionPerformed(evt);
			}
		});
		jButton22.setBounds(120, 240, 50, 40);
		jDesktopPane1.add(jButton22, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jButton23.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton23ActionPerformed(evt);
			}
		});
		jButton23.setBounds(170, 240, 50, 40);
		jDesktopPane1.add(jButton23, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jButton24.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton24ActionPerformed(evt);
			}
		});
		jButton24.setBounds(220, 240, 50, 40);
		jDesktopPane1.add(jButton24, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jButton25.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton25ActionPerformed(evt);
			}
		});
		jButton25.setBounds(270, 240, 50, 40);
		jDesktopPane1.add(jButton25, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jButton26.setText("Play");
		jButton26.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton26ActionPerformed(evt);
			}
		});
		jButton26.setBounds(370, 80, 53, 23);
		jDesktopPane1.add(jButton26, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jLabel1.setFont(new java.awt.Font("Pristina", 0, 24)); // NOI18N
		jLabel1.setForeground(new java.awt.Color(0, 0, 51));
		jLabel1.setText("PLAYER 2 CLIENT");
		jLabel1.setBounds(110, 10, 210, 40);
		jDesktopPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jMenu1.setText("File");
		jMenuBar1.add(jMenu1);

		jMenu2.setText("Edit");
		jMenuBar1.add(jMenu2);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
				);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
		// 
		if(flag[1]!= 1)
		{
			jButton1.setText(""+count);
			count++;
			flag[1]=1;
			if(count == 25)
				play = 1;
		}
		else if (play ==1)
		{
			PrintWriter out;
			flag1[1] = 1;
			jButton1.setEnabled(false);
			try {
				out = new PrintWriter(s.getOutputStream(), true);
				out.printf(jButton1.getText()+"\n");
			} catch (IOException ex) {
				Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}//GEN-LAST:event_jButton1ActionPerformed



	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
		// 
		if(flag[2]!= 1)
		{
			jButton2.setText(""+count);
			count++;
			flag[2]=1;
			if(count == 25)
				play = 1;
		}
		else if (play ==1)
		{
			PrintWriter out;
			flag1[2] = 1;
			jButton2.setEnabled(false);
			try {
				out = new PrintWriter(s.getOutputStream(), true);
				out.printf(jButton2.getText()+"\n");
			} catch (IOException ex) {
				Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
			}


		}
	}//GEN-LAST:event_jButton2ActionPerformed

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
		// 
		if(flag[3]!= 1)
		{
			jButton3.setText(""+count);
			count++;
			flag[3]=1;
			if(count == 25)
				play = 1;
		}
		else if (play ==1)
		{
			PrintWriter out;
			flag1[3] = 1;
			jButton3.setEnabled(false);
			try {
				out = new PrintWriter(s.getOutputStream(), true);
				out.printf(jButton3.getText()+"\n");
				JOptionPane.showMessageDialog(null,jButton3.getText(), "Retry Later",JOptionPane.ERROR_MESSAGE);
			} catch (IOException ex) {
				Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}//GEN-LAST:event_jButton3ActionPerformed

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
		// 
		if(flag[4]!= 1)
		{
			jButton4.setText(""+count);
			count++;
			flag[4]=1;
			if(count == 25)
				play = 1;
		}
		else if (play ==1)
		{
			PrintWriter out;
			flag1[4] = 1;
			jButton4.setEnabled(false);
			try {
				out = new PrintWriter(s.getOutputStream(), true);
				out.printf(jButton4.getText()+"\n");
			} catch (IOException ex) {
				Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}//GEN-LAST:event_jButton4ActionPerformed

	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
		// 
		if(flag[5]!= 1)
		{
			jButton5.setText(""+count);
			count++;
			flag[5]=1;
			if(count == 25)
				play = 1;
		}
		else if (play ==1)
		{
			PrintWriter out;
			flag1[5] = 1;
			jButton5.setEnabled(false);
			try {
				out = new PrintWriter(s.getOutputStream(), true);
				out.printf(jButton5.getText()+"\n");
			} catch (IOException ex) {
				Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}//GEN-LAST:event_jButton5ActionPerformed

	private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
		// 
		if(flag[6]!= 1)
		{
			jButton6.setText(""+count);
			count++;
			flag[6]=1;
			if(count == 25)
				play = 1;
		}
		else if (play ==1)
		{
			PrintWriter out;
			flag1[6] = 1;
			jButton6.setEnabled(false);
			try {
				out = new PrintWriter(s.getOutputStream(), true);
				out.printf(jButton6.getText()+"\n");
			} catch (IOException ex) {
				Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}//GEN-LAST:event_jButton6ActionPerformed

	private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
		// 
		if(flag[7]!= 1)
		{
			jButton7.setText(""+count);
			count++;
			flag[7]=1;
			if(count == 25)
				play = 1;
		}
		else if (play ==1)
		{
			PrintWriter out;
			flag1[7] = 1;
			jButton7.setEnabled(false);
			try {
				out = new PrintWriter(s.getOutputStream(), true);
				out.printf(jButton7.getText()+"\n");
			} catch (IOException ex) {
				Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}//GEN-LAST:event_jButton7ActionPerformed

	private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
		// 
		if(flag[8]!= 1)
		{
			jButton8.setText(""+count);
			count++;
			flag[8]=1;
			if(count == 25)
				play = 1;
		}
		else if (play ==1)
		{
			PrintWriter out;
			flag1[8] = 1;
			jButton8.setEnabled(false);
			try {
				out = new PrintWriter(s.getOutputStream(), true);
				out.printf(jButton8.getText()+"\n");
			} catch (IOException ex) {
				Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}//GEN-LAST:event_jButton8ActionPerformed

	private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
		// 
		if(flag[9]!= 1)
		{
			jButton9.setText(""+count);
			count++;
			flag[9]=1;
			if(count == 25)
				play = 1;
		}
		else if (play ==1)
		{
			PrintWriter out;
			flag1[9] = 1;
			jButton9.setEnabled(false);
			try {
				out = new PrintWriter(s.getOutputStream(), true);
				out.printf(jButton9.getText()+"\n");
			} catch (IOException ex) {
				Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}//GEN-LAST:event_jButton9ActionPerformed

	private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
		// 
		if(flag[10]!= 1)
		{
			jButton10.setText(""+count);
			count++;
			flag[10]=1;
			if(count == 25)
				play = 1;
		}
		else if (play ==1)
		{
			PrintWriter out;
			flag1[10] = 1;
			jButton10.setEnabled(false);
			try {
				out = new PrintWriter(s.getOutputStream(), true);
				out.printf(jButton10.getText()+"\n");
			} catch (IOException ex) {
				Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}//GEN-LAST:event_jButton10ActionPerformed

	private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
		// 
		if(flag[11]!= 1)
		{
			jButton11.setText(""+count);
			count++;
			flag[11]=1;
			if(count == 25)
				play = 1;
		}
		else if (play ==1)
		{
			PrintWriter out;
			flag1[11] = 1;
			jButton11.setEnabled(false);
			try {
				out = new PrintWriter(s.getOutputStream(), true);
				out.printf(jButton11.getText()+"\n");
			} catch (IOException ex) {
				Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}//GEN-LAST:event_jButton11ActionPerformed

	private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
		// 
		if(flag[12]!= 1)
		{
			jButton12.setText(""+count);
			count++;
			flag[12]=1;
			if(count == 25)
				play = 1;
		}
		else if (play ==1)
		{
			PrintWriter out;
			flag1[12] = 1;
			jButton12.setEnabled(false);
			try {
				out = new PrintWriter(s.getOutputStream(), true);
				out.printf(jButton12.getText()+"\n");
			} catch (IOException ex) {
				Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}//GEN-LAST:event_jButton12ActionPerformed

	private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
		// 
		if(flag[13]!= 1)
		{
			jButton13.setText(""+count);
			count++;
			flag[13]=1;
			if(count == 25)
				play = 1;
		}
		else if (play ==1)
		{
			PrintWriter out;
			flag1[13] = 1;
			jButton13.setEnabled(false);
			try {
				out = new PrintWriter(s.getOutputStream(), true);
				out.printf(jButton13.getText()+"\n");
			} catch (IOException ex) {
				Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}//GEN-LAST:event_jButton13ActionPerformed

	private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
		// 
		if(flag[14]!= 1)
		{
			jButton14.setText(""+count);
			count++;
			flag[14]=1;
			if(count == 25)
				play = 1;
		}
		else if (play ==1)
		{
			PrintWriter out;
			flag1[14] = 1;
			jButton14.setEnabled(false);
			try {
				out = new PrintWriter(s.getOutputStream(), true);
				out.printf(jButton14.getText()+"\n");
			} catch (IOException ex) {
				Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}//GEN-LAST:event_jButton14ActionPerformed

	private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
		// 
		if(flag[15]!= 1)
		{
			jButton15.setText(""+count);
			count++;
			flag[15]=1;
			if(count == 25)
				play = 1;
		}
		else if (play ==1)
		{
			PrintWriter out;
			flag1[15] = 1;
			jButton15.setEnabled(false);
			try {
				out = new PrintWriter(s.getOutputStream(), true);
				out.printf(jButton15.getText()+"\n");
			} catch (IOException ex) {
				Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}//GEN-LAST:event_jButton15ActionPerformed

	private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
		// 
		if(flag[16]!= 1)
		{
			jButton16.setText(""+count);
			count++;
			flag[16]=1;
			if(count == 25)
				play = 1;
		}
		else if (play ==1)
		{
			PrintWriter out;
			flag1[16] = 1;
			jButton16.setEnabled(false);
			try {
				out = new PrintWriter(s.getOutputStream(), true);
				out.printf(jButton16.getText()+"\n");
			} catch (IOException ex) {
				Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}//GEN-LAST:event_jButton16ActionPerformed

	private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
		// 
		if(flag[17]!= 1)
		{
			jButton17.setText(""+count);
			count++;
			flag[17]=1;
			if(count == 25)
				play = 1;
		}
		else if (play ==1)
		{
			PrintWriter out;
			flag1[17] = 1;
			jButton17.setEnabled(false);
			try {
				out = new PrintWriter(s.getOutputStream(), true);
				out.printf(jButton17.getText()+"\n");
			} catch (IOException ex) {
				Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}//GEN-LAST:event_jButton17ActionPerformed

	private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
		// 
		if(flag[18]!= 1)
		{
			jButton18.setText(""+count);
			count++;
			flag[18]=1;
			if(count == 25)
				play = 1;
		}
		else if (play ==1)
		{
			PrintWriter out;
			flag1[18] = 1;
			jButton18.setEnabled(false);
			try {
				out = new PrintWriter(s.getOutputStream(), true);
				out.printf(jButton18.getText()+"\n");
			} catch (IOException ex) {
				Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}//GEN-LAST:event_jButton18ActionPerformed

	private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
		// 
		if(flag[19]!= 1)
		{
			jButton19.setText(""+count);
			count++;
			flag[19]=1;
			if(count == 25)
				play = 1;
		}
		else if (play ==1)
		{
			PrintWriter out;
			flag1[19] = 1;
			jButton19.setEnabled(false);
			try {
				out = new PrintWriter(s.getOutputStream(), true);
				out.printf(jButton19.getText()+"\n");
			} catch (IOException ex) {
				Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}//GEN-LAST:event_jButton19ActionPerformed

	private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
		// 
		if(flag[20]!= 1)
		{
			jButton20.setText(""+count);
			count++;
			flag[20]=1;
			if(count == 25)
				play = 1;
		}
		else if (play ==1)
		{
			PrintWriter out;
			flag1[20] = 1;
			jButton20.setEnabled(false);
			try {
				out = new PrintWriter(s.getOutputStream(), true);
				out.printf(jButton20.getText()+"\n");
			} catch (IOException ex) {
				Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}//GEN-LAST:event_jButton20ActionPerformed

	private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
		// 
		if(flag[21]!= 1)
		{
			jButton21.setText(""+count);
			count++;
			flag[21]=1;
			if(count == 25)
				play = 1;
		}
		else if (play ==1)
		{
			PrintWriter out;
			flag1[21] = 1;
			jButton21.setEnabled(false);
			try {
				out = new PrintWriter(s.getOutputStream(), true);
				out.printf(jButton21.getText()+"\n");
			} catch (IOException ex) {
				Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}//GEN-LAST:event_jButton21ActionPerformed

	private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
		// 
		if(flag[22]!= 1)
		{
			jButton22.setText(""+count);
			count++;
			flag[22]=1;
			if(count == 25)
				play = 1;
		}
		else if (play ==1)
		{
			PrintWriter out;
			flag1[22] = 1;
			jButton22.setEnabled(false);
			try {
				out = new PrintWriter(s.getOutputStream(), true);
				out.printf(jButton22.getText()+"\n");
			} catch (IOException ex) {
				Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}//GEN-LAST:event_jButton22ActionPerformed

	private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
		// 
		if(flag[23]!= 1)
		{
			jButton23.setText(""+count);
			count++;
			flag[23]=1;
			if(count == 25)
				play = 1;
		}
		else if (play ==1)
		{
			PrintWriter out;
			flag1[23] = 1;
			jButton23.setEnabled(false);
			try {
				out = new PrintWriter(s.getOutputStream(), true);
				out.printf(jButton23.getText()+"\n");
			} catch (IOException ex) {
				Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}//GEN-LAST:event_jButton23ActionPerformed

	private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
		// 
		if(flag[24]!= 1)
		{
			jButton24.setText(""+count);
			count++;
			flag[24]=1;
			if(count == 25)
				play = 1;
		}
		else if (play ==1)
		{
			PrintWriter out;
			flag1[24] = 1;
			jButton24.setEnabled(false);
			try {
				out = new PrintWriter(s.getOutputStream(), true);
				out.printf(jButton24.getText()+"\n");
			} catch (IOException ex) {
				Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}//GEN-LAST:event_jButton24ActionPerformed

	private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
		// 
		if(flag[25]!= 1)
		{
			jButton25.setText(""+count);
			count++;
			flag[25]=1;
			if(count == 25)
				play = 1;
		}
		else if (play ==1)
		{
			PrintWriter out;
			flag1[25] = 1;
			jButton25.setEnabled(false);
			try {
				out = new PrintWriter(s.getOutputStream(), true);
				out.printf(jButton25.getText()+"\n");
			} catch (IOException ex) {
				Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}//GEN-LAST:event_jButton25ActionPerformed

	private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
		// 

		if(play==1)
		{
			ThreadServer x = new ThreadServer();
			Thread t = new Thread(x);
			t.start();
			jButton26.setEnabled(false);
			JOptionPane.showMessageDialog(null, "Client Started", null,JOptionPane.ERROR_MESSAGE);
		}
		else
			JOptionPane.showMessageDialog(null, "Fill Up", "Retry Later",JOptionPane.ERROR_MESSAGE);
	}//GEN-LAST:event_jButton26ActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
		 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Main().setVisible(true);
			}
		});
	}
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton10;
	private javax.swing.JButton jButton11;
	private javax.swing.JButton jButton12;
	private javax.swing.JButton jButton13;
	private javax.swing.JButton jButton14;
	private javax.swing.JButton jButton15;
	private javax.swing.JButton jButton16;
	private javax.swing.JButton jButton17;
	private javax.swing.JButton jButton18;
	private javax.swing.JButton jButton19;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton20;
	private javax.swing.JButton jButton21;
	private javax.swing.JButton jButton22;
	private javax.swing.JButton jButton23;
	private javax.swing.JButton jButton24;
	private javax.swing.JButton jButton25;
	private javax.swing.JButton jButton26;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton5;
	private javax.swing.JButton jButton6;
	private javax.swing.JButton jButton7;
	private javax.swing.JButton jButton8;
	private javax.swing.JButton jButton9;
	private javax.swing.JDesktopPane jDesktopPane1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenuBar jMenuBar1;
	// End of variables declaration//GEN-END:variables
}
