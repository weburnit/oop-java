package vds.infrastructure.repository;

import vds.api.interfaces.ITrackingTransferRepo;
import vds.api.TrackingTransfer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackingTransferRepository implements ITrackingTransferRepo {
    @Override
    public Error Create(TrackingTransfer trackingTransfer) {
        return null;
    }

    @Override
    public List<TrackingTransfer> ListTrackingTransfers() {
        return null;
    }
}
