import deserializer.Deserializer;
import deserializer.DeserializerFactory;
import serializer.Serializer;
import serializer.SerializerFactory;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SampleObject sampleObject = new SampleObject("sample", 123, Arrays.asList(1, 2, 3));
        Serializer jsonSerializer = SerializerFactory.getSerializer("JSON");
        String serializedObject = jsonSerializer.serialize(sampleObject);
        System.out.println("Serialized object: " + serializedObject);

        Deserializer jsonDeserializer = DeserializerFactory.getDeserializer("JSON");
        SampleObject deserializedObject = (SampleObject)jsonDeserializer.deserialize(serializedObject);
        System.out.println("Deserialized object: " + deserializedObject.toString());
    }
}
