package dad.delibeer;

import org.apache.commons.logging.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.apache.commons.logging.LogFactory;

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
}
