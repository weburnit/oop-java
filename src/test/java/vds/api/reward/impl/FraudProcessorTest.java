package vds.api.reward.impl;

import com.google.common.base.Verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import vds.api.cor.AllocationEmitter;
import vds.api.cor.RewardAllocationProcessor;
import vds.api.cor.AllocationEmitter.EventEmitter;
import vds.api.cor.impl.FraudProcessor;
import vds.api.cor.impl.FrequencyCapAllocation;
import vds.api.cor.impl.KafkaAllocationEmitter;
import vds.api.cor.impl.KafkaEventEmitter;
import vds.api.sm.Reward;
import vds.api.sm.State;


@RunWith(MockitoJUnitRunner.class)
public class FraudProcessorTest {
    private RewardAllocationProcessor fraudProcessor;

    @Before
    public void setup() {
        this.fraudProcessor = new FraudProcessor();
    }

    @Test
    public void process_test() {
        Reward reward = new Reward("1", new State("OPEN", "1"));
        RewardAllocationProcessor freqProcessor = new FrequencyCapAllocation();
        AllocationEmitter kafkaEmitter = mock(KafkaAllocationEmitter.class);
        fraudProcessor.setNext(freqProcessor);
        fraudProcessor.process(reward, kafkaEmitter);
        verify(kafkaEmitter, atLeastOnce()).emit(reward);
    }

}
