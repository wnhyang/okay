package org.okay4cloud.okay.common.core.constant;

/**
 * @author wnhyang
 * @date 2023/2/15
 **/
public interface CommonConstants {

    /**
     * 删除
     */
    String STATUS_DEL = "1";

    /**
     * 正常
     */
    String STATUS_NORMAL = "0";

    /**
     * 锁定
     */
    String STATUS_LOCK = "9";

    /**
     * 菜单树根节点
     */
    Long MENU_TREE_ROOT_ID = -1L;

    /**
     * 菜单
     */
    String MENU = "0";

    /**
     * 编码
     */
    String UTF8 = "UTF-8";

    /**
     * JSON 资源
     */
    String CONTENT_TYPE = "application/json; charset=utf-8";

    /**
     * 前端工程名
     */
    String FRONT_END_PROJECT = "okay-ui";

    /**
     * 后端工程名
     */
    String BACK_END_PROJECT = "okay";

    /**
     * 成功标记
     */
    Integer SUCCESS = 0;

    /**
     * 默认成功信息
     */
    String SUCCESS_MSG = "success";

    /**
     * 失败标记
     */
    Integer FAIL = 1;

    /**
     * 默认失败信息
     */
    String FAIL_MSG = "fail";

    /**
     * 验证码前缀
     */
    String DEFAULT_CODE_KEY = "DEFAULT_CODE_KEY_";

    /**
     * 当前页
     */
    String CURRENT = "current";

    /**
     * size
     */
    String SIZE = "size";
}
