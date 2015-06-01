package br.edu.ufcg.embedded.roocodeduplication;

import br.edu.ufcg.embedded.roocodeduplication.domain.Company;
import br.edu.ufcg.embedded.roocodeduplication.domain.Developer;
import br.edu.ufcg.embedded.roocodeduplication.domain.Job;
import br.edu.ufcg.embedded.roocodeduplication.domain.Orders;
import br.edu.ufcg.embedded.roocodeduplication.domain.Person;
import br.edu.ufcg.embedded.roocodeduplication.domain.Product;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.roo.addon.web.mvc.controller.converter.RooConversionService;

@Configurable
/**
 * A central place to register application converters and formatters. 
 */
@RooConversionService
public class ApplicationConversionServiceFactoryBean extends FormattingConversionServiceFactoryBean {

	@Override
	protected void installFormatters(FormatterRegistry registry) {
		super.installFormatters(registry);
		// Register application converters and formatters
	}

	public Converter<Company, String> getCompanyToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<br.edu.ufcg.embedded.roocodeduplication.domain.Company, java.lang.String>() {
            public String convert(Company company) {
                return "(no displayable fields)";
            }
        };
    }

	public Converter<Long, Company> getIdToCompanyConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, br.edu.ufcg.embedded.roocodeduplication.domain.Company>() {
            public br.edu.ufcg.embedded.roocodeduplication.domain.Company convert(java.lang.Long id) {
                return Company.findCompany(id);
            }
        };
    }

	public Converter<String, Company> getStringToCompanyConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, br.edu.ufcg.embedded.roocodeduplication.domain.Company>() {
            public br.edu.ufcg.embedded.roocodeduplication.domain.Company convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Company.class);
            }
        };
    }

	public Converter<Person, String> getPersonToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<br.edu.ufcg.embedded.roocodeduplication.domain.Person, java.lang.String>() {
            public String convert(Person person) {
                return "(no displayable fields)";
            }
        };
    }

	public Converter<Long, Person> getIdToPersonConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, br.edu.ufcg.embedded.roocodeduplication.domain.Person>() {
            public br.edu.ufcg.embedded.roocodeduplication.domain.Person convert(java.lang.Long id) {
                return Person.findPerson(id);
            }
        };
    }

	public Converter<String, Person> getStringToPersonConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, br.edu.ufcg.embedded.roocodeduplication.domain.Person>() {
            public br.edu.ufcg.embedded.roocodeduplication.domain.Person convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Person.class);
            }
        };
    }

	public void installLabelConverters(FormatterRegistry registry) {
        registry.addConverter(getCompanyToStringConverter());
        registry.addConverter(getIdToCompanyConverter());
        registry.addConverter(getStringToCompanyConverter());
        registry.addConverter(getPersonToStringConverter());
        registry.addConverter(getIdToPersonConverter());
        registry.addConverter(getStringToPersonConverter());
    }

	public void afterPropertiesSet() {
        super.afterPropertiesSet();
        installLabelConverters(getObject());
    }

	public Converter<Orders, String> getOrdersToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<br.edu.ufcg.embedded.roocodeduplication.domain.Orders, java.lang.String>() {
            public String convert(Orders orders) {
                return "(no displayable fields)";
            }
        };
    }

	public Converter<Long, Orders> getIdToOrdersConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, br.edu.ufcg.embedded.roocodeduplication.domain.Orders>() {
            public br.edu.ufcg.embedded.roocodeduplication.domain.Orders convert(java.lang.Long id) {
                return Orders.findOrders(id);
            }
        };
    }

	public Converter<String, Orders> getStringToOrdersConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, br.edu.ufcg.embedded.roocodeduplication.domain.Orders>() {
            public br.edu.ufcg.embedded.roocodeduplication.domain.Orders convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Orders.class);
            }
        };
    }

	public Converter<Developer, String> getDeveloperToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<br.edu.ufcg.embedded.roocodeduplication.domain.Developer, java.lang.String>() {
            public String convert(Developer developer) {
                return "(no displayable fields)";
            }
        };
    }

	public Converter<Long, Developer> getIdToDeveloperConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, br.edu.ufcg.embedded.roocodeduplication.domain.Developer>() {
            public br.edu.ufcg.embedded.roocodeduplication.domain.Developer convert(java.lang.Long id) {
                return Developer.findDeveloper(id);
            }
        };
    }

	public Converter<String, Developer> getStringToDeveloperConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, br.edu.ufcg.embedded.roocodeduplication.domain.Developer>() {
            public br.edu.ufcg.embedded.roocodeduplication.domain.Developer convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Developer.class);
            }
        };
    }

	public Converter<Product, String> getProductToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<br.edu.ufcg.embedded.roocodeduplication.domain.Product, java.lang.String>() {
            public String convert(Product product) {
                return "(no displayable fields)";
            }
        };
    }

	public Converter<Long, Product> getIdToProductConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, br.edu.ufcg.embedded.roocodeduplication.domain.Product>() {
            public br.edu.ufcg.embedded.roocodeduplication.domain.Product convert(java.lang.Long id) {
                return Product.findProduct(id);
            }
        };
    }

	public Converter<String, Product> getStringToProductConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, br.edu.ufcg.embedded.roocodeduplication.domain.Product>() {
            public br.edu.ufcg.embedded.roocodeduplication.domain.Product convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Product.class);
            }
        };
    }

	public Converter<Job, String> getJobToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<br.edu.ufcg.embedded.roocodeduplication.domain.Job, java.lang.String>() {
            public String convert(Job job) {
                return "(no displayable fields)";
            }
        };
    }

	public Converter<Long, Job> getIdToJobConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, br.edu.ufcg.embedded.roocodeduplication.domain.Job>() {
            public br.edu.ufcg.embedded.roocodeduplication.domain.Job convert(java.lang.Long id) {
                return Job.findJob(id);
            }
        };
    }

	public Converter<String, Job> getStringToJobConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, br.edu.ufcg.embedded.roocodeduplication.domain.Job>() {
            public br.edu.ufcg.embedded.roocodeduplication.domain.Job convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Job.class);
            }
        };
    }
}
