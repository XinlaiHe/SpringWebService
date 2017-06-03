package hsbc.gbm.controller;

import java.util.List;

import hsbc.gbm.domain.FlowerDomain;
import hsbc.gbm.repository.FlowerRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlowerController {
	private Logger logInfo = LoggerFactory.getLogger(FlowerController.class); 
	
	@Autowired
	private FlowerRepository flowerRepository;
	
	@RequestMapping("/flowers")
	public List<FlowerDomain> getFlowers() {
		logInfo.info("Access Flower Path");
		return flowerRepository.getList();
	}
}
