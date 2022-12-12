package uk.co.freddiefaulkner.supercars;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.ListIterator;

public class ViewCards extends AppCompatActivity {
    // declares variables used for objects on the form
    ImageView imageView;
    TextView textView;
    LinkedList<Card> cards = new LinkedList<>();
    ListIterator<Card> iterator1;
    boolean forward1 = true, soundOn = true;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cards);

        // sets up the media player for background music
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.i);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);

        // sets up the image view and textbox for the card
        imageView = findViewById(R.id.imageView9);
        textView = findViewById(R.id.txtName);

        // instances of the cards
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

        // adding the cards to the linkedlist
        cards.add(JAG_XJ220);
        cards.add(KOEN_CCX);
        cards.add(LAFERRARI);
        cards.add(LEX_LFA);
        cards.add(LAM_AVENT);
        cards.add(LOT_ELI);
        cards.add(MAS_GT);
        cards.add(MAZDA_RX8);
        cards.add(MCLA_F1);
        cards.add(MCLA_12C);
        cards.add(NISS_GTR);
        cards.add(PAG_HUA);
        cards.add(POR_959);
        cards.add(POR_911_997);
        cards.add(Toy_GT86);
        cards.add(JAG_FT);
        cards.add(HON_NSX);
        cards.add(FOR_MUS);
        cards.add(FOR_GT);
        cards.add(FER_F40);
        cards.add(ALR_4C);
        cards.add(ALR_GTV);
        cards.add(ARE_ATO);
        cards.add(AST_VAN);
        cards.add(ALR_SPI);
        cards.add(AUD_R8);
        cards.add(BAC_MON);
        cards.add(BUG_VEY);
        cards.add(CHE_COR);
        cards.add(FER_458);

        // sets up the list iterator to move through the list
        iterator1 = cards.listIterator();
        // shows the image of the card
        imageView.setImageResource(iterator1.next().getImage());
        // sets up the text for the cards
        iterator1.previous();
        textView.setText(iterator1.next().getName());

    }

    // function used to iterate through the list of cards if user wants to see all playing cards
    public void moveCard(View view) {
        switch (view.getId()){
            case R.id.btnNext:
                if(!forward1){
                    if(iterator1.hasNext()){
                        iterator1.next();
                    }
                    forward1 = true;
                }
                if(iterator1.hasNext()){
                    imageView.setImageResource(iterator1.next().getImage());
                    iterator1.previous();
                    textView.setText(iterator1.next().getName());
                }
                break;

            case R.id.btnPrevious:
                if(forward1){
                    if(iterator1.hasPrevious()){
                        iterator1.previous();
                    }
                    forward1 = false;
                }
                if(iterator1.hasPrevious()){
                    imageView.setImageResource(iterator1.previous().getImage());
                    iterator1.next();
                    textView.setText(iterator1.previous().getName());
                }
                break;
        }
    }

    // checks the sound to see if it is on or not and will mute or unmute depending on if playing or not
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

    // function used to restart form if navigated back
    @Override
    protected void onRestart() {
        super.onRestart();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.i);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);
    }

    // function used to destroy the form if navigated away
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.pause();
        mediaPlayer.release();
    }
}
