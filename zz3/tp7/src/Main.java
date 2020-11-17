import java.util.ArrayList;

public class Main {
    public static long[] sequentialIterations = new long[Constantes.ITERATIONS];

    public static void main(String[] args) {
        long sequentialMean = 0;

        for (int i = 0; i < Constantes.ITERATIONS; i++)
            sequentialIterations[i] = sequentialTask();

        for (int i = 0; i < Constantes.ITERATIONS; i++) {
            sequentialMean += sequentialIterations[i];
        }
        sequentialMean = sequentialMean / Constantes.ITERATIONS;
        System.out.println("Elapsed time in milliseconds: " + sequentialMean/1000000);
    }

    public static long sequentialTask(){
        long lStartTime = System.nanoTime();

        ArrayList<Etudiant> list = Generator.generateStudents();

        for (int i = 0; i < 150000; i++)
            System.out.println(list.get(i).toString());

        long lEndTime = System.nanoTime();
        long elapsedTime = lEndTime - lStartTime;
        return elapsedTime;
    }


}
