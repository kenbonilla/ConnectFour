package connectfour;



import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author ken
 */
public class FXMLDocumentController implements Initializable {

    //the scene
    @FXML
    private GridPane gamePane;
    @FXML
    private Pane namesPane;
    @FXML
    private Pane splashScreen;


    //LABEL
    @FXML
    private Label red_scr;
    @FXML
    private Label blue_scr;
    @FXML
    private Label p1_name;
    @FXML
    private Label p2_name;


    //BOARD
    @FXML
    private Rectangle r00;
    @FXML
    private Rectangle r01;
    @FXML
    private Rectangle r02;
    @FXML
    private Rectangle r03;
    @FXML
    private Rectangle r04;
    @FXML
    private Rectangle r05;
    @FXML
    private Rectangle r06;
    @FXML
    private Rectangle r10;
    @FXML
    private Rectangle r11;
    @FXML
    private Rectangle r12;
    @FXML
    private Rectangle r13;
    @FXML
    private Rectangle r14;
    @FXML
    private Rectangle r15;
    @FXML
    private Rectangle r16;
    @FXML
    private Rectangle r20;
    @FXML
    private Rectangle r21;
    @FXML
    private Rectangle r22;
    @FXML
    private Rectangle r23;
    @FXML
    private Rectangle r24;
    @FXML
    private Rectangle r25;
    @FXML
    private Rectangle r26;
    @FXML
    private Rectangle r30;
    @FXML
    private Rectangle r31;
    @FXML
    private Rectangle r32;
    @FXML
    private Rectangle r33;
    @FXML
    private Rectangle r34;
    @FXML
    private Rectangle r35;
    @FXML
    private Rectangle r36;
    @FXML
    private Rectangle r40;
    @FXML
    private Rectangle r41;
    @FXML
    private Rectangle r42;
    @FXML
    private Rectangle r43;
    @FXML
    private Rectangle r44;
    @FXML
    private Rectangle r45;
    @FXML
    private Rectangle r46;
    @FXML
    private Rectangle r50;
    @FXML
    private Rectangle r51;
    @FXML
    private Rectangle r52;
    @FXML
    private Rectangle r53;
    @FXML
    private Rectangle r54;
    @FXML
    private Rectangle r55;
    @FXML
    private Rectangle r56;


    //BUTTONS
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private Button btn6;
    @FXML
    private Button btn7;
    @FXML
    private Button quit;
    @FXML
    private Button pvp;
    @FXML
    private Button pvc;
    @FXML
    private Button about;
    @FXML
    private Button pvpBack;
    @FXML
    private Button pvpStart;
    @FXML
    private Button btnBack;

    //Textfield
    @FXML
    private TextField pvpp1name;
    @FXML
    private TextField pvpp2name;


    //FUNCTIONS
    @FXML
    public void backToMain(){
	//resetscore
	//resetboard
	playMenuSound();
	splashScreen.setVisible(true);
	namesPane.setVisible(true);
	if(!ConnectFour.pl_turn){
	    ConnectFour.pl_turn = ConnectFour.changeColors(ConnectFour.pl_turn);
	}
	resetboard();
	ConnectFour.theBoard.clearWins();
	red_scr.setText("0");
	blue_scr.setText("0");
    }

    //Start PVP game, sets names
    @FXML
    public void startGame(){
	playMenuSound();
	//sets player names
	setTheNames();

	//sets player turn
	ConnectFour.pl_turn = ConnectFour.changeColors(false);

	//show the board
	namesPane.setVisible(false);
    }

    @FXML
    public void goBack(){
	playMenuSound();
	splashScreen.setVisible(true);
    }

    //Select either PVP or PVC
    @FXML
    public void menuButtonAction(ActionEvent e){
	playMenuSound();
	if(e.getSource() == pvp){
	    splashScreen.setVisible(false);
	    ConnectFour.pvpbool = true;

	}
	if(e.getSource() == pvc){
	    //popup.display("Coming Soon", "This function has not yet been built!");
	    splashScreen.setVisible(false);
	    ConnectFour.pvpbool = false;
	}
    }

