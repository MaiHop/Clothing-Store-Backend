/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.service;

import Springweb.entity.KichThuoc;
import java.util.Optional;


/**
 *
 * @author maiho
 */

public interface InterfaceService<T> {

    Iterable<T> getAll();

    T get(Integer id);

    String save(T kt);

    String update(T kt);

    String delete(T t);

}
