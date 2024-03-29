package com.marcelo.client.configuration;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket cadastraClisntesApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.marcelo.client")).paths(regex("/Clientes.*")).build()
				.apiInfo(metaInfo());

	}

	private ApiInfo metaInfo() {

		ApiInfo clientesInfo = new ApiInfo("Cadastro-Clientes", "PROVA - DE CADASTRO DE CLIENTES", "1.0",
				"Terms Of Service",
				new Contact("Marcelo Henrique Machado",
						"https://www.linkedin.com/in/marcelo-henrique-machado-5278ab112/ ",
						"marcelo.h.machado@hotmail.com"),
				"", "", new ArrayList<VendorExtension>());
		return clientesInfo;

	}
}
