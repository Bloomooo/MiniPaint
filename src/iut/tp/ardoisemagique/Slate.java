/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iut.tp.ardoisemagique;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

import iut.tp.ardoisemagique.models.Paint;
import iut.tp.ardoisemagique.models.Tool;

/**
 * Slate est un JPanel personnalisé utilisé pour dessiner sur une toile.
 * Il prend en charge différents outils de peinture et permet de mettre à
 * l'échelle la zone de dessin.
 * 
 * @author Yanis Mechta
 * @version 1.0
 */
public class Slate extends JPanel {
    /**
     * La dimension de la toile.
     */
    private Dimension dimension;

    /**
     * La liste des points de peinture sur la toile.
     */
    private java.util.List<Paint> listPoints;

    /**
     * L'objet IDrawer utilisé pour les opérations de dessin sur la toile.
     */
    private IDrawer drawer;

    /**
     * L'échelle de la toile.
     */
    private double scale;

    /**
     * La position en X du curseur de dessin sur la toile.
     */
    private int posX;

    /**
     * La position en Y du curseur de dessin sur la toile.
     */
    private int posY;

    /**
     * Construit un objet Slate avec les dimensions spécifiées et le drawer associé.
     * 
     * @param dimension Les dimensions de la toile
     * @param drawer    L'objet drawer utilisé pour les opérations de dessin
     */
    public Slate(Dimension dimension, IDrawer drawer) {
        this.dimension = dimension;
        this.listPoints = new ArrayList<>();
        this.drawer = drawer;

        this.setPreferredSize(this.dimension);
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                posX = e.getX() * dimension.width / getWidth();
                posY = e.getY() * dimension.height / getHeight();
                int taille = drawer.getSlateToolSize();
                Color color = drawer.getSlateColor();

                Paint paint = new Paint(color, posX, posY, taille, taille, drawer.getSlateTool());
                listPoints.add(paint);

                repaint();
            }
        });
    }

    /**
     * Redessine la toile en utilisant les informations de dessin stockées.
     * 
     * @param g L'objet Graphics utilisé pour dessiner
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        if (drawer.isSlateSmooth()) {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        } else {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        }

        for (Paint point : listPoints) {
            int posX = point.getPosX() * getWidth() / dimension.width;
            int posY = point.getPosY() * getHeight() / dimension.height;
            int tailleX = point.getTailleX() * getWidth() / dimension.width;
            int tailleY = point.getTailleY() * getHeight() / dimension.height;

            g2d.setColor(point.getPointColor());

            if (point.getTool() == Tool.ROUND) {
                int adjustedPosX = posX - tailleX / 2;
                int adjustedPosY = posY - tailleY / 2;
                g2d.fillOval(adjustedPosX, adjustedPosY, tailleX, tailleY);
            } else if (point.getTool() == Tool.SQUARE) {
                int adjustedPosX = posX - tailleX / 2;
                int adjustedPosY = posY - tailleY / 2;
                g2d.fillRect(adjustedPosX, adjustedPosY, tailleX, tailleY);
            }
        }
    }

    /**
     * Définit l'échelle de la toile.
     * 
     * @param scale L'échelle de la toile
     */
    public void setScale(double scale) {
        this.scale = scale;
        Dimension scaledDimension = new Dimension((int) (dimension.width * scale), (int) (dimension.height * scale));
        setSize(scaledDimension);
        setPreferredSize(scaledDimension);
        setMinimumSize(scaledDimension);
        setMaximumSize(scaledDimension);
        revalidate();
        repaint();
    }

    /**
     * Gère l'événement de clic de souris.
     * Si l'outil actuel est la pipette (Tool.CHOOSER), la couleur choisie est
     * déterminée en fonction du point de peinture cliqué.
     * Sinon, l'événement est ignoré.
     *
     * @param e L'événement MouseEvent représentant le clic de souris
     */
    public void mouseClicked(MouseEvent e) {
        if (drawer.getSlateTool() == Tool.CHOOSER) {
            Color chosenColor = Color.white;
            for (Paint point : listPoints) {
                int posX = point.getPosX() * getWidth() / dimension.width;
                int posY = point.getPosY() * getHeight() / dimension.height;
                int tailleX = point.getTailleX() * getWidth() / dimension.width;
                int tailleY = point.getTailleY() * getHeight() / dimension.height;

                if (e.getX() >= posX && e.getX() <= posX + tailleX &&
                        e.getY() >= posY && e.getY() <= posY + tailleY) {
                    chosenColor = point.getPointColor();

                }
            }

            drawer.newColorChoosen(chosenColor);
        }

    }

}
