package mck.service.policy;


abstract class AbstractEventHandler implements EventHandler {
    protected EventHandler next;

    @Override
    public void setNext(EventHandler next) {
        this.next = next;
    }
}
