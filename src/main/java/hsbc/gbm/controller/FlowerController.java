package hsbc.gbm.controller;

import java.util.List;
import javax.validation.Valid;
import hsbc.gbm.domain.FlowerDomain;
import hsbc.gbm.repository.FlowerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlowerController {
	private Logger logInfo = LoggerFactory.getLogger(FlowerController.class); 
	
	@Autowired
	private FlowerRepository flowerRepository;
	
	@RequestMapping(value="/flowers", method=RequestMethod.GET)
	public List<FlowerDomain> getFlowers() {
		logInfo.info("Get All Flowers");
		return flowerRepository.getList();
	}
	
	@RequestMapping(value="/flowers", method=RequestMethod.POST)
	public void addFlower(@Valid FlowerDomain flower) {
		logInfo.info("Add New Flower " + flower.toString());
		flowerRepository.creatFlower(flower);
	}
}
