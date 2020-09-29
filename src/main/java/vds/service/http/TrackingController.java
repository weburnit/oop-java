package vds.service.http;

import vds.spi.ITrackingService;
import vds.dto.request.RegisterAccountRequest;
import vds.dto.output.TrackingTransferResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="tracking")
@Api(tags="Tracking")
public class TrackingController {
    private ITrackingService trackingService;

    public TrackingController(ITrackingService trackingService) { this.trackingService = trackingService; }

    @ApiOperation(value = "transfer ", tags = "Transfer")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK")})
    @RequestMapping(value = "transfer",method = RequestMethod.POST, consumes={"application/json"})
    public List<TrackingTransferResponse> ListTrackingTransfers (@RequestBody RegisterAccountRequest request) {
        return trackingService.ListTrackingTransfer();
    }
}
