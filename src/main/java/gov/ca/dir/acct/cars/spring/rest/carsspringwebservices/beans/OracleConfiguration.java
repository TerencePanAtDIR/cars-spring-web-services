package gov.ca.dir.acct.cars.spring.rest.carsspringwebservices.beans;

import oracle.jdbc.pool.OracleDataSource;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import javax.validation.constraints.NotNull;
import java.security.Security;
import java.sql.SQLException;

@Configuration
@ConfigurationProperties("oracle")
public class OracleConfiguration {
    @NotNull
    private String element;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String url;

    public void setElement(String element) {
        this.element = element;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String getDecryptedString(String encryptedString){

        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setProviderName("BC");
        encryptor.setPassword(element);
        encryptor.setAlgorithm("PBEWITHSHA-256AND256BITAES-CBC-BC");

        String plainText = encryptor.decrypt(encryptedString);
        return plainText;
    }

    @Bean
    DataSource dataSource() throws SQLException {
        Security.addProvider(new BouncyCastleProvider());

        OracleDataSource dataSource = new OracleDataSource();
        dataSource.setUser(getDecryptedString(username));
        dataSource.setPassword(getDecryptedString(password));
        dataSource.setURL(url);
        dataSource.setImplicitCachingEnabled(true);
        dataSource.setFastConnectionFailoverEnabled(true);
        return dataSource;
    }


}
