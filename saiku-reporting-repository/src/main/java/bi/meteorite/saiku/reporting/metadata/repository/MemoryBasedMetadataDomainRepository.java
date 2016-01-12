package bi.meteorite.saiku.reporting.metadata.repository;

import org.pentaho.metadata.model.Domain;
import org.pentaho.metadata.repository.InMemoryMetadataDomainRepository;
import org.pentaho.metadata.util.XmiParser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.UUID;

/**
 * Created by bugg on 12/01/16.
 */
public class MemoryBasedMetadataDomainRepository implements IMemoryBasedMetadataDomainRepository {

  InMemoryMetadataDomainRepository immdr;

  private String metadataFile;

//	@Autowired
//	private IRepositoryAccess repositoryAccess;

//	@Autowired
  //private IContentAccessFactory contentAccessFactory;

  public MemoryBasedMetadataDomainRepository() {
    immdr = new InMemoryMetadataDomainRepository();

    createDomain("/tmp/metadata.xmi");
  }

  public MemoryBasedMetadataDomainRepository(String metadataFile) {
    createDomain(metadataFile);
  }

  public InMemoryMetadataDomainRepository getImmdr() {
    return immdr;
  }

  public void createDomain(String metadataFile) {

    FileInputStream in = null;
    try {
      in = new FileInputStream(metadataFile);
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    final XmiParser parser = new XmiParser();
    Domain domain = null;
    try {
      domain = parser.parseXmi(in);
      domain.setId(UUID.randomUUID().toString() + "/" + "metadata.xmi");
      immdr.storeDomain(domain, true);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

  public String getMetadataFile() {
    return metadataFile;
  }

  public void setMetadataFile(String metadataFile) {
    createDomain(metadataFile);
  }
}
