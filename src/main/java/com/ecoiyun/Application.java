/**
 * 
 */
package com.ecoiyun;

import org.mybatis.spring.annotation.MapperScan;
//import org.eclipse.jetty.server.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//import jetty.JettyFactory;
//import jetty.Profiles;

/**
 * @author Administrator
 *
 */
@SpringBootApplication
@EnableAutoConfiguration // 标识该类开启SpringBoot的配置.
@ComponentScan(basePackages = { "com.ecoiyun" })
@MapperScan("com.ecoiyun.mapper")
@EntityScan("com.ecoiyun.entity")
@EnableTransactionManagement
public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	/*
	 * public static final int PORT = 8080; public static final String CONTEXT =
	 * "/scm"; public static final String[] TLD_JAR_NAMES = new String[]
	 * {"spring-webmvc","mybatis"};
	 * 
	 * public static void main(String[] args) throws Exception { // 设定Spring的profile
	 * Profiles.setProfileAsSystemProperty(Profiles.DEVELOPMENT);
	 * 
	 * // 启动Jetty Server server = JettyFactory.createServerInSource(PORT, CONTEXT);
	 * JettyFactory.setTldJarNames(server, TLD_JAR_NAMES);
	 * 
	 * try { server.start();
	 * 
	 * System.out.println("[INFO] 服务启动  http://localhost:" + PORT + CONTEXT);
	 * System.out.println("[HINT] 按回车迅速重启");
	 * 
	 * // 等待用户输入回车重载应用. while (true) { char c = (char) System.in.read(); if (c ==
	 * '\n') { JettyFactory.reloadContext(server); } } } catch (Exception e) {
	 * e.printStackTrace(); System.exit(-1); } }
	 */

}
