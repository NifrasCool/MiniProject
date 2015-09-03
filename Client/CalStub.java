
import java.io.*;
import java.net.*;

public class CalStub {

    Socket socket;
    ObjectOutputStream oos;
    ObjectInputStream ois;

    public CalStub(String op) throws IOException {
        RegistrySearch rs = new RegistrySearch();
        String[] s = rs.getServer(op);
        this.socket = new Socket("127.0.0.1", Integer.parseInt(s[1]));
        this.oos = new ObjectOutputStream(socket.getOutputStream());
        this.ois = new ObjectInputStream(socket.getInputStream());
        System.out.println("Client connected on " + s[0] + " run on port number " + s[1]);
    }

    public float add(float num1, float num2) throws IOException {
        float ans = 0;
        SeriObj so = new SeriObj(num1, num2, ans, "+");
        oos.writeObject(so);
        oos.flush();
        ans = ois.readFloat();
        return ans;
    }

    public float sub(float num1, float num2) throws IOException {
        float ans = 0;
        SeriObj so = new SeriObj(num1, num2, ans, "-");
        oos.writeObject(so);
        oos.flush();
        ans = ois.readFloat();
        return ans;
    }

    public float mul(float num1, float num2) throws IOException {
        float ans = 0;
        SeriObj so = new SeriObj(num1, num2, ans, "*");
        oos.writeObject(so);
        oos.flush();
        ans = ois.readFloat();
        return ans;
    }

    public float div(float num1, float num2) throws IOException {
        float ans = 0;
        SeriObj so = new SeriObj(num1, num2, ans, "/");
        oos.writeObject(so);
        oos.flush();
        ans = ois.readFloat();
        return ans;
    }
}
