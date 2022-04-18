package ir.shayandaneshvar;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class Presenter implements Initializable {
    @FXML
    private ColorPicker color1;
    @FXML
    private ColorPicker color2;
    @FXML
    private ColorPicker color3;
    @FXML
    private ColorPicker color4;
    @FXML
    private Circle n22;
    @FXML
    private Circle n5;
    @FXML
    private Circle n2;
    @FXML
    private Circle n6;
    @FXML
    private Circle n3;
    @FXML
    private Circle n4;
    @FXML
    private Circle n1;
    @FXML
    private Circle n7;
    @FXML
    private Circle n9;
    @FXML
    private Circle n10;
    @FXML
    private Circle n11;
    @FXML
    private Circle n12;
    @FXML
    private Circle n14;
    @FXML
    private Circle n8;
    @FXML
    private Circle n18;
    @FXML
    private Circle n19;
    @FXML
    private Circle n15;
    @FXML
    private Circle n20;
    @FXML
    private Circle n21;
    @FXML
    private Circle n16;
    @FXML
    private Circle n17;
    @FXML
    private Circle n13;

    private Map<Integer, Circle> circleMap;
    private Integer[][] matrixGraph;
    private final Color[] colors = new Color[4];
    private Color[] verticesColor;

    @FXML
    void handleColoring() {
        verticesColor = new Color[matrixGraph.length];
        colors[0] = color1.getValue();
        colors[1] = color2.getValue();
        colors[2] = color3.getValue();
        colors[3] = color4.getValue();
        for (int c = 2; c <= 4; c++) {
            if (startColoring(0, c)) {
                updateMap();
                break;
            }
        }
    }

    private void updateMap() {
        for (int i = 0; i < verticesColor.length; i++) {
            circleMap.get(i + 1).setFill(verticesColor[i]);
        }
    }

    private boolean startColoring(int i, int numberOfColors) {
        if (i == verticesColor.length) {
            return true;
        }
        for (int c = 0; c < numberOfColors; c++) {
            if (promising(i, colors[c])) {
                verticesColor[i] = colors[c];
                if (startColoring(i + 1, numberOfColors)) {
                    return true;
                } else {
                    verticesColor[i] = null;
                }
            }
        }
        return false;
    }

    private boolean promising(int i, Color color) {
        for (int j = 0; j < verticesColor.length; j++) {
            if (matrixGraph[i][j] == 1 && color.equals(verticesColor[j])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        matrixGraph = new Integer[][]{
                {0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
        };
        circleMap = new HashMap<>();
        circleMap.put(1, n1);
        circleMap.put(2, n2);
        circleMap.put(3, n3);
        circleMap.put(4, n4);
        circleMap.put(5, n5);
        circleMap.put(6, n6);
        circleMap.put(7, n7);
        circleMap.put(8, n8);
        circleMap.put(9, n9);
        circleMap.put(10, n10);
        circleMap.put(11, n11);
        circleMap.put(12, n12);
        circleMap.put(13, n13);
        circleMap.put(14, n14);
        circleMap.put(15, n15);
        circleMap.put(16, n16);
        circleMap.put(17, n17);
        circleMap.put(18, n18);
        circleMap.put(19, n19);
        circleMap.put(20, n20);
        circleMap.put(21, n21);
        circleMap.put(22, n22);
    }
}