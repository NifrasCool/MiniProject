
import java.io.IOException;

public class AddServer {

    public float add(float n1, float n2) {
        return n1 + n2;
    }

    public static void main(String args[]) throws IOException {
        AddServerSkeleton ass = new AddServerSkeleton();
        ass.main();
    }
}
