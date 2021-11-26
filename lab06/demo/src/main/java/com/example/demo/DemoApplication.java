package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.ColumnMapRowMapper;

import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private CreditRepository creditRepo;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//jesli jest polaczenie z baza danych to wyswietli wiersz
		List<CreditTable> creditTableList = creditRepo.findAll();
		creditTableList.forEach(System.out::println);

	}
}
