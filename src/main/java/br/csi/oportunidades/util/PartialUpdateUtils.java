package br.csi.oportunidades.util;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.HashSet;
import java.util.Set;

public class PartialUpdateUtils {

    /**
     * Copies non-null properties from a source object to a target object,
     * excluding specific properties like "uuid" and "role".
     *
     * @param src    The source object.
     * @param target The target object.
     */
    public static void copyNonNullProperties(Object src, Object target) {
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    }

    /**
     * Returns an array of property names with null values from a given source object.
     * This method also includes "uuid" and "role" in the exclusion list.
     *
     * @param source The source object to inspect.
     * @return An array of property names to be ignored during property copy.
     */
    private static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            // Ignores properties with null values and specifically "uuid" and "role"
            if (srcValue == null || "uuid".equals(pd.getName()) || "role".equals(pd.getName())) {
                emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}