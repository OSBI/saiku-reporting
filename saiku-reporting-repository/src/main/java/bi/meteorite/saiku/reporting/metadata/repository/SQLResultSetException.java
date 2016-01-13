package bi.meteorite.saiku.reporting.metadata.repository;

import java.sql.SQLException;

/**
 * Created by bugg on 12/01/16.
 */
public class SQLResultSetException extends Throwable {
  public SQLResultSetException(String errorString, SQLException e) {
  }
}

