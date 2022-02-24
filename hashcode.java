import java.io.*;
import java.util.*;

class Pair<T, U> {

    private final T first;
    private final U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() { return first; }
    public U getSecond() { return second; }
}

public class hashcode{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int countContributors = Integer.parseInt(st.nextToken());
        int countProjects = Integer.parseInt(st.nextToken());
        ArrayList<Person> contributors = new ArrayList<>();
        for(int i=0; i<countContributors; i++){
            st = new StringTokenizer(br.readLine());
            Person obj = new Person();
            obj.name = st.nextToken();
            int countSkills = Integer.parseInt(st.nextToken());
            ArrayList<Skill> skills = new ArrayList<>();
            for(int j=0; j<countSkills; j++){
                st = new StringTokenizer(br.readLine());
                Skill obj2 = new Skill();
                obj2.skillName = st.nextToken();
                obj2.skillLevel = Integer.parseInt(st.nextToken());
                skills.add(obj2);
            }
            obj.skills = skills;
            contributors.add(obj);
        }
        ArrayList<Project> projects = new ArrayList<>();
        for(int i=0; i<countProjects; i++){
            st = new StringTokenizer(br.readLine());
            Project obj = new Project();
            obj.name = st.nextToken();
            obj.days = Integer.parseInt(st.nextToken());
            obj.score = Integer.parseInt(st.nextToken());
            obj.bestBefore = Integer.parseInt(st.nextToken());
            int roles = Integer.parseInt(st.nextToken());
            ArrayList<Skill> skills = new ArrayList<>();
            for(int j=0; j<roles; j++){
                st = new StringTokenizer(br.readLine());
                Skill obj2 = new Skill();
                obj2.skillName = st.nextToken();
                obj2.skillLevel = Integer.parseInt(st.nextToken());
                skills.add(obj2);
            }
            obj.skills = skills;
            projects.add(obj);
        }

        int currTime=0;

        List<Solution> ans=new ArrayList<>();

        Collections.sort(projects, new SortProjects());
        for(int i=0;i<projects.size(); i++){
            Solution curAns=new Solution();
            Project curP=projects.get(i);
            if(currTime+curP.days >= curP.bestBefore+ curP.score){
                continue;
            }
            List<Skill> skills=curP.skills;
            Collections.sort(skills, new SortSkills());
            Map<String, Pair<Integer,Integer> > ogSkills = new HashMap<>();
            for(int j=0; j<contributors.size(); j++){
                Person contributor = contributors.get(j);
                for(int k=0; k<contributor.skills.size(); k++){
                    Skill curS=contributor.skills.get(k);
                    Pair<Integer,Integer> pair=new Pair(curS.skillLevel, k);
                    if(contributor.unavailableTill < currTime)
                        ogSkills.put(curS.skillName, pair);
                }
            }
            curAns.ProjectName=curP.name;

            for(int j=0;j<skills.size(); j++){
                Skill curS=skills.get(j);
                if(ogSkills.containsKey(curS.skillName) && curS.skillLevel >= ogSkills.get(curS.skillName).getFirst()){
                    // select this person
                    Person contributor=contributors.get(ogSkills.get(curS.skillName).getSecond());
                    contributor.unavailableTill=currTime+curP.days;
                    curAns.Persons.add(contributor.name);
                }
            }

            ans.add(curAns);
        }

    }


}
