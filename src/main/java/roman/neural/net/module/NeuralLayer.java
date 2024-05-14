package roman.neural.net.module;

abstract class NeuralLayer {
    private Double[][] input;
    private Double[][] output;
    private Double learningRate=0.01;
    abstract Double[][] forwardPropagation(Double[] input);
    abstract Double[][] backwardPropagation(Double[] outputError);
}
