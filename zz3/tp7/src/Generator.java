import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.HashSet;

public class Generator {

    private static final Faker faker = new Faker();

    private static final ArrayList<Etudiant> listEtudiant = new ArrayList<>();

    public static ArrayList<Etudiant> generateStudents(){
        for (int i = 1; i <= 150000; i++)
            listEtudiant.add(new Etudiant(i, faker.name().lastName(), faker.name().firstName()));
        return listEtudiant;
    }
}
