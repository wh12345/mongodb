package com.wh.test;

import java.util.List;
import org.bson.types.ObjectId;

import java.net.UnknownHostException;
import java.util.ArrayList;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

public class MongoDB {
	public static Mongo mongo=null;
	public static DB db=null;
	public MongoDB(String databaseName) throws UnknownHostException {
		mongo=new Mongo("127.0.0.1:27017");
		db=mongo.getDB(databaseName);
	}
	public static void main(String[] args) throws UnknownHostException {
		MongoDB mongoDB=new MongoDB("foobar");
		//mongoDB.createCollection("javadb");
		//在javadb集合中插入dbs
		/*DBObject dbs=new BasicDBObject();
		dbs.put("name","uspcat.com");
		dbs.put("age",2);
		List<String> books=new ArrayList<String>();
		books.add("one");
		books.add("two");
		dbs.put("books",books);
		db.getCollection("javadb").insert(dbs);*/
		//批量插入数据
		/*List<DBObject> dbList=new ArrayList<DBObject>();
		BasicDBObject object1=new BasicDBObject("name","wh");
		BasicDBObject object2=new BasicDBObject("name","zh");
		dbList.add(object1);
		dbList.add(object2);
		db.getCollection("javadb").insert(dbList);*/
		//根据ID删除数据
		/*db.getCollection("javadb").remove(new BasicDBObject("_id",new ObjectId("5b3507fc229943e72fea081a")));*/
		//得到删除条数
		/*int count=0;
		count =db.getCollection("javadb").remove(new BasicDBObject("name","zh")).getN();
		System.out.println("删除条数为："+count);*/
		/*BasicDBObject update=new BasicDBObject();
		update.put("$set",new BasicDBObject("email","1439894056@qq.com"));
		db.getCollection("javadb").update(new BasicDBObject(), update, false, true);*/
		DBCursor dbCursor=db.getCollection("javadb");
		
		
	}
	
	public void createCollection(String collName) {
		DBObject dbs=new BasicDBObject();
		db.createCollection(collName, dbs);
	}
	

}
