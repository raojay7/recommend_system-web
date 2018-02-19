package com.recommend_system.utils.impl;

import com.recommend_system.utils.JedisClient;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * redis集群版客户端
 * <p>Title: JedisClientCluster</p>
 * <p>Description: </p>
 */
public class JedisClientCluster implements JedisClient
{

    @Autowired
    private JedisCluster jedisCluster;

    public static int SECONDS = 3600 * 24;//为key指定过期时间，单位是秒

    @Override
    public String get(String key)
    {
        String string = jedisCluster.get(key);
        return string;
    }

    @Override
    public String set(String key, String value)
    {
        String string = jedisCluster.set(key, value);
        return string;
    }

    @Override
    public long incr(String key)
    {
        Long result = jedisCluster.incr(key);
        return result;
    }

    @Override
    public Long hset(String hkey, String key, String value)
    {
        Long result = jedisCluster.hset(hkey, key, value);
        return result;
    }

    @Override
    public String hget(String hkey, String key)
    {
        String string = jedisCluster.hget(hkey, key);
        return string;
    }

    @Override
    public Long del(String key)
    {
        Long result = jedisCluster.del(key);
        return result;
    }

    @Override
    public Long hdel(String hkey, String key)
    {
        Long result = jedisCluster.hdel(hkey, key);
        return result;
    }

    @Override
    public Long expire(String key, int second)
    {
        Long result = jedisCluster.expire(key, second);
        return result;
    }

    @Override
    public Long setRList(String key, List<String> list)
    {
        String[] array = list.toArray(new String[list.size()]);
        Long rpush = jedisCluster.rpush(key, array);
        return rpush;
    }

    @Override
    public Long appendRightList(String key, String str)
    {
        Long rpush = jedisCluster.rpush(key, str);
        return rpush;
    }

    @Override
    public Long appendLeftList(String key, String str)
    {
        Long lpush = jedisCluster.lpush(key, str);
        return lpush;
    }

    @Override
    public Long setLList(String key, List<String> list)
    {
        String[] array = list.toArray(new String[list.size()]);
        Long lpush = jedisCluster.lpush(key, array);
        return lpush;
    }

    @Override
    public Long deleteValueOfList(String key, int count, String value)
    {
        Long lrem = jedisCluster.lrem(key, count, value);
        return lrem;
    }

    @Override
    public List<String> getList(String key)
    {
        List<String> list = new ArrayList<String>();
        long l = jedisCluster.llen(key);
        if (l == 0)
        {
            return null;
        }
        list = jedisCluster.lrange(key, 0, l);
        return list;
    }

    @Override
    public boolean exists(String key)
    {
        boolean exists = false;
        if (jedisCluster.exists(key))
        {
            exists = true;
        }
        return exists;
    }

    @Override
    public void flushDB()
    {
        jedisCluster.flushDB();
    }

    @Override
    public void push(String key, int ownerId, int toId, String value)
    {

        jedisCluster.sadd(key + ownerId, key + toId);
        if (jedisCluster.exists(key + toId))
        {
            jedisCluster.del(key + toId);
        }
        jedisCluster.set(key + toId, value);
        jedisCluster.expire(key + ownerId, SECONDS);
        jedisCluster.expire(key + toId, SECONDS);
        jedisCluster.close();

    }

    @Override
    public void saveBeanListToRedis(String key, List<HttpSession> sessions)
    {
        if (sessions != null)
        {
            for (HttpSession session : sessions)
            {
                saveBeanToRedis(key, session);
            }
        }
    }

    @Override
    public void saveToRedis(String key, List<HttpSession> sessions)
    {

        if (sessions != null)
        {
            for (HttpSession session : sessions)
            {
                saveBeanToRedis(key, session);
            }
        }

    }
    @Override
    public void saveBeanToRedis(String key, HttpSession session)
    {
        jedisCluster.lpush(key, changeJsonToSave(session));

    }



    @Override
    public List<HttpSession> getBeanList(String key)
    {

        long len = jedisCluster.llen(key);
        List<String> list = jedisCluster.lrange(key, 0, (int)len - 1);
        List<HttpSession> sessions = new ArrayList<HttpSession>();
        for (String value : list)
        {
            sessions.add(changeStringToBean(value));
        }
        jedisCluster.close();

        return sessions;
    }

    @Override
    public HttpSession getBean(String key)
    {
        List<String> list = jedisCluster.lrange(key, 0, 0);
        HttpSession session = null;
        for (String value : list)
        {
            session = changeStringToBean(value);
        }

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
        if (beanJson != null && !"".equals(beanJson))
        {
            String[] params = beanJson.split("ゎ∴♂㊣ф≒ж☆♀∴ぁ");
            if (params != null && params.length == 2)
            {
                String className = "";
                String realJson = "";
                HttpSession session = null;
                try
                {
                    if (params[0] == null || "".equals(params[0]))
                    {
                        throw new Exception("beanJson中未找到实体类名");
                    }
                    else
                    {
                        className = params[0];
                        realJson = params[1];
                        session = (HttpSession)Class.forName(className).newInstance();
                        JSONObject fromObject = JSONObject.fromObject(realJson);
                        session = (HttpSession)JSONObject.toBean(fromObject, HttpSession.class);

                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                return session;
            }
            else
            {
                return null;
            }
        }
        else
        {
            return null;
        }
    }

}
