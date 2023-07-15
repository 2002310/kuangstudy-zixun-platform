package com.pug.zixun.config.validator;

import com.pug.zixun.common.enums.AdminResulInterface;
import com.pug.zixun.common.exceptions.PugValidatorException;
import org.springframework.util.CollectionUtils;

import javax.annotation.Nullable;
import java.util.Collection;

public abstract class PugAssert {
    /*
    *
    * 字符串为空抛出异常
    * */
    public static void isNullEx(@Nullable Object object, AdminResulInterface message) {
        if (object == null) {
            throw new PugValidatorException(message);
        }
    }
    /*
    *
    * 字符串不为空抛出异常
    * */

    public static void isNotNullEx(@Nullable Object object, AdminResulInterface message) {
        if (object != null) {
            throw new PugValidatorException(message);
        }
    }

    /*
    *
    * 字符串为空，抛出异常
    * */
    public static void isEmptyEx(@Nullable String str, AdminResulInterface message) {
        if (str.equals("") || null == str) {
            throw new PugValidatorException(message);
        }
    }


    public static void isFalseEx(@Nullable boolean isflag, AdminResulInterface message) {
        if (!isflag){
            throw new PugValidatorException(message);
        }
    }
    public static void isTrueEx(@Nullable boolean isflag, AdminResulInterface message) {
        if (isflag){
            throw new PugValidatorException(message);
        }
    }
    /*
    *
    * 集合为空抛异常
    * */
    public static void isCollectionNullEx(@Nullable Collection collection, AdminResulInterface message) {
        if (collection == null || collection.isEmpty()) {
            throw new PugValidatorException(message);
        }
    }


}