    //Game board buttons 1 - 7
    //MAIN LOGIC BRANCH
    @FXML
    public void handleButtonAction(ActionEvent e) {
	int winnerIs = 0;
	if(e.getSource() == btn1){
	    winnerIs = makeTheMove(0);
	}else if(e.getSource() == btn2){
	    winnerIs = makeTheMove(1);
	}else if(e.getSource() == btn3){
	    winnerIs = makeTheMove(2);
	}else if(e.getSource() == btn4){
	    winnerIs = makeTheMove(3);
	}else if(e.getSource() == btn5){
	    winnerIs = makeTheMove(4);
	}else if(e.getSource() == btn6){
	    winnerIs = makeTheMove(5);
	}else if(e.getSource() == btn7){
	    winnerIs = makeTheMove(6);
	}else{
	    System.out.println("You broke the buttons");
	}
	String message;
	switch (winnerIs) {
	    case 0:
		//no winner
		break;
	    case 1:
		ConnectFour.theBoard.incrPlayerWins(true);
		red_scr.setText(Integer.toString(ConnectFour.theBoard.getPlayerWins(1)));
		playWinSound();
		message = ConnectFour.theBoard.getName(true);
		message += " wins!";
		popup.display("Victory!", message);
		resetboard();
		break;
	    case 2:
		//blue won
		ConnectFour.theBoard.incrPlayerWins(false);
		blue_scr.setText(Integer.toString(ConnectFour.theBoard.getPlayerWins(2)));
		playWinSound();
		message = ConnectFour.theBoard.getName(false);
		message += " wins!";
		popup.display("Victory!", message);
		resetboard();
		break;
	    case 3:
		playLosingSound();
		popup.display("No winner", "The board is full!");
		resetboard();
		break;
	    default:
		System.out.println("You broke the winner");
		break;
	}
    }

    //making the move logic
    @FXML
    private int makeTheMove(int colm){
	boolean validMove = ConnectFour.theBoard.isValidMove(colm);

	//checks if move is legal
	if(validMove){
	    //if move is legal
	    //1 - play pop sound
	    //2 - place the piece on the board
	    //3 - check if pvp
	    //	    //if pvp check for winner
	    //		    //if no winner flip player boolean and color
	    //	    //if pvc makeAI move
	    playPopSound();
	    pieceToBoard(ConnectFour.theBoard.makeMove(colm, ConnectFour.pl_turn), colm);
	    if(ConnectFour.pvpbool){
		if(ConnectFour.theBoard.isWinner() == 0){
		    ConnectFour.pl_turn = ConnectFour.changeColors(ConnectFour.pl_turn);
		}

	    }else if(ConnectFour.theBoard.isWinner() == 0){
		AIMakeMove();
	    }else{}
	//if not a legal move play bad sound
	}else{
	    playBadSound();
	}
	return ConnectFour.theBoard.isWinner();
    }

    
    private void AIMakeMove(){
        ConnectFour.pl_turn = false;
        int[] theMove;
        theMove = gamebackend.ComputerAI.makeMove(ConnectFour.theBoard.getBoard());
        int colm = theMove[0];
        int row = theMove[1];
        pieceToBoard(row, colm);
        ConnectFour.pl_turn = true;
    }

