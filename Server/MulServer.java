
import java.io.IOException;

public class MulServer {

    public float mul(float n1, float n2) {
        return n1 * n2;
    }

    public static void main(String args[]) throws IOException {
        MulServerSkeleton mss = new MulServerSkeleton();
        mss.main();
    }
}
