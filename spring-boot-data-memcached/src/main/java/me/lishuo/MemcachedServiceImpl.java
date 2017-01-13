package me.lishuo;

import com.whalin.MemCached.MemCachedClient;
import com.whalin.MemCached.SockIOPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Date;
import java.util.Properties;

/**
 * Created by lis on 17/1/13.
 */
public class MemcachedServiceImpl implements MemcachedService {

    private static final Logger LOG = LoggerFactory.getLogger(MemcachedServiceImpl.class);
    private MemCachedClient mcc;

    public MemcachedServiceImpl() {
        String path = "spring-boot-data-memcached/src/main/resources/memcached.properties";
        Properties _conf = MemcachedFactory.load(new File(path));
        if (_conf == null) {
            LOG.error("Not found memcached.file {}", path);
            return;
        }

        String pname = _conf.getProperty("mem.name");

        SockIOPool _pool = createPool(_conf);
        _pool.initialize();
        LOG.info("SockIOPool {} initialize successfully!", pname);

        mcc = new MemCachedClient(pname);
    }

    private static SockIOPool createPool(Properties _conf) {
        String pname = _conf.getProperty("mem.name");

        SockIOPool _pool = SockIOPool.getInstance(pname);
        String[] servers = _conf.getProperty("mem.servers").split("[,\\s+]");
        String[] memServers = new String[servers.length];
        Integer[] memWeights = new Integer[servers.length];
        for (int i = 0; i < servers.length; i++) {
            memServers[i] = _conf.getProperty("mem.server." + servers[i].trim() + ".host", "127.0.0.1") + ":"
                    + _conf.getProperty("mem.server." + servers[i].trim() + ".port", "11211");
            memWeights[i] = Integer.parseInt(_conf.getProperty("mem." + servers[i] + ".weight", "1"));


        }
        _pool.setServers(memServers);
        _pool.setWeights(memWeights);

        _pool.setInitConn(Integer.parseInt(_conf.getProperty("mem.initconn", "10")));
        _pool.setMinConn(Integer.parseInt(_conf.getProperty("mem.minconn", "5")));
        _pool.setMaxConn(Integer.parseInt(_conf.getProperty("mem.maxconn", "250")));
        _pool.setMaxIdle(Integer.parseInt(_conf.getProperty("mem.maxidle", "3600000")));

        _pool.setMaintSleep(30);
        _pool.setNagle(false);
        _pool.setSocketTO(Integer.parseInt(_conf.getProperty("mem.timeout.read", "3000")));
        _pool.setSocketConnectTO(Integer.parseInt(_conf.getProperty("mem.timeout.conn", "3000")));
        return _pool;
    }

    @Override
    public boolean add(String key, Object value, Date expiry) {
        return mcc.add(key, value, expiry);
    }

    @Override
    public boolean add(String key, Object value) {
        return mcc.add(key, value);
    }

    @Override
    public boolean set(String key, Object value, Date expiry) {
        return mcc.set(key, value, expiry);
    }

    @Override
    public boolean set(String key, Object value) {
        return mcc.set(key, value);
    }

    @Override
    public Object get(String key) {
        return mcc.get(key);
    }

    @Override
    public boolean delete(String key) {
        return mcc.delete(key);
    }

}
