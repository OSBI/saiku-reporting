package bi.meteorite.saiku.reporting.metadata.repository;

import bi.meteorite.saiku.reporting.metadata.repository.model.IMetadataModelInfo;
import bi.meteorite.saiku.reporting.metadata.repository.model.MetadataModelInfoImpl;

import org.apache.commons.lang.StringUtils;

import org.pentaho.metadata.model.Domain;
import org.pentaho.metadata.model.LogicalModel;
import org.pentaho.metadata.model.thin.ModelInfoComparator;
import org.pentaho.metadata.repository.IMetadataDomainRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * Created by bugg on 12/01/16.
 */
public abstract class AbstractMetadataRepository implements IMetadataRepository {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private Logger log = LoggerFactory.getLogger(AbstractMetadataRepository.class);

  /**
   * Returns a list of ModelInfo objects for the specified domain.
   * @param domainId
   * @param context
   *            Area to check for model visibility
   * @param models
   * @throws UnsupportedEncodingException
   */
  protected void getModelInfos(final String domainId, final String context, List<IMetadataModelInfo> models,
                               Locale locale) throws UnsupportedEncodingException {

    Domain domainObject = getDomain(domainId);

    if (domainObject == null) {
      return;
    }

    //Some guessing here
    String loc = getClosestLocale(locale.toString(), domainObject.getLocaleCodes());

    // iterate over all of the models in this domain
    for (LogicalModel model : domainObject.getLogicalModels()) {
      String vis = (String) model.getProperty("visible");
      if (vis != null) {
        String[] visibleContexts = vis.split(",");
        boolean visibleToContext = false;
        for (String c : visibleContexts) {
          if (c.equals(context)) {
            visibleToContext = true;
            break;
          }
        }
        if (!visibleToContext) {
          continue;
        }
      }
      // create a new ModelInfo object and give it the envelope
      // information about the model
      IMetadataModelInfo modelInfo = new MetadataModelInfoImpl();
      modelInfo.setDomainId(URLEncoder.encode(domainId,"UTF-8"));
      modelInfo.setModelId(model.getId());
      modelInfo.setModelName(model.getName(loc));
      if (model.getDescription() != null) {
        String modelDescription = model.getDescription(loc);
        modelInfo.setModelDescription(modelDescription);
      }
      models.add(modelInfo);
    }
    return;
  }

  @SuppressWarnings("unchecked")
  public IMetadataModelInfo[] getBusinessModels(String domainName, Locale locale) {

    List<IMetadataModelInfo> models = new ArrayList<IMetadataModelInfo>();

    IMetadataDomainRepository repo = getMetadataDomainRepository();

    if (repo == null) {
      log.error("MetadataService.ERROR_0001_BAD_REPO"); //$NON-NLS-1$
      return null;
    }

    // TODO: what context is appropriate here?
    String context = null;

    try {
      if (StringUtils.isEmpty(domainName)) {
        for (String domain : getMetadataDomainRepository().getDomainIds()) {
          getModelInfos(domain, context, models, locale);
        }
      } else {
        getModelInfos(domainName, context, models, locale);
      }
    } catch (Throwable t) {
      log.error("MetadataService.ERROR_0002_BAD_MODEL_LIST", t); //$NON-NLS-1$
    }

    Collections.sort(models, new ModelInfoComparator());
    return models.toArray(new IMetadataModelInfo[models.size()]);
  }

  private static String getClosestLocale( String locale, String locales[] ) {
    // see if this locale is supported
    if( locales == null || locales.length == 0 ) {
      return locale;
    }
    if( locale == null || locale.length() == 0 ) {
      return locales[ 0 ];
    }
    String localeLanguage = locale.substring(0, 2);
    String localeCountry = (locale.length() > 4) ? locale.substring(0, 5) : localeLanguage;
    int looseMatch = -1;
    int closeMatch = -1;
    int exactMatch = -1;
    for( int idx=0; idx<locales.length; idx++ ) {
      if( locales[idx].equals( locale ) ) {
        exactMatch = idx;
        break;
      }
      else if( locales[idx].length() > 1 && locales[idx].substring(0, 2).equals( localeLanguage ) ) {
        looseMatch = idx;
      }
      else if( locales[idx].length() > 4 && locales[idx].substring(0, 5).equals( localeCountry ) ) {
        closeMatch = idx;
      }
    }
    if( exactMatch != -1 ) {
      // do nothing we have an exact match
    }
    else if( closeMatch != - 1) {
      locale = locales[ closeMatch ];
    }
    else if( looseMatch != - 1) {
      locale = locales[ looseMatch ];
    }
    else {
      // no locale is close , just go with the first?
      locale = locales[ 0 ];
    }
    return locale;
  }




}
