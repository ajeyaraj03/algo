package symantic;

import java.net.SocketException;

/**
 * Created by ajeya.hb on 21/09/16.
 */
public class PersonExtend  extends Person{

    @Override
    public int get(String id)  throws SocketException {
        System.out.println("am here");
        return 0;
    }
}
