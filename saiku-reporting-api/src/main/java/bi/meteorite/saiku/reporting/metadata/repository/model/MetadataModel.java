package bi.meteorite.saiku.reporting.metadata.repository.model;

import bi.meteorite.saiku.reporting.metadata.repository.objects.ICategory;

import java.io.Serializable;

/**
 * Created by bugg on 12/01/16.
 */
public interface MetadataModel extends Serializable {

  /**
   * Returns the id of the model
   *
   * @return
   */
  public String getId();

  /**
   * Returns the id of the domain of the model
   *
   * @return
   */
  public String getDomainId();

  /**
   * Returns the name of the model for the current locale
   *
   * @return
   */
  public String getName();

  /**
   * Returns an array of categories for the model
   *
   * @return
   */
  public ICategory[] getCategories();

  /**
   * Returns the description of the model for the current locale
   *
   * @return
   */
  public String getDescription();

  void setName(String name);

  void setId(String id);

  void setDomainId(String domainId);

  void setDescription(String description);

  void setCategories(ICategory[] categories);
}
