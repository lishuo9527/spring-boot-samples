/**
 *
 */
package me.lishuo;

import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by lis on 17/1/13.
 */
public interface MemcachedService {

    boolean add(String key, Object value, Date expiry);

    boolean add(String key, Object value);

    boolean set(String key, Object value, Date expiry);

    boolean set(String key, Object value);

    Object get(String key);

    boolean delete(String key);

}
