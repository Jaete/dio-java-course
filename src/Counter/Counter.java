package Counter;
import java.util.Scanner;

public class Counter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Insert a value.");
        long min = scan.nextLong();
        System.out.println("Insert another value.");
        long sub = scan.nextLong();
        try {
            long start = System.nanoTime();
            int iterations = count(min, sub);
            long finish = System.nanoTime();
            float elapsed = (finish - start) / 1000000;
            System.out.println("The number of iterations looped is: " + iterations +"\n");
            System.out.printf("Elapsed time: %.1fms", elapsed);
        } catch (InvalidNumbersException e) {
            System.out.println("Exception occurred: " + e + "\nHappened because first value was minor than second value.\n");
            
        }finally{
            scan.close();
            System.exit(0);
        }
    }
    /**
     * @param min MINUEND. The number that will be subtracted by param_2.
     * @param sub SUBTRAHEND. The number that will subtract in the param_1.
     * @return COUNTER. This is the amount of iterations made in the for loop, equivalent of the difference between param_1 and param_2.
     * @throws InvalidNumbersException When subtrahend is greater than minuend. 
     */
    static int count(float min, float sub) throws InvalidNumbersException{
        if(min < sub){
            throw new InvalidNumbersException();
        }
        int counter = 0;
        for(int i = 0; i < min - sub; i++ ){
            counter++;
        }
        return counter;
    }
}
