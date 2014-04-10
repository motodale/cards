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
private CardPanel card;
private DrawPilePanel drawPile;
private IDeckOfCards next;
private JPanel menu;
private JPanel field;


//Constructor
/**
 * Craeats the frame with using the deck provided.
 * @param aDeck - the deck to use.
 */
public PlayingCardFrame(IDeckOfCards aDeck)
{
    this.setLayout(new FlowLayout());
    this.setSize(300,300);
    this.setTitle("Cards...What's Next");
    this.setBackground(Color.lightGray);
    
    this.createMenuPanel();
    this.fieldMenuPanel();
    this.add(menu);
    this.add(field);
    
    next = aDeck;
}

//Helpers Methods

private void createMenuPanel()
{
    menu = new JPanel();
    
    JButton resetButton = new JButton("Reset");
    resetButton.addActionListener(new ResetListener());
    menu.add(resetButton);
}

private void fieldMenuPanel()
{
    field = new JPanel();
    
    card = new CardPanel();
    drawPile = new DrawPilePanel();
    drawPile.addMouseListener(new DrawListener());
    
    field.add(drawPile);
    field.add(card);
}


class DrawListener implements MouseListener
{

    @Override
    public void mouseClicked(MouseEvent e)
    {

        if (!next.isEmpty())
        {
            IPlayingCard nextCard = next.drawCard();
            card.setCard(nextCard);
        
            if (next.isEmpty())
                drawPile.setOutOfCards(true);
            
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



class ResetListener implements ActionListener
{
    public void actionPerformed(ActionEvent event)
    {
        next.reset();
        drawPile.setOutOfCards(false);
        card.setCard(null);
        
        PlayingCardFrame.this.repaint();
    }
}
}