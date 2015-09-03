
import java.io.Serializable;

public class SeriObj  implements Serializable{
    public float n1,n2,ans;
    public String op;
    
    public SeriObj(float para1, float para2, float result, String operand){
        this.n1=para1;
        this.n2=para2;
        this.ans=result;
        this.op=operand;
    }
}