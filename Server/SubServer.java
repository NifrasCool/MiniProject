
import java.io.IOException;

public class SubServer {

    public float sub(float n1, float n2) {
        return n1 - n2;
    }

    public static void main(String args[]) throws IOException {
        SubServerSkeleton sss = new SubServerSkeleton();
        sss.main();
    }
}
