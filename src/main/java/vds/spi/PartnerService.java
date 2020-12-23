package vds.spi;

import vds.dto.partner.PartnerConfig;
import vds.exceptions.PartnerConfigException;


public interface PartnerService {
    PartnerConfig getPartnerConfig(String partner) throws PartnerConfigException;
}
 