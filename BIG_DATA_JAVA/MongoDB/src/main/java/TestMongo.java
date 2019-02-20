import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.junit.Test;

public class TestMongo {

    @Test
    public void testConnection(){

        //连接MongoDB数据库
        //连接到指定的MongoDB数据库，如果不设置host和port，则自动连接localhost:27017
        MongoClient client = new MongoClient("192.168.18.101",27017);
        //MongoClient client = new MongoClient();

        //连接到指定的数据库
        MongoDatabase testDB = client.getDatabase("test");

        System.out.println(testDB);

    }

    @Test
    public void testInsertDocument(){

        //连接MongoDB数据库
        //连接到指定的MongoDB数据库，如果不设置host和port，则自动连接localhost:27017
        MongoClient client = new MongoClient("192.168.18.101",27017);
        //MongoClient client = new MongoClient();

        //连接到指定的数据库
        MongoDatabase testDB = client.getDatabase("test");

        //获取到指定的集合对象
        MongoCollection<Document> userCollection = testDB.getCollection("users");

        //创建一个文档
        Document doc = new Document("name", "sylar");
        //向文档中添加属性
        doc.append("age",16);
        doc.append("gender","男");
        doc.append("address","女儿国");
        //向users集合中插入一个文档
        userCollection.insertOne(doc);

    }

    @Test
    public void testInsertClass(){
        //连接数据库
        MongoClient client = new MongoClient("192.168.18.101",27017);
        //获取数据库的实例
        MongoDatabase testDB = client.getDatabase("test");
        //获取集合的实例
        MongoCollection<Document> stuColl = testDB.getCollection("students");

        //创建一个stu对象
        Student stu = new Student("sylar",16,"男");

        // 对象转为document
        Gson gson = new Gson();
        String stuJSON = gson.toJson(stu);
        Document doc = Document.parse(stuJSON);

        //将stu对象插入到数据库中
        stuColl.insertOne(doc);

    }


    @Test
    public void testFindFirst(){
        //连接数据库
        MongoClient client = new MongoClient();
        //获取数据库的实例
        MongoDatabase testDB = client.getDatabase("test");
        //获取集合的实例
        MongoCollection<Document> stuColl = testDB.getCollection("students");
        Gson gson = new Gson();

        // 查询数据库中的文档
        Document doc = stuColl.find().first();
        //将doc转换为JSON，然后再将json转换为java对象
        Student stu = gson.fromJson(doc.toJson(), Student.class);
        System.out.println(stu);

    }


    @Test
    public void testFindAll(){
        //连接数据库
        MongoClient client = new MongoClient();
        //获取数据库的实例
        MongoDatabase testDB = client.getDatabase("test");
        //获取集合的实例
        MongoCollection<Document> stuColl = testDB.getCollection("students");

        //查询集合中所有文档
        //FindIterable<Document> docs = stuColl.find().skip(2).limit(1);
        //在java中查询操作符是通过Filters的方法来说实现
        //FindIterable<Document> docs = stuColl.find(Filters.eq("name","唐僧"));
        FindIterable<Document> docs = stuColl.find();

        for (Document doc : docs){
            System.out.println(doc.toJson());
        }

    }

    @Test
    public void testRemove(){
        //连接数据库
        MongoClient client = new MongoClient();
        //获取数据库的实例
        MongoDatabase testDB = client.getDatabase("test");
        //获取集合的实例
        MongoCollection<Document> stuColl = testDB.getCollection("students");

        stuColl.deleteOne(Filters.eq("name","唐僧"));
    }

    @Test
    public void testUpdate(){
        //连接数据库
        MongoClient client = new MongoClient();
        //获取数据库的实例
        MongoDatabase testDB = client.getDatabase("test");
        //获取集合的实例
        MongoCollection<Document> stuColl = testDB.getCollection("students");

        //db.collection.update({name:"猪八戒"},{$set:{age:20}})
        stuColl.updateOne(Filters.eq("name","猪八戒"), new Document("$set" , new Document("age",20)) );
    }


}
