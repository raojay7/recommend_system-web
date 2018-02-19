package com.recommend_system.utils;


import javax.servlet.http.HttpSession;
import java.util.List;

public interface JedisClient {

	String get(String key);
	String set(String key, String value);
	long incr(String key);
	Long hset(String hkey, String key, String value);
	String hget(String hkey, String key);
	Long del(String key);
	Long hdel(String hkey, String key);
	Long expire(String key, int second);


	Long setRList(String key , List<String> list);
	Long appendRightList(String key , String str);
	Long appendLeftList(String key , String str);
	Long setLList(String key , List<String> list);
	Long deleteValueOfList(String key ,int count, String value);
	/**
	 * 获取List<String>
	 * @param key
	 * @return
	 */
	List<String> getList(String key);
	/**
	 * 判断key是否存在
	 * @param key
	 * @return
	 */
	boolean exists(String key);
	/**
	 * 清空当前库
	 */
	void flushDB();
	/**
	 * 添加一个string元素到key对应的set集合中，成功返回1,如果元素已经在集合中返回0,key对应的set不存在返回错误
	 * @param key
	 * @param ownerId
	 * @param toId
	 * @param value
	 */
	void push(String key, int ownerId, int toId, String value);

	/**
	 * 非可用方法
	 * 将对象集合存放到redis里，可重新设计，传递不同类型pojo，在此提供模板
	 * @param key 主键
	 * @param sessions
	 */
	@Deprecated
	void saveBeanListToRedis(String key, List<HttpSession>  sessions );

	@Deprecated
	void saveToRedis(String key, List<HttpSession>  sessions  );

	/**
	 * 存放单个bean到redis
	 * @param key
	 * @param session
	 */
	@Deprecated
	void saveBeanToRedis(String key, HttpSession session);

	/**
	 * 通过key，查询beanList
	 * @param key
	 * @return
	 */
	@Deprecated
	List<HttpSession> getBeanList(String key);

	/**
	 * 通过key，查询单个的bean
	 * @param key
	 * @return
	 */
	@Deprecated

	HttpSession getBean(String key);
	/**
	 * 将bean转换为json
	 */
	@Deprecated
	String changeJsonToSave(HttpSession session);

	/**
	 * 可能有bug
	 * 转换json为bean
	 */
	@Deprecated
	HttpSession changeStringToBean(String beanJson);
}
