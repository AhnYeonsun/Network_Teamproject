package ThreeGo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class isBingo {


	public isBingo(int[] board){
		int i=0,j=0;
		
		if(board[1]==1 && board[2]==1 && board[3]==1 && board[4]==1 && board[5]==1) //horizontal
			j++;
		if(board[6]==1 && board[7]==1 && board[8]==1 && board[9]==1 && board[10]==1)
			j++;
		if(board[11]==1 && board[12]==1 && board[13]==1 && board[14]==1 && board[15]==1)
			j++;
		if(board[16]==1 && board[17]==1 && board[18]==1 && board[19]==1 && board[20]==1)
			j++;
		if(board[21]==1 && board[22]==1 && board[23]==1 && board[24]==1 && board[25]==1)
			j++;

		if(board[1]==1 && board[6]==1 && board[11]==1 && board[16]==1 && board[21]==1) //vertical
			j++;
		if(board[2]==1 && board[7]==1 && board[12]==1 && board[17]==1 && board[12]==1)
			j++;
		if(board[3]==1 && board[8]==1 && board[13]==1 && board[18]==1 && board[23]==1)
			j++;
		if(board[4]==1 && board[9]==1 && board[14]==1 && board[19]==1 && board[24]==1)
			j++;
		if(board[5]==1 && board[10]==1 && board[15]==1 && board[20]==1 && board[25]==1)
			j++;

		if(board[1]==1 && board[7]==1 && board[13]==1 && board[19]==1 && board[25]==1) //diagonal
			j++;
		if(board[5]==1 && board[9]==1 && board[13]==1 && board[17]==1 && board[21]==1)
			j++;

		if(j==3)
	       {
	           JOptionPane.showMessageDialog(null, "U win", "U win the match",JOptionPane.INFORMATION_MESSAGE);
	           PrintWriter out;
	       }
	}
}
