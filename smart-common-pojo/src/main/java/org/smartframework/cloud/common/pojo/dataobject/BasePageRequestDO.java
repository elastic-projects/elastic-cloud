package org.smartframework.cloud.common.pojo.dataobject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.smartframework.cloud.common.pojo.Base;

/**
 * （用于dao层）分页请求参数基类
 *
 * @author liyulin
 * @date 2020-05-07
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BasePageRequestDO extends Base {

    private static final long serialVersionUID = 1L;

    private Integer offset;

    private Integer rows;

}