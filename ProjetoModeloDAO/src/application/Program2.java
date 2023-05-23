package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        DepartmentDao depDao = DaoFactory.createDepartmentDao();
        Scanner sc = new Scanner(System.in);

        System.out.println("\n**** TEST 1 department .findById() ****");
        Department department = depDao.findById(2);
        System.out.println(department);


        System.out.println("\n**** TEST 2 department .findAll() ****");
        List<Department> list = depDao.findAll();
        for(Department dep : list){
            System.out.println(dep);
        }

        System.out.println("\n**** TEST 3 department .insert() ****");
        Department dep = new Department(null, "Carros");
        depDao.insert(dep);
        System.out.println("Inserido! O Id do novo departamento é: " + dep.getId());


        System.out.println("\n**** TEST 4 department .update() ****");
        department = depDao.findById(8);
        department.setName("Books");
        depDao.updade(department);
        System.out.println("Update realizado com sucesso!");

        System.out.println("\n**** TEST 5 department .delete() ****");
        System.out.print("Entre com o Id do Departamento que deseja deletar: ");
        int id = sc.nextInt();
        System.out.println("Deseja deletar: " + depDao.findById(id));
        System.out.print("(s/n)? ");
        char ch = sc.next().charAt(0);
            if(ch == 's'){
            depDao.deleteById(id);
            System.out.println("Departamento deletado com sucesso!");
            }



        sc.close();
    }
}
