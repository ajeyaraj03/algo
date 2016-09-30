//import org.codehaus.jackson.map.ObjectMapper;
//import org.codehaus.jackson.node.ArrayNode;
//import org.codehaus.jackson.node.ObjectNode;
//
//import java.io.IOException;
//
///**
// * Created by ajeya.hb on 25/04/16.
// */
//public class JacksonSample {
//
//    public static void main(String[] args) throws IOException {
//        JsonFactory factory = new JsonFactory();
//        ObjectMapper om = new ObjectMapper(factory);
//        factory.setCodec(om);
//        ObjectNode node = om.createObjectNode();
//        node.put("hoge", 1);
//        ObjectNode child = om.createObjectNode();
//        child.put("piro", "10");
//        ArrayNode an = om.createArrayNode();
//        an.add(1);
//        an.add(2);
//        child.put("ary", an);
//        node.put("fuga", child);
//
//        JsonGenerator gen = factory.createJsonGenerator(System.out,
//                JsonEncoding.UTF8);
//        gen.writeTree(node);
//        gen.close();
//    }
//}
