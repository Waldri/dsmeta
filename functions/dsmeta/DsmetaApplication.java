import com.catalyst.Context;
import com.catalyst.basic.BasicIO;
import com.catalyst.basic.ZCFunction;

import java.util.logging.Logger;
import java.util.logging.Level;

import com.zc.common.ZCProject;
import com.zc.component.cache.ZCCache;

public class DsmetaApplication implements ZCFunction {
	private static final Logger LOGGER = Logger.getLogger(DsmetaApplication.class.getName());
	
	@Override
    public void runner(Context context, BasicIO basicIO) throws Exception {
		try {
			ZCProject.initProject();
			String name = (String) basicIO.getParameter("name");
			LOGGER.log(Level.INFO, "Hello "+name);
			ZCCache.getInstance().putCacheValue("DsmetaApplication", "Working", 1l);
			basicIO.setStatus(200);
		}
		catch(Exception e) {
			LOGGER.log(Level.SEVERE,"Exception in DsmetaApplication",e);
			basicIO.setStatus(500);
		}
        basicIO.write("Hello From DsmetaApplication.java");
	}
	
}