package test;

import java.util.Date;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nxdcms.entity.Student;
import com.nxdcms.entity.UserPerference;

import utils.HibernateUtils;

public class SetPerferenceAtRandom {
	public static void main(String[] args) {
		Session session = null;
		Transaction tx = null;
		UserPerference up = null;
		int id = 14550000;
		try {
			
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
//2000个人 每个人给 80个项目打分  随机打分
			Random random = new Random();
			for(int i=0;i<2000;i++){	
//				id  = id +1;
				int [] rand = randomCommon(1, 81, 45);
				for(int j =0;j<45 ;j++){
						up = new UserPerference();
						up.setStudentId(i+id);
						up.setCompetitionId(rand[j]);
						up.setPerferences(random.nextInt(6));
						up.setTime(new Date());
						session.save(up);
					}
					if(i%100==0){
						session.flush();
						session.clear();
					}
				}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();

			}
		}
		HibernateUtils.closeSession(session);
	}
	
	
	public static int[] randomCommon(int min, int max, int n){  
	    if (n > (max - min + 1) || max < min) {  
	           return null;  
	       }  
	    int[] result = new int[n];  
	    int count = 0;  
	    while(count < n) {  
	        int num = (int) (Math.random() * (max - min)) + min;  
	        boolean flag = true;  
	        for (int j = 0; j < n; j++) {  
	            if(num == result[j]){  
	                flag = false;  
	                break;  
	            }  
	        }  
	        if(flag){  
	            result[count] = num;  
	            count++;  
	        }  
	    }  
	    return result;  
	}  
}
