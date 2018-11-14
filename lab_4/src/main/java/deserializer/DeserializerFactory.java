package deserializer;

import deserializer.impl.CsvDeserializer;
import deserializer.impl.JsonDeserializer;
import deserializer.impl.XmlDeserializer;

public class DeserializerFactory {
    public static Deserializer getDeserializer(String deserializer) {
        if(deserializer == null)
            return null;
        else if(deserializer.equalsIgnoreCase("JSON"))
            return new JsonDeserializer();
        else if(deserializer.equalsIgnoreCase("CSV"))
            return new CsvDeserializer();
        else if(deserializer.equalsIgnoreCase("XML"))
            return new XmlDeserializer();
        else
            throw new IllegalArgumentException("Factory doest recognize deserializer: " + deserializer);
    }
}
