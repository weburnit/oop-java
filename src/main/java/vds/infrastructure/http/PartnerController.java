package vds.infrastructure.http;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
import vds.exceptions.PartnerConfigException;
import vds.spi.PartnerService;

@RestController
@RequestMapping(value="partner")
@Api(tags="Partner")
public class PartnerController {
    private PartnerService partnerService;

    @ApiOperation(value = "Get partner config", tags = "Partner")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Suceess|OK") })
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String getPartnerConfig(String partnerCode) {
        try {
            return partnerService.getPartnerConfig(partnerCode).getKey();
        } catch(PartnerConfigException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Config not found.");     
        }
    }
}
