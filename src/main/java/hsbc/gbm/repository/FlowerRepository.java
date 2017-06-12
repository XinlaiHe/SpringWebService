package hsbc.gbm.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import hsbc.gbm.domain.FlowerDomain;

@Repository("FlowerRepository")
public class FlowerRepository extends AbstractRepository {
	private Logger logInfo = LoggerFactory.getLogger(FlowerRepository.class); 
	
	@SuppressWarnings("unchecked")
	public List<FlowerDomain> getList() {
		Session session = this.getSession();
		Criteria criteria = session.createCriteria(FlowerDomain.class);
		
		return criteria.list();
	}
	
	public void creatFlower(FlowerDomain flower) {
		Session session = this.getSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.persist(flower);
			transaction.commit();
			logInfo.info("Inserting New Flower Successfully.");
		} catch(Exception e) {
			logInfo.error("Error Occur During Inserting New Flower, Begin to Rollback.");
			transaction.rollback();
		}
		
	}
}
