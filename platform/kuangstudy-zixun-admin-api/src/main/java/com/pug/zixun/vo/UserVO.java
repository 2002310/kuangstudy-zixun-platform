package com.pug.zixun.vo;
import com.pug.zixun.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO extends ParentVO implements java.io.Serializable{
    private Long id;
    private String userName;
    private String passWord;
    private String code;
    private String uuid;
}
