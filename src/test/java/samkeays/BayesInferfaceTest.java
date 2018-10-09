package samkeays;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;


public class BayesianInterfaceTest
{

    @Test
    public void shouldProvideCorrectNodes()
    {
        BayesInterface bayesInterface = new BayesInterface();
        Nodes nodes = bayesInterface.getListOfFeatureObjects();
        assertEquals(nodes.getNodes().get(0).getName(), "success");
        assertEquals(nodes.getNodes().get(0).getOutcomes().get(0), "2");
        assertEquals(nodes.getNodes().get(0).getOutcomes().get(1), "4");

    }

    @Test
    public void shouldInferenceCorrectlyWithEmptyQuery()
    {
        BayesInterface bayesInterface = new BayesInterface();
        double[] percentages = bayesInterface.performQueryPercentage(new QueryRequest());
        assertEquals(percentages[0], 0.6688421788435935);
    }


    @Test
    public void shouldInferenceCorrectlyWithQueryThatHasFeature()
    {
        BayesInterface bayesInterface = new BayesInterface();
        QueryRequest queryRequest = new QueryRequest();
        queryRequest.setComputerSkill(">1.5<4.5");
        double[] percentages = bayesInterface.performQueryPercentage(queryRequest);
        assertEquals(percentages[0], 0.5964822699385757);
    }
}