package bi.meteorite.saiku.reporting.metadata.repository.objects;

import java.io.Serializable;

/**
 * Created by bugg on 12/01/16.
 */
public interface IColumn extends Serializable {

  /**
   * Returns the data type of the column
   * @return
   */
  public String getType();

  /**
   * Returns the id of the column
   * @return
   */
  public String getId();

  /**
   * Returns the name of the column
   * @return
   */
  public String getName();

  /**
   * Returns the description of the column
   * @return
   */
  public String getDescription();

  /**
   * Returns the category of the column
   * @return
   */
  public String getCategory();

  /**
   * Returns the default aggregation type of the column. Can be NONE.
   * @return
   */
  public String getDefaultAggType();

  /**
   * Returns an array of the availble aggregation types. Can be empty.
   * @return
   */
  public String[] getAggTypes();

  /**
   * Returns the currently selected aggregation type. Can be NONE.
   * @return
   */
  public String getSelectedAggType();

  /**
   * Returns the type of this column, e.g. DIMENSION. Can be UNKNOWN.
   * @return
   */
  public String getFieldType();

  /**
   * Returns the horizontal alignment of the column - RIGHT, LEFT, CENTERED.
   * @return
   */
  public String getHorizontalAlignment();

  /**
   * Returns the format mask for this column, e.g. "#,###.00" or "MMM dd, yyyy"
   * @return
   */
  public String getFormatMask();
}
