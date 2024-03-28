package com.kadai10.employee.mapper;

import com.kadai10.employee.entity.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Optional;

@Mapper
public interface EmployeeMapper {

    @Select("select * from employee")
    List<Employee> getAll();

    @Select("select * from employee where id = #{id}")
    Optional<Employee> findByEmployeeId(int id);

    @Insert("insert into employee(name,age,mail) values(#{name},#{age},#{mail})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Employee employee);

    @Update("update employee set name = #{name},age = #{age}, mail = #{mail} where id = #{id} ")
    void update(Employee employee);

    @Delete("delete from employee where id = #{id}")
    void delete(int id);
}

