package com.assign.entrance.base.result;

import java.io.Serial;
import java.util.HashMap;

/**
 * http请求返回信息，遵循restful
 *
 * @author R
 */
public final class Result extends HashMap<String, Object> {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * @param code   {@link HttpStatus#code()}
     * @param status {@link HttpStatus#status()}
     * @param value  描述信息
     * @author LJQ
     * @date 2020/11/24
     */
    private Result(int code, String status, String value) {
        put(ResultConstants.RESULT.CODE.getCode(), code);
        put(ResultConstants.RESULT.STATUS.getCode(), status);
        put(ResultConstants.RESULT.MESSAGE.getCode(), value);
    }

    // ---  Error ---

    /**
     * <p/>默认为HttpStatus为 {@link HttpStatus#NOT_IMPLEMENTED}
     *
     * @author LJQ
     * @date 2020/11/24
     */

    public static Result fail() {
        return fail(ResultConstants.RESULT_VALUE.FAIL.getCode());
    }

    public static Result fail(String value) {
        return fail(HttpStatus.INTERNAL_SERVER_ERROR, value);
    }

    public static Result fail(HttpStatus httpStatus, String value) {
        return fail(httpStatus.code(), value);
    }

    public static Result fail(int code, String value) {
        return fail(code, HttpStatus.INTERNAL_SERVER_ERROR.status(), value);
    }

    public static Result fail(int code, String status, String value) {
        return new Result(code, status, value);
    }

    // ---  OK ---

    /**
     * <p/>默认为HttpStatus为 {@link HttpStatus#OK}
     *
     * @author LJQ
     * @date 2020/11/24
     */

    public static Result ok() {
        return ok(ResultConstants.RESULT_VALUE.SUCCESS.getCode());
    }

    public static Result ok(String value) {
        return ok(HttpStatus.OK, value);
    }

    public static Result ok(HttpStatus httpStatus, String value) {
        return ok(httpStatus.code(), value);
    }

    public static Result ok(int code, String value) {
        return ok(code, HttpStatus.OK.status(), value);
    }

    public static Result ok(int code, String status, String value) {
        return new Result(code, status, value);
    }

    /**
     * 添加date数据
     *
     * @author LJQ
     * @date 2020/11/24
     */
    @Override
    public Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    /**
     * 添加date数据
     *
     * @author LJQ
     * @date 2020/11/24
     */
    public Result data(Object value) {
        this.put(ResultConstants.RESULT.DATA.getCode(), value);
        return this;
    }


}
