package vds.infrastructure.services;

import vds.dto.output.TrackingTransferResponse;
import vds.api.interfaces.ITrackingTransferRepo;
import vds.api.TrackingTransfer;
import org.springframework.stereotype.Service;
import vds.spi.ITrackingService;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrackingService implements ITrackingService {
    private ITrackingTransferRepo trackingTransferRepo;

    public TrackingService(ITrackingTransferRepo trackingTransferRepo){
        this.trackingTransferRepo = trackingTransferRepo;
    }

    @Override
    public List<TrackingTransferResponse> ListTrackingTransfer() {
        List<TrackingTransferResponse> responses = new ArrayList<TrackingTransferResponse>();
        List<TrackingTransfer> trackingTransfers = trackingTransferRepo.ListTrackingTransfers();
        for (TrackingTransfer trackingTransfer : trackingTransfers) {
            responses.add(TrackingTransferResponse.Create(trackingTransfer.TrackingID, trackingTransfer.UserReceiveID,
                    trackingTransfer.UserTransferID, trackingTransfer.MoneyTransfer, trackingTransfer.Status, trackingTransfer.Message));
        }
        return responses;
    }
}
