/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package iut.tp.ardoisemagique;

import iut.tp.ardoisemagique.models.Tool;

/**
 * L'interface IDrawer définit les méthodes pour récupérer les paramètres de
 * dessin d'une toile.
 * Elle permet également de notifier les changements de couleur et de position
 * de la souris.
 * 
 * @author Yanis Mechta
 * @version 1.0
 */
public interface IDrawer {

    /**
     * Renvoie la couleur actuelle de la toile.
     *
     * @return La couleur actuelle de la toile
     */
    public java.awt.Color getSlateColor();

    /**
     * Renvoie l'outil de dessin actuel de la toile.
     *
     * @return L'outil de dessin actuel de la toile
     */
    public Tool getSlateTool();

    /**
     * Renvoie la taille de l'outil de dessin actuel de la toile.
     *
     * @return La taille de l'outil de dessin actuel de la toile
     */
    public int getSlateToolSize();

    /**
     * Indique si le dessin sur la toile est lissé ou non.
     *
     * @return true si le dessin est lissé, false sinon
     */
    public boolean isSlateSmooth();

    /**
     * Notifie le changement de couleur sélectionnée sur la toile.
     *
     * @param newColor La nouvelle couleur sélectionnée
     */
    public void newColorChoosen(java.awt.Color newColor);

    /**
     * Notifie le déplacement de la souris sur la toile.
     *
     * @param point Les coordonnées de la nouvelle position de la souris
     */
    public void newMousePosition(java.awt.Point point);
}
