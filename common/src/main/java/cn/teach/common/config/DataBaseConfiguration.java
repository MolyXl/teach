package cn.teach.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableTransactionManagement
public class DataBaseConfiguration implements EnvironmentAware {

    @Value(value = "${jdbc.url}")
    private String url;
    @Value(value = "${jdbc.driverClassName}")
    private String driverClassName;
    @Value(value = "${jdbc.username}")
    private String username;
    @Value(value = "${jdbc.password}")
    private String password;
    @Value(value = "${mybatis.mapperLocations}")
    private String mapperLocations;

    @Autowired
    private Environment env;

    @Override
    public void setEnvironment(Environment environment) {

    }

    @Bean(initMethod = "init", destroyMethod = "close")
    @Primary
    public DruidDataSource dataSource() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(url);
        datasource.setDriverClassName(driverClassName);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setInitialSize(0);
        return datasource;
    }

    @Bean
    public GlobalConfig mpGlobalConfig() {
        // ??????????????????
        GlobalConfig globalConfig = new GlobalConfig();
        GlobalConfig.DbConfig dbConfig = new GlobalConfig.DbConfig();
        // ???????????????
        dbConfig.setIdType(IdType.AUTO);

        dbConfig.setDbType(DbType.MYSQL);
        dbConfig.setLogicDeleteValue("1");
        dbConfig.setLogicNotDeleteValue("0");
        globalConfig.setDbConfig(dbConfig);
        /*if (!ProjectStageUtil.isProd(projectStage)) {
            // ?????????dev??????,????????? reload xml?????????,????????????
            globalConfig.setRefresh(true);
        }*/
        // ?????????????????????
        LogicSqlInjector injector = new LogicSqlInjector();
        globalConfig.setSqlInjector(injector);
        return globalConfig;
    }

    @Bean
    public MybatisSqlSessionFactoryBean sqlSessionFactory(DruidDataSource dataSource, GlobalConfig globalConfig) throws Exception {
        return getSessionFactoryBean(dataSource, globalConfig);
    }

    private MybatisSqlSessionFactoryBean getSessionFactoryBean(DruidDataSource dataSource, GlobalConfig globalConfig) throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations));
        sqlSessionFactoryBean.setGlobalConfig(globalConfig);
        // ?????????????????????configuration, ????????????BaseMapper???????????????, ????????????????????????
        MybatisConfiguration configuration = new MybatisConfiguration();
        configuration.init(globalConfig);
        configuration.setMapUnderscoreToCamelCase(true);
        sqlSessionFactoryBean.setConfiguration(configuration);
        sqlSessionFactoryBean.setVfs(SpringBootVFS.class);
        sqlSessionFactoryBean.setTypeAliasesPackage("cn.teach.pojo.**");
        List<Interceptor> interceptors = new ArrayList<>();
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // ??????????????????
        interceptors.add(paginationInterceptor);
        /*if (!ProjectStageUtil.isProd(projectStage)) {
            // ?????????dev??????,?????????sql, ??????sql????????????, prod??????????????????, ???????????????*/
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        interceptors.add(performanceInterceptor);
        /*}*/
        sqlSessionFactoryBean.setPlugins(interceptors.toArray(new Interceptor[0]));
        return sqlSessionFactoryBean;
    }
    /*@Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(env.getProperty("mybatis.mapperLocations")));
        return sqlSessionFactoryBean.getObject();
    }*/
}
