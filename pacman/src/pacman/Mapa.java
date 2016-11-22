/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReferenceArray;

/**
 *
 * @author Antonio
 */
public class Mapa {
    private AtomicReferenceArray<AtomicIntegerArray> labirinto;
    private Pacman pacman;
    
    public Mapa(){
        AtomicIntegerArray[] x = new AtomicIntegerArray[20];

        for(int i =0; i< x.length;i++){
            x[i] = new AtomicIntegerArray(new int[20]);
        }
        this.labirinto = new AtomicReferenceArray<>(x);
        this.pacman = new Pacman(0, 0);
        this.push(0, 0, 1);
    }

    public void push(int x, int y, int value){
        this.labirinto.get(x).addAndGet(y, value);
    }
    
    public int get(int x, int y){
        return this.labirinto.get(x).get(y);
    }
    
    public void gerar(int[][] modelo){
        for(int i=0; i < modelo.length; i++){
            for(int j=0; j < modelo[0].length; j++){
                this.push(i, j, modelo[i][j]);
            }
        }
    }
    
    public int[] rastrear(MoveObject atual){
        int x = atual.getPosicaoX();
        int y = atual.getPosicaoY();
        int[] retorno = new int[4];
        retorno[0] = this.get(x+1, y);
        retorno[1] = this.get(x, y+1);
        retorno[2] = this.get(x-1, y);
        retorno[3] = this.get(x, y-1);
        return retorno;
    }
    
    public String imprimir(){
        String p;
        String retorno = "";
        for(int i=0;i<this.labirinto.length();i++){
            for(int j=0;j<this.labirinto.get(i).length(); j++){
                switch(this.labirinto.get(i).get(j)){
                    case 1:
                        p="c";
                        break;
                    case 2:
                        p="&";
                        break;
                    case 3:
                        p="#";
                        break;
                    case 4:
                        p=".";
                        break;
                    case 5:
                        p="o";
                        break;
                    default:
                        p=" ";
                }
                retorno += p;
            }
            retorno += "\n";
        }
        return retorno;
    }
}
