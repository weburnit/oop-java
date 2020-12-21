package vds.spi;

import java.io.IOException;

public interface Serializer<T, R> {
    R serialize(T data) throws IOException;
    T deserialize(R data) throws IOException;
}