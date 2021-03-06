package dad.delibeer;


import org.apache.commons.logging.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.apache.commons.logging.LogFactory;

import org.springframework.session.hazelcast.config.annotation.web.http.EnableHazelcastHttpSession;
import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;

import java.util.ArrayList;
import java.util.List;

@EnableCaching
@SpringBootApplication
public class DeliBeerApplication {

	private static final Log LOG=LogFactory.getLog(DeliBeerApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(DeliBeerApplication.class, args);
	}
	
	@Bean
	public CacheManager cacheManager() {
		LOG.info("activating cache...");
		return new ConcurrentMapCacheManager("packs");
	}
	
	
	@Bean
	 public Config config() {
	 Config config = new Config();
	 JoinConfig joinConfig = config.getNetworkConfig().getJoin();
	 joinConfig.getMulticastConfig().setEnabled(false);
	 
	 List<String> serversList = new ArrayList<String>();
    serversList.add("delibeer1");
    serversList.add("delibeer2");
	 
	 joinConfig.getTcpIpConfig().setEnabled(true).setMembers(serversList);
	 return config;
	}
	
	
}

