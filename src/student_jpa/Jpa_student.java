/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student_jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author poramet
 */
public class Jpa_student {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Student stu = new Student(6, "pond2", 3.99);
        Student stu2 = new Student(7, "pond3", 3.99);
        StudentTable.insertStudent(stu);
        StudentTable.insertStudent(stu2);

        List<Student> stdList = StudentTable.findAllStudent();
        printAllStudent(stdList);
    }

    public static void printAllStudent(List<Student> studentList) {
        for (Student emp : studentList) {
            System.out.print(emp.getId() + " ");
            System.out.print(emp.getName() + " ");
            System.out.println(emp.getGpa() + " ");
        }
    }

    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("student_jpaPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
