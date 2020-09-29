package vds.infrastructure.repository;

import vds.api.interfaces.TrackingTransferRepoInterface;
import vds.api.TrackingTransfer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackingTransferRepository implements TrackingTransferRepoInterface {
    @Override
    public Error Create(TrackingTransfer trackingTransfer) {
        return null;
    }

    @Override
    public List<TrackingTransfer> ListTrackingTransfers() {
        return null;
    }
}
