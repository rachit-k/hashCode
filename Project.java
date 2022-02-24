import java.util.Comparator;
import java.util.List;

public class Project {
    String name;
    int score;
    int days;
    int bestBefore;
    List<Skill> skills;
}

class SortProjects implements Comparator<Project>{
    @Override
    public int compare (Project a, Project b){
        int aSkillSum = 0;
        for(int i = 0; i< a.skills.size(); i++){
            aSkillSum =  aSkillSum + a.skills.get(i).skillLevel;
        }

        int bSkillSum = 0;
        for(int i = 0; i< b.skills.size(); i++){
            bSkillSum =  bSkillSum + b.skills.get(i).skillLevel;
        }

        double aScore = (Math.pow(a.score,2))/(a.days * aSkillSum);
        double bScore = (Math.pow(b.score,2))/(b.days * bSkillSum);
        return  (int)bScore - (int)aScore;
    }
}