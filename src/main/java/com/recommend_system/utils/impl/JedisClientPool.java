package com.recommend_system.utils.impl;

import com.recommend_system.utils.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import net.sf.json.JSONObject;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * redis单机版客户端
 * <p>Title: JedisClientPool</p>
 * <p>Description: </p>
 */
public class JedisClientPool implements JedisClient
{

    @Autowired
    private JedisPool jedisPool;

    public static int SECONDS = 3600 * 24;//为key指定过期时间，单位是秒

    @Override
    public String get(String key)
    {
        Jedis jedis = jedisPool.getResource();
        String result = jedis.get(key);
        jedis.close();
        return result;
    }

    @Override
    public String set(String key, String value)
    {
        Jedis jedis = jedisPool.getResource();
        String string = jedis.set(key, value);
        jedis.close();
        return string;
    }

    @Override
    public long incr(String key)
    {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.incr(key);
        jedis.close();
        return result;
    }

    @Override
    public Long hset(String hkey, String key, String value)
    {
        Jedis jedis = jedisPool.getResource();
        Long hset = jedis.hset(hkey, key, value);
        jedis.close();
        return hset;
    }

    @Override
    public String hget(String hkey, String key)
    {
        Jedis jedis = jedisPool.getResource();
        String result = jedis.hget(hkey, key);
        jedis.close();
        return result;
    }

    @Override
    public Long del(String key)
    {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.del(key);
        jedis.close();
        return result;
    }

    @Override
    public Long hdel(String hkey, String key)
    {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.hdel(hkey, key);
        jedis.close();
        return result;
    }

    @Override
    public Long expire(String key, int second)
    {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.expire(key, second);
        return result;
    }

    @Override
    public Long setRList(String key, List<String> list)
    {
        Jedis jedis = jedisPool.getResource();
        String[] array = list.toArray(new String[list.size()]);
        Long rpush = jedis.rpush(key, array);
        jedis.close();
        return rpush;
    }

    @Override
    public Long appendRightList(String key, String str)
    {
        Jedis jedis = jedisPool.getResource();
        Long rpush = jedis.rpush(key, str);
        jedis.close();
        return rpush;
    }

    @Override
    public Long appendLeftList(String key, String str)
    {
        Jedis jedis = jedisPool.getResource();
        Long lpush = jedis.lpush(key, str);
        jedis.close();
        return lpush;
    }

    @Override
    public Long setLList(String key, List<String> list)
    {
        Jedis jedis = jedisPool.getResource();
        String[] array = list.toArray(new String[list.size()]);
        Long lpush = jedis.lpush(key, array);
        return lpush;
    }

    @Override
    public Long deleteValueOfList(String key, int count, String value)
    {
        Jedis jedis = jedisPool.getResource();
        Long lrem = jedis.lrem(key, count, value);
        jedis.close();
        return lrem;
    }

    @Override
    public List<String> getList(String key)
    {
        Jedis jedis = jedisPool.getResource();
        List<String> list = new ArrayList<String>();
        long l = jedis.llen(key);
        if (l == 0)
        {
            return null;
        }
        list = jedis.lrange(key, 0, l);
        jedis.close();
        return list;
    }

    @Override
    public boolean exists(String key)
    {
        boolean exists = false;
        Jedis jedis = jedisPool.getResource();
        if (jedis.exists(key))
        {
            exists = true;
        }
        jedis.close();
        return exists;
    }

    @Override
    public void flushDB()
    {
        Jedis jedis = jedisPool.getResource();

        jedis.flushDB();
        jedis.close();
    }

    @Override
    public void push(String key, int ownerId, int toId, String value)
    {
        Jedis jedis = jedisPool.getResource();

        jedis.sadd(key + ownerId, key + toId);
        if (jedis.exists(key + toId))
        {
            jedis.del(key + toId);
        }
        jedis.set(key + toId, value);
        jedis.expire(key + ownerId, SECONDS);
        jedis.expire(key + toId, SECONDS);
        jedis.close();

    }

    @Override
    public void saveBeanListToRedis(String key, List<HttpSession> sessions)
    {
        Jedis jedis = jedisPool.getResource();
        if (sessions != null)
        {
            for (HttpSession session : sessions)
            {
                saveBeanToRedis(jedis, key, session);
            }
        }
    }

    @Override
    public void saveToRedis(String key, List<HttpSession> sessions)
    {
        Jedis jedis = jedisPool.getResource();

        if (sessions != null)
        {
            for (HttpSession session : sessions)
            {
                saveBeanToRedis(jedis, key, session);
            }
        }
        jedis.close();

    }

    @Override
    public void saveBeanToRedis(String key, HttpSession session)
    {
        Jedis jedis = jedisPool.getResource();
        jedis.lpush(key, changeJsonToSave(session));
        jedis.close();

    }

    public void saveBeanToRedis(Jedis jedis, String key, HttpSession session)
    {
        jedis.lpush(key, changeJsonToSave(session));
    }

    @Override
    public List<HttpSession> getBeanList(String key)
    {
        Jedis jedis = jedisPool.getResource();

        long len = jedis.llen(key);
        List<String> list = jedis.lrange(key, 0, (int)len - 1);
        List<HttpSession> sessions = new ArrayList<HttpSession>();
        for (String value : list)
        {
            sessions.add(changeStringToBean(value));
        }
        jedis.close();

        return sessions;
    }

    @Override
    public HttpSession getBean(String key)
    {
        Jedis jedis = jedisPool.getResource();
        List<String> list = jedis.lrange(key, 0, 0);
        HttpSession session = null;
        for (String value : list) {
            session = changeStringToBean(value);
        }
        jedis.close();

        return session;
    }

    @Override
    public String changeJsonToSave(HttpSession session)
    {
        JSONObject jsonObject = JSONObject.fromObject(session);
        return session.getClass().getCanonicalName() + "ゎ∴♂㊣ф≒ж☆♀∴ぁ"
            + jsonObject.toString();
    }

    @Override
    public HttpSession changeStringToBean(String beanJson)
    {
        if(beanJson != null && !"".equals(beanJson)){
            String[] params = beanJson.split("ゎ∴♂㊣ф≒ж☆♀∴ぁ");
            if(params != null && params.length == 2){
                String className = "";
                String realJson = "";
                HttpSession session = null;
                try {
                    if (params[0] == null || "".equals(params[0])) {
                        throw new Exception("beanJson中未找到实体类名");
                    } else {
                        className = params[0];
                        realJson = params[1];
                        session= (HttpSession)Class.forName(className).newInstance();
                        JSONObject fromObject = JSONObject.fromObject(realJson);
                        session = (HttpSession)JSONObject.toBean(fromObject, HttpSession.class);

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return session;
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

}
