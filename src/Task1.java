import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Task1 {
    static class Item{
        String s;
        int num;
        Item(String s,int num){
            this.s=s;
            this.num=num;
        }
    }
    void solve (Scanner in, PrintWriter out ){
        ArrayList<Item> arr= new ArrayList<>();
        while (in.hasNextLine()){
            String s = in.nextLine();
            int num=0;
            for(int i=0;i<s.length();i++){
                char c =s.charAt(i);
                if (c<='9' && '0'<= c){
                    int d = c-'0';
                    num=num*10+d;
                }
            }
            arr.add(new Item(s,num));
        }
        String[] res = new String[arr.size()];
        for(Item item: arr){
            res[item.num-1]=item.s;
        }
        for (String s : res){
            for(int i=0;i<s.length();i++){
                char c =s.charAt(i);
                if (c<='9' && '0'<= c){
                }else{
                    out.print(c);
                }
            }
            out.println();
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
        new Task1().run();
    }
}