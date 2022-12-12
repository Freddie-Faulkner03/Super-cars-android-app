package uk.co.freddiefaulkner.supercars;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Deck {
    public ArrayList<Card> deck = new ArrayList<>();
    Queue<Card> playerCards = new LinkedList<>();
    Queue<Card> computerCards = new LinkedList<>();
}
