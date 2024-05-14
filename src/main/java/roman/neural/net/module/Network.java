package roman.neural.net.module;

import java.util.ArrayList;
import java.util.List;

public class Network {
    private List<NeuralLayer> layers;
    private String lossFunction="";

    public Network() {
        layers = new ArrayList<>();

    }
}
