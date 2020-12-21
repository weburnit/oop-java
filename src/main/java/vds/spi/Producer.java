package vds.spi;

import java.io.IOException;
import java.io.Serializable;

public interface Producer<T extends Serializable> {
    void send(T data) throws IOException;
}
