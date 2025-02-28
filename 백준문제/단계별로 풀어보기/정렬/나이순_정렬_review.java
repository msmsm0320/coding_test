import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 나이순_정렬_review {
    public static class Person{
        int age;
        String name;

        public Person(int age, String name){
            this.age = age;
            this.name = name;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<Person> list = new ArrayList<>();

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            list.add(new Person(age, name));
        }
        Collections.sort(list,(p1,p2) ->{
            return p1.age - p2.age;
        });

        StringBuilder sb  = new StringBuilder();

        for(int j = 0; j<N; j++){
            sb.append(list.get(j).age +" "+ list.get(j).name).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
