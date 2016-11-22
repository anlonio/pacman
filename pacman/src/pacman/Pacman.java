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
public class Pacman extends MoveObject{
    private int pontuacao;
    private boolean power;
    private int direcao;
    
    public Pacman(int posicaoX, int posicaoY) {
        super(posicaoX, posicaoY);
        this.pontuacao = 0;
        this.power = false;
        this.direcao = 2;
    }

    public int getDirecao() {
        return direcao;
    }

    public void setDirecao(int direcao) {
        this.direcao = direcao;
    }
    
    public void andar(){
        this.mover(this.direcao);
    }
    
    @Override
    public void run() {
        while(true){
            andar();
        }
    }
    
    
}
