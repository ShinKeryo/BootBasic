package com.simple.basic.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

//@Configuration
//@PropertySource("classpath:/application.properties") 
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    ApplicationContext applicationContext;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariConfig hikariConfig() {
        return new HikariConfig();
    }

    @Bean
    public DataSource dataSource() {
        return new HikariDataSource(hikariConfig());
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();

        bean.setDataSource(dataSource);
        //부가적인 설정들
        bean.setTypeAliasesPackage("com.simple.basic.commend");
        bean.setMapperLocations(applicationContext.getResources("classpath:/mapper/*.xml"));

        return bean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    
    /*
	@Autowired
	ApplicationContext context; //스프링의 빈들을 전역적으로 관리하는 IOC기반의 bean관리 객체
	
	@Value("${server.port}") //properties에 있는 값을 참조
	String port;
	
	@Value("${hello}")
	String hello;
	
	@Value("${goodbye}")
	String bye;
	
	@Bean //스프링이 실행할 때 이 메서드를 실행시켜서 반환되는 값을 bean으로 등록
	void hello () {
		//System.out.println("스프링 bean설정 hello world");
		System.out.println("설정값 : "+port);
		System.out.println("설정값 : "+hello);
		System.out.println("2번째 프로펄티 파일 설정값:"+bye);
		
		//DI
		HomeController controller = context.getBean(HomeController.class);
		System.out.println(controller);
		
		int count = context.getBeanDefinitionCount();
		String[] arr = context.getBeanDefinitionNames();
		
		System.out.println("빈의개수 : "+count);
		System.out.println(Arrays.toString(arr));
		
	}*/
}

