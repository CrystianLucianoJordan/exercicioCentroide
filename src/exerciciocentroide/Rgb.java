/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciciocentroide;

/**
 *
 * @author cryst
 */
public class Rgb {
    private int r,g,b;
    private String cor;
private double distancia;    
    public Rgb(){
        
    }
    
     public Rgb(int r,int g,int b,String cor){
        this.r = r;
        this.g = g;
        this.b = b;
        this.cor = cor;
    }
     
       public Rgb(int r,int g,int b){
        this.r = r;
        this.g = g;
        this.b = b;
        
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
    
    
}
