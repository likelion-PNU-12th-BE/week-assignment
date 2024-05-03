package com.project.weekassignment.week2;

public class CreateObject100Times {

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			Service service = new Service();
			System.out.println(service);
		}
	}
}

class Service {
	public Service() {
	}
}
