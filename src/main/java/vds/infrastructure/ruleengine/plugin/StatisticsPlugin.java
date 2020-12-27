package vds.infrastructure.ruleengine.plugin;

import org.apache.commons.lang3.StringUtils;
import vds.infrastructure.ruleengine.state.State;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class StatisticsPlugin implements Plugin {
    private final Map<State, AtomicInteger> stats;

    public StatisticsPlugin() {
        stats = new HashMap<>();
        // only care about these 3 states
        stats.put(State.RUNNING, new AtomicInteger(0));
        stats.put(State.PAUSING, new AtomicInteger(0));
        stats.put(State.STOPPED, new AtomicInteger(0));
    }

    @Override
    public String name() {
        return "stats-plugin";
    }

    @Override
    public void onEvent(State event) {
        stats.get(event).incrementAndGet();
    }

    public String statsStr() {
        StringBuilder sb = new StringBuilder();
        sb.append("Statistics:\n");
        for (Map.Entry<State, AtomicInteger> entry : stats.entrySet()) {
            int value = entry.getValue().get();
            sb
                    .append("\t")
                    .append(StringUtils.leftPad(entry.getKey() + "(" + value + "):", 20));
            for (int j = 0; j < value; j++) {
                sb.append("▍");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
