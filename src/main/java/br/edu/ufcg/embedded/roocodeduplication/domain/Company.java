package br.edu.ufcg.embedded.roocodeduplication.domain;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import java.util.Collection;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Version;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.transaction.annotation.Transactional;

@Configurable
@Entity
@RooJavaBean
@RooToString
@RooJpaActiveRecord
@RooJson(deepSerialize = true)
public class Company {

    public String toJson() {
        return new JSONSerializer().exclude("*.class").deepSerialize(this);
    }

    public String toJson(String[] fields) {
        return new JSONSerializer().include(fields).exclude("*.class").deepSerialize(this);
    }

    public static Company fromJsonToCompany(String json) {
        return new JSONDeserializer<Company>().use(null, Company.class).deserialize(json);
    }

    public static String toJsonArray(Collection<Company> collection) {
        return new JSONSerializer().exclude("*.class").deepSerialize(collection);
    }

    public static String toJsonArray(Collection<Company> collection, String[] fields) {
        return new JSONSerializer().include(fields).exclude("*.class").deepSerialize(collection);
    }

    public static Collection<Company> fromJsonArrayToCompanys(String json) {
        return new JSONDeserializer<List<Company>>().use("values", Company.class).deserialize(json);
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Version
    @Column(name = "version")
    private Integer version;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @PersistenceContext
    transient EntityManager entityManager;

    public static final List<String> fieldNames4OrderClauseFilter = java.util.Arrays.asList("");

    public static final EntityManager entityManager() {
        EntityManager em = new Company().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

    public static long countCompanys() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Company o", Long.class).getSingleResult();
    }

    public static List<Company> findAllCompanys() {
        return entityManager().createQuery("SELECT o FROM Company o", Company.class).getResultList();
    }

    public static List<Company> findAllCompanys(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Company o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Company.class).getResultList();
    }

    public static Company findCompany(Long id) {
        if (id == null) return null;
        return entityManager().find(Company.class, id);
    }

    public static List<Company> findCompanyEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Company o", Company.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    public static List<Company> findCompanyEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Company o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Company.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    @Transactional
    public void persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }

    @Transactional
    public void remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Company attached = Company.findCompany(this.id);
            this.entityManager.remove(attached);
        }
    }

    @Transactional
    public void flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }

    @Transactional
    public void clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }

    @Transactional
    public Company merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Company merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

    /**
     */
    private Boolean name;

	public Boolean getName() {
        return this.name;
    }

	public void setName(Boolean name) {
        this.name = name;
    }
}
