package vds.infrastructure.ruleengine;

public interface Engine {
    void initialize();
    void reset();
    void start();
    void pause();
    void resume();
    void stop();
}
