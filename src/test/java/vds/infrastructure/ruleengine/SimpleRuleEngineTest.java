package vds.infrastructure.ruleengine;

import org.junit.Test;
import vds.infrastructure.ruleengine.plugin.StatisticsPlugin;

public class SimpleRuleEngineTest {
    // not actually test
    @Test
    public void normalTest() {
        SimpleRuleEngine engine = new SimpleRuleEngine();
        engine.initialize();
        StatisticsPlugin statsPlugin = new StatisticsPlugin();
        engine.registerPlugin(statsPlugin);
        engine.start();
        engine.pause();
        engine.resume();
        engine.pause();
        engine.resume();
        engine.stop();
        System.out.println(statsPlugin.statsStr()); // print stats
    }
}
