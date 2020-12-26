package vds.infrastructure.ruleengine.plugin;

import vds.infrastructure.ruleengine.state.State;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class StatisticsPlugin implements Plugin {
    private final Map<State, AtomicInteger> stats;

    public StatisticsPlugin() {
        stats = new HashMap<>();
        for (State state : State.values()) {
            stats.put(state, new AtomicInteger(0));
        }
    }

    @Override
    public String name() {
        return "stats-plugin";
    }

    @Override
    public void onEvent(State event) {
        stats.get(event).incrementAndGet();
        printStats(); // print stats each time the engine change its status
    }

    private void printStats() {
        StringBuilder sb = new StringBuilder();
        sb.append("Statistic:\n");
        for (Map.Entry<State, AtomicInteger> entry : stats.entrySet()) {
            int value = entry.getValue().get();
            sb.append(entry.getKey()).append("(").append(value).append(")");
            sb.append(":");
            for (int j = 0; j < value; j++) {
                sb.append("]");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
