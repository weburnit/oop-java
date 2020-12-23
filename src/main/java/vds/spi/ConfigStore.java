package vds.spi;

public interface ConfigStore<T> {
    void save(T config);
    void get(String partner);
}
