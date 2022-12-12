package uk.co.freddiefaulkner.supercars;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main5Activity extends AppCompatActivity {
    TextView txtPlayerCards, txtCpuCards, txtChoice;
    String username, choice = "", roundWinner = "", winner = "";
    MediaPlayer mediaPlayer;
    boolean soundOn = true, playerGo = false;
    Card playerCard, computerCard;
    ImageView playerCardView, computerCardView;
    Button btnTopSpeed, btnEngineSize, btnCoolFactor, btnInnovation, btnYearLaunched, btnNext;
    Queue<Card> playerCards = new LinkedList<>();
    Queue<Card> computerCards = new LinkedList<>();
    ArrayList<Card> deck = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        playerCardView = (ImageView) findViewById(R.id.playerCardView);
        computerCardView = (ImageView) findViewById(R.id.computerCardView);

        btnTopSpeed = (Button) findViewById(R.id.btnTopSpeed);
        btnEngineSize = (Button) findViewById(R.id.btnEngineSize);
        btnCoolFactor = (Button) findViewById(R.id.btnCoolFactor);
        btnInnovation = (Button) findViewById(R.id.btnInnovation);
        btnYearLaunched = (Button) findViewById(R.id.btnYearLaunched);
        btnNext = (Button) findViewById(R.id.btnNext);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.e);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);

        txtPlayerCards = (TextView) findViewById(R.id.txtPlayerCards);
        txtCpuCards = (TextView) findViewById(R.id.txtCpuCards);
        txtChoice = (TextView) findViewById(R.id.txtChoice);

        Bundle bundle = getIntent().getExtras();
        username = bundle.getString("A");

        Card JAG_XJ220 = new Card("Jaguar XJ220", R.drawable.jaguar_xj220, 220, 3.5, 40, 8, 1992);
        Card KOEN_CCX = new Card("Koenigsegg CCX", R.drawable.koenigsegg_ccx, 273, 5.0, 41, 4, 2006);
        Card LAFERRARI = new Card("Laferrari", R.drawable.laferrari, 217, 6.3, 36, 10, 2013);
        Card LEX_LFA = new Card("Lexus LFA", R.drawable.lexus_lfa, 203, 4.8, 29, 3, 2010);
        Card LAM_AVENT = new Card("Lambourghini Aventador", R.drawable.lamborghini_aventador, 217, 6.5, 29, 4, 2011);
        Card LOT_ELI = new Card("Lotus Elise", R.drawable.lotus_elise, 127, 1.8, 35, 3, 1996);
        Card MAS_GT = new Card("Maserati Granturismo", R.drawable.maserati_granturismo, 177, 4.7, 28, 3, 2007);
        Card MAZDA_RX8 = new Card("Mazda RX8", R.drawable.mazda_rx8, 145, 1.3, 30, 10, 1978);
        Card MCLA_F1 = new Card("McLaren F1", R.drawable.mclaren_f1, 217, 3.8, 50, 9, 1992);
        Card MCLA_12C = new Card("McLaren 12C", R.drawable.mclaren_12c, 207, 3.8, 45, 9, 2011);
        Card NISS_GTR = new Card("Nissan GTR", R.drawable.nissan_gtr, 195, 3.8, 36, 5, 2007);
        Card PAG_HUA = new Card("Pagani Huayra", R.drawable.pagani_huayra, 231, 6, 44, 8, 2012);
        Card POR_959 = new Card("Porsche 959", R.drawable.porsche_959, 195, 2.85, 34, 8, 1986);
        Card POR_911_997 = new Card("Porsche 911/997", R.drawable.porsche_911_997, 188, 3.8, 48, 7, 1963);
        Card Toy_GT86 = new Card("Toyota GT86", R.drawable.toyota_gt86, 140, 2, 23, 5, 2012);
        Card JAG_FT = new Card("Jaguar F-Type", R.drawable.jaguar_ftype, 171, 3.0, 26, 2, 2013);
        Card HON_NSX = new Card("Honda NSX", R.drawable.honda_nsx, 191, 3.0, 49, 8, 1990);
        Card FOR_MUS = new Card("Ford Mustang", R.drawable.ford_mustang, 190, 5.8, 20, 3, 1964);
        Card FOR_GT = new Card("Ford GT", R.drawable.ford_gt, 205, 5.4, 33, 6, 2004);
        Card FER_F40 = new Card("Ferrari F40", R.drawable.ferrari_f40, 201, 2.9, 49, 4, 1987);
        Card ALR_4C = new Card("Alpha Romeo 4C", R.drawable.alfa_romeo_4c, 160, 1.8, 40, 6, 2013);
        Card ALR_GTV = new Card("Alpha Romeo GTV", R.drawable.alfa_romeo_gtv, 158, 3.2, 39, 5, 1993);
        Card ARE_ATO = new Card("Ariel Atom", R.drawable.ariel_atom, 150, 2.0, 44, 3, 1996);
        Card AST_VAN = new Card("Aston Martin Vantage", R.drawable.aston_martin_vantage, 205, 6.0, 36, 5, 2005);
        Card ALR_SPI = new Card("Alpha Romeo Spider", R.drawable.alfa_romeo_spider, 118, 2.0, 34, 1, 1966);
        Card AUD_R8 = new Card("Audi R8", R.drawable.audi_r8, 196, 5.2, 23, 4, 2007);
        Card BAC_MON = new Card("Bac Mono", R.drawable.bac_mono, 170, 2.3, 47, 7, 2011);
        Card BUG_VEY = new Card("Bugatti Veyron", R.drawable.bugatti_veyron, 267, 8.0, 46, 9, 2005);
        Card CHE_COR = new Card("Chevrolet Corvette", R.drawable.chevrolet_corvette, 190, 6.2, 24, 8, 1953);
        Card FER_458 = new Card("Ferrari 458", R.drawable.ferrari_458, 202, 4.5, 46, 7, 2009);

        deck.add(JAG_XJ220);
        deck.add(KOEN_CCX);
        deck.add(LAFERRARI);
        deck.add(LEX_LFA);
        deck.add(LAM_AVENT);
        deck.add(LOT_ELI);
        deck.add(MAS_GT);
        deck.add(MAZDA_RX8);
        deck.add(MCLA_F1);
        deck.add(MCLA_12C);
        deck.add(NISS_GTR);
        deck.add(PAG_HUA);
        deck.add(POR_959);
        deck.add(POR_911_997);
        deck.add(Toy_GT86);
        deck.add(JAG_FT);
        deck.add(HON_NSX);
        deck.add(FOR_MUS);
        deck.add(FOR_GT);
        deck.add(FER_F40);
        deck.add(ALR_4C);
        deck.add(ALR_GTV);
        deck.add(ARE_ATO);
        deck.add(AST_VAN);
        deck.add(ALR_SPI);
        deck.add(AUD_R8);
        deck.add(BAC_MON);
        deck.add(BUG_VEY);
        deck.add(CHE_COR);
        deck.add(FER_458);

        shuffleDeck();
        dealCards();
        txtPlayerCards.setText("N.O cards: " + playerCards.size());
        txtCpuCards.setText("N.O cards: " + computerCards.size());
        computersGo();
    }



    @SuppressLint("SetTextI18n")
    public void setChoice(View v) {
        switch (v.getId()) {
            case R.id.btnTopSpeed:
                choice = "TOP SPEED";
                break;
            case R.id.btnEngineSize:
                choice = "ENGINE SIZE";
                break;
            case R.id.btnCoolFactor:
                choice = "COOL FACTOR";
                break;
            case R.id.btnInnovation:
                choice = "INNOVATION";
                break;
            case R.id.btnYearLaunched:
                choice = "YEAR LAUNCHED";
                break;
        }

        txtChoice.setText("Choice: " + choice);

        btnTopSpeed.setEnabled(false);
        btnEngineSize.setEnabled(false);
        btnCoolFactor.setEnabled(false);
        btnInnovation.setEnabled(false);
        btnYearLaunched.setEnabled(false);

        computerCard = computerCards.poll();
        computerCardView.setImageResource(computerCard.getImage());
        setRoundWinner();
        sortCardPiles();
        btnNext.setEnabled(true);
        playerGo = false;
    }

    public void computersGo(){
        playerCardView.setImageResource(R.drawable.background);
        computerCardView.setImageResource(R.drawable.background);
        btnTopSpeed.setEnabled(false);
        btnEngineSize.setEnabled(false);
        btnCoolFactor.setEnabled(false);
        btnInnovation.setEnabled(false);
        btnYearLaunched.setEnabled(false);

        btnNext.setEnabled(false);

        computerCard = computerCards.poll();
        computerCardView.setImageResource(computerCard.getImage());
        randomChoice();
        playerCard = playerCards.poll();
        playerCardView.setImageResource(playerCard.getImage());
        setRoundWinner();
        sortCardPiles();
        btnNext.setEnabled(true);
        playerGo = true;
    }

    public void playersGo(){
        playerCardView.setImageResource(R.drawable.background);
        computerCardView.setImageResource(R.drawable.background);
        btnTopSpeed.setEnabled(true);
        btnEngineSize.setEnabled(true);
        btnCoolFactor.setEnabled(true);
        btnInnovation.setEnabled(true);
        btnYearLaunched.setEnabled(true);

        btnNext.setEnabled(false);
        playerCard = playerCards.poll();
        playerCardView.setImageResource(playerCard.getImage());
    }

    public void setRoundWinner(){
        switch (choice){
            case "TOP SPEED":
                if(playerCard.getTopSpeed() < computerCard.getTopSpeed())
                    roundWinner = "COMPUTER";
                else if(playerCard.getTopSpeed() > computerCard.getTopSpeed())
                    roundWinner = "PLAYER";
                else
                    roundWinner = "DRAW";
                break;

            case "ENGINE SIZE":
                if(playerCard.getEngineSize() < computerCard.getEngineSize())
                    roundWinner = "COMPUTER";
                else if(playerCard.getEngineSize() > computerCard.getEngineSize())
                    roundWinner = "PLAYER";
                else
                    roundWinner = "DRAW";
                break;

            case "COOL FACTOR":
                if(playerCard.getCoolFactor() < computerCard.getCoolFactor())
                    roundWinner = "COMPUTER";
                else if(playerCard.getCoolFactor() > computerCard.getCoolFactor())
                    roundWinner = "PLAYER";
                else
                    roundWinner = "DRAW";
                break;

            case "INNOVATION":
                if(playerCard.getInnovation() < computerCard.getInnovation())
                    roundWinner = "COMPUTER";
                else if(playerCard.getInnovation() > computerCard.getInnovation())
                    roundWinner = "PLAYER";
                else
                    roundWinner = "DRAW";
                break;

            case "YEAR LAUNCHED":
                if(playerCard.getYearLaunched() < computerCard.getYearLaunched())
                    roundWinner = "COMPUTER";
                else if(playerCard.getYearLaunched() > computerCard.getYearLaunched())
                    roundWinner = "PLAYER";
                else
                    roundWinner = "DRAW";
                break;
        }
    }

    @SuppressLint("SetTextI18n")
    public void sortCardPiles(){
        if(roundWinner.equals("PLAYER")){
            playerCards.add(computerCard);
            playerCards.add(playerCard);
        }
        else if(roundWinner.equals("COMPUTER")){
            computerCards.add(playerCard);
            computerCards.add(computerCard);
        }
        else{
            computerCards.add(computerCard);
            playerCards.add(playerCard);
        }

        txtPlayerCards.setText("N.O Cards: " + playerCards.size());
        txtCpuCards.setText("N.O Cards: " + computerCards.size());
    }

    public void randomChoice(){
        int randomNum = 1 + (int)(Math.random() * 5);
        switch (randomNum){
            case 1:
                choice = "TOP SPEED";
                break;
            case 2:
                choice = "ENGINE SIZE";
                break;
            case 3:
                choice = "COOL FACTOR";
                break;
            case 4:
                choice = "INNOVATION";
                break;
            case 5:
                choice = "YEAR LAUNCHED";
                break;
        }

        txtChoice.setText("Choice: " + choice);
    }

    public void sound(View view) {
        if(!soundOn){
            mediaPlayer.start();
            soundOn = true;
        }
        else{
            mediaPlayer.pause();
            soundOn = false;
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.e);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.pause();
        mediaPlayer.release();
    }

    public void nextRound(View view) {
        if(playerCards.size() == 0){
            Intent intent = new Intent(this, Main4Activity.class);
            Bundle b = new Bundle();
            b.putString("A", username);
            mediaPlayer.pause();
            mediaPlayer.release();
            intent.putExtras(b);
            startActivity(intent);
        }

        else if(computerCards.size() == 0) {
            DatabaseHelper databaseHelper = new DatabaseHelper(this);
            int highScore = Integer.parseInt(databaseHelper.getHighScore(username));
            databaseHelper.updateWins(username, highScore);

            Intent intent = new Intent(this, Main4Activity.class);
            Bundle b = new Bundle();
            b.putString("A", username);
            mediaPlayer.pause();
            mediaPlayer.release();
            intent.putExtras(b);
            startActivity(intent);
        }

        else {
            if (playerGo) {
                playersGo();
            } else {
                computersGo();
            }
        }
    }

    public void shuffleDeck(){
        Collections.shuffle(deck);
    }

    public void dealCards(){
        Card card;
        for(int i = 0; i < deck.size(); i++){
            if((i+1) % 2 == 0) {
                card = deck.get(i);
                playerCards.add(card);
            }
            else{
                card = deck.get(i);
                computerCards.add(card);
            }
        }
    }
}
