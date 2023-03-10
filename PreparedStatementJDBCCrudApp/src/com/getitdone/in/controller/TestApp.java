package com.getitdone.in.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.getitdone.in.dto.Student;
import com.getitdone.in.service.IStudentService;
import com.getitdone.in.servicefactory.StudentServiceFactory;

public class TestApp {

	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);

		int i=1;
		while(i==1) {
		
		//Operation menu
			System.out.println("1. Press 1 for Insert operation\r\n"
					+ "2. Press 2 for select operation\r\n"
					+ "3. Press 3 for Update operation\r\n"
					+ "4. Press 4 for Delete operation\r\n"
					+ "5. Press 5 for exit");
			int x=sc.nextInt();
			if(x==1) {
				insertOperation();
			}
			else if(x==2) {
				searchOperation();
			}
			else if(x==3) {
				updateOperation();
		}
			else if(x==4) {
				deleteOperation();
		}
		else if(x==5) {
				System.out.println("Excited succesfully.");
				i=0;
			}
		else {
		    System.out.println("Invalid Operation.");
		    
		}
			if(i!=0) {
				System.out.println();
				System.out.println();
			System.out.println("-->Press 1 to Display Operation menu : \r\n-->press 0 to exit.");
		i=	sc.nextInt();
			}
		}
		
           
		}
		
		
		
		

	
	@SuppressWarnings("resource")
	public static void insertOperation(){
		Scanner scanner=null;
		IStudentService studentService=StudentServiceFactory.getStudentService();
		scanner=new Scanner(System.in);
		System.out.println("Enter the student name");
		String name=scanner.next();
		System.out.println("Enter the student age");
		Integer age=scanner.nextInt();
		System.out.println("Enter the student address");
		String address=scanner.next();
		String msg = studentService.addStudent(name,age, address);
		if(msg.equalsIgnoreCase("success")) System.out.println("Student added successfully.");
		else System.out.println("Student addtion failed!!.");
	}
	public static void searchOperation() {
		Scanner scanner=null;
		IStudentService studentService=StudentServiceFactory.getStudentService();
		
		System.out.println("Enter the student id : ");
	      scanner=new Scanner(System.in);
		Integer id=scanner.nextInt();
		Student student = studentService.searchStudent(id);
		if(student!=null){
		System.out.println("Student id is       -->  "+student.getSid()+"\n"+
				           "Student name is     -->  "+student.getSname()+"\n"+
		                   "Student age is      -->  "+student.getSage()+"\n"+
		                   "Student address is  -->  "+student.getSaddress()+"\n"
		                   );
		}else {
			System.out.println("Student not found.");
		}
	}
	public static void updateOperation() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the student id to be updated:: ");
		String sid = br.readLine();

		IStudentService studentService = StudentServiceFactory.getStudentService();
		Student student = studentService.searchStudent(Integer.parseInt(sid));

		if (student != null) {
			Student newStudent = new Student();

			System.out.println("Student id is :: " + student.getSid());
			newStudent.setSid(student.getSid());

			System.out.print("Student oldName is :: " + student.getSname() + "  Enter newName :: ");
			String newName = br.readLine();
			if (newName.equals("") || newName == "") {
				newStudent.setSname(student.getSname());
			} else {
				newStudent.setSname(newName);
			}
			System.out.print("Student oldAge is :: " + student.getSage() + "  Enter newAge :: ");
			String newAge = br.readLine();
			if (newAge.equals("") || newAge == "") {
				newStudent.setSage(student.getSage());
			} else {
				newStudent.setSage(Integer.parseInt(newAge));
			}
			System.out.print("Student oldAddress is :: " + student.getSaddress() + "  Enter newAddress :: ");
			String newAddress = br.readLine();
			if (newAddress.equals("") || newAddress == "") {
				newStudent.setSaddress(student.getSaddress());
			} else {
				newStudent.setSaddress(newAddress);
			}

			System.out.println("new Object data is :: " + newStudent);
			System.out.println();

			String status = studentService.updateStudent(newStudent);
			if (status.equalsIgnoreCase("success")) {
				System.out.println("record updated succesfully");
			} else {
				System.out.println("record updation failed");
			}

		} else {
			System.out.println("Student record not available for the given id  " + sid + " for updation...");
		}
		
	}
	@SuppressWarnings("resource")
	public static void deleteOperation(){
		Scanner scanner=null;
		IStudentService studentService=StudentServiceFactory.getStudentService();
		scanner=new Scanner(System.in);
		System.out.println("Enter the student id  to be deleted: ");
		Integer id=scanner.nextInt();
		String student = studentService.deleteStudent(id);
		if(student.equalsIgnoreCase("success")) {
			System.out.println("Student deleted.");
		}else {
			System.out.println("Student deletion FAILED");
		}
	}

}
