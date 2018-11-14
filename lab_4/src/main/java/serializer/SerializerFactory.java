package serializer;

import serializer.impl.CsvSerializer;
import serializer.impl.JsonSerializer;
import serializer.impl.XmlSerializer;

public class SerializerFactory {
    public static Serializer getSerializer(String serializer) {
        if(serializer == null)
            return null;
        else if(serializer.equalsIgnoreCase("JSON"))
            return new JsonSerializer();
        else if(serializer.equalsIgnoreCase("CSV"))
            return new CsvSerializer();
        else if(serializer.equalsIgnoreCase("XML"))
            return new XmlSerializer();
        else
            throw new IllegalArgumentException("Factory doest recognize deserializer: " + serializer);
    }
}
