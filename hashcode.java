import java.io.*;
import java.util.*;

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
    }
}
