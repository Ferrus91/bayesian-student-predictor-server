package samkeays;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("")
public class PredictorEndpoint {
    BayesInterface bayesianNetwork;

    public PredictorEndpoint(BayesInterface bayesianNetwork) {
        this.bayesianNetwork = bayesianNetwork;
    }

    @Path("values")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Nodes nodeValues() {
        return bayesianNetwork.getListOfFeatureObjects();
    }

    @Path("query")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public QueryResult queryNetwork(QueryRequest queryRequest) {
        double[] result = bayesianNetwork.performQueryPercentage(queryRequest);
        return new QueryResult(result[0], result[1]);
    }
}
