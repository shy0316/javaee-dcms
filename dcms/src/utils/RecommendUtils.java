package utils;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.IRStatistics;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.eval.RecommenderIRStatsEvaluator;
import org.apache.mahout.cf.taste.impl.eval.GenericRecommenderIRStatsEvaluator;
import org.apache.mahout.cf.taste.impl.model.jdbc.ConnectionPoolDataSource;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.model.JDBCDataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class RecommendUtils {
	public static void evaluate() throws Exception{
		
		ConnectionPoolDataSource connectionPool = new ConnectionPoolDataSource(getRecommendDateSource());
		JDBCDataModel model = new MySQLJDBCDataModel(connectionPool, "userperference", "student_Id", "competition_Id", "perferences", "time");
       		//创建评估器
		RecommenderIRStatsEvaluator evaluator = new GenericRecommenderIRStatsEvaluator();
		//构建推荐引擎
		RecommenderBuilder recommenderBuilder = new RecommenderBuilder() {

			public Recommender buildRecommender(DataModel dataModel)
					throws TasteException {
				// TODO Auto-generated method stub
				UserSimilarity similarity = new PearsonCorrelationSimilarity(
						dataModel);
				UserNeighborhood neighborhood = new NearestNUserNeighborhood(2,
						similarity, dataModel);

				return new GenericUserBasedRecommender(dataModel, neighborhood,
						similarity);
			}
		};
		int at = 1;// 评估推荐两个ITEM时的查准率和查全率
		//开始评估查准率和查全率
		IRStatistics statistics = evaluator.evaluate(recommenderBuilder, null,model, null, at,GenericRecommenderIRStatsEvaluator.CHOOSE_THRESHOLD,
				1.0);

		System.out.println("precision at " + at + " 查准率:"+ statistics.getPrecision());
		System.out.println("recall at " + at + " 查全率:" + statistics.getRecall());

	}
	public static MysqlDataSource getRecommendDateSource(){
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setServerName("localhost");
		dataSource.setUser("root");
		dataSource.setPassword("123456");
		dataSource.setDatabaseName("dcms");
		return dataSource;
	
	}
		
}
