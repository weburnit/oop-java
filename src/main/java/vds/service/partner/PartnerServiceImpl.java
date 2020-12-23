package vds.service.partner;

import vds.api.Partner;
import vds.api.interfaces.ConfigStorageInterface;
import vds.dto.partner.PartnerConfig;
import vds.exceptions.PartnerConfigException;
import vds.infrastructure.repository.LazadaRepository;
import vds.infrastructure.repository.TikiRepository;
import vds.spi.PartnerService;

public class PartnerServiceImpl implements PartnerService {

    @Override
    public PartnerConfig getPartnerConfig(String partnerCode) throws PartnerConfigException {
        ConfigStorageInterface storage = null;
        switch(partnerCode.toLowerCase()) {
            case "tiki":
                storage = new TikiRepository();
                break;
            case "lazada":
                storage = new LazadaRepository();
                break;
            default:
        }
        if(storage == null) {
            throw new PartnerConfigException();
        }
        Partner partner = storage.getPartner();
        return extractPartnerConfig(partner);
    }

    private PartnerConfig extractPartnerConfig(Partner partner) {
        return new PartnerConfig(partner.getCode(), partner.getName(), partner.getKey());
    }
}