    //Update player move
    private void pieceToBoard(int row, int colm){
	colm++;
	row++;
	String theColor;
	if(ConnectFour.pl_turn){
	    theColor = "#B22222";
	}else{
	    theColor = "#3c697e";
	}
	switch (colm) {
	    case 1:
		switch (row){
		    case 1:
			r00.setFill(Paint.valueOf(theColor));
			break;
		    case 2:
			r10.setFill(Paint.valueOf(theColor));
			break;
		    case 3:
			r20.setFill(Paint.valueOf(theColor));
			break;
		    case 4:
			r30.setFill(Paint.valueOf(theColor));
			break;
		    case 5:
			r40.setFill(Paint.valueOf(theColor));
			break;
		    case 6:
			r50.setFill(Paint.valueOf(theColor));
			break;
		    default:
			System.out.println("You broke case 1");
			break;
		}
		break;
	    case 2:
		switch (row){
		    case 1:
			r01.setFill(Paint.valueOf(theColor));
			break;
		    case 2:
			r11.setFill(Paint.valueOf(theColor));
			break;
		    case 3:
			r21.setFill(Paint.valueOf(theColor));
			break;
		    case 4:
			r31.setFill(Paint.valueOf(theColor));
			break;
		    case 5:
			r41.setFill(Paint.valueOf(theColor));
			break;
		    case 6:
			r51.setFill(Paint.valueOf(theColor));
			break;
		    default:
			System.out.println("You broke case 2");
			break;
		}
		break;
	    case 3:
		switch (row){
		    case 1:
			r02.setFill(Paint.valueOf(theColor));
			break;
		    case 2:
			r12.setFill(Paint.valueOf(theColor));
			break;
		    case 3:
			r22.setFill(Paint.valueOf(theColor));
			break;
		    case 4:
			r32.setFill(Paint.valueOf(theColor));
			break;
		    case 5:
			r42.setFill(Paint.valueOf(theColor));
			break;
		    case 6:
			r52.setFill(Paint.valueOf(theColor));
			break;
		    default:
			System.out.println("You broke case3");
			break;
		}
		break;
	    case 4:
		switch (row){
		    case 1:
			r03.setFill(Paint.valueOf(theColor));
			break;
		    case 2:
			r13.setFill(Paint.valueOf(theColor));
			break;
		    case 3:
			r23.setFill(Paint.valueOf(theColor));
			break;
		    case 4:
			r33.setFill(Paint.valueOf(theColor));
			break;
		    case 5:
			r43.setFill(Paint.valueOf(theColor));
			break;
		    case 6:
			r53.setFill(Paint.valueOf(theColor));
			break;
		    default:
			System.out.println("You broke case4");
			break;
		}
		break;
	    case 5:
		switch (row){
		    case 1:
			r04.setFill(Paint.valueOf(theColor));
			break;
		    case 2:
			r14.setFill(Paint.valueOf(theColor));
			break;
		    case 3:
			r24.setFill(Paint.valueOf(theColor));
			break;
		    case 4:
			r34.setFill(Paint.valueOf(theColor));
			break;
		    case 5:
			r44.setFill(Paint.valueOf(theColor));
			break;
		    case 6:
			r54.setFill(Paint.valueOf(theColor));
			break;
		    default:
			System.out.println("You broke case5");
			break;
		}
		break;
	    case 6:
		switch (row){
		    case 1:
			r05.setFill(Paint.valueOf(theColor));
			break;
		    case 2:
			r15.setFill(Paint.valueOf(theColor));
			break;
		    case 3:
			r25.setFill(Paint.valueOf(theColor));
			break;
		    case 4:
			r35.setFill(Paint.valueOf(theColor));
			break;
		    case 5:
			r45.setFill(Paint.valueOf(theColor));
			break;
		    case 6:
			r55.setFill(Paint.valueOf(theColor));
			break;
		    default:
			System.out.println("You broke case 6");
			break;
		}
		break;
	    case 7:
		switch (row){
		    case 1:
			r06.setFill(Paint.valueOf(theColor));
			break;
		    case 2:
			r16.setFill(Paint.valueOf(theColor));
			break;
		    case 3:
			r26.setFill(Paint.valueOf(theColor));
			break;
		    case 4:
			r36.setFill(Paint.valueOf(theColor));
			break;
		    case 5:
			r46.setFill(Paint.valueOf(theColor));
			break;
		    case 6:
			r56.setFill(Paint.valueOf(theColor));
			break;
		    default:
			System.out.println("You broke case 7");
			break;
		}
		break;
	    default:
		System.out.println("You broke the columns");
		break;
	}

    }

    //Game board forfeit match
    @FXML
    private void forfeit(){
	if(ConnectFour.pl_turn){
	    ConnectFour.theBoard.incrPlayerWins(false);
	    blue_scr.setText(Integer.toString(ConnectFour.theBoard.getPlayerWins(2)));
	} else{
	    ConnectFour.theBoard.incrPlayerWins(true);
	    red_scr.setText(Integer.toString(ConnectFour.theBoard.getPlayerWins(1)));
	}
	playLosingSound();
	resetboard();
    }

    //Clears the board
    private void resetboard(){
	resetColors();
	ConnectFour.theBoard.boardReset();
	if(!ConnectFour.pl_turn){
	ConnectFour.pl_turn = ConnectFour.changeColors(false);
	}
    }

    private void setTheNames(){
	try{
	    if(pvpp1name.getText() != null && !pvpp1name.getText().isEmpty()){
		int a = pvpp1name.getText().length();
		if( a > 7) p1_name.setText(pvpp1name.getText(0,7));
		else p1_name.setText(pvpp1name.getText());
		ConnectFour.theBoard.setName(true, pvpp1name.getText());
	    }else{
		p1_name.setText("Player 1");
		ConnectFour.theBoard.setName(true, "Player 1");
	    }
	}catch(NullPointerException e){
	    System.out.println("pvpp1name.getText() null pointer exception");
	}

	try{
	    if(pvpp2name.getText() != null && !pvpp2name.getText().isEmpty()){
		int a = pvpp2name.getText().length();
		if( a > 7) p2_name.setText(pvpp2name.getText(0,7));
		else p2_name.setText(pvpp2name.getText());
		ConnectFour.theBoard.setName(false, pvpp2name.getText());
	    }else{
		p2_name.setText("Player 2");
		ConnectFour.theBoard.setName(false, "Player 2");
	    }
	}catch(NullPointerException e){
	    System.out.println("pvppname.getText() null pointer exception");
	}
    }

    //plays the pop sound
    private void playPopSound(){
	AudioClip popsound = new AudioClip(getClass().getResource("/snd/pop.aif").toExternalForm());
	popsound.setVolume(.5);
	popsound.play();
    }

    //plays bad selection
    private void playBadSound(){
	AudioClip popsound = new AudioClip(getClass().getResource("/snd/bad.aif").toExternalForm());
	popsound.setVolume(.5);
	popsound.play();
    }

