package vds.infrastructure.publisher;

import vds.spi.IPublisher;
import org.springframework.stereotype.Service;

@Service
class Publisher implements IPublisher
{
    public void Publish(Object o)
    {
       //Perform publishing logic via a message bus
    }
}

