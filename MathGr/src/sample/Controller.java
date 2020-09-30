package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private CheckBox sin;
     @FXML
    private CheckBox cos;
    @FXML
    private CheckBox tg;
    @FXML
    private CheckBox ctg;

    @FXML
    private Button sin0;
    @FXML
    private Button sin1;
    @FXML
    private Label sinN;

    @FXML
    private Button cos0;
    @FXML
    private Button cos1;
    @FXML
    private Label cosN;

    @FXML
    private Button tg0;
    @FXML
    private Button tg1;
    @FXML
    private Label tgN;

    @FXML
    private Button ctg0;
    @FXML
    private Button ctg1;
    @FXML
    private Label ctgN;

    @FXML
    private LineChart <Double, Double> lineGraph;

    private MyGraph mathsGraph;

    private double sinn = 5, cosn = 5, tgn = 5, ctgn = 5;
    private int selected = 0;

    @Override
    public void initialize(final URL url, final ResourceBundle rb) {
        mathsGraph = new MyGraph(lineGraph, 10.0);

        sinN.setText(Double.toString(sinn));
        cosN.setText(Double.toString(cosn));
        tgN.setText(Double.toString(tgn));
        ctgN.setText(Double.toString(ctgn));

    }

    private void plotLine(String fun, double n) {
        if (lineGraph.isVisible()) {
            mathsGraph.plotLine(fun, n);
        }
    }

    @FXML
    private void sin (javafx.event.ActionEvent event){
        if (!cos.isSelected() && !tg.isSelected() && !ctg.isSelected()){
        lineGraph.setVisible(true);
        if (sin.isSelected())
            plotLine("sin", sinn);
        else
            mathsGraph.clear("sin");
        }else sin.setSelected(false);
    }

    @FXML
    private void sin0(javafx.event.ActionEvent event){
        if (sin.isSelected() && sinn > 0){
            sinn--;
            mathsGraph.clear("sin");
            plotLine("sin", sinn);
            sinN.setText(Double.toString(sinn)); }
    }
    @FXML
    private void sin1(javafx.event.ActionEvent event){
        if (sin.isSelected()){
            sinn++;
            mathsGraph.clear("sin");
            plotLine("sin", sinn);
            sinN.setText(Double.toString(sinn));}
    }

    @FXML
    private void cos(javafx.event.ActionEvent event) {
        if (!sin.isSelected() && !tg.isSelected() && !ctg.isSelected()){
        lineGraph.setVisible(true);
        if (cos.isSelected())
            plotLine("cos", cosn);
        else
            mathsGraph.clear("cos");
        }
        else cos.setSelected(false);
    }

    @FXML
    private void cos0(javafx.event.ActionEvent event){
        if (cos.isSelected() && cosn > 0){
            cosn--;
            mathsGraph.clear("cos");
            plotLine("cos", cosn);
            cosN.setText(Double.toString(cosn)); }
    }
    @FXML
    private void cos1(javafx.event.ActionEvent event){
        if (cos.isSelected()){
            cosn++;
            mathsGraph.clear("cos");
            plotLine("cos", cosn);
            cosN.setText(Double.toString(cosn));}
    }

    @FXML
    private void tg(javafx.event.ActionEvent event) {
        if (!cos.isSelected() && !sin.isSelected() && !ctg.isSelected()){
        lineGraph.setVisible(true);
        if (tg.isSelected())
            plotLine("tg", tgn);
        else
            mathsGraph.clear("tg");
        } else tg.setSelected(false);
    }

    @FXML
    private void tg0(javafx.event.ActionEvent event){
        if (tg.isSelected() && tgn > 0){
            tgn--;
            mathsGraph.clear("tg");
            plotLine("tg", tgn);
            tgN.setText(Double.toString(tgn)); }
    }
    @FXML
    private void tg1(javafx.event.ActionEvent event){
        if (tg.isSelected()){
            tgn++;
            mathsGraph.clear("tg");
            plotLine("tg", tgn);
            tgN.setText(Double.toString(tgn));}
    }

    @FXML
    private void ctg(javafx.event.ActionEvent event) {
        if (!cos.isSelected() && !tg.isSelected() && !sin.isSelected()){
        lineGraph.setVisible(true);
        if (ctg.isSelected())
            plotLine("ctg", ctgn);
        else
            mathsGraph.clear("ctg");
            }else ctg.setSelected(false);
    }

    @FXML
    private void ctg0(javafx.event.ActionEvent event){
        if (ctg.isSelected() && ctgn > 0){
            ctgn--;
            mathsGraph.clear("ctg");
            plotLine( "ctg", ctgn);
            ctgN.setText(Double.toString(ctgn)); }
    }
    @FXML
    private void ctg1(javafx.event.ActionEvent event){
        if (ctg.isSelected()){
            ctgn++;
            mathsGraph.clear("ctg");
            plotLine("ctg", ctgn);
            ctgN.setText(Double.toString(ctgn));}
    }

}
