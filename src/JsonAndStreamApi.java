import com.google.gson.Gson;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class JsonAndStreamApi {
    public static void main(String[] args) throws IOException {
        Student student = new Student("Salimov Qudratilla",19);
        Student student1 = new Student("Yusufbek Murodov",20);
        Student student2 = new Student("Ilyosbek Mamashukurov",21);
        Student student3 = new Student("Tursunali Tojaliyev",22);
        Student student4 = new Student("Xusniddin Muxiddinov",23);
        List<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        Gson gson = new Gson();
        String json = gson.toJson(students);
        System.out.println(json);
        Files.writeString(Path.of("JsonText"),json);

        String jsonText = Files.readString(Path.of("JsonText"));
        Type type = TypeToken.getParameterized(List.class, Student.class).getType();
        List<Student> studentlar = gson.fromJson(jsonText, type);
        Stream<Student> stream = studentlar.stream();
        Optional<Integer> reduce = stream.map(Student::getAge).reduce(Integer::sum);
        Integer i = reduce.get();
        Double averageOfAges = (double) (i/studentlar.size());
        System.out.println(averageOfAges);
    }
}
