package bi.meteorite.saiku.reporting.metadata.repository;

import org.pentaho.metadata.model.IMetadataQueryExec;
import org.pentaho.metadata.query.model.Query;
import org.pentaho.metadata.query.model.util.QueryXmlHelper;
import org.pentaho.pms.core.exception.PentahoMetadataException;

/**
 * Created by bugg on 12/01/16.
 */
public class ReportingService {

  private IMemoryBasedMetadataDomainRepository repo;

  public ReportingService() {


  }

  public void testQuery(String xml) throws PentahoMetadataException {

    QueryXmlHelper queryXmlHelper = new QueryXmlHelper();

    Query query = queryXmlHelper.fromXML(repo.getImmdr(), xml);

    String queryExecName = query.getLogicalModel().getPhysicalModel().getQueryExecName();
    String queryExecDefault = query.getLogicalModel().getPhysicalModel().getDefaultQueryClassname();
    IMetadataQueryExec executor = new SaikuQueryExecutor();

    /*executor.setDoQueryLog( logSql );
    executor.setForwardOnly( this.useForwardOnlyResultSet );
    executor.setMaxRows( this.maxRows );*/
    executor.setMetadataDomainRepository( repo.getImmdr() );
    /*executor.setReadOnly( this.readOnly );
    executor.setTimeout( this.timeout );
    if ( this.inputs != null ) {
      executor.setInputs( this.inputs );
    }*/
    executor.executeQuery(query);
  }

public void test(){
  String id = (String) repo.getImmdr().getDomainIds().toArray()[0];
  String xml = "<mql>\n"
               + "  <domain_type>relational</domain_type>\n"
               + "  <domain_id>"+id+"</domain_id>\n"
               + "  <model_id>BV_HUMAN_RESOURCES</model_id>\n"
               + "  <model_name>Human Resources</model_name>\n"
               + "  <options>\n"
               + "    <disable_distinct>false</disable_distinct>\n"
               + "    <limit>-1</limit>\n"
               + "  </options>\n"
               + "  <selections>\n"
               + "    <selection>\n"
               + "      <view>BC_OFFICES_</view>\n"
               + "      <column>BC_OFFICES_TERRITORY</column>\n"
               + "      <aggregation>none</aggregation>\n"
               + "    </selection>\n"
               + "  </selections>\n"
               + "  <constraints/>\n"
               + "  <orders/>\n"
               + "</mql>";
  try {
    testQuery(xml);
  } catch (PentahoMetadataException e) {
    e.printStackTrace();
  }
}
  public void setRepo(IMemoryBasedMetadataDomainRepository repo) {
    this.repo = repo;
  }
}
