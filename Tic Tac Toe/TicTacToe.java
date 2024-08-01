import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe {
  int boardWidth = 500;
  int boardHeight = 550; //extra pixel for text 
  JFrame frame = new JFrame("Tic-Tac-Toe"); //title appears at the top, not inside the frame

  //make panels 
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel boardPanel = new JPanel();

    JButton[][] board = new JButton[3][3]; //array that keeps track of the buttons on the board
    String x = "X";
    String o = "O";
    String currentPlayer = o;
    
    boolean gameOver = false;
    int turns = 0;


    TicTacToe() {
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null); //centers the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close when exit
        frame.setLayout(new BorderLayout()); 
    
      // 'formatting' label
      textLabel.setBackground(Color.white);
      textLabel.setForeground(Color.black);
      textLabel.setFont(new Font("TimesRoman", Font.BOLD, 30));
      textLabel.setHorizontalAlignment(JLabel.CENTER);
      textLabel.setText("Let's play Tic Tac Toe!");
      textLabel.setOpaque(true);

      textPanel.setLayout(new BorderLayout());
      textPanel.add(textLabel);
      frame.add(textPanel, BorderLayout.NORTH);

      textPanel.setLayout(new BorderLayout());
      textPanel.add(textLabel);
      frame.add(textPanel, BorderLayout.NORTH);

      boardPanel.setLayout(new GridLayout(3, 3));
      boardPanel.setBackground(Color.LIGHT_GRAY);
      frame.add(boardPanel);

      //looping through 3x3 array
      for (int i = 0; i < 3; i++) {
          for (int n = 0; n < 3; n++) {
            //adding tiles to board
            JButton tile = new JButton();
                board[i][n] = tile;
                boardPanel.add(tile);
            //tiles graphics
            tile.setBackground(Color.DARK_GRAY);
            tile.setForeground(Color.white);
            //formatting "X" and "O" strings 
            tile.setFont(new Font("TimesRoman", Font.BOLD, 120));
            tile.setFocusable(false);

            //Display text on a tile we clicked on
            tile.addActionListener(new ActionListener() {
              //ActionListener() dectates what happens when an event happens
              public void actionPerformed(ActionEvent e) {
                if (gameOver) {
                  return;
                }
                JButton tile = (JButton) e.getSource();
                //we specify the action is a JButton
                if (tile.getText() == "") //can only populate a tile if not empty
                 {
                    tile.setText(currentPlayer);
                    turns++;
                    checkWinner();
                    if (!gameOver) {
                        currentPlayer = currentPlayer == x ? o : x;
                        //if equal x then change to o, otherwise stays x 
                        textLabel.setText(currentPlayer + "'s turn.");
                        //player is shown on label 
                    }
                  }
              }

              private void checkWinner() {
                //Horizontal -> check rows 
                for (int r = 0; r < 3; r++) {
                  if (board[r][0].getText() == "") {
                    continue;} //check if first is empty 
      
                  if (board[r][0].getText() == board[r][1].getText() &&
                      board[r][1].getText() == board[r][2].getText()) {
                      for (int i = 0; i < 3; i++) {
                          setWinner(board[r][i]);
                      }
                      gameOver = true;
                      return;
                  }
              }
      
              //vertical
              for (int c = 0; c < 3; c++) {
                  if (board[0][c].getText() == "") continue;
                  
                  if (board[0][c].getText() == board[1][c].getText() &&
                      board[1][c].getText() == board[2][c].getText()) {
                      for (int i = 0; i < 3; i++) {
                          setWinner(board[i][c]);
                      }
                      gameOver = true;
                      return;
                  }
              }
      
              //diagonally
              if (board[0][0].getText() == board[1][1].getText() &&
                  board[1][1].getText() == board[2][2].getText() &&
                  board[0][0].getText() != "") {
                  for (int i = 0; i < 3; i++) {
                      setWinner(board[i][i]);
                  }
                  gameOver = true;
                  return;
              }
      
              //anti-diagonally
              if (board[0][2].getText() == board[1][1].getText() &&
                  board[1][1].getText() == board[2][0].getText() &&
                  board[0][2].getText() != "") {
                  setWinner(board[0][2]);
                  setWinner(board[1][1]);
                  setWinner(board[2][0]);
                  gameOver = true;
                  return;
              }
              //if there´s 9 turns and no winner, it's a tie! 
              if (turns == 9) {
                  for (int r = 0; r < 3; r++) {
                      for (int c = 0; c < 3; c++) {
                          setTie(board[r][c]);
                      }
                  }
                  gameOver = true;
              }
              }
            });
          }
      }
          
          
}

void setWinner(JButton tile) {
  //change color of winning line and background and label 
  tile.setForeground(Color.yellow);
  tile.setBackground(Color.black);
  textLabel.setText(currentPlayer + " is the winner!");
}

void setTie(JButton tile) {
  tile.setForeground(Color.red);
  tile.setBackground(Color.black);
  textLabel.setText("Tie!");
}
}
