package vds.spi;

import vds.dto.output.TrackingTransferResponse;

import java.util.List;

public interface TrackingServiceInterface {
    List<TrackingTransferResponse> ListTrackingTransfer();
}
