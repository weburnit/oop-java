package vds.spi;

import vds.dto.output.TrackingTransferResponse;

import java.util.List;

public interface TrackingService {
    List<TrackingTransferResponse> ListTrackingTransfer();
}
