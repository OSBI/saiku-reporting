package bi.meteorite.saiku.reporting.metadata.repository;

import bi.meteorite.saiku.reporting.metadata.repository.exceptions.MetadataException;
import bi.meteorite.saiku.reporting.metadata.repository.model.IMetadataModelInfo;
import bi.meteorite.saiku.reporting.metadata.repository.model.MetadataModel;

import org.pentaho.metadata.model.Domain;
import org.pentaho.metadata.model.LogicalModel;
import org.pentaho.metadata.repository.IMetadataDomainRepository;

import java.util.Locale;
import java.util.Map;

/**
 * Created by bugg on 12/01/16.
 */
public interface IMetadataRepository {

  /**
   * Get a thin representation of all available metadata models
   *
   * @param domainName
   * @param locale
   * @return
   * @throws QuerybuilderServiceException
   */
  public abstract IMetadataModelInfo[] getBusinessModels(String domainName, Locale locale)
      throws MetadataException;

  /**
   * Get the real logical model for a given ID
   *
   * @param modelId
   * @param domainId
   * @return
   */
  public abstract LogicalModel getLogicalModel(String domainId, String modelId);

  /**
   * Get the real domain object for a given id
   * @param domain
   * @return
   */
  public abstract Domain getDomain(String domainId);

  /**
   * Returns a Model object for the requested model. The model will include
   * the basic metadata - categories and columns.
   *
   * @param domainId
   * @param modelId
   * @return
   */
  public abstract MetadataModel loadModel(String domainId, String modelId);

  //public abstract ReportTemplate[] loadTemplates();

  public abstract IMetadataDomainRepository getMetadataDomainRepository();

  public abstract Object getExecutor(Object query, Map<String, Object> inputs, IMetadataRepository metadataRepository);


}
