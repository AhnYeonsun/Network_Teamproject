package ThreeGo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class isBingo {
	static boolean isWin = false;
	static boolean[] f = new boolean[12];
	int cnt;
	
	private void yesbingo(int i){
		f[i] = true;
		cnt = 0;
		for (boolean myBool : f){
			if(myBool){
				cnt++;
			}
		}
		
		if(cnt == 3 && isWin == false){
			JOptionPane.showMessageDialog(null, "You win", "Bingocheck message",JOptionPane.INFORMATION_MESSAGE);
			isWin = true;
		}
	}
	public isBingo(int[] board){

		if(board[1]==1 && board[2]==1 && board[3]==1 && board[4]==1 && board[5]==1) //horizontal
			yesbingo(0);
		if(board[6]==1 && board[7]==1 && board[8]==1 && board[9]==1 && board[10]==1)
			yesbingo(1);
		if(board[11]==1 && board[12]==1 && board[13]==1 && board[14]==1 && board[15]==1)
			yesbingo(2);
		if(board[16]==1 && board[17]==1 && board[18]==1 && board[19]==1 && board[20]==1)
			yesbingo(3);
		if(board[21]==1 && board[22]==1 && board[23]==1 && board[24]==1 && board[25]==1)
			yesbingo(4);

		if(board[1]==1 && board[6]==1 && board[11]==1 && board[16]==1 && board[21]==1) //vertical
			yesbingo(5);
		if(board[2]==1 && board[7]==1 && board[12]==1 && board[17]==1 && board[12]==1)
			yesbingo(6);
		if(board[3]==1 && board[8]==1 && board[13]==1 && board[18]==1 && board[23]==1)
			yesbingo(7);
		if(board[4]==1 && board[9]==1 && board[14]==1 && board[19]==1 && board[24]==1)
			yesbingo(8);
		if(board[5]==1 && board[10]==1 && board[15]==1 && board[20]==1 && board[25]==1)
			yesbingo(9);

		if(board[1]==1 && board[7]==1 && board[13]==1 && board[19]==1 && board[25]==1) //diagonal
			yesbingo(10);
		if(board[5]==1 && board[9]==1 && board[13]==1 && board[17]==1 && board[21]==1)
			yesbingo(11);
	}
}
