package bi.meteorite.saiku.reporting.metadata.repository.objects;

import bi.meteorite.saiku.reporting.metadata.repository.objects.IColumn;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bugg on 12/01/16.
 */
public class Column implements IColumn {
  private static final long serialVersionUID = 3751750093446278893L;
  private String id, name, description;
  private String type;
  private List<String> aggTypes = new ArrayList<String>();
  private String defaultAggType;
  private String selectedAggType;
  private String fieldType;
  private String category;
  private String getHorizontalAlignment;
  private String formatMask;

  public String getHorizontalAlignment() {
    return getHorizontalAlignment;
  }

  public void setHorizontalAlignment(String getHorizontalAlignment) {
    this.getHorizontalAlignment = getHorizontalAlignment;
  }

  public String getFormatMask() {
    return formatMask;
  }

  public void setFormatMask(String formatMask) {
    this.formatMask = formatMask;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getFieldType() {
    return fieldType;
  }

  public void setFieldType(String fieldType) {
    this.fieldType = fieldType;
  }

  public String getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public String getType() {
    return this.type;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getDefaultAggType() {
    return defaultAggType;
  }

  public String[] getAggTypes() {
    return aggTypes.toArray( new String[aggTypes.size()] );
  }

  public void setAggTypes(List<String> aggTypes) {
    this.aggTypes = aggTypes;
  }

  public void setDefaultAggType(String defaultAggType) {
    this.defaultAggType = defaultAggType;
  }

  public void setSelectedAggType(String aggType){
    this.selectedAggType = aggType;
  }

  public String getSelectedAggType(){
    return this.selectedAggType;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

}
