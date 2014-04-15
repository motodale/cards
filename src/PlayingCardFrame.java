import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;


public class PlayingCardFrame extends JFrame
{

    //Instance Variables
    private CardPanel card1;
    private CardPanel card2;
    private DrawPilePanel drawPile1;
    private DrawPilePanel drawPile2;
    private JPanel menu;
    private JPanel field1;
    private JPanel field2;
    private IHand hand1;
    private IHand hand2;
    IHand[] hands = new IHand[2];

//Constructor
    /**
     * Craeats the frame with using the deck provided.
     * @param aDeck - the deck to use.
     */
    public PlayingCardFrame(IDeckOfCards aDeck)
    {
        this.setLayout(new FlowLayout());
        this.setSize(800,600);
        this.setTitle("WAR");
        this.setBackground(Color.lightGray);

        this.createMenuPanel();
        this.fieldMenuPanel1();
        this.fieldMenuPanel2();
        this.add(menu);
        this.add(field1);
        this.add(field2);


        hands = aDeck.dealCards(2);
        hand1 = hands[0];
        hand2 = hands[1];

    }

//Helpers Methods

    private void createMenuPanel()
    {
        menu = new JPanel();

        JButton newGameButton = new JButton("New Game");
        newGameButton.addActionListener(new NewGameListener());
        menu.add(newGameButton);
    }

    private void fieldMenuPanel1()
    {
        field1 = new JPanel();

        card1 = new CardPanel();
        drawPile1 = new DrawPilePanel();
        drawPile1.addMouseListener(new DrawListener());

        field1.add(drawPile1);
        field1.add(card1);
    }
    private void fieldMenuPanel2()
    {
        field2 = new JPanel();

        card2 = new CardPanel();
        drawPile2 = new DrawPilePanel();
        drawPile2.addMouseListener(new DrawListener());

        field2.add(drawPile2);
        field2.add(card2);
    }


    class DrawListener implements MouseListener
    {

        @Override
        public void mouseClicked(MouseEvent e)
        {

            if (!hand1.isEmpty() || !hand2.isEmpty())
            {
                IPlayingCard playerOne = hand1.drawCard();
                IPlayingCard playerTwo = hand2.drawCard();

                card1.setCard(playerOne);
                card2.setCard(playerTwo);
                if(playerOne.compareTo(playerTwo) == -1){
                    hand2.add(playerOne);
                    hand2.add(playerTwo);

                }else if(playerOne.compareTo(playerTwo) == 1){
                    hand1.add(playerOne);
                    hand1.add(playerTwo);

                }else{
                    hand1.drawCard();
                    hand2.drawCard();
                    // this is where I got stuck, I'm not sure how to recursively call this method to
                    //mouseClicked(MouseEvent);
                }





                if (hand1.isEmpty()) {
                    drawPile1.setOutOfCards(true);
                    System.out.println("Player 2 wins");
                }
                if (hand2.isEmpty()) {
                    drawPile2.setOutOfCards(true);
                    System.out.println("Player 1 wins");
                }

                PlayingCardFrame.this.repaint();
            }

        }

        @Override
        public void mousePressed(MouseEvent e)
        {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseReleased(MouseEvent e)
        {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseEntered(MouseEvent e)
        {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseExited(MouseEvent e)
        {
            // TODO Auto-generated method stub

        }

    }



    class NewGameListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            hand1.reset();
            hand2.reset();
            drawPile1.setOutOfCards(false);
            drawPile2.setOutOfCards(false);
            card1.setCard(null);
            card2.setCard(null);

            PlayingCardFrame.this.repaint();
        }
    }
}