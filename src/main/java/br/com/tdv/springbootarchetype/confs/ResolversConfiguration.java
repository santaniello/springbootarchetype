package br.com.tdv.springbootarchetype.confs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.tdv.springbootarchetype.models.Cnpj;
import br.com.tdv.springbootarchetype.resolvers.JsonViewResolver;
import br.com.tdv.springbootarchetype.resolvers.XmlViewResolver;

//@Configuration
public class ResolversConfiguration {
//	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		// Estamos expondo a nossa bean para ser acessada nas views da nossa aplicação...
		//resolver.setExposedContextBeanNames("carrinhoCompras");
		return resolver;
	}
	
//	@Bean
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
//	@Bean
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
