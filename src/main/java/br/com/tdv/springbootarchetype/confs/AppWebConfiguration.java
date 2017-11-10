package br.com.tdv.springbootarchetype.confs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.support.ErrorPageFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.tdv.springbootarchetype.interceptors.AuthorizerInterceptor;
import br.com.tdv.springbootarchetype.models.Cnpj;
import br.com.tdv.springbootarchetype.resolvers.JsonViewResolver;
import br.com.tdv.springbootarchetype.resolvers.XmlViewResolver;

@Configuration
@EnableWebMvc
public class AppWebConfiguration extends WebMvcConfigurerAdapter {

	@Autowired
	private AuthorizerInterceptor authorizerInterceptor;

//	@Override
//	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//	    configurer.ignoreAcceptHeader(true)
//	    		  .defaultContentType(MediaType.TEXT_HTML)
//	    		  .favorParameter(true)
//	    		  .parameterName("mediaType")
//	    		  .ignoreAcceptHeader(true)
//	    		  .useJaf(false)
//	    		  .mediaType("xml", MediaType.APPLICATION_XML)
//	    		  .mediaType("json", MediaType.APPLICATION_JSON);    
//	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authorizerInterceptor);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Bean
	@Order(Ordered.HIGHEST_PRECEDENCE)
	public CharacterEncodingFilter characterEncodingFilter() {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		return filter;
	}
	
	@Bean
	public ErrorPageFilter errorPageFilter() {
	    return new ErrorPageFilter();
	}

	@Bean
	public FilterRegistrationBean disableSpringBootErrorFilter(ErrorPageFilter filter) {
	    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
	    filterRegistrationBean.setFilter(filter);
	    filterRegistrationBean.setEnabled(false);
	    return filterRegistrationBean;
	}
	
	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		// Estamos expondo a nossa bean para ser acessada nas views da nossa aplicação...
		//resolver.setExposedContextBeanNames("carrinhoCompras");
		return resolver;
	}
	
	@Bean
    public ViewResolver jaxb2MarshallingXmlViewResolver() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(Cnpj.class);
        return new XmlViewResolver(marshaller);
    }	
	
	/**
	 * A Técnica chamada de Content Negociation é possível que uma mesma URL retorne as informações em formatos 
	 * diferentes. Exemplo: acessar a URL localhost:8080/casadocodigo/produtos/5 traria como resposta o HTML 
	 * da página de detalhes daquele produto, enquanto acessar localhost:8080/casadocodigo/produtos/5.json 
	 * retornaria o JSON que representa aquele produto.
	 * 
	 * */	
	@Bean
	public ViewResolver contentNegotiationViewResolver(ContentNegotiationManager manager){
		System.out.println("PAssou aqui");
	    List<ViewResolver> viewResolvers = new ArrayList<>();
	    viewResolvers.add(internalResourceViewResolver());
	    viewResolvers.add(jaxb2MarshallingXmlViewResolver());	 
	    viewResolvers.add(new JsonViewResolver());
	    ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
	    resolver.setViewResolvers(viewResolvers);
	    resolver.setContentNegotiationManager(manager);
	    return resolver;
	}
	

	
	
}