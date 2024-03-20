package com.kadai10.employee.mapper;

import com.kadai10.employee.entity.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    @Select("select * from employee")
    List<Employee> getAll();

    @Select("select * from employee where id = #{id}")
    Employee findByEmployeeId(int id);

    @Insert("insert into employee(name,age,mail) values(#{name},#{age},#{mail})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Employee employee);
}
