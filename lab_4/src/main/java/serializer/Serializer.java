package serializer;

import java.io.Serializable;

public interface Serializer {
    String serialize(Serializable obj);
}
