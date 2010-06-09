package dispatch

import dispatch.gae.GAEConnectionManager
import org.apache.http.params.HttpParams
import org.apache.http.conn.ClientConnectionManager

class AppEngineConfiguredClient(conman: ClientConnectionManager) extends ConfiguredHttpClient(conman) {
  // NOOP
  override protected def configureProxy(params: HttpParams) = params
}

object AppEngineHttp extends AppEngineHttp with HttpImplicits

class AppEngineHttp extends Http {
  override val client = new AppEngineConfiguredClient(GAEConnectionManager)
}
