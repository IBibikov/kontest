import java.io.PrintWriter;
import java.util.Scanner;


public class Task4{
    static class Queue{
        int [] q;
        int first=0;
        int after=0;
        Queue(int size){
            q=new int[size];
        }
        void add(int v){
            q[after]=v;
            after++;
        }
        int poll(){
            int v = q[first];
            first++;
            return v;
        }
        boolean isEmpty(){
            return first==after;
        }
    }
    void solve (Scanner in, PrintWriter out ){
        int n = in.nextInt();
        int m = in.nextInt();
        int sn= in.nextInt();
        int sm= in.nextInt();
        int fn= in.nextInt();
        int fm= in.nextInt();
        boolean[][] free= new boolean[n][m];
        in.nextLine();
        for(int i=0;i<n;i++){
            String s = in.nextLine();
            for(int j=0;j<m;j++){
                free[i][j]=s.charAt(j*2)=='0';
            }
        }
        if (!free[sn][sm] || !free[fn][fm] || sn==fn && sm==fm){
            throw new AssertionError();
        }
        char[][] from = new char[n][m];
        Queue queue = new Queue(n*m*2);
        queue.add(fn);
        queue.add(fm);
        free[fn][fm] = false;
        while(!queue.isEmpty()){
            int i= queue.poll();
            int j =queue.poll();
            int li=i;
            int lj= (j-1+m)%m;
            if(free[li][lj]){
                free[li][lj]=false;
                from[li][lj]='E';
                queue.add(li);
                queue.add(lj);
            }
            int ri=i;
            int rj= (j+1)%m;
            if(free[ri][rj]){
                free[ri][rj]=false;
                from[ri][rj]='W';
                queue.add(ri);
                queue.add(rj);
            }
            int ui=(i-1+n)%n;
            int uj=j;
            if(free[ui][uj]){
                free[ui][uj]=false;
                from[ui][uj]='S';
                queue.add(ui);
                queue.add(uj);
            }
            int di=(i+1)%n;
            int dj= j;
            if(free[di][dj]){
                free[di][dj]=false;
                from[di][dj]='N';
                queue.add(di);
                queue.add(dj);
            }
        }
        if(free[sn][sm]){
            out.println(-1);
            return;
        }
        while(!(sn==fn && sm == fm)){
            out.print(from[sn][sm]);
            if (from[sn][sm]=='E'){
                sm= (sm+1)%m;
            }else if (from[sn][sm]=='W'){
                sm=(sm-1+m)%m;
            } else if (from[sn][sm]=='N'){
                sn=(sn-1+n)%n;
            }
            else if (from[sn][sm]=='S') {
                sn = (sn + 1) % n;
            }
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
        new Task4().run();
    }
}