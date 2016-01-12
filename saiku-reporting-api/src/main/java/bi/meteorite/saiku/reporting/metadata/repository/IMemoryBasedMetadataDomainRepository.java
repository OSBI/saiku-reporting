package bi.meteorite.saiku.reporting.metadata.repository;

import org.pentaho.metadata.repository.InMemoryMetadataDomainRepository;

/**
 * Created by bugg on 12/01/16.
 */
public interface IMemoryBasedMetadataDomainRepository {

  public InMemoryMetadataDomainRepository getImmdr();

 void createDomain(String metadataFile);

  public String getMetadataFile();

  public void setMetadataFile(String metadataFile);
}
