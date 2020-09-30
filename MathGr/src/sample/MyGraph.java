package sample;

import javafx.scene.chart.XYChart;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MyGraph {

    private XYChart<Double, Double> graph;
    private double range;

    public MyGraph(final XYChart<Double, Double> graph, final double range) {
        this.graph = graph;
        this.range = range;
    }

    int[] sinind = new int[2];
    int[] cosind = new int[2];
    int[] tgind = new int[2];
    int[] ctgind = new int[2];
    double q = Math.pow(10, -2);

    public void plotLine(String fun, double n) {
        switch (fun) {
            case "sin":
                XYChart.Series<Double, Double> sinser = new XYChart.Series<Double, Double>();
                XYChart.Series<Double, Double> sinser1 = new XYChart.Series<Double, Double>();
                for (double x = -range; x <= range; x = x + 0.05){
                    plotPoint(x, sinx(x, n), sinser);
                    plotPoint(x, Math.sin(x) + 0.1, sinser1);
                }
                graph.getData().add(sinser1);
                graph.getData().add(sinser);
                sinser.getNode().setStyle("-fx-stroke: #9B4DFF;");
                sinser1.getNode().setStyle("-fx-stroke: #D4A1FF; -fx-stroke-width: 5px;");
                sinind[0] = graph.getData().indexOf(sinser);
                sinind[1] = graph.getData().indexOf(sinser1);
                break;

            case "cos":
                XYChart.Series<Double, Double> cosser = new XYChart.Series<Double, Double>();
                XYChart.Series<Double, Double> cosser1 = new XYChart.Series<Double, Double>();
                for (double x = -range; x <= range; x = x + 0.1){
                    plotPoint(x, cosx(x, n), cosser);
                    plotPoint(x, Math.cos(x) + 0.1, cosser1);
                }
                graph.getData().add(cosser1);
                graph.getData().add(cosser);
                cosser.getNode().setStyle("-fx-stroke: #E8523A;");
                cosser1.getNode().setStyle("-fx-stroke: #F5917B; -fx-stroke-width: 5px;");
                cosind[0] = graph.getData().indexOf(cosser);
                cosind[1] = graph.getData().indexOf(cosser1);
                break;


            case "tg":
                XYChart.Series<Double, Double> tgser = new XYChart.Series<Double, Double>();
                XYChart.Series<Double, Double> tgser1 = new XYChart.Series<Double, Double>();
                if (n == 0){
                   for (double x= -100; x <= 100 ;x = x + 0.05)
                        plotPoint(x, 0, tgser);
                   for (double x = -Math.PI/2.0 + q; x <= Math.PI/2.0 - q; x = x + 0.05)
                        plotPoint(x, Math.tan(x) + 0.1, tgser1);
                }
                else if (n == 1){
                    for (double x= -100; x <= 100 ; x = x + 0.05)
                        plotPoint(x, sinx(x, 0)/cosx(x, 0), tgser);
                    for (double x = -Math.PI/2.0 + q; x <= Math.PI/2.0 - q; x = x + 0.05)
                        plotPoint(x, Math.tan(x) + 0.1, tgser1);
                }
                else if (n == 2){
                    for (double x= -100; x <= 100 ; x = x + 0.05)
                        plotPoint(x, sinx(x, 0)/cosx(x, 0), tgser);
                    for (double x = -Math.PI/2.0 + q; x <= Math.PI/2.0 - q; x = x + 0.05)
                        plotPoint(x, Math.tan(x) + 0.1, tgser1);
                }
                else if (n == 3){
                    for (double x= -100; x <= 100 ; x = x + 0.05)
                        plotPoint(x, x+(2*(Math.pow(x,3)/fact(3))), tgser);
                    for (double x = -Math.PI/2.0 + q; x <= Math.PI/2.0 - q; x = x + 0.05)
                        plotPoint(x, Math.tan(x) + 0.1, tgser1);
                }
                else if (n == 4){
                    for (double x= -100; x <= 100 ; x = x + 0.05)
                        plotPoint(x, x+(2*(Math.pow(x,3)/fact(3))), tgser);
                    for (double x = -Math.PI/2.0 + q; x <= Math.PI/2.0 - q; x = x + 0.05)
                        plotPoint(x, Math.tan(x) + 0.1, tgser1);
                }
                else if (n == 5){
                    for (double x= -100; x <= 100 ; x = x + 0.05)
                        plotPoint(x, (x+(2*(Math.pow(x,3)/fact(3)))+(16*(Math.pow(x,5)/fact(5)))), tgser);
                    for (double x = -Math.PI/2.0 + q; x <= Math.PI/2.0 - q; x = x + 0.05)
                        plotPoint(x, Math.tan(x) + 0.1, tgser1);
                }
                else if (n == 6){
                    for (double x= -100; x <= 100 ; x = x + 0.05)
                        plotPoint(x, (x+(2*(Math.pow(x,3)/fact(3)))+(16*(Math.pow(x,5)/fact(5)))), tgser);
                    for (double x = -Math.PI/2.0 + q; x <= Math.PI/2.0 - q; x = x + 0.05)
                        plotPoint(x, Math.tan(x) + 0.1, tgser1);
                }
                else if (n == 7){
                    for (double x= -100; x <= 100 ; x = x + 0.05)
                        plotPoint(x, (x+(2*(Math.pow(x,3)/fact(3)))+(16*(Math.pow(x,5)/fact(5)))+(272*(Math.pow(x,7)/fact(7)))), tgser);
                    for (double x = -Math.PI/2.0 + q; x <= Math.PI/2.0 - q; x = x + 0.05)
                        plotPoint(x, Math.tan(x) + 0.1, tgser1);
                }
                else if (n == 8){
                    for (double x= -100; x <= 100 ; x = x + 0.05)
                        plotPoint(x, (x+(2*(Math.pow(x,3)/fact(3)))+(16*(Math.pow(x,5)/fact(5)))+(272*(Math.pow(x,7)/fact(7)))), tgser);
                    for (double x = -Math.PI/2.0 + q; x <= Math.PI/2.0 - q; x = x + 0.05)
                        plotPoint(x, Math.tan(x) + 0.1, tgser1);
                }
                else if (n == 9){
                    for (double x= -100; x <= 100 ; x = x + 0.05)
                        plotPoint(x, (x+(2*(Math.pow(x,3)/fact(3)))+(16*(Math.pow(x,5)/fact(5)))+(272*(Math.pow(x,7)/fact(7)))+(7936*(Math.pow(x,9)/fact(9)))), tgser);
                    for (double x = -Math.PI/2.0 + q; x <= Math.PI/2.0 - q; x = x + 0.05)
                        plotPoint(x, Math.tan(x) + 0.1, tgser1);
                }
                else if (n == 10){
                    for (double x= -100; x <= 100 ; x = x + 0.05)
                        plotPoint(x, (x+(2*(Math.pow(x,3)/fact(3)))+(16*(Math.pow(x,5)/fact(5)))+(272*(Math.pow(x,7)/fact(7)))+(7936*(Math.pow(x,9)/fact(9)))), tgser);
                    for (double x = -Math.PI/2.0 + q; x <= Math.PI/2.0 - q; x = x + 0.05)
                        plotPoint(x, Math.tan(x) + 0.1, tgser1);
                }
                else
                    for (double x = -Math.PI/2.0 + q; x <= Math.PI/2.0 - q; x = x + 0.05){
                        plotPoint(x, sinx(x, n)/cosx(x, n), tgser);
                        plotPoint(x, Math.tan(x) + 0.1, tgser1);
                    }
                graph.getData().add(tgser1);
                graph.getData().add(tgser);
                tgser.getNode().setStyle("-fx-stroke: #4682B4;");
                tgser1.getNode().setStyle("-fx-stroke: #B3DEFF; -fx-stroke-width: 5px;");
                tgind[0] = graph.getData().indexOf(tgser);
                tgind[1] = graph.getData().indexOf(tgser1);
                break;

            case "ctg":
                XYChart.Series<Double, Double> ctgser = new XYChart.Series<Double, Double>();
                XYChart.Series<Double, Double> ctgser1 = new XYChart.Series<Double, Double>();
                if (n == 0){
                    for (double x= -100; x <= 100 ; x = x + 0.05){
                        plotPoint(x, 0.64, ctgser);
                    }
                    for (double x = 0 + q; x < Math.PI - q; x = x + 0.05){
                        plotPoint(x, 1.0/Math.tan(x) + 0.1, ctgser1);
                    }}
                else if (n == 1){
                    for (double x= -100; x <= 100 ; x = x + 0.05){
                        plotPoint(x, 0.64-1.41*(x-1), ctgser);
                    }
                    for (double x = 0 + q; x < Math.PI - q; x = x + 0.05){
                        plotPoint(x, 1.0/Math.tan(x) + 0.1, ctgser1);
                    }}
                else if (n == 2){
                    for (double x= -100; x <= 100 ; x = x + 0.05){
                        plotPoint(x, 0.64-1.41*(x-1)+(1.81*((Math.pow((x-1),2))/fact(2))), ctgser);
                    }
                    for (double x = 0 + q; x < Math.PI - q; x = x + 0.05){
                        plotPoint(x, 1.0/Math.tan(x) + 0.1, ctgser1);
                    }}
                else if (n == 3) {
                    for (double x= -100; x <= 100 ; x = x + 0.05){
                        plotPoint(x, 0.64-1.41*(x-1)+(1.81*((Math.pow((x-1),2))/fact(2)))
                                -(6.32*((Math.pow((x-1),3))/fact(3))), ctgser);
                    }
                    for (double x = 0 + q; x < Math.PI - q; x = x + 0.05){
                        plotPoint(x, 1.0/Math.tan(x) + 0.1, ctgser1);
                    }}
                else if (n == 4) {
                    for (double x= -100; x <= 100 ; x = x + 0.05){
                        plotPoint(x, 0.64-1.41*(x-1)+(1.81*((Math.pow((x-1),2))/fact(2)))
                                -(6.32*((Math.pow((x-1),3))/fact(3)))
                                +(23.48*((Math.pow((x-1),4))/fact(4))), ctgser);
                    }
                    for (double x = 0 + q; x < Math.PI - q; x = x + 0.05){
                        plotPoint(x, 1.0/Math.tan(x) + 0.1, ctgser1);
                    }}
                else if (n == 5) {
                    for (double x= -100; x <= 100 ; x = x + 0.05){
                        plotPoint(x, 0.64-1.41*(x-1)+(1.81*((Math.pow((x-1),2))/fact(2)))
                                -(6.32*((Math.pow((x-1),3))/fact(3)))
                                +(23.48*((Math.pow((x-1),4))/fact(4)))
                                -(121.27*((Math.pow((x-1),5))/fact(5))), ctgser);
                    }
                    for (double x = 0 + q; x < Math.PI - q; x = x + 0.05){
                        plotPoint(x, 1.0/Math.tan(x) + 0.1, ctgser1);
                    }}
                else if (n == 6) {
                    for (double x= -100; x <= 100 ; x = x + 0.05){
                        plotPoint(x, 0.64-1.41*(x-1)+(1.81*((Math.pow((x-1),2))/fact(2)))
                                -(6.32*((Math.pow((x-1),3))/fact(3)))
                                +(23.48*((Math.pow((x-1),4))/fact(4)))
                                -(121.27*((Math.pow((x-1),5))/fact(5)))
                                +(716.54*((Math.pow((x-1),6))/fact(6))), ctgser);
                    }
                    for (double x = 0 + q; x < Math.PI - q; x = x + 0.05){
                        plotPoint(x, 1.0/Math.tan(x) + 0.1, ctgser1);
                    }}
                else if (n == 7) {
                    for (double x= -100; x <= 100 ; x = x + 0.05){
                        plotPoint(x, 0.64-1.41*(x-1)+(1.81*((Math.pow((x-1),2))/fact(2)))
                                -(6.32*((Math.pow((x-1),3))/fact(3)))
                                +(23.48*((Math.pow((x-1),4))/fact(4)))
                                -(121.27*((Math.pow((x-1),5))/fact(5)))
                                +(716.54*((Math.pow((x-1),6))/fact(6)))
                                -(5051.46*((Math.pow((x-1),7))/fact(7))), ctgser);
                    }
                    for (double x = 0 + q; x < Math.PI - q; x = x + 0.05){
                        plotPoint(x, 1.0/Math.tan(x) + 0.1, ctgser1);
                    }}
                else if (n == 8) {
                    for (double x= -100; x <= 100 ; x = x + 0.05){
                        plotPoint(x, 0.64-1.41*(x-1)+(1.81*((Math.pow((x-1),2))/fact(2)))
                                -(6.32*((Math.pow((x-1),3))/fact(3)))
                                +(23.48*((Math.pow((x-1),4))/fact(4)))
                                -(121.27*((Math.pow((x-1),5))/fact(5)))
                                +(716.54*((Math.pow((x-1),6))/fact(6)))
                                -(5051.46*((Math.pow((x-1),7))/fact(7)))
                                +(.46*((Math.pow((x-1),8))/fact(8))), ctgser);
                    }
                    for (double x = 0 + q; x < Math.PI - q; x = x + 0.05){
                        plotPoint(x, 1.0/Math.tan(x) + 0.1, ctgser1);
                    }}
                /*else if (n == 9) {
                    for (double x = 0; x < Math.PI - 0.1; x = x + 0.05){
                        plotPoint(x, 0.64-1.41*(x-1)+(1.81*((Math.pow((x-1),2))/fact(2)))
                                -(6.32*((Math.pow((x-1),3))/fact(3)))
                                +(23.48*((Math.pow((x-1),4))/fact(4)))
                                -(121.27*((Math.pow((x-1),5))/fact(5)))
                                +(716.54*((Math.pow((x-1),6))/fact(6)))
                                -(5051.46*((Math.pow((x-1),7))/fact(7)))
                                +(5051.46*((Math.pow((x-1),8))/fact(8)))
                                -(20000.46*((Math.pow((x-1),9))/fact(9))), ctgser);
                    }
                    for (double x = 0 + q; x < Math.PI - q; x = x + 0.05){
                        plotPoint(x, 1.0/Math.tan(x) + 0.1, ctgser1);
                    }}
                else if (n == 10) {
                    for (double x = 0; x < Math.PI - 0.1; x = x + 0.05){
                        plotPoint(x, 0.64-1.41*(x-1)+(1.81*((Math.pow((x-1),2))/fact(2)))
                                -(6.32*((Math.pow((x-1),3))/fact(3)))
                                +(23.48*((Math.pow((x-1),4))/fact(4)))
                                -(121.27*((Math.pow((x-1),5))/fact(5))), ctgser);
                    }
                    for (double x = 0 + q; x < Math.PI - q; x = x + 0.05){
                        plotPoint(x, 1.0/Math.tan(x) + 0.1, ctgser1);
                    }}*/
               /* else
                    for (double x = 0 + q; x < Math.PI - q; x = x + 0.05){
                        plotPoint(x, 1.0/(sinx(x, n)/cosx(x, n)), ctgser);
                        plotPoint(x, 1.0/Math.tan(x) + 0.1, ctgser1);
                    }*/
                graph.getData().add(ctgser1);
                graph.getData().add(ctgser);
                ctgser.getNode().setStyle("-fx-stroke: #006400;");
                ctgser1.getNode().setStyle("-fx-stroke: #84FF30; -fx-stroke-width: 5px;");
                tgind[0] = graph.getData().indexOf(ctgser);
                tgind[1] = graph.getData().indexOf(ctgser1);
        }
    }

    private double sinx(double x, double n){
        double y = 0;
        for (int i = 0; i <= n; i++){
            y += Math.pow(-1, i)*((Math.pow(x, 2*i + 1))/(fact(2*i + 1)));
        }
        return y;
    }

    private double cosx(double x, double n){
        double y = 0;
        for (int i = 0; i <= n; i++){
            y +=  Math.pow(-1, i)*((Math.pow(x, 2*i))/(fact(2*i)));
        }
        return y;
    }

  /*  private double tgx(double x, double n){
        double y = 0;
        for (int i = 0; i <= n; i++){
            y +=  ;
        }
        return y;
    }*/


    private double fact(double n){
        if (n <= 1) return 1;
        else return n * fact(n - 1);
    }


    private void plotPoint(final double x, final double y, XYChart.Series<Double, Double> series) {
        series.getData().add(new XYChart.Data<Double, Double>(x, y));
    }


    public void clear(String fun) {
        switch (fun){
            case "sin":
                graph.getData().remove(sinind[0]);
                graph.getData().remove(sinind[1]);
                break;
            case "cos":
                graph.getData().remove(cosind[0]);
                graph.getData().remove(cosind[1]);
                break;
            case "tg":
                graph.getData().remove(tgind[0]);
                graph.getData().remove(tgind[1]);
                break;
            case "ctg":
                graph.getData().remove(ctgind[0]);
                graph.getData().remove(ctgind[1]);
                break;
        }
    }
}