    //plays winning sound
    private void playWinSound(){
	AudioClip popsound = new AudioClip(getClass().getResource("/snd/win.aif").toExternalForm());
	popsound.setVolume(.5);
	popsound.play();
    }

    //plays losing sound
    private void playLosingSound(){
	AudioClip popsound = new AudioClip(getClass().getResource("/snd/lose.aif").toExternalForm());
	popsound.setVolume(.5);
	popsound.play();
    }

    //plays the menu sound
    private void playMenuSound(){
	AudioClip popsound = new AudioClip(getClass().getResource("/snd/menu.aif").toExternalForm());
	popsound.setVolume(.1);
	popsound.play();
    }

    //clears game pieces off board
    private void resetColors(){
	String yellowish = "#e6e8b7";
	r00.setFill(Color.valueOf(yellowish));
	r00.setOpacity(.5);
	r01.setFill(Color.valueOf(yellowish));
	r01.setOpacity(.5);
	r02.setFill(Color.valueOf(yellowish));
	r02.setOpacity(.5);
	r03.setFill(Color.valueOf(yellowish));
	r03.setOpacity(.5);
	r04.setFill(Color.valueOf(yellowish));
	r04.setOpacity(.5);
	r05.setFill(Color.valueOf(yellowish));
	r05.setOpacity(.5);
	r06.setFill(Color.valueOf(yellowish));
	r06.setOpacity(.5);

	r10.setFill(Color.valueOf(yellowish));
	r10.setOpacity(.5);
	r11.setFill(Color.valueOf(yellowish));
	r11.setOpacity(.5);
	r12.setFill(Color.valueOf(yellowish));
	r12.setOpacity(.5);
	r13.setFill(Color.valueOf(yellowish));
	r13.setOpacity(.5);
	r14.setFill(Color.valueOf(yellowish));
	r14.setOpacity(.5);
	r15.setFill(Color.valueOf(yellowish));
	r15.setOpacity(.5);
	r16.setFill(Color.valueOf(yellowish));
	r16.setOpacity(.5);

	r20.setFill(Color.valueOf(yellowish));
	r20.setOpacity(.5);
	r21.setFill(Color.valueOf(yellowish));
	r21.setOpacity(.5);
	r22.setFill(Color.valueOf(yellowish));
	r22.setOpacity(.5);
	r23.setFill(Color.valueOf(yellowish));
	r23.setOpacity(.5);
	r24.setFill(Color.valueOf(yellowish));
	r24.setOpacity(.5);
	r25.setFill(Color.valueOf(yellowish));
	r25.setOpacity(.5);
	r26.setFill(Color.valueOf(yellowish));
	r26.setOpacity(.5);

	r30.setFill(Color.valueOf(yellowish));
	r30.setOpacity(.5);
	r31.setFill(Color.valueOf(yellowish));
	r31.setOpacity(.5);
	r32.setFill(Color.valueOf(yellowish));
	r32.setOpacity(.5);
	r33.setFill(Color.valueOf(yellowish));
	r33.setOpacity(.5);
	r34.setFill(Color.valueOf(yellowish));
	r34.setOpacity(.5);
	r35.setFill(Color.valueOf(yellowish));
	r35.setOpacity(.5);
	r36.setFill(Color.valueOf(yellowish));
	r36.setOpacity(.5);

	r40.setFill(Color.valueOf(yellowish));
	r40.setOpacity(.5);
	r41.setFill(Color.valueOf(yellowish));
	r41.setOpacity(.5);
	r42.setFill(Color.valueOf(yellowish));
	r42.setOpacity(.5);
	r43.setFill(Color.valueOf(yellowish));
	r43.setOpacity(.5);
	r44.setFill(Color.valueOf(yellowish));
	r44.setOpacity(.5);
	r45.setFill(Color.valueOf(yellowish));
	r45.setOpacity(.5);
	r46.setFill(Color.valueOf(yellowish));
	r46.setOpacity(.5);

	r50.setFill(Color.valueOf(yellowish));
	r50.setOpacity(.5);
	r51.setFill(Color.valueOf(yellowish));
	r51.setOpacity(.5);
	r52.setFill(Color.valueOf(yellowish));
	r52.setOpacity(.5);
	r53.setFill(Color.valueOf(yellowish));
	r53.setOpacity(.5);
	r54.setFill(Color.valueOf(yellowish));
	r54.setOpacity(.5);
	r55.setFill(Color.valueOf(yellowish));
	r55.setOpacity(.5);
	r56.setFill(Color.valueOf(yellowish));
	r56.setOpacity(.5);
    }

    //Shows the credits
    @FXML
    private void aboutButton(ActionEvent e){
	playMenuSound();
	aboutBox.display();
    }

    //default initialize function
    @Override
    public void initialize(URL url, ResourceBundle rb) {
	// TODO - not needed
    }

}
