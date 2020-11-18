import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.HashSet;

public class Generator implements Runnable{

    private static final Faker faker = new Faker();

    public static final ArrayList<Etudiant> listEtudiant = new ArrayList<>();

    public static final ArrayList[] threads =  new ArrayList[Constantes.NUMBER_OF_THREADS];

    public int currentInstance;

    public static int instances = 0;

    public Generator() {
        instances++;
        currentInstance = instances;
    }

    public static ArrayList<Etudiant> generateStudents(){
        for (int i = 1; i <= 150000; i++)
            listEtudiant.add(new Etudiant(faker.name().lastName(), faker.name().firstName()));
        return listEtudiant;
    }

    @Override
    public void run() {
        threads[currentInstance - 1] = new ArrayList<Etudiant>();
        for (int i = 1; i <= 50000; i++){
            threads[currentInstance - 1].add(new Etudiant( faker.name().lastName(), faker.name().firstName()));

        }
    }
}
