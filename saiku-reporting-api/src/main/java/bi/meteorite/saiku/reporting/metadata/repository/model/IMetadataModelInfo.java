package bi.meteorite.saiku.reporting.metadata.repository.model;

/**
 * Created by bugg on 12/01/16.
 */
public interface IMetadataModelInfo {


    /**
     * Returns the id of the domain of the model
     * @return
     */
    public String getDomainId();

    /**
     * Sets the domain id of the model
     * @param domainId
     * @throws UnsupportedEncodingException
     */
    public void setDomainId(String domainId);

    /**
     * Returns the id of the model
     * @return
     */
    public String getModelId();

    /**
     * Sets the id of the model
     * @param id
     */
    public void setModelId(String modelId);

    /**
     * Returns the name of the model for the current locale
     * @return
     */
    public String getModelName();

    /**
     * Sets the name of the model for the current locale
     * @param name
     */
    public void setModelName(String modelName);

    /**
     * Returns the description of the model for the current locale
     * @return
     */
    public String getModelDescription();

    /**
     * Sets the description of the model
     * @param description
     */
    public void setModelDescription(String modelDescription);

    public void setJson(String json);

    public String getJson();



  }
