package vds.api.interfaces;

import vds.api.TrackingTransfer;

import java.util.List;

public interface TrackingTransferRepoInterface {
    Error Create(TrackingTransfer trackingTransfer);
    List<TrackingTransfer> ListTrackingTransfers();
}
