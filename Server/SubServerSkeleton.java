
import java.io.*;
import java.net.*;

public class SubServerSkeleton extends Thread {

    private static boolean shallWeStall = false;
    private static Socket socket;
    
    public void main() throws IOException {
        ServerSocket serverSocket = new ServerSocket(9877);
        for (;;) {
            socket = serverSocket.accept();
            new SubServerSkeleton().start();
        }
    }

    @Override
    public void run() {
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try {
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());

            SeriObj e = (SeriObj) ois.readObject();
            System.out.println("Client sending number1 = " + e.n1);
            System.out.println("Client sending number1 = " + e.n2);
            SubServer ss = new SubServer();
            e.ans = ss.sub(e.n1, e.n2);
            System.out.println("Client request calculation answer is:" + e.ans + "\n");
            oos.writeFloat(e.ans);
            oos.flush();

            if (shallWeStall) {
                shallWeStall = false;
            } else {
                shallWeStall = true;
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
