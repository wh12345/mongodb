package com.wh.test;

import java.util.List;
import java.util.Set;
import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

public class MongoDBTest {
	public static void main(String[] args) {
		try {
			Mongo mongo=new Mongo("127.0.0.1:27017");
			List<String> dbNames=mongo.getDatabaseNames();
			for(String name:dbNames) {
				System.out.println(name);
			}
			DB db=mongo.getDB("foobar");
			Set<String> dbSet=db.getCollectionNames();
			for(String dbString:dbSet) {
				System.out.println(dbString);
			}
			DBCollection dbCollection=db.getCollection("persons");
			DBCursor cursor=dbCollection.find();
			while(cursor.hasNext()) {
				DBObject dbObject=cursor.next();
				System.out.println(dbObject.get("name"));
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}
}
