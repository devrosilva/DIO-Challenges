import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;


public class Challenge03{

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        String owner, l;
        String[] details;
        Tshirt[] tshirts;
        Tshirt tshirt;
        int N;
        while (!(l = read()).equals("0")) {

            N = toInt(l);
            tshirts = new Tshirt[N];
            for (int i = 0; i < N; i++) {
             
              owner = read();
              details = read().split(" ");
              tshirt = new Tshirt(details[1], details[0], owner);
              tshirts[i] = tshirt;
            }
            Arrays.sort(tshirts, new Comparator<Tshirt>() {
                @Override
                public int compare(Tshirt t1, Tshirt t2) {

                    int diff = t1.getColor().compareTo(t2.getColor());
                    if (diff != 0) {
                        return diff;
                    }
                    diff = t2.getSize().compareTo(t1.getSize());
                    if(diff != 0){
                    	return diff;
                    }
                    diff = t1.getOwner().compareTo(t2.getOwner());
                    if(diff != 0){
                    	return diff;
                    }
                    return 0;
                }
            });

		    for (int i = 0; i < tshirts.length; i++) {
		    	System.out.println(tshirts[i].toString());
		    }
        }

        out.close();
    }

    private static String read() throws IOException {
        return in.readLine();
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }
}

class Tshirt {

    private String size;
    private String color;
    private String owner;

    public Tshirt(String size, String color, String owner) {
        this.size = size;
        this.color = color;
        this.owner = owner;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return this.getColor() + " " + this.getSize() + " " + this.getOwner();
    }
}
