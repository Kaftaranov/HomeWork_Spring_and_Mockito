package ru.mockito.demo.Spring_and_Mockito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class SpringAndMockitoApplication {
	private static final List<String> setOfNames = new ArrayList<>(List.of("Semyon Semyonovich Gorbunkov", "Fyodor Mikhailovich Sukhov",
			"Pavel Artemyevich Vereshchagin", "Max Otto von Schtirlitz", "Afanasiy Nikolaevich Borshchyov",
			"Yevgeniy Ivanovich Troshkin", "Anton Semyonovich Shpak", "Ivan Vasilyevich Bunsha",
			"Gleb Yegorovich Zheglov", "Pyotr Ruchnikov", "Yevgeniy Petrovich Foks"));
	private static final Random salary = new Random();
	private static final List<Double> salaries = new ArrayList<>();
	private static int employeeId = 0;
	private static String processedName;
	private static String processedMiddlename = null;
	private static String processedSurname = null;
	private static final List<Integer> division = new ArrayList<>(List.of(1, 2, 3, 4, 5));
	public static List<Employee> staff = new ArrayList<>();

	private static void nameProcessing(String nameToProcess) {
		processedName = nameToProcess.split(" ")[0];
		switch (nameToProcess.split(" ").length) {
			case 2 -> {
				processedMiddlename = "";
				processedSurname = nameToProcess.split(" ")[1];
			}
			case 3 -> {
				processedMiddlename = nameToProcess.split(" ")[1];
				processedSurname = nameToProcess.split(" ")[2];
			}
			case 4 -> {
				processedMiddlename = nameToProcess.split(" ")[1];
				processedSurname = nameToProcess.split(" ")[2] + " " + nameToProcess.split(" ")[3];
			}
		}
	}

	private static void staffListInitializing() {
		int departmentId = 1;
		for (int i = 0; i < setOfNames.size(); i++) {
			nameProcessing(setOfNames.get(i));
			employeeId++;
			if (departmentId > division.size()){departmentId = 1;}
			staff.add(new Employee(processedName, processedMiddlename, processedSurname,
					departmentId, salaries.get(i), employeeId));
			departmentId++;
		}
	}
	private static void salariesInitializing() {
		for (int i = 0; i < setOfNames.size(); i++) {
			salaries.add(salary.nextDouble(200_000D, 300_000D));
		}
	}
	public static void main(String[] args) {
		salariesInitializing();
		staffListInitializing();
		SpringApplication.run(SpringAndMockitoApplication.class, args);
	}
}
