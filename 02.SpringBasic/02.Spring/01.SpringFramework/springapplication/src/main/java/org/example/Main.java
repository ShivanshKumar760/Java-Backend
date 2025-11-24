package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");
//        Student stu1=(Student) context.getBean("student1");//problem is here in spring get bean return
        //type of object so we will need to do typecasting
//        stu1.code();
//        stu1.setAge(19);
//        System.out.println(stu1.getAge());
//
//        Student stu2=(Student) context.getBean("student1");
//      This will print the same age as of stu1 cause of spring bean default singleton nature
//      They are references to the same bean instance created by the Spring IoC container.
//      Spring creates only ONE object of your bean and stores it in the IoC container.
//      Every call to getBean("student1") returns the same object, NOT a new one.
//        System.out.println(stu2.getAge());



        /*
        * this below code simulate the same nature of singleton bean as both stu4 and stu5 point
        * to stu3 refrence
        * */
//        Student stu3=new Student();
//        Student stu4=stu3;
//        Student stu5=stu3;
//
//        stu4.setAge(25);
//        System.out.println(stu4.getAge());
//        System.out.println(stu5.getAge());
        /*
        *but suppose we want that when ever we call getBean pointing to same bean id it creates new object
        * so that every object creates a own copy of that bean
        *
         */

//        Student stu6= (Student) context.getBean("student3");
//        stu6.setAge(26);
//        System.out.println(stu6.getAge());
//        Student stu7= (Student) context.getBean("student3");
//        System.out.println(stu7.getAge());
//
//
//
//        Student stuNew=(Student) context.getBean("student4");
//        System.out.println(stuNew.getAge());

        Student stuFinal=(Student) context.getBean("studentfinal");
        stuFinal.code();










    }
}