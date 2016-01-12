package bi.meteorite.saiku.reporting.metadata.repository.model;

import bi.meteorite.saiku.reporting.metadata.repository.model.IMetadataModelInfo;

import java.io.Serializable;

/**
 * Created by bugg on 12/01/16.
 */
public class MetadataModelInfoImpl implements IMetadataModelInfo, Serializable {

  private static final long serialVersionUID = -8341925508348437605L;

  private String domainId;

  private String modelId;

  private String modelName;

  private String modelDescription;

  //a saved query gets echoed back to the server
  private String json;

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
   * @throws UnsupportedEncodingException
   */
  public void setDomainId(String domainId) {
    this.domainId = domainId;
  }

  /**
   * Returns the id of the model
   * @return
   */
  public String getModelId() {
    return modelId;
  }

  /**
   * Sets the id of the model
   * @param id
   */
  public void setModelId(String modelId) {
    this.modelId = modelId;
  }

  /**
   * Returns the name of the model for the current locale
   * @return
   */
  public String getModelName() {
    return modelName;
  }

  /**
   * Sets the name of the model for the current locale
   * @param name
   */
  public void setModelName(String modelName) {
    this.modelName = modelName;
  }

  /**
   * Returns the description of the model for the current locale
   * @return
   */
  public String getModelDescription() {
    return modelDescription;
  }

  /**
   * Sets the description of the model
   * @param description
   */
  public void setModelDescription(String modelDescription) {
    this.modelDescription = modelDescription;
  }

  public void setJson(String json) {
    this.json = json;
  }

  public String getJson() {
    return json;
  }



}