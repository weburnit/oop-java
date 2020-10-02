package vds.service;

import vds.dto.output.TrackingTransferResponse;
import vds.api.interfaces.TrackingTransferRepoInterface;
import vds.api.TrackingTransfer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrackingService implements vds.spi.TrackingService {
    private TrackingTransferRepoInterface trackingTransferRepo;

    public TrackingService(TrackingTransferRepoInterface trackingTransferRepo){
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
