/**
 *
 */
package me.lishuo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * Created by lis on 17/1/13.
 */
public class MemcachedFactory {

    static Logger LOG = LoggerFactory.getLogger(MemcachedFactory.class);

    private MemcachedFactory() {
    }

    public static Properties load(File conf) {
        if (!conf.exists()) {
            LOG.error("Not found memcached.properties, path -> {}",
                    conf.getAbsolutePath());
            return null;
        }

        InputStream is = null;
        try {
            is = new FileInputStream(conf);
            Properties _conf = new Properties();
            _conf.load(is);
            return _conf;
        } catch (Exception e) {
            LOG.error(e.getMessage());
        } finally {
            if (is != null)
                try {
                    is.close();
                } catch (IOException e) {
                }
        }
        return null;
    }
}
