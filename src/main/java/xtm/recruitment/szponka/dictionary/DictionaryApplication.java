package xtm.recruitment.szponka.dictionary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.io.IOException;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class DictionaryApplication {


	public static void main(String[] args) throws IOException {
		SpringApplication.run(DictionaryApplication.class, args);
	}
}
