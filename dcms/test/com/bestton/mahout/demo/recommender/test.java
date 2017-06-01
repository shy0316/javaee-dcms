package com.bestton.mahout.demo.recommender;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.activation.FileDataSource;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.MySQLJDBCIDMigrator;
import org.apache.mahout.cf.taste.impl.model.jdbc.ConnectionPoolDataSource;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.CachingRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.slopeone.SlopeOneRecommender;
import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.model.JDBCDataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import freemarker.ext.beans.DateModel;

public class test {
	public static void main(String[] args) throws TasteException, IOException {
//
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setServerName("localhost");
		dataSource.setUser("root");
		dataSource.setPassword("dddzi5200");
		dataSource.setDatabaseName("dcms");
		ConnectionPoolDataSource connectionPool = new ConnectionPoolDataSource(dataSource);
		JDBCDataModel model = new MySQLJDBCDataModel(connectionPool, "userperference", "student_Id", "competition_Id", "perferences", "time");
//		DataModel data = dataModel;
//		DataModel model = new FileDataModel(new File("test/com/bestton/mahout/demo/recommender/movie.txt"));
//		GenericDataModel gdm = new GenericDataModel(model);
//		System.out.println(gdm.getPreferencesFromUser(1));
//		System.out.println(model);
		  //新建推荐引擎 三种方式  
        
//        //1-----根据用户相似度建立推荐引擎  
        UserSimilarity userSim = new EuclideanDistanceSimilarity(model); 
        
        NearestNUserNeighborhood userNei = new NearestNUserNeighborhood(10, userSim, model); 
        
        Recommender cachingRecommender = new GenericUserBasedRecommender(model, userNei, userSim);  
//        //----end  
          
        //2----根据Item相似度建立推荐引擎  
//		ItemSimilarity itemSim = new LogLikelihoodSimilarity(model); 
//        Recommender cachingRecommender = new GenericItemBasedRecommender(model, itemSim);
//          
        //3----缓存推荐引擎  
    //    CachingRecommender cachingRecommender = new CachingRecommender(new SlopeOneRecommender(model));  
          
          
        //遍历获得的全部用户  
        for(LongPrimitiveIterator it =model.getUserIDs();it.hasNext();)  
        {  
            //获取单个用户ID  
            long userId =it.nextLong();  
              
            //20表示推荐个数  
            List<RecommendedItem> recommendations = cachingRecommender.recommend(userId, 1);  
              
            //该用户没有推荐  
            if(recommendations.size() ==0)  
            {  
                System.out.println("UserId"+userId+":no Recommendations");  
            }  
              
            //输出推荐后的数据  
            for (RecommendedItem recommendedItem : recommendations) {  
                  
                System.out.println("UserId"+userId+":"+recommendedItem);  
                //这里的话更新Student表
            }  
        }  
      
      
    }  

}
