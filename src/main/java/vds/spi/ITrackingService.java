package vds.spi;

import vds.dto.output.TrackingTransferResponse;

import java.util.List;

public interface ITrackingService {
    List<TrackingTransferResponse> ListTrackingTransfer();
}
