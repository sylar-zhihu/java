package com.atguigu.spring.helloWorld;

public class Person {
	
	private String  name ;  // 成员变量
	
	public Person( ) {
	}

	public String getName() {
		return name;
	}

	public void setName2(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	} 
	
	
	//自定义方法
	public  void  sayHello() {
		System.out.println("My Name is " + name );
	}
	
}
