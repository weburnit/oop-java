package vds.api.interfaces;

import vds.api.TrackingTransfer;

import java.util.List;

public interface ITrackingTransferRepo {
    Error Create(TrackingTransfer trackingTransfer);
    List<TrackingTransfer> ListTrackingTransfers();
}
