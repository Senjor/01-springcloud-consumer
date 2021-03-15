/**
 * @Copyright (C), 2013-2021 德一集团
 * @FileName: User
 * @Author: laosun
 * @Date: 2021/3/11 4:47 下午
 * @Description: TODO
 */
package com.test.eurekaclienthystrixprovider.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
}
