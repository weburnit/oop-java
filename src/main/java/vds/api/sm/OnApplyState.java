package vds.api.sm;

public interface OnApplyState <S extends SMEntity> {
    void apply(S s);
}
