package vds.infrastructure.publisher;

import vds.spi.PublisherInterface;
import org.springframework.stereotype.Service;

@Service
class Publisher implements PublisherInterface
{
    public void Publish(Object o)
    {
       //Perform publishing logic via a message bus
    }
}

