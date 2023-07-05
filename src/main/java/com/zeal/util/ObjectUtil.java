//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.zeal.util;

import org.springframework.lang.Nullable;
import org.springframework.util.ObjectUtils;

public class ObjectUtil extends ObjectUtils {
    public ObjectUtil() {
    }

    public static boolean isNotEmpty(@Nullable Object obj) {
        return !isEmpty(obj);
    }
}
