package samkeays;

import java.io.Serializable;
import java.util.List;

public class Node implements Serializable {

    public Node() {
    }


    public List<String> outcomes;

    public String name;

    public List<String> getOutcomes() {
        return outcomes;
    }

    public void setOutcomes(List<String> outcomes) {
        this.outcomes = outcomes;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "outcomes=" + outcomes +
                ", name='" + name + '\'' +
                '}';
    }
}
