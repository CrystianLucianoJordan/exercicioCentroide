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
public class Utils {

    public Double getDistance(Rgb o1, Rgb o2) {
        return Math.sqrt(Math.pow((o2.getR() - o1.getR()), 2) + Math.pow((o2.getG() - o1.getG()), 2) + Math.pow((o2.getG() - o1.getG()), 2));
    }
}
