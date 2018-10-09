package samkeays;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class QueryRequest implements Serializable {
    public QueryRequest() {
    }

    @JsonProperty("MatSciEng_d")
    String coreSubjectsTaken;

    @JsonProperty("CompSkill_d")
    String computerSkill;

    @JsonProperty("SecEduMark_d")
    String secondarySchoolMark;

    @JsonProperty("PriEduMark_d")
    String primarySchoolMark;

    @JsonProperty("module1_Group_d")
    String moduleGroup1Score;

    @JsonProperty("module2_Group_d")
    String moduleGroup2Score;

    @JsonProperty("module3_Group_d")
    String moduleGroup3Score;

    @JsonProperty("module4_Group_d")
    String moduleGroup4Score;

    @JsonProperty("module5_Group_d")
    String moduleGroup5Score;

    public String getCoreSubjectsTaken() {
        return coreSubjectsTaken;
    }

    public void setCoreSubjectsTaken(String coreSubjectsTaken) {
        this.coreSubjectsTaken = coreSubjectsTaken;
    }

    public String getComputerSkill() {
        return computerSkill;
    }

    public void setComputerSkill(String computerSkill) {
        this.computerSkill = computerSkill;
    }

    public String getSecondarySchoolMark() {
        return secondarySchoolMark;
    }

    public void setSecondarySchoolMark(String secondarySchoolMark) {
        this.secondarySchoolMark = secondarySchoolMark;
    }

    public String getPrimarySchoolMark() {
        return primarySchoolMark;
    }

    public void setPrimarySchoolMark(String primarySchoolMark) {
        this.primarySchoolMark = primarySchoolMark;
    }

    public String getModuleGroup1Score() {
        return moduleGroup1Score;
    }

    public void setModuleGroup1Score(String moduleGroup1Score) {
        this.moduleGroup1Score = moduleGroup1Score;
    }

    public String getModuleGroup2Score() {
        return moduleGroup2Score;
    }

    public void setModuleGroup2Score(String moduleGroup2Score) {
        this.moduleGroup2Score = moduleGroup2Score;
    }

    public String getModuleGroup3Score() {
        return moduleGroup3Score;
    }

    public void setModuleGroup3Score(String moduleGroup3Score) {
        this.moduleGroup3Score = moduleGroup3Score;
    }

    public String getModuleGroup4Score() {
        return moduleGroup4Score;
    }

    public void setModuleGroup4Score(String moduleGroup4Score) {
        this.moduleGroup4Score = moduleGroup4Score;
    }

    public String getModuleGroup5Score() {
        return moduleGroup5Score;
    }

    public void setModuleGroup5Score(String moduleGroup5Score) {
        this.moduleGroup5Score = moduleGroup5Score;
    }

    @Override
    public String toString() {
        return "QueryRequest{" +
                "coreSubjectsTaken='" + coreSubjectsTaken + '\'' +
                ", computerSkill='" + computerSkill + '\'' +
                ", secondarySchoolMark='" + secondarySchoolMark + '\'' +
                ", primarySchoolMark='" + primarySchoolMark + '\'' +
                ", moduleGroup1Score='" + moduleGroup1Score + '\'' +
                ", moduleGroup2Score='" + moduleGroup2Score + '\'' +
                ", moduleGroup3Score='" + moduleGroup3Score + '\'' +
                ", moduleGroup4Score='" + moduleGroup4Score + '\'' +
                ", moduleGroup5Score='" + moduleGroup5Score + '\'' +
                '}';
    }
}

