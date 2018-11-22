package Game.Games.TicTacToe.TicTacToeView;

import javax.swing.*;
import java.awt.*;

public class Box extends JButton {
    private final Coord coord;

    public Box(Coord coord) {
        this.coord = coord;
        this.setPreferredSize(new Dimension(150,150));
        this.setLayout(new BorderLayout());

        setOpaque(true);
        setBackground(Color.LIGHT_GRAY);
        setForeground(Color.BLACK);

    }

    public void setPawn(String text){
        this.setText(text);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
    }

    public Coord getCoord() {
        // TODO Auto-generated method stub
        return this.coord;
    }


}