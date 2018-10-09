package samkeays;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Nodes implements Serializable {
    public List<Node> nodes = new ArrayList<>();

    public Nodes() { }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    @Override
    public String toString() {
        return "Nodes{" +
                "nodes=" + nodes +
                '}';
    }

}
