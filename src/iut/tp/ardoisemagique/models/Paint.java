/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iut.tp.ardoisemagique.models;

/**
 * La classe Paint représente une peinture sur la toile avec ses attributs tels
 * que la couleur, la position et la taille.
 * 
 * @author Yanis Mechta
 * @version 1.0
 */
public class Paint {
    /**
     * La couleur de la peinture.
     */
    private java.awt.Color pointColor;

    /**
     * La position en X de la peinture sur la toile.
     */
    private int posX;

    /**
     * La position en Y de la peinture sur la toile.
     */
    private int posY;

    /**
     * La taille en X de la peinture.
     */
    private int tailleX;

    /**
     * La taille en Y de la peinture.
     */
    private int tailleY;

    /**
     * L'outil utilisé pour la peinture.
     */
    private Tool tool;

    /**
     * Constructeur de la classe Paint.
     *
     * @param pointColor La couleur de la peinture
     * @param posX       La position en X de la peinture sur la toile
     * @param posY       La position en Y de la peinture sur la toile
     * @param tailleX    La taille en X de la peinture
     * @param tailleY    La taille en Y de la peinture
     * @param tool       L'outil utilisé pour la peinture
     */
    public Paint(java.awt.Color pointColor, int posX, int posY, int tailleX, int tailleY, Tool tool) {
        this.pointColor = pointColor;
        this.posX = posX;
        this.posY = posY;
        this.tailleX = tailleX;
        this.tailleY = tailleY;
        this.tool = tool;
    }

    /**
     * Obtient l'outil utilisé pour la peinture.
     *
     * @return L'outil utilisé pour la peinture
     */
    public Tool getTool() {
        return this.tool;
    }

    /**
     * Définit l'outil utilisé pour la peinture.
     *
     * @param tool L'outil utilisé pour la peinture
     */
    public void setTool(Tool tool) {
        this.tool = tool;
    }

    /**
     * Définit la couleur de la peinture.
     *
     * @param pointColor La couleur de la peinture
     */
    public void setPointColor(java.awt.Color pointColor) {
        this.pointColor = pointColor;
    }

    /**
     * Définit la position en X de la peinture sur la toile.
     *
     * @param posX La position en X de la peinture sur la toile
     */
    public void setPosX(int posX) {
        this.posX = posX;
    }

    /**
     * Définit la position en Y de la peinture sur la toile.
     *
     * @param posY La position en Y de la peinture sur la toile
     */
    public void setPosY(int posY) {
        this.posY = posY;
    }

    /**
     * Définit la taille en X de la peinture.
     *
     * @param tailleX La taille en X de la peinture
     */
    public void setTailleX(int tailleX) {
        this.tailleX = tailleX;
    }

    /**
     * Définit la taille en Y de la peinture.
     *
     * @param tailleY La taille en Y de la peinture
     */
    public void setTailleY(int tailleY) {
        this.tailleY = tailleY;
    }

    /**
     * Renvoie la couleur de la peinture.
     *
     * @return La couleur de la peinture
     */
    public java.awt.Color getPointColor() {
        return this.pointColor;
    }

    /**
     * Renvoie la position en X de la peinture sur la toile.
     *
     * @return La position en X de la peinture sur la toile
     */
    public int getPosX() {
        return this.posX;
    }

    /**
     * Renvoie la position en Y de la peinture sur la toile.
     *
     * @return La position en Y de la peinture sur la toile
     */
    public int getPosY() {
        return this.posY;
    }

    /**
     * Renvoie la taille en X de la peinture.
     *
     * @return La taille en X de la peinture
     */
    public int getTailleX() {
        return this.tailleX;
    }

    /**
     * Renvoie la taille en Y de la peinture.
     *
     * @return La taille en Y de la peinture
     */
    public int getTailleY() {
        return this.tailleY;
    }
}
