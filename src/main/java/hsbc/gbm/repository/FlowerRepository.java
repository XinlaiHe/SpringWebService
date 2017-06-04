package hsbc.gbm.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import hsbc.gbm.domain.FlowerDomain;

@Repository("FlowerRepository")
public class FlowerRepository extends AbstractRepository {

	public List<FlowerDomain> getList() {
		Session session = this.getSession();
		Criteria criteria = session.createCriteria(FlowerDomain.class);
		
		return criteria.list();
	}
	
	public void creatFlower(FlowerDomain flower) {
		Session session = this.getSession();
		session.save(flower);
	}
}
