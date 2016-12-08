package ThreeGo;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class isBingo {
   static boolean isWin = false;
   static boolean[] f = new boolean[12];
   int cnt;
   Clip clip;
   
   private void yesbingo(int i){
      f[i] = true;
      cnt = 0;
      for (boolean myBool : f){
         if(myBool){
            cnt++;
         }
      }
      
      //3 bingo일 경우 이겼다고 메시지가 뜬다.
      if(cnt == 3 && isWin == false){
         Sound("ppap.wav", false);
         JOptionPane.showMessageDialog(null, "You win", "Bingocheck message",JOptionPane.INFORMATION_MESSAGE);
         isWin = true;
      }
   }
   
   private void Sound(String file, boolean Loop) {
         try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream(file)));
            clip = AudioSystem.getClip();
            clip.open(ais);
            clip.start();
            if (Loop)
               clip.loop(-1);
         } catch (Exception e) {
            e.printStackTrace();
         }
      }

   //각 대각선과 가로 세로 를 세어서 빙고의 수를 세어준다.
   public isBingo(int[] board){
	  //horizontal
      if(board[1]==1 && board[2]==1 && board[3]==1 && board[4]==1 && board[5]==1){
         yesbingo(0);
         JOptionPane.showMessageDialog(null, String.valueOf(cnt) +" Bingo", "Bingocheck message",JOptionPane.INFORMATION_MESSAGE);
      }
      if(board[6]==1 && board[7]==1 && board[8]==1 && board[9]==1 && board[10]==1){
         yesbingo(1);
         JOptionPane.showMessageDialog(null, String.valueOf(cnt) +" Bingo", "Bingocheck message",JOptionPane.INFORMATION_MESSAGE);
      }
      if(board[11]==1 && board[12]==1 && board[13]==1 && board[14]==1 && board[15]==1){
         yesbingo(2);
         JOptionPane.showMessageDialog(null, String.valueOf(cnt) +" Bingo", "Bingocheck message",JOptionPane.INFORMATION_MESSAGE);
      }
      if(board[16]==1 && board[17]==1 && board[18]==1 && board[19]==1 && board[20]==1){
         yesbingo(3);
         JOptionPane.showMessageDialog(null, String.valueOf(cnt) +" Bingo", "Bingocheck message",JOptionPane.INFORMATION_MESSAGE);
      }
      if(board[21]==1 && board[22]==1 && board[23]==1 && board[24]==1 && board[25]==1){
         yesbingo(4);
         JOptionPane.showMessageDialog(null, String.valueOf(cnt) +" Bingo", "Bingocheck message",JOptionPane.INFORMATION_MESSAGE);
      }
      //vertical
      if(board[1]==1 && board[6]==1 && board[11]==1 && board[16]==1 && board[21]==1){
         yesbingo(5);
         JOptionPane.showMessageDialog(null, String.valueOf(cnt) +" Bingo", "Bingocheck message",JOptionPane.INFORMATION_MESSAGE);
      }
      if(board[2]==1 && board[7]==1 && board[12]==1 && board[17]==1 && board[12]==1){
         yesbingo(6);
         JOptionPane.showMessageDialog(null, String.valueOf(cnt) +" Bingo", "Bingocheck message",JOptionPane.INFORMATION_MESSAGE);
      }
      if(board[3]==1 && board[8]==1 && board[13]==1 && board[18]==1 && board[23]==1){
         yesbingo(7);
         JOptionPane.showMessageDialog(null, String.valueOf(cnt) +" Bingo", "Bingocheck message",JOptionPane.INFORMATION_MESSAGE);
      }
      if(board[4]==1 && board[9]==1 && board[14]==1 && board[19]==1 && board[24]==1){
         yesbingo(8);
         JOptionPane.showMessageDialog(null, String.valueOf(cnt) +" Bingo", "Bingocheck message",JOptionPane.INFORMATION_MESSAGE);
      }
      if(board[5]==1 && board[10]==1 && board[15]==1 && board[20]==1 && board[25]==1){
         yesbingo(9);
         JOptionPane.showMessageDialog(null, String.valueOf(cnt) +" Bingo", "Bingocheck message",JOptionPane.INFORMATION_MESSAGE);
      }
      //diagonal
      if(board[1]==1 && board[7]==1 && board[13]==1 && board[19]==1 && board[25]==1){
         yesbingo(10);
         JOptionPane.showMessageDialog(null, String.valueOf(cnt) +" Bingo", "Bingocheck message",JOptionPane.INFORMATION_MESSAGE);
      }
      if(board[5]==1 && board[9]==1 && board[13]==1 && board[17]==1 && board[21]==1){
         yesbingo(11);
         JOptionPane.showMessageDialog(null, String.valueOf(cnt) +" Bingo", "Bingocheck message",JOptionPane.INFORMATION_MESSAGE);
      }
   }
}