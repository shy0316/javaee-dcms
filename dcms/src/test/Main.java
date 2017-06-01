package test;

import java.io.IOException;
import java.util.List;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.IRStatistics;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.eval.RecommenderEvaluator;
import org.apache.mahout.cf.taste.eval.RecommenderIRStatsEvaluator;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.eval.AverageAbsoluteDifferenceRecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.eval.GenericRecommenderIRStatsEvaluator;
import org.apache.mahout.cf.taste.impl.model.jdbc.ConnectionPoolDataSource;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.model.JDBCDataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import utils.RecommendUtils;

public class Main {
	public static void main(String[] args) throws TasteException, IOException {
	ConnectionPoolDataSource connectionPool = new ConnectionPoolDataSource(RecommendUtils.getRecommendDateSource());
		JDBCDataModel model = new MySQLJDBCDataModel(connectionPool, "userperference", "student_Id", "competition_Id", "perferences", "time");
        UserSimilarity userSim = new EuclideanDistanceSimilarity(model); 
        
        NearestNUserNeighborhood userNei = new NearestNUserNeighborhood(10, userSim, model); 
        
        Recommender cachingRecommender = new GenericUserBasedRecommender(model, userNei, userSim);  
          
        RecommenderBuilder bulider = new RecommenderBuilder() {
			
			@Override
			public Recommender buildRecommender(DataModel model) throws TasteException {
				return new GenericUserBasedRecommender(model, userNei, userSim);
			}
		};

        for(LongPrimitiveIterator it =model.getUserIDs();it.hasNext();)  
        {  
            long userId =it.nextLong();  
              
            List<RecommendedItem> recommendations = cachingRecommender.recommend(userId, 1);  
              
            if(recommendations.size() ==0)  
            {  
                System.out.println("UserId"+userId+":no Recommendations");  
            }  
              
            for (RecommendedItem recommendedItem : recommendations) {  
                  
                System.out.println("UserId"+userId+":"+recommendedItem);  
            }  
        }  
      
      
    }  

}
