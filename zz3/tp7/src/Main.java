import java.util.ArrayList;

public class Main {
    public static Thread[] threads = new Thread[3];

    public static ArrayList<Etudiant> threadedStudents = new ArrayList<>();

    public static void main(String[] args) {
        long sequentialMean = 0;

        for (int i = 0; i < Constantes.ITERATIONS; i++)
            sequentialMean = sequentialTask();

        sequentialMean = sequentialMean / Constantes.ITERATIONS;
        System.out.println("Elapsed time in milliseconds: " + sequentialMean/1000000);

       long threadMean = 0;

        for (int i = 0; i < Constantes.ITERATIONS; i++)
            threadMean += threadedTask();

        threadMean /= Constantes.ITERATIONS;
        System.out.println("Elapsed time in milliseconds: " + threadMean/1000000);
    }

    public static long sequentialTask(){
        long lStartTime = System.nanoTime();

        ArrayList<Etudiant> list = Generator.generateStudents();

        long lEndTime = System.nanoTime();
        long elapsedTime = lEndTime - lStartTime;

        for (int i = 0; i < 150000; i++)
            System.out.println(list.get(i).toString());

        return elapsedTime;
    }

    public static long threadedTask(){
        long lStartTime = System.nanoTime();

        for (int i = 0; i < Constantes.NUMBER_OF_THREADS; i++){
            threads[i] = new Thread(new Generator());
            threads[i].start();
        }

        for (int i = 0; i < Constantes.NUMBER_OF_THREADS; i++){
            while (threads[i].isAlive()){}
        }

        for (int i = 0; i < Constantes.NUMBER_OF_THREADS; i++)
            threadedStudents.addAll(Generator.threads[i]);

        long lEndTime = System.nanoTime();
        long elapsedTime = lEndTime - lStartTime;

        for (int i = 0; i < 150000; i++)
            System.out.println(threadedStudents.get(i).toString());

        return elapsedTime;
    }


}
