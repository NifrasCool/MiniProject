
import java.io.IOException;

public class DivServer {

    public float div(float n1, float n2) {
        return n1 / n2;
    }

    public static void main(String args[]) throws IOException {
        DivServerSkeleton dss = new DivServerSkeleton();
        dss.main();
    }
}
