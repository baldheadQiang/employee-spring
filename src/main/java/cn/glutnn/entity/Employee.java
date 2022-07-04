package cn.glutnn.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
  private Long id;
  private String name;
  private String username;
  private String password;
  private String phone;
  private Integer sex;
  private String idNumber;
  private Long status;
  private LocalDateTime createTime;
  private LocalDateTime updateTime;
  @TableField(fill = FieldFill.INSERT)
  private Long createUser;
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Long updateUser;
}
