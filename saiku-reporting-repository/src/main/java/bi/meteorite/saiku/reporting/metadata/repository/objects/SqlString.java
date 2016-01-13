package bi.meteorite.saiku.reporting.metadata.repository.objects;

/**
 * Created by bugg on 12/01/16.
 */
public class SqlString {
  public SqlString(String sql) {
    super();
    this.sql = sql;
  }

  public String getSql() {
    return sql;
  }

  public void setSql(String sql) {
    this.sql = sql;
  }

  private String sql;
}
