package tla.vku.agentarena.services;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class HomeService {
	
	public Date getDate() {
		return new Date();
	}

}
