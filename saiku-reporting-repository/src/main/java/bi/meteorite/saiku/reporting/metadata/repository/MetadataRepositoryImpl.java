package bi.meteorite.saiku.reporting.metadata.repository;

import bi.meteorite.saiku.reporting.metadata.repository.model.MetadataModel;

import org.pentaho.metadata.model.Domain;
import org.pentaho.metadata.model.LogicalModel;
import org.pentaho.metadata.repository.IMetadataDomainRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by bugg on 12/01/16.
 */
public class MetadataRepositoryImpl extends AbstractMetadataRepository {

  private Logger log = LoggerFactory.getLogger(MetadataRepositoryImpl.class);

  //@Autowired
  private IMemoryBasedMetadataDomainRepository mbr;

  public MetadataRepositoryImpl() {
    super();
  }


  public LogicalModel getLogicalModel(String domainId, String modelId) {
    return mbr.getImmdr().getDomain(domainId).findLogicalModel(modelId);
  }


  public Domain getDomain(String domainId) {
    return mbr.getImmdr().getDomain(domainId);
  }

  public MetadataModel loadModel(String domainId, String modelId) {

    if (domainId == null) {
      //log.error(Messages.getErrorString("MetadataService.ERROR_0003_NULL_DOMAIN")); //$NON-NLS-1$
      return null;
    }

    if (modelId == null) {
      //log.error(Messages.getErrorString("MetadataService.ERROR_0004_NULL_Model")); //$NON-NLS-1$
      return null;
    }

    Domain domain = mbr.getImmdr().getDomain(domainId);
    if (domain == null) {
      //log.error(Messages.getErrorString("MetadataService.ERROR_0005_DOMAIN_NOT_FOUND", domainId)); //$NON-NLS-1$
      return null;
    }

    LogicalModel model = domain.findLogicalModel(modelId);

    if (model == null) {
      // the model cannot be found or cannot be loaded
      //log.error(Messages.getErrorString("MetadataService.ERROR_0006_MODEL_NOT_FOUND", modelId)); //$NON-NLS-1$
      return null;
    }

    MetadataDtoMapper util = new MetadataDtoMapper();
    util.setDomain(domain);
    MetadataModel thinModel = util.createThinModel(model, domainId);
    return thinModel;

  }

  /**
   * Returns a instance of the IMetadataDomainRepository for the current session
   *
   * @return
   */
  public IMetadataDomainRepository getMetadataDomainRepository() {

    return mbr.getImmdr();

  }

  public Object getExecutor(Object query, Map<String, Object> inputs, IMetadataRepository metadataRepository) {
    return null;
  }
}
