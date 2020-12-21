package vds.service;

import org.apache.commons.lang3.SerializationUtils;
import vds.spi.Serializer;

import java.io.IOException;
import java.io.Serializable;

public class ByteSerializer<T extends Serializable> implements Serializer<T, byte[]> {
    @Override
    public byte[] serialize(T data) throws IOException {
        return SerializationUtils.serialize(data);
    }

    @Override
    public T deserialize(byte[] data) throws IOException {
        return SerializationUtils.deserialize(data);
    }
}