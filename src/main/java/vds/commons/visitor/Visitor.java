package vds.commons.visitor;

public interface Visitor<T, R> {
    R visit(T o);
}
