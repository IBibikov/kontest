import java.io.PrintWriter;
import java.util.Scanner;

public class Task2 {
    void solve (Scanner in, PrintWriter out ){
        int w = in.nextInt();
        int h=in.nextInt();
        long[] sumI = new long[h];
        long[] sumJ = new long[w];
        for (int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                long v =(long)(i+1)*(h-i)*(j+1)*(w-j);
                sumI[i]+=v;
                sumJ[j]+=v;
            }
        }
        for(long v :sumI) {
            out.print(v + " ");
        }
        out.println();
        for(long v :sumJ){
            out.print(v +" ");
        }
    }
    void run(){
        try (
                Scanner in = new Scanner(System.in);
                PrintWriter out= new PrintWriter(System.out)
        ){
            solve(in,out);
        }
    }

    public static void main(String[] args) {
        new Task2().run();
    }
}