/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciciocentroide;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.collections.transformation.FilteredList;

/**
 *
 * @author cryst
 */
public class ex1 {

    DataSource source;
    DataSource teste;
    Utils util = new Utils();
    int k;

    public void setBase() {
        System.out.println("===============Exercicio 1================");
        source = new DataSource();
        teste = new DataSource();

        Random r = new Random();
        int low = 0;
        int high = 250;

        source.addData(new Rgb(1, 10, 200));
        source.addData(new Rgb(2, 20, 230));
        source.addData(new Rgb(6, 25, 150));
        source.addData(new Rgb(7, 45, 100));
        source.addData(new Rgb(10, 50, 125));
        source.addData(new Rgb(3, 24, 111));
        source.addData(new Rgb(100, 4, 10));
        source.addData(new Rgb(250, 7, 50));
        source.addData(new Rgb(243, 5, 68));
        source.addData(new Rgb(210, 2, 90));
        source.addData(new Rgb(200, 1, 95));
        source.addData(new Rgb(215, 0, 68));
        source.addData(new Rgb(56, 200, 1));
        source.addData(new Rgb(79, 234, 3));
        source.addData(new Rgb(80, 210, 8));
        source.addData(new Rgb(95, 200, 10));
        source.addData(new Rgb(80, 210, 4));
        source.addData(new Rgb(49, 207, 1));

        teste.addData(new Rgb(r.nextInt(high - low) + low, r.nextInt(high - low) + low, r.nextInt(high - low) + low, "amarelo"));
        teste.addData(new Rgb(r.nextInt(high - low) + low, r.nextInt(high - low) + low, r.nextInt(high - low) + low, "vermelho"));
        teste.addData(new Rgb(r.nextInt(high - low) + low, r.nextInt(high - low) + low, r.nextInt(high - low) + low, "azul"));

    }

    public void k3() {
        setBase();
        k = 3;

        predict(source.getList(), teste.getList());

    }

    public void predict(List<Rgb> lista, List<Rgb> centroids) {
        double smaller;
        boolean mustAgain = false;
        
        List<Rgb> newCentroids = new ArrayList<Rgb>();
        for (Rgb rgbSource : lista) {
            smaller = 99999999;

            for (Rgb rgbCentroid : centroids) {
                if (util.getDistance(rgbCentroid, rgbSource) < smaller) {
                    rgbSource.setCor(rgbCentroid.getCor());
                    smaller = util.getDistance(rgbCentroid, rgbSource);
                }

            }

        }

        for (Rgb rgbCentroid : centroids) {
            System.out.println("Centralizer: \nR: " + rgbCentroid.getR() + " G: " + rgbCentroid.getG() + " B: " + rgbCentroid.getB() + " Cor: " + rgbCentroid.getCor() + "\n=======================");
            for (Rgb rgbSource : lista) {
                if (rgbSource.getCor().equals(rgbCentroid.getCor())) {
                    System.out.println("R: " + rgbSource.getR() + " G: " + rgbSource.getG() + " B: " + rgbSource.getB() + " Cor: " + rgbSource.getCor() + "\n");
                }
            }
        }

        for (Rgb rgbCentroid : centroids) {
            int count = 0;
            int sumR = 0;
            int sumG = 0;
            int sumB = 0;
            for (Rgb rgbSource : lista) {
                if (rgbSource.getCor().equals(rgbCentroid.getCor())) {
                    count++;
                    sumR += rgbSource.getR();
                    sumG += rgbSource.getG();
                    sumB += rgbSource.getB();
                }
            }
            sumR = sumR / count;
            sumG = sumG / count;
            sumB = sumB / count;
            Rgb newCentroid = new Rgb(sumR, sumG, sumB, rgbCentroid.getCor());
            newCentroids.add(newCentroid);
            System.out.println(rgbCentroid.getCor() + " andou: " + util.getDistance(rgbCentroid, newCentroid));

        }
        
        
        for(Rgb newCentroid : newCentroids){
            for(Rgb centroid: centroids){
                if(newCentroid.getCor().equals(centroid.getCor())){
                    if(util.getDistance(centroid, newCentroid)> 5){
                        mustAgain = true;
                    }
                }
            }
        }
        
        

        if (mustAgain) {
            predict(lista, newCentroids);
        }

    }
}
