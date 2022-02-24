import java.util.Comparator;

public class Skill {
    String skillName;
    int skillLevel;
}

class SortSkills implements Comparator<Skill>{
    @Override
    public int compare(Skill a, Skill b){
        return a.skillLevel - b.skillLevel;
    }
}
