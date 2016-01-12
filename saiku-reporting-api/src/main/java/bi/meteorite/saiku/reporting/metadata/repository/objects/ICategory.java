package bi.meteorite.saiku.reporting.metadata.repository.objects;

import java.io.Serializable;

/**
 * Created by bugg on 12/01/16.
 */
public interface ICategory extends Serializable {

  /**
   * Returns the id of the category
   */
  public String getId();

  /**
   * Returns the name of the cateogry for the current locale
   */
  public String getName();

  /**
   * Returns the array of {@see IColumn}s for this category
   */
  public IColumn[] getColumns();

}