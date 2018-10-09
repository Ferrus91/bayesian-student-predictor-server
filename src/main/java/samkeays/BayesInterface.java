package samkeays;

import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.eclipse.recommenders.jayes.BayesNet;
import org.eclipse.recommenders.jayes.BayesNode;
import org.eclipse.recommenders.jayes.inference.IBayesInferer;
import org.eclipse.recommenders.jayes.inference.junctionTree.JunctionTreeAlgorithm;
import org.eclipse.recommenders.jayes.io.XMLBIFReader;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;

public class BayesInterface {
    BayesNet bayesNet;


    public BayesInterface () {
        XMLBIFReader xmlBIFReader = new XMLBIFReader();
        try {
            bayesNet = xmlBIFReader.read(getClass().getClassLoader().getResourceAsStream(("studentpredictormodel.xml")));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Nodes getListOfFeatureObjects() {
        List<String> nodeNames = new ArrayList<>();
        Nodes nodes = new Nodes();
        for (BayesNode bayesNode : bayesNet.getNodes()) {
            Node node = new Node();
            node.setName(bayesNode.getName());
            node.setOutcomes(bayesNode.getOutcomes());
            nodes.getNodes().add(node);
        }
        return nodes;
    }

    public double[] performQueryPercentage(QueryRequest query) {
        IBayesInferer inferer = new JunctionTreeAlgorithm();
        inferer.setNetwork(bayesNet);
        Map<BayesNode,String> evidence = new HashMap<BayesNode,String>();

        if (query.getCoreSubjectsTaken() != null) {
            BayesNode getCoreSubjectsTakenNode = bayesNet.getNode("MatSciEng_d");
            evidence.put(getCoreSubjectsTakenNode, query.getCoreSubjectsTaken());
        }

        if (query.getComputerSkill() != null) {
            BayesNode computerSkillNode = bayesNet.getNode("CompSkill_d");
            evidence.put(computerSkillNode, query.getComputerSkill());
        }

        if (query.getSecondarySchoolMark() != null) {
            BayesNode secondarySchoollNode = bayesNet.getNode("SecEduMark_d");
            evidence.put(secondarySchoollNode, query.getSecondarySchoolMark());
        }

        if (query.getPrimarySchoolMark() != null) {
            BayesNode primarySchoolNode = bayesNet.getNode("PriEduMark_d");
            evidence.put(primarySchoolNode, query.getPrimarySchoolMark());
        }

        if (query.getModuleGroup1Score() != null) {
            BayesNode moduleGroup1Node = bayesNet.getNode("module1_Group_d");
            evidence.put(moduleGroup1Node, query.getModuleGroup1Score());
        }

        if (query.getModuleGroup2Score() != null) {
            BayesNode moduleGroup2Node = bayesNet.getNode("module2_Group_d");
            evidence.put(moduleGroup2Node, query.getModuleGroup2Score());
        }

        if (query.getModuleGroup3Score() != null) {
            BayesNode moduleGroup3Node = bayesNet.getNode("module3_Group_d");
            evidence.put(moduleGroup3Node, query.getModuleGroup3Score());
        }

        if (query.getModuleGroup4Score() != null) {
            BayesNode moduleGroup4Node = bayesNet.getNode("module4_Group_d");
            evidence.put(moduleGroup4Node, query.getModuleGroup4Score());
        }

        if (query.getModuleGroup5Score() != null) {
            BayesNode moduleGroup5Node = bayesNet.getNode("module5_Group_d");
            evidence.put(moduleGroup5Node, query.getModuleGroup5Score());
        }

        inferer.setEvidence(evidence);

        BayesNode successNode = bayesNet.getNode("success");
        return inferer.getBeliefs(successNode);
    }
}
