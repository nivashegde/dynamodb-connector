package org.csulb.md.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.ConnectionFactoryBuilder;
import net.spy.memcached.MemcachedClient;
import net.spy.memcached.transcoders.SerializingTranscoder;

@Configuration
public class MemcachedConfiguration {
	
	@Value("${cache.host}")
	private String memcachedHost;

	@Value("${cache.port}")
	private Integer memcachedPort;
	
    @Bean
    public MemcachedClient getMemcachedClient() throws IOException {
    	MemcachedClient client = new MemcachedClient(
            new ConnectionFactoryBuilder()
                .setTranscoder(new SerializingTranscoder())
                .setProtocol(ConnectionFactoryBuilder.Protocol.BINARY)
                .build(),
            AddrUtil.getAddresses(memcachedHost));
    	return client;
    }

}
