//import org.codehaus.jackson.map.JsonMappingException;
//import org.codehaus.jackson.map.ObjectMapper;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Created by ajeya.hb on 25/04/16.
// */
//public class TestMap {
//
//    public static void main(String[] args) throws Exception, JsonMappingException,Throwable {
//        Map<String,String> asd = new HashMap<String,String>();
//        Map<String,String> detailsMap = new HashMap<String,String>();
//        asd.put("ajeya","ajeyaval");
//        asd.put("dd","ddval");
//
//        System.out.println(asd);
//
//        String crap = "{\'atp\' = 1, \'quanity\' = 1, \'area\' = \'store\'}";
//        ObjectMapper objectMapper = new ObjectMapper();
//
//
//
//                detailsMap = objectMapper.readValue(crap, HashMap.class);
//
//
//    }
//}
