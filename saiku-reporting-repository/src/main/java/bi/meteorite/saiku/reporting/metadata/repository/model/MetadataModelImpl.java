package bi.meteorite.saiku.reporting.metadata.repository.model;

import bi.meteorite.saiku.reporting.metadata.repository.objects.Category;
import bi.meteorite.saiku.reporting.metadata.repository.objects.ICategory;

import java.util.Comparator;

/**
 * Created by bugg on 12/01/16.
 */
public class MetadataModelImpl implements MetadataModel {


  private static final long serialVersionUID = 6865069259179116876L;

  private ICategory[] categories = new Category[0];

  private String id, name, domainId, description;

  /**
   * Returns an array of categories for the model
   * @return
   */
  public ICategory[] getCategories() {
    return categories;
  }

  /**
   * Returns the id of the model
   * @return
   */
  public String getId() {
    return id;
  }

  /**
   * Returns the name of the model for the current locale
   * @return
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the categories for the model
   * @param categories
   */
  public void setCategories(ICategory[] categories) {
    this.categories = categories;
  }

  /**
   * Sets the id of the model
   * @param id
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Sets the name of the model for the current locale
   * @param name
   */
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((categories == null) ? 0 : categories.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
  }

  /**
   * Determines whether two models are equal to each other
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    MetadataModel other = (MetadataModel) obj;
    if (categories == null) {
      if (other.getCategories() != null) {
        return false;
      }
    }
    else if (categories.length != other.getCategories().length) {
      return false;
    }
    else {
      int idx=0;
      for( ICategory category : categories ) {
        if(!category.equals(other.getCategories()[idx])) {
          return false;
        }
        idx++;
      }
    }
    if (id == null) {
      if (other.getId() != null) {
        return false;
      }
    } else if (!id.equals(other.getId())) {
      return false;
    }
    if (name == null) {
      if (other.getName() != null) {
        return false;
      }
    } else if (!name.equals(other.getName())) {
      return false;
    }
    return true;
  }

  /**
   * Returns the id of the domain of the model
   * @return
   */
  public String getDomainId() {
    return domainId;
  }

  /**
   * Sets the domain id of the model
   * @param domainId
   */
  public void setDomainId(String domainId) {
    this.domainId = domainId;
  }

  /**
   * Returns the description of the model for the current locale
   * @return
   */
  public String getDescription() {
    return description;
  }

  /**
   * Sets the description of the model
   * @param description
   */
  public void setDescription(String description) {
    this.description = description;
  }



}
