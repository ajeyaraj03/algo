package algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ajeya.hb on 05/08/16.
 */
public class PoolDataManager {

    public static void main(String [] args) throws Exception {
        DBPool dbPool = new DBPool();
        dbPool.init(2);
        System.out.println("Before Size"+dbPool.getPools().size());

        for (int i =0; i<21;i++) {
            if(Math.random() < 0.5) {
                System.out.println("ggg");
                System.out.println(dbPool.getConnection());
            }
            else {
                System.out.println("xxxxx");
                dbPool.addConnection(new DBData("fff"));
            }
            System.out.println("After Size"+dbPool.getPools().size());
        }


    }


}

class DBPool{

    private List<DBData>  pools = new ArrayList<>();
    private int maxPoolSize = 10;

    public synchronized DBData getConnection() throws Exception
    {
        DBData dbData = null;
        if(pools.isEmpty())
        {
            throw new Exception("No connection available");
        }
        else
        {
            dbData = pools.remove(pools.size()-1);
        }
        return dbData;
    }

    public void init(int maxPoolSize)
    {
        for( int i=0; i< maxPoolSize; i++)
        {
            pools.add(new DBData("conUrl"));
        }
    }

    public List<DBData> getPools()
    {
        return pools;
    }

    public synchronized void addConnection(DBData dbData) throws Exception
    {
        if(pools.size() < maxPoolSize) {
            pools.add(dbData);
        }
        else {
            throw new Exception("Max connection exceeded");
        }

    }

    @Override
    public String toString() {
        return "DBPool{" +
                "pools=" + pools +
                ", maxPoolSize=" + maxPoolSize +
                '}';
    }
}

class DBData{

private String conUrl;

    public DBData (String conUrl)
    {
        this.conUrl = conUrl;
    }

    @Override
    public String toString() {
        return "DBData{" +
                "conUrl='" + conUrl + '\'' +
                '}';
    }
}