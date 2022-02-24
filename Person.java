import java.util.Comparator;
import java.util.List;

public class Person{
    String name;
    List<Skill> skills;
    int unavailableTill = 0;
}

class ComparePerson implements Comparator<Person>{
    @Override
    public int compare(Person a, Person b){
        //placeholder
        return a.skills.size() - b.skills.size();
    }
}
