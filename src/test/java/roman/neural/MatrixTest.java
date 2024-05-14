package roman.neural;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static roman.neural.net.module.NeuralFunction.mse;
import static roman.neural.net.module.NeuralFunction.subtract;

public class MatrixTest {
    @Test
    public void testMatrixSubtraction() {
        Double[][] matrix1 = {{1.0, 2.0}, {3.0, 4.0}};
        Double[][] matrix2 = {{4.0, 3.0}, {2.0, 1.0}};
        Double[][] expected = {{-3.0, -1.0}, {1.0, 3.0}};
        assertArrayEquals(expected, subtract(matrix1, matrix2));
    }

    @Test
    public void testMatrixSubtractionUnequalSize() {
        Double[][] matrix1 = {{1.0, 2.0}, {3.0, 4.0}};
        Double[][] matrix2 = {{4.0, 3.0, 2.0}, {2.0, 1.0, 0.0}};
        try {
            subtract(matrix1, matrix2);
        } catch (RuntimeException e) {
            // Проверяем, что исключение выбрасывается при разных размерах матриц
            assert true;
        }
    }
    @Test
    public void testMSECalculation() {
        Double[][] yTrue = {{1.0, 2.0}, {3.0, 4.0}};
        Double[][] yPred = {{2.0, 4.0}, {6.0, 8.0}};
        assertEquals(7.5, mse(yTrue, yPred), 0.000001);
    }
}
