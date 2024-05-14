package roman.neural.net.module;

import org.apache.commons.math3.util.FastMath;

import java.util.ArrayList;

public class NeuralFunction {

    public static Double mse(Double[][] yTrue,
                             Double[][] yPred) {

        double sum = 0;
        for (int i = 0; i < yTrue.length; i++) {
            for (int j = 0; j < yTrue[i].length; j++) {
                sum += Math.pow(yTrue[i][j] - yPred[i][j], 2);
            }

        }
        return sum / countElements(yTrue);
    }
    public static Double tanh(Double x) {
        return FastMath.tanh(x);
    }
    public static Double tanhDerivative(Double x) {
        return 1-Math.pow(FastMath.tanh(x),2);
    }


    public static double[] mseDerivative(Double[] yTrue, Double[] yPred) {
        ArrayList<Double> mseResult=new ArrayList<Double>();
        for (int i = 0; i < yTrue.length; i++) {
                mseResult.add((yPred[i]-yTrue[i])*2/yTrue.length);
        }
        return mseResult.stream().mapToDouble(i -> i).toArray();
    }

    public static int countElements(Double[][] matrix) {
        int count = 0;
        for (Double[] row : matrix) {
            count += row.length;
        }
        return count;
    }

    public static Double[][] subtract(Double[][] matrix1, Double[][] matrix2) {
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            throw new RuntimeException("Матрицы должны иметь одинаковый размер для вычитания.");
        }

        int m = matrix1.length;
        int n = matrix1[0].length;
        Double[][] result = new Double[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }

        return result;
    }

}


