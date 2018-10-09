package samkeays;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class QueryResult implements Serializable {
    Double successProbability;

    Double failureProbability;

    public QueryResult(Double successProbability, Double failureProbability) {
        this.successProbability = successProbability;
        this.failureProbability = failureProbability;
    }

    public Double getSuccessProbability() {
        return successProbability;
    }

    public void setSuccessProbability(Double successProbability) {
        this.successProbability = successProbability;
    }

    public Double getFailureProbability() {
        return failureProbability;
    }

    public void setFailureProbability(Double failureProbability) {
        this.failureProbability = failureProbability;
    }

    @Override
    public String toString() {
        return "QueryResult{" +
                "successProbability=" + successProbability +
                ", failureProbability=" + failureProbability +
                '}';
    }
}
