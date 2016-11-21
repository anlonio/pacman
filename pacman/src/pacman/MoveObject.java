/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

/**
 *
 * @author Antonio
 */
public class MoveObject {
    private int posicaoX;
    private int posicaoY;
    
    public MoveObject(int posicaoX, int posicaoY){
        this.posicaoX = posicaoX;
        this.posicaoY = posicaoY;
    }

    public int getPosicaoX() {
        return posicaoX;
    }

    public int getPosicaoY() {
        return posicaoY;
    }
    
    public void mover(int direcao){
        switch(direcao){
            case 0:
                this.posicaoX++;
                break;
            case 1:
                this.posicaoY++;
                break;
            case 2:
                this.posicaoX--;
                break;
            case 3:
                this.posicaoY--;
                break;
            default:
                break;
        }
    }
}